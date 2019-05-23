package com.kfstudio.tripplanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StreamDownloadTask;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Kashaf on 01-03-2018.
 */

public class YouProfile extends AppCompatActivity {
    private TextView phonenumber;
    private TextView name;
    private TextView email;
    private TextView dob;
    private RadioGroup gender;
    private DatabaseReference demoRef;
    private Button edit;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.you_profile);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        email = findViewById(R.id.email);
        dob= findViewById(R.id.dob);
        gender= findViewById(R.id.gender);
        phonenumber = findViewById(R.id.phonnumber);
        name = findViewById(R.id.name);
        edit = findViewById(R.id.edit);
        final CircleImageView imageView = findViewById(R.id.profile_image);
        if(bundle!=null){
            final String phoneNumber = (String) bundle.get("phoneNumber");
            phonenumber.setText(phoneNumber);
            checkdata(phoneNumber);
            storage = FirebaseStorage.getInstance();
            storageReference = storage.getReferenceFromUrl("gs://tripplanner-b51c5.appspot.com/");
            storageReference.child(phoneNumber).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    // Got the download URL for 'users/me/profile.png'
                    Glide.with(YouProfile.this)
                            .load(uri)
                            .apply(new RequestOptions().placeholder(R.drawable.blank_profile_picture_973460_960_720))
                            .into(imageView);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Glide.with(YouProfile.this)
                            .load(R.drawable.blank_profile_picture_973460_960_720)
                            .into(imageView);
                }
            });
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(YouProfile.this,HomePage.class);
                    intent.putExtra("phoneNumber", phoneNumber);
                    startActivity(intent);
                    finish();

                }
            });



        }else{
            sendToAuth();
        }


    }
    private void sendToAuth(){

        Intent intent = new Intent(YouProfile.this,SplashActivity.class);
        startActivity(intent);
        finish();
    }
    private void checkdata(final String phoneNumber) {
        demoRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference reference = demoRef.child(phoneNumber);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    if(snapshot.getKey().equals("Dob")) {
                        String Dob = (String) snapshot.getValue();
                        dob.setText(Dob);

                    }
                    if(snapshot.getKey().equals("Email")) {
                        String Email = (String) snapshot.getValue();
                        email.setText(Email);
                    }
                    if(snapshot.getKey().equals("Gender")) {
                        String Gender = (String) snapshot.getValue();
                        int selectedId = gender.getCheckedRadioButtonId();
                        RadioButton Female = findViewById(R.id.Female);
                        RadioButton Male = findViewById(R.id.Male);
                        Male.setChecked(true);
                        RadioButton radioButton = findViewById(selectedId);
                        String radiosex = radioButton.getText().toString();
                        if(!radiosex.equals(Gender)){
                            Female.setChecked(true);
                        }else{
                            Male.setChecked(true);
                        }
                    }
                    if(snapshot.getKey().equals("Name")) {
                        String Name = (String) snapshot.getValue();
                        name.setText(Name);
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(YouProfile.this, "Database high traffic", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
