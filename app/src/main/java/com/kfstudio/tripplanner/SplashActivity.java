package com.kfstudio.tripplanner;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;


public class SplashActivity extends AppCompatActivity {
    private Handler handler;
    private FirebaseAuth mAuth;
    private DatabaseReference demoRef;
    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.splash_screen);
        ProgressBar spinner = findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
        requestStoragePermission();

    }
    private void checkdata(final String phoneNumber) {
        demoRef = FirebaseDatabase.getInstance().getReference();

        demoRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(phoneNumber).exists()){
                    final DatabaseReference reference = demoRef.child(phoneNumber);
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.child("Name").exists()){
                                reference.child("Name").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        String value = dataSnapshot.getValue(String.class);
                                        Intent intent = new Intent(SplashActivity.this, HotelsPage.class);
                                        intent.putExtra("Name", value);
                                        startActivity(intent);
                                        finish();

                                    }
                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                        Toast.makeText(SplashActivity.this, "Database high traffic !!", Toast.LENGTH_SHORT).show();
                                        TaskStackBuilder.create(getApplicationContext())
                                                .addNextIntentWithParentStack(new Intent(getApplicationContext(), MainActivity.class))
                                                .addNextIntent(new Intent(getApplicationContext(), IntroActivity.class))
                                                .startActivities();

                                        finish();
                                    }
                                });
                            }else{
                                TaskStackBuilder.create(getApplicationContext())
                                        .addNextIntentWithParentStack(new Intent(getApplicationContext(), MainActivity.class))
                                        .addNextIntent(new Intent(getApplicationContext(), IntroActivity.class))
                                        .startActivities();

                                finish();
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                            Toast.makeText(SplashActivity.this, "Database high traffic", Toast.LENGTH_SHORT).show();
                            TaskStackBuilder.create(getApplicationContext())
                                    .addNextIntentWithParentStack(new Intent(getApplicationContext(), MainActivity.class))
                                    .addNextIntent(new Intent(getApplicationContext(), IntroActivity.class))
                                    .startActivities();

                            finish();
                        }
                    });
                }else{
                    TaskStackBuilder.create(getApplicationContext())
                            .addNextIntentWithParentStack(new Intent(getApplicationContext(), MainActivity.class))
                            .addNextIntent(new Intent(getApplicationContext(), IntroActivity.class))
                            .startActivities();

                    finish();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SplashActivity.this, "Database high traffic", Toast.LENGTH_SHORT).show();
                TaskStackBuilder.create(getApplicationContext())
                        .addNextIntentWithParentStack(new Intent(getApplicationContext(), MainActivity.class))
                        .addNextIntent(new Intent(getApplicationContext(), IntroActivity.class))
                        .startActivities();

                finish();
            }
        });


        }

    private boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
}
    private void requestStoragePermission() {
        Dexter.withActivity(this)
                .withPermissions(
                        android.Manifest.permission.CALL_PHONE,
                            android.Manifest.permission.INTERNET,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        android.Manifest.permission.RECEIVE_SMS,
                        android.Manifest.permission.READ_SMS,
                        android.Manifest.permission.SEND_SMS,
                        android.Manifest.permission.READ_CONTACTS,
                        android.Manifest.permission.WRITE_CONTACTS)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            if(isNetworkAvailable()){
                                mAuth = FirebaseAuth.getInstance();
                                handler=new Handler();
                                ProgressBar spinner = findViewById(R.id.progressBar);
                                spinner.setVisibility(View.VISIBLE);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        FirebaseUser currentUser = mAuth.getCurrentUser();
                                        if (currentUser == null) {
                                            TaskStackBuilder.create(getApplicationContext())
                                                    .addNextIntentWithParentStack(new Intent(getApplicationContext(), MainActivity.class))
                                                    .addNextIntent(new Intent(getApplicationContext(), IntroActivity.class))
                                                    .startActivities();

                                            finish();

                                        }
                                        else{
                                            String phonenumber = currentUser.getPhoneNumber();
                                            checkdata(phonenumber);
                                        }
                                    }
                                },500);

                            }
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Error occurred! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }
    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }
}