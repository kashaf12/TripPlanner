package com.kfstudio.tripplanner;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity  {


    private EditText phoneText;
    private Button sendButton;
    private DatabaseReference rootRef;
    private DatabaseReference demoRef;
    private TextView tvValidity;
    private ImageView imgValidity;
    private CountryCodePicker  ccpGetNumber;
    private FirebaseAuth mAuth;
    private ProgressBar spinner,spinnerverify;
    private String mVerificationId;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ccpGetNumber = findViewById(R.id.ccp_getFullNumber);
        phoneText = findViewById(R.id.editText_getCarrierNumber);
        sendButton = findViewById(R.id.sendButton);
        tvValidity = findViewById(R.id.tv_validity);
        imgValidity = findViewById(R.id.img_validity);
        spinner= findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
        registerCarrierEditText();
        rootRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

                signInWithPhoneAuthCredential(phoneAuthCredential);

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                sendButton.setText("Send");
                Toast.makeText(MainActivity.this, "Database error!! please try again later..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCodeSent(String verificationId,PhoneAuthProvider.ForceResendingToken token){
                mVerificationId = verificationId;

                Toast.makeText(MainActivity.this, "Verification code has been sent", Toast.LENGTH_SHORT).show();
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.verification_dialog);
                dialog.setCancelable(false);
                spinnerverify= dialog.findViewById(R.id.progress_verification);
                spinnerverify.setVisibility(View.GONE);

                final Button verifyButton = dialog.findViewById(R.id.btn_verify);
                Button resendButton = dialog.findViewById(R.id.btn_resend);

                verifyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText verificationCode  = dialog.findViewById(R.id.verification_code);
                        String verifyCode = verificationCode.getText().toString();
                        verifyButton.setVisibility(View.GONE);
                        spinnerverify.setVisibility(View.VISIBLE);
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, verifyCode);
                        signInWithPhoneAuthCredential(credential);


                    }

                });
                resendButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendCode();
                        dialog.dismiss();
                    }
                });
                spinner.setVisibility(View.GONE);
                dialog.show();
            }
        };
    }
    private void sendCode() {
        spinner.setVisibility(View.VISIBLE);
        sendButton.setText("Sending");
        sendButton.setOnClickListener(null);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                ccpGetNumber.getFullNumberWithPlus(),
                60,
                TimeUnit.SECONDS,
                MainActivity.this,
                mCallbacks

        );

    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            checkdata(ccpGetNumber.getFullNumberWithPlus());

                        }
                        else{
                            if(task.getException()instanceof FirebaseAuthInvalidCredentialsException){
                                Toast.makeText(MainActivity.this, "Credential error !! ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
    private void checkdata(final String phoneNumber) {
        demoRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference reference = demoRef.child(phoneNumber);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("Name").exists()){
                    reference.child("Name").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String value = dataSnapshot.getValue(String.class);
                            Intent intent = new Intent(MainActivity.this, HotelsPage.class);
                            intent.putExtra("Name", value);
                            startActivity(intent);
                            finish();

                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(MainActivity.this, "Database high traffic !!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    intent.putExtra("phoneNumber", ccpGetNumber.getFullNumberWithPlus());
                    startActivity(intent);
                    finish();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Database high traffic", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void registerCarrierEditText(){
        ccpGetNumber.registerCarrierNumberEditText(phoneText);
        ccpGetNumber.setPhoneNumberValidityChangeListener(new CountryCodePicker.PhoneNumberValidityChangeListener() {
            @Override
            public void onValidityChanged(boolean isValidNumber) {
                if (isValidNumber) {
                    imgValidity.setImageDrawable(getResources().getDrawable(R.drawable.ic_assignment_turned_in_black_24dp));
                    tvValidity.setText("Valid Number");
                    sendButton.setBackgroundColor(getResources().getColor(R.color.green));
                    sendButton.setText("Verify");
                    sendButton.setClickable(true);
                    sendButton.setVisibility(View.VISIBLE);
                    sendButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            sendCode();
                        }
                    });


                } else {
                    imgValidity.setImageDrawable(getResources().getDrawable(R.drawable.ic_assignment_late_black_24dp));
                    tvValidity.setText("Invalid Number");
                    sendButton.setText("Invalid");
                    sendButton.setBackgroundColor(getResources().getColor(R.color.grey));
                    sendButton.setOnClickListener(null);
                    sendButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
