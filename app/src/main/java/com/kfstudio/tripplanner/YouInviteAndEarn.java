package com.kfstudio.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Kashaf on 13-03-2018.
 */

public class YouInviteAndEarn extends AppCompatActivity {
    private ImageButton share;
    private TextView invitecode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.you_invite_and_earn);
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        invitecode = findViewById(R.id.invitecode);
        share = findViewById(R.id.share);
        if (bundle != null) {

            final String phone = (String) bundle.get("PhoneNumber");
            invitecode.setText( phone);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "I recommend you use the Trip Planner app for hassles-free stays at affordable prices. Download and get 500 INR Trip Planner. Use code: " + phone);
                shareIntent.setType("text/*");
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "Invite And Earn"));

            }
        });
    }
    }

}
