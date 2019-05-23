package com.kfstudio.tripplanner;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mlsdev.rximagepicker.RxImageConverters;
import com.mlsdev.rximagepicker.RxImagePicker;
import com.mlsdev.rximagepicker.Sources;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class HomePage extends AppCompatActivity {

    private Uri filePath;
    private FirebaseStorage storage;
    private StorageReference storageReference;

    private EditText name;
    private EditText email;
    private EditText dob;
    private RadioGroup gender;
    private RadioButton radioButton;
    private Button save;
    private DatabaseReference rootRef;
    private DatabaseReference demoRef;
    private static final String MyPREFERENCES = "MyPrefs" ;
    private static final String Phone = "phoneKey";
    private SharedPreferences sharedpreferences;
    private CircleImageView circleImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        name= findViewById(R.id.name);
        email = findViewById(R.id.email);
        gender = findViewById(R.id.gender);
        dob= findViewById(R.id.dob);
        RadioButton male = findViewById(R.id.MALE);
        male.setChecked(true);
        dob.setFocusable(false);
        dob.setLongClickable(false);
        EditText pHonenumber = findViewById(R.id.phonnumber);
        save = findViewById(R.id.save);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                dob.setText(sdf.format(myCalendar.getTime()));
            }

        };
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(HomePage.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        rootRef = FirebaseDatabase.getInstance().getReference();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReferenceFromUrl("gs://tripplanner-b51c5.appspot.com/");
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();
        circleImageView = findViewById(R.id.profile_image);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxImagePicker.with(HomePage.this).requestImage(Sources.GALLERY)
                        .flatMap(new Function<Uri, ObservableSource<Bitmap>>() {
                            @Override
                            public ObservableSource<Bitmap> apply(@NonNull Uri uri) {
                                return RxImageConverters.uriToBitmap(getApplicationContext(), uri);
                            }
                        }).subscribeOn(Schedulers.newThread())
                          .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Bitmap>() {

                    @Override
                    public void accept(@NonNull Bitmap bitmap) {
                       Glide
                                .with(HomePage.this)
                                .load(bitmap)
                                .apply(new RequestOptions().placeholder(R.color.colorPrimary))
                                .into(circleImageView);
                        filePath = getImageUri(HomePage.this,bitmap);
                    }});}});
        if(bundle!=null) {
            String phoneNumber = (String) bundle.get("phoneNumber");
            pHonenumber.setFocusable(false);
            pHonenumber.setEnabled(false);
            pHonenumber.setCursorVisible(false);
            pHonenumber.setKeyListener(null);
            pHonenumber.setText(phoneNumber);
            pHonenumber.setTextColor(Color.WHITE);
            editor.putString(Phone,phoneNumber );
            editor.apply();
        }
        final String phoneNumber=sharedpreferences.getString(Phone,null);
        if(phoneNumber==null){
            sendToAuth();
        }else{
            pHonenumber.setFocusable(false);
            pHonenumber.setEnabled(false);
            pHonenumber.setCursorVisible(false);
            pHonenumber.setKeyListener(null);
            pHonenumber.setText(phoneNumber);
            pHonenumber.setTextColor(Color.WHITE);
        }
        save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(validateForm()){
                    save.setText("Sending .... ");
                    save.setClickable(false);
                    demoRef = rootRef.child(phoneNumber);
                    String Name=name.getText().toString().trim();
                    String Dob=dob.getText().toString().trim();
                    String Email=email.getText().toString().trim();
                    int selectedId = gender.getCheckedRadioButtonId();
                    radioButton = findViewById(selectedId);
                    String radiosex = radioButton.getText().toString();
                    demoRef.child("Name").setValue(Name);
                    demoRef.child("Email").setValue(Email);
                    demoRef.child("Dob").setValue(Dob);
                    demoRef.child("Gender").setValue(radiosex);
                    uploadImage(Name,phoneNumber);
 }
            }
        });
    }
    private void sendToAuth(){
        sharedpreferences.edit().clear().apply();
        Intent intent = new Intent(HomePage.this,SplashActivity.class);
        startActivity(intent);
        finish();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean validateForm()
    {
        boolean alldone;
        String Name=name.getText().toString().trim();
        String Dob=dob.getText().toString().trim();
        String Email=email.getText().toString().trim();
        int selectedId = gender.getCheckedRadioButtonId();
        radioButton = findViewById(selectedId);
        if(radioButton==null){
            radioButton.setError("Select your gender",getDrawable(R.drawable.ic_error_white_24dp));
            return false;
        }
        CharSequence radiosex = radioButton.getText();
        if(TextUtils.isEmpty(Name))
        {
            name.setError("Enter your name",getDrawable(R.drawable.ic_error_white_24dp));
            return false;
        }else
        {
            name.setError(null);
        }
        if(TextUtils.isEmpty(Email))
        {
            email.setError("Enter your Email",getDrawable(R.drawable.ic_error_white_24dp));
            return false;
        }else
        {

            email.setError(null);
        }
        if(TextUtils.isEmpty(Dob))
        {
            dob.setError("Enter your DOB",getDrawable(R.drawable.ic_error_white_24dp));
            return false;
        }else
        {
            dob.setError(null);
        }
        if(TextUtils.isEmpty(radiosex)){
            radioButton.setError("Select your gender",getDrawable(R.drawable.ic_error_white_24dp));
            return false;
        }else{

            alldone = true;
            radioButton.setError(null);
        }

        return true;
    }
    private void uploadImage(final String Name,final String phone) {
        if(filePath!=null){
            StorageReference ref = storageReference.child(phone);
            ref.putFile(filePath).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                }
            })
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(HomePage.this, "Uploaded", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Image Upload Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        Intent intent = new Intent(HomePage.this,HotelsPage.class);
        intent.putExtra("Name",Name);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }
    private Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.WEBP, 50, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

}