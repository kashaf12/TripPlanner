package com.kfstudio.tripplanner;

import android.content.ContentProviderOperation;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;


public class ProfileActivity extends AppCompatActivity {
    private Button mLogout;
    private FirebaseAuth mAuth;
    private TextView name;
    private LinearLayout profile;
    private LinearLayout wallet;
    private LinearLayout invite;
    private LinearLayout faq;
    private LinearLayout call;
    private LinearLayout chatus;
    private LinearLayout feedback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.you);
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        mAuth = FirebaseAuth.getInstance();
        name = findViewById(R.id.name);
        faq = findViewById(R.id.youfaq);
        call = findViewById(R.id.callus);
        chatus= findViewById(R.id.chatwithus);
        feedback= findViewById(R.id.feedback);
        profile = findViewById(R.id.profile);
        wallet = findViewById(R.id.wallet);
        mLogout = findViewById(R.id.logout123);
        invite = findViewById(R.id.youshare);
        final FirebaseUser currentUser = mAuth.getCurrentUser();
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUser != null) {
                    mAuth.signOut();
                    sendToAuth();
                } else {
                    sendToAuth();
                }
            }

        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String phoneNumber = user.getPhoneNumber();
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!phoneNumber.equals("null")) {
                    Intent intent = new Intent(ProfileActivity.this, YouProfile.class);
                    intent.putExtra("phoneNumber", phoneNumber);
                    startActivity(intent);
                } else {
                    sendToAuth();
                }
            }
        });
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, YouWallets.class);
                startActivity(intent);
            }
        });
        if (bundle != null) {
            final String name1 = (String) bundle.get("Name");
            name.setText("Hello, " + name1);

            invite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ProfileActivity.this, YouInviteAndEarn.class);
                    intent.putExtra("Name", name1);
                    intent.putExtra("PhoneNumber", phoneNumber);
                    startActivity(intent);
                }
            });
        }
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (whatsappInstalledOrNot()) {
                    savecontact();
                    Uri uri = Uri.parse("smsto:" + " ");
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                    sendIntent.putExtra("sms_body", "Hello, ");
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                } else{
                    sendSMS();
                }
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(" "));
                if (ActivityCompat.checkSelfPermission(ProfileActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }
        });
    chatus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (whatsappInstalledOrNot()) {
                savecontact();
                Uri uri = Uri.parse("smsto:" + " ");
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
            } else {
                sendSMS();
            }
        }
    });
    feedback.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sendEmail();
        }
    });
    }

    private void sendToAuth(){

        Intent intent = new Intent(ProfileActivity.this,SplashActivity.class);
        startActivity(intent);
        finish();
    }
    private void sendEmail() {

        Log.i("Send email", "");
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto: "));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send Feedback"));
            finish();

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ProfileActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean whatsappInstalledOrNot() {
        PackageManager pm = getPackageManager();
        boolean app_installed;
        try {
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }
    private void savecontact(){

        String DisplayName = "Trip Planner";
        String MobileNumber = " ";

        ArrayList<ContentProviderOperation> ops =
                new ArrayList<>();

        int rawContactID = ops.size();

        // Adding insert operation to operations list
        // to insert a new raw contact in the table ContactsContract.RawContacts
        ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                .build());

        // Adding insert operation to operations list
        // to insert display name in the table ContactsContract.Data
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, rawContactID)
                .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, DisplayName)
                .build());

        // Adding insert operation to operations list
        // to insert Mobile Number in the table ContactsContract.Data
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, rawContactID)
                .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, MobileNumber)
                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
                .build());

        try{
            // Executing all the insert operations as a single database transaction
            getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
        }catch (RemoteException | OperationApplicationException e) {
            e.printStackTrace();
        }
    }
    private void sendSMS()
    {
        SmsManager sm = SmsManager.getDefault();
        String number = " ";
        String msg = "hello, call ASAP";
        sm.sendTextMessage(number, null, msg, null, null);
        Toast.makeText(this, "We will contact you as soon as possible", Toast.LENGTH_SHORT).show();
    }}
