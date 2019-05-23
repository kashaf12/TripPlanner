package com.kfstudio.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

/**
 * Created by Kashaf on 25-03-2018.
 */

public class EndBooking extends AppCompatActivity {
    private BannerSlider goldentulip;
    private RadioGroup ride;
    private RadioButton radioButton;
    private Button bookbutton;
    private LinearLayout ridefare;
    private LinearLayout dob_current;
    private LinearLayout dob_later;
    private LinearLayout adult;
    private TextView ridefaretext;
    private TextView dob_current_text;
    private TextView dob_later_text;
    private TextView addresstext;
    private TextView pricetext;
    private TextView hotelname;
    private EditText name;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endbooking);
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        final Calendar myCalendar = Calendar.getInstance();
        SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yy");
        final String formattedDate1 = df1.format(myCalendar.getTime());
        String myFormat = "dd/MM/yy";
        final SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        name= findViewById(R.id.namebooking);
        final FirebaseUser currentUser = mAuth.getCurrentUser();
        ride = findViewById(R.id.ride);
        bookbutton= findViewById(R.id.bookroom);
        ridefaretext = findViewById(R.id.faretext);
        addresstext= findViewById(R.id.adresstext);
        dob_current_text = findViewById(R.id.dob_current_text);
        pricetext= findViewById(R.id.pricetext);
        hotelname= findViewById(R.id.hotelname);
        dob_later_text = findViewById(R.id.dob_later_text);
        dob_current = findViewById(R.id.dob_current);
        dob_later = findViewById(R.id.dob_later);
        final TextView noofadultss = findViewById(R.id.noofadultss);
        final TextView noofroomss = findViewById(R.id.noofroomss);
        adult = findViewById(R.id.adult);
        goldentulip = findViewById(R.id.upperimage);
        ridefare = findViewById(R.id.bikefarelayout);
        ridefare.setVisibility(View.GONE);
        if (bundle != null) {
            final String name1=(String)bundle.get("Name");
            final String hotelname1 = (String)bundle.get("hotelname");
            String today = (String) bundle.get("Today");
            String tomorrow = (String) bundle.get("Tomorrow");
            String noofrooms = (String) bundle.get("noofrooms");
            String noofadults = (String) bundle.get("noofadults");
            final String img1 = (String) bundle.get("img1");
            final String img2 = (String) bundle.get("img2");
            final String img3 = (String) bundle.get("img3");
            final String img4 = (String) bundle.get("img4");
            String address = (String) bundle.get("address");
            final String price = (String) bundle.get("price");
            hotelname.setText(hotelname1);
            dob_current_text.setText(today);
            dob_later_text.setText(tomorrow);
            noofroomss.setText(noofrooms);
            noofadultss.setText(noofadults);
            addresstext.setText(address);
            pricetext.setText(price);
            name.setText(name1);
        List<Banner> golden = new ArrayList<>();
        golden.add(new RemoteBanner(img1));
        golden.add(new RemoteBanner(img2));
        golden.add(new RemoteBanner(img3));
        golden.add(new RemoteBanner(img4));
        goldentulip.setBanners(golden);
        int selectedId = ride.getCheckedRadioButtonId();
        radioButton = findViewById(selectedId);

        ride.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.yes:
                        ridefare.setVisibility(View.VISIBLE);
                        if((dob_current_text.getText().toString()).equals("Today"))
                        {
                            try {
                                Date date1 = sdf.parse(formattedDate1);
                                Date date2 = sdf.parse(dob_later_text.getText().toString());
                                long diff = date2.getTime() - date1.getTime();
                                int j=(int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                                ridefaretext.setText(j + " X ₹ 300");
                                int rideprice = ((j*300)+ Integer.parseInt(price.substring(1)));
                                pricetext.setText("₹"+rideprice);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                        }else {
                            try {
                                Date date1 = sdf.parse(dob_current_text.getText().toString());
                                Date date2 = sdf.parse(dob_later_text.getText().toString());
                                long diff = date2.getTime() - date1.getTime();
                                int j=(int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                                ridefaretext.setText(j + " X ₹ 300");
                                int rideprice = ((j*300)+ Integer.parseInt(price.substring(1)));
                                pricetext.setText("₹"+rideprice);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case R.id.No:
                        pricetext.setText(price);
                        ridefare.setVisibility(View.GONE);
                        break;

                }
            }
        });

        bookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent1 = new Intent(EndBooking.this, Booking.class);
                    intent1.putExtra("order","no");
                    intent1.putExtra("Name1",name.getText().toString());
                    intent1.putExtra("hotelname",hotelname1);
                    intent1.putExtra("Today", dob_current_text.getText().toString());
                    intent1.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent1.putExtra("noofrooms", noofroomss.getText().toString());
                    intent1.putExtra("noofadults", noofadultss.getText().toString());
                    intent1.putExtra("img1", img1);
                    intent1.putExtra("img2", img2);
                    intent1.putExtra("img3", img3);
                    intent1.putExtra("img4", img4);
                    intent1.putExtra("address", addresstext.getText().toString());
                    intent1.putExtra("price", pricetext.getText().toString());
                    startActivity(intent1);
                    finish();
               }
        });
      }else{
            mAuth.signOut();
            sendToAuth();
        }
    }
    private void sendToAuth(){

        Intent intent = new Intent(EndBooking.this,SplashActivity.class);
        startActivity(intent);
        finish();
    }
}
