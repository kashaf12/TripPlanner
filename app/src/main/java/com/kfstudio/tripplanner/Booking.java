package com.kfstudio.tripplanner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

/**
 * Created by Kashaf on 01-03-2018.
 */

public class Booking extends AppCompatActivity {
    private TextView bookingtext;
    private TextView name2;
    private Button booknow;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        LinearLayout l1= findViewById(R.id.l1);
        BannerSlider bookingimage1= findViewById(R.id.bookingimage1);
        name2= findViewById(R.id.name);
        TextView hotelbookingname1= findViewById(R.id.hotelbookingname1);
        TextView addressbooking1= findViewById(R.id.addressbooking1);
            TextView datesbooking1= findViewById(R.id.datesbooking1);
        TextView pricebooking1= findViewById(R.id.pricebooking1);
        Intent intent = getIntent();
        Intent intent1 = getIntent();
        booknow= findViewById(R.id.booknow1);
        final Bundle bundle1=intent1.getExtras();
        final Bundle bundle = intent.getExtras();
        l1.setVisibility(View.GONE);
        bookingtext = findViewById(R.id.bookingtext);
        bookingtext.setVisibility(View.VISIBLE);
        booknow.setVisibility(View.VISIBLE);

        if(bundle!=null ) {
            String name = preferences.getString("Name", "empty");
            String name1 = (String) bundle.get("Name");
            String order=(String)bundle.get("order");
            if(order.equals("yes")){
            if(name.equals("empty")){
                bookingtext.setVisibility(View.VISIBLE);
                booknow.setVisibility(View.VISIBLE);
                bookingtext.setText(name1 + ", Start booking to unlock rooms");
            }else{
                bookingtext.setVisibility(View.GONE);
                booknow.setVisibility(View.GONE);
                l1.setVisibility(View.VISIBLE);
            String hotelname = preferences.getString("hotelname", "");
            String today = preferences.getString("Today", "");
            String tomorrow = preferences.getString("Tomorrow", "");
            String noofrooms = preferences.getString("noofrooms", "");
            String noofadults = preferences.getString("noofadults", "");
            String img1 = preferences.getString("img1", "");
            String img2 = preferences.getString("img2", "");
            String img3 = preferences.getString("img3", "");
            String img4 = preferences.getString("img4", "");
            String address = preferences.getString("address", "");
            String price = preferences.getString("price", "");
            name2.setText(name);

            List<Banner> l11 = new ArrayList<>();
            l11.add(new RemoteBanner(img1));
            l11.add(new RemoteBanner(img2));
            l11.add(new RemoteBanner(img3));
            l11.add(new RemoteBanner(img4));
            bookingimage1.setBanners(l11);
            hotelbookingname1.setText(hotelname);
            addressbooking1.setText(address);
            pricebooking1.setText(price);
            datesbooking1.setText(today + " - " + tomorrow + " - " + noofrooms + " - " + noofadults );
        }
        }}
        if(bundle1!=null){
            String order = (String)bundle1.get("order");
            String name1=(String)bundle1.get("Name1");
            String hotelname=(String)bundle1.get("hotelname");
            String today = (String) bundle1.get("Today");
            String tomorrow = (String) bundle1.get("Tomorrow");
            String noofrooms = (String) bundle1.get("noofrooms");
            String noofadults = (String) bundle1.get("noofadults");
            final String img1 = (String) bundle1.get("img1");
            final String img2 = (String) bundle1.get("img2");
            final String img3 = (String) bundle1.get("img3");
            final String img4 = (String) bundle1.get("img4");
            String address = (String) bundle1.get("address");
            final String price = (String) bundle1.get("price");
            if(order.equals("no")) {
                editor.putString("Name", name1);
                editor.putString("hotelname", hotelname);
                editor.putString("Today", today);
                editor.putString("Tomorrow", tomorrow);
                editor.putString("noofrooms", noofrooms);
                editor.putString("noofadults", noofadults);
                editor.putString("img1", img1);
                editor.putString("img2", img2);
                editor.putString("img3", img3);
                editor.putString("img4", img4);
                editor.putString("address", address);
                editor.putString("price", price);
                editor.apply();
                name2.setText(name1);
                bookingtext.setVisibility(View.GONE);
                booknow.setVisibility(View.GONE);
                l1.setVisibility(View.VISIBLE);
                List<Banner> l11 = new ArrayList<>();
                l11.add(new RemoteBanner(img1));
                l11.add(new RemoteBanner(img2));
                l11.add(new RemoteBanner(img3));
                l11.add(new RemoteBanner(img4));
                bookingimage1.setBanners(l11);
                hotelbookingname1.setText(hotelname);
                addressbooking1.setText(address);
                pricebooking1.setText(price);
                datesbooking1.setText(today + " - " + tomorrow + " - " + noofrooms + " - " + noofadults);

            }
        }
        booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                    Intent intent = new Intent(Booking.this,SearchLocalities.class);
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }}
        });

    }
}
