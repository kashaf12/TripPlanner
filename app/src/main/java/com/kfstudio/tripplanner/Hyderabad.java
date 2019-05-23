package com.kfstudio.tripplanner;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPickerListener;


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
 * Created by Kashaf on 23-03-2018.
 */

public class Hyderabad extends AppCompatActivity {
    private BannerSlider goldentulip;
    private BannerSlider hotelkamal;
    private BannerSlider savvygrand;
    private BannerSlider placesarovar;
    private BannerSlider renaissanc;
    private LinearLayout dob_current;
    private LinearLayout dob_later;
    private LinearLayout adult;
    private LinearLayout goldentuliplayout;
    private LinearLayout hotelkamallayout;
    private LinearLayout savvylayout;
    private LinearLayout laplacelayout;
    private LinearLayout renaissancelayout;
    private TextView dob_current_text;
    private TextView dob_later_text;
    private TextView pricegolden;
    private TextView pricekamal;
    private TextView addresslaplace;
    private TextView renaissancename;
    private TextView addressrenaissance;
    private TextView addresssavvy;
    private TextView privesavvy;
    private TextView pricesarovar;
    private TextView pricerenaissance;
    private TextView addressgolden;
    private TextView goldenname;
    private TextView kamalname;
    private TextView savvyname;
    private TextView laplacename;
    private TextView addresskamal;
    private int j=1;
    private final String img1="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fp1.jpg?alt=media&token=942f970d-37a3-440c-8a30-101972e21775";
    private final String img2="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fp2.jpg?alt=media&token=c406d1a7-e820-4a7b-bea8-9103842c0357";
    private final String img3="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fp3.jpg?alt=media&token=57c582b4-9a3a-4832-b279-3fd71db7c0e4";
    private final String img4="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fp4.jpg?alt=media&token=4ac31782-b162-437e-a4c6-42908c661882";
    private final String img5="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fs1.jpg?alt=media&token=e89a1fd9-c7db-49ff-abac-46c04eaa8d8d";
    private final String img6="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fs2.jpg?alt=media&token=abe65191-b308-4218-a611-a2c3bc117a29";
    private final String img7="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fs3.jpg?alt=media&token=6d6a9b45-432e-4096-b2c5-843bf6da8ebe";
    private final String img8="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fs4.jpg?alt=media&token=ccf809de-3ceb-4ddb-b02e-0bd4229bbb45";
    private final String img9="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Ft1.jpg?alt=media&token=1fc170ab-014c-415c-ba1d-8d0c067b00a7";
    private final String img10="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Ft2.jpg?alt=media&token=b76eb42d-1b92-40ac-89cb-54452638efc8";
    private final String img11="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Ft3.jpg?alt=media&token=65f6ded2-6cfb-4ef3-bec0-f6ec260a41c0";
    private final String img12="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Ft4.jpg?alt=media&token=fee0154c-083a-4a36-b277-09cdb8da47a4";
    private final String img13="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fw1.jpg?alt=media&token=e8b654fa-49ec-40e8-b144-6e59238335ec";
    private final String img14="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fw2.jpg?alt=media&token=a4267fee-1138-4e72-89e3-03cf688f7608";
    private final String img15="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fw3.jpg?alt=media&token=efc8657a-d945-4b8c-b900-2555982c27b2";
    private final String img16="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fw4.jpg?alt=media&token=beb42b95-1790-47e4-9f1a-b0a41793faa4";
    private final String img17="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fv1.jpg?alt=media&token=c299cb53-e471-479b-9f67-84e8d2ec68de";
    private final String img18="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fv2.jpg?alt=media&token=419bf996-e746-4de5-aaaa-c6b55e73e12d";
    private final String img19="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fv3.jpg?alt=media&token=2f2d7764-0592-4ac5-9bdc-192f3615d13f";
    private final String img20="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fv4.jpg?alt=media&token=91494fc0-18d0-415b-882d-d727dfcd00ce";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hyderabad);
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        goldentuliplayout= findViewById(R.id.goldentuliplayout);
        goldenname= findViewById(R.id.goldenname);
        laplacename= findViewById(R.id.laplacename);
        addressrenaissance= findViewById(R.id.addressrenaissance);
        addressgolden= findViewById(R.id.addressgolden);
        addresslaplace= findViewById(R.id.addresslaplace);
        goldentulip = findViewById(R.id.goldentulip);
        hotelkamal = findViewById(R.id.hotelkamal);
        addresskamal= findViewById(R.id.addresskamal);
        renaissancename= findViewById(R.id.renaissancename);
        kamalname= findViewById(R.id.kamalname);
        laplacelayout= findViewById(R.id.laplacelayout);
        savvylayout= findViewById(R.id.savvylayout);
        savvyname= findViewById(R.id.savvyname);
        addresssavvy= findViewById(R.id.addresssavvy);
        renaissancelayout= findViewById(R.id.renaissancelayout);
        hotelkamallayout= findViewById(R.id.hotelkamallayout);
        savvygrand = findViewById(R.id.hotelsavvygrand);
        placesarovar = findViewById(R.id.laplacesarovarportico);
        renaissanc = findViewById(R.id.renaissancelucknowhtel);
        dob_current_text= findViewById(R.id.dob_current_text);
        dob_later_text= findViewById(R.id.dob_later_text);
        dob_current= findViewById(R.id.dob_current);
        dob_later= findViewById(R.id.dob_later);
        adult= findViewById(R.id.adult);
        pricegolden= findViewById(R.id.pricegolden);
        pricekamal= findViewById(R.id.pricekamal);
        privesavvy= findViewById(R.id.pricesavvy);
        pricesarovar= findViewById(R.id.pricesarovar);
        pricerenaissance= findViewById(R.id.pricerenaissance);
        final TextView noofadultss = findViewById(R.id.noofadultss);
        final TextView noofroomss = findViewById(R.id.noofroomss);
        pricegolden.setText("₹"+Integer.toString(price(noofroomss.getText().toString(),j)));
        pricekamal.setText("₹"+Integer.toString(price1(noofroomss.getText().toString(),j)));
        pricesarovar.setText("₹"+Integer.toString(price2(noofroomss.getText().toString(),j)));
        privesavvy.setText("₹"+Integer.toString(price3(noofroomss.getText().toString(),j)));
        pricerenaissance.setText("₹"+Integer.toString(price4(noofroomss.getText().toString(),j)));
        if(bundle!=null) {

            String today = (String) bundle.get("Today");
            String tomorrow = (String) bundle.get("Tomorrow");
            String noofrooms = (String) bundle.get("noofrooms");
            String noofadults = (String) bundle.get("noofadults");
            dob_current_text.setText(today);
            dob_later_text.setText(tomorrow);
            noofroomss.setText(noofrooms);
            noofadultss.setText(noofadults);
        }
        final Calendar myCalendar = Calendar.getInstance();
        SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yy");
        final String formattedDate1 = df1.format(myCalendar.getTime());
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                if((sdf.format(myCalendar.getTime())).equals(formattedDate1)){
                    dob_current_text.setText("Today");
                }else{
                    dob_current_text.setText(sdf.format(myCalendar.getTime()));
                }
            }

        };
        final DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                dob_later_text.setText(sdf.format(myCalendar.getTime()));
                if((dob_current_text.getText().toString()).equals("Today"))
                {
                    try {
                        Date date1 = sdf.parse(formattedDate1);
                        Date date2 = sdf.parse(dob_later_text.getText().toString());
                        long diff = date2.getTime() - date1.getTime();
                        j=(int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                        pricegolden.setText("₹"+Integer.toString(price(noofroomss.getText().toString(),j)));
                        pricekamal.setText("₹"+Integer.toString(price1(noofroomss.getText().toString(),j)));
                        pricesarovar.setText("₹"+Integer.toString(price2(noofroomss.getText().toString(),j)));
                        privesavvy.setText("₹"+Integer.toString(price3(noofroomss.getText().toString(),j)));
                        pricerenaissance.setText("₹"+Integer.toString(price4(noofroomss.getText().toString(),j)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }else {
                    try {
                        Date date1 = sdf.parse(dob_current_text.getText().toString());
                        Date date2 = sdf.parse(dob_later_text.getText().toString());
                        long diff = date2.getTime() - date1.getTime();
                        j=(int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                        pricegolden.setText("₹"+Integer.toString(price(noofroomss.getText().toString(),j)));
                        pricekamal.setText("₹"+Integer.toString(price1(noofroomss.getText().toString(),j)));
                        pricesarovar.setText("₹"+Integer.toString(price2(noofroomss.getText().toString(),j)));
                        privesavvy.setText("₹"+Integer.toString(price3(noofroomss.getText().toString(),j)));
                        pricerenaissance.setText("₹"+Integer.toString(price4(noofroomss.getText().toString(),j)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            }

        };
        dob_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(Hyderabad.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
        dob_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(Hyderabad.this, date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                myCalendar.add(Calendar.DATE,1);
                datePickerDialog.getDatePicker().setMinDate(myCalendar.getTimeInMillis());
                datePickerDialog.show();
            }
        });
        adult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Hyderabad.this);
                dialog.setContentView(R.layout.adult_dialog);
                dialog.setCancelable(false);
                final Button verifyButton = dialog.findViewById(R.id.btn_verify);
                final ScrollableNumberPicker noofrooms= dialog.findViewById(R.id.noofrooms);
                final ScrollableNumberPicker noofadults= dialog.findViewById(R.id.noofadults);
                noofrooms.setValue(1);
                noofadults.setValue(1);
                noofrooms.setListener(new ScrollableNumberPickerListener() {
                    @Override
                    public void onNumberPicked(int value) {
                        String x = Integer.toString(value);
                        noofroomss.setText(x + " Rooms");
                    }
                });
                noofadults.setListener(new ScrollableNumberPickerListener() {
                    @Override
                    public void onNumberPicked(int value) {
                        String x = Integer.toString(value);
                        noofadultss.setText(x + " Adults");
                    }
                });
                verifyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pricegolden.setText("₹"+Integer.toString(price(noofroomss.getText().toString(),j)));
                        pricekamal.setText("₹"+Integer.toString(price1(noofroomss.getText().toString(),j)));
                        pricesarovar.setText("₹"+Integer.toString(price2(noofroomss.getText().toString(),j)));
                        privesavvy.setText("₹"+Integer.toString(price3(noofroomss.getText().toString(),j)));
                        pricerenaissance.setText("₹"+Integer.toString(price4(noofroomss.getText().toString(),j)));
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        List<Banner> kamal = new ArrayList<>();
        List<Banner> golden=new ArrayList<>();
        List<Banner> savvy = new ArrayList<>();
        List<Banner> rovar=new ArrayList<>();
        List<Banner> renaissance = new ArrayList<>();
        golden.add(new RemoteBanner(img1));
        golden.add(new RemoteBanner(img2));
        golden.add(new RemoteBanner(img3));
        golden.add(new RemoteBanner(img4));
        goldentulip.setBanners(golden);
        kamal.add(new RemoteBanner(img5));
        kamal.add(new RemoteBanner(img6));
        kamal.add(new RemoteBanner(img7));
        kamal.add(new RemoteBanner(img8));
        hotelkamal.setBanners(kamal);
        savvy.add(new RemoteBanner(img9));
        savvy.add(new RemoteBanner(img10));
        savvy.add(new RemoteBanner(img11));
        savvy.add(new RemoteBanner(img12));
        savvygrand.setBanners(savvy);
        rovar.add(new RemoteBanner(img13));
        rovar.add(new RemoteBanner(img14));
        rovar.add(new RemoteBanner(img15));
        rovar.add(new RemoteBanner(img16));
        placesarovar.setBanners(rovar);
        renaissance.add(new RemoteBanner(img17));
        renaissance.add(new RemoteBanner(img18));
        renaissance.add(new RemoteBanner(img19));
        renaissance.add(new RemoteBanner(img20));
        renaissanc.setBanners(renaissance);
        goldentuliplayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dob_later_text.getText().equals("Select date")) {
                    Toast.makeText(Hyderabad.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
                }else{
                    if(bundle!=null) {
                        String name1 = (String) bundle.get("Name");
                        Intent intent = new Intent(Hyderabad.this, EndBooking.class);
                        intent.putExtra("Name",name1);
                        intent.putExtra("hotelname", goldenname.getText().toString());
                        intent.putExtra("Today", dob_current_text.getText().toString());
                        intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                        intent.putExtra("noofrooms", noofroomss.getText().toString());
                        intent.putExtra("noofadults", noofadultss.getText().toString());
                        intent.putExtra("img1", img1);
                        intent.putExtra("img2", img2);
                        intent.putExtra("img3", img3);
                        intent.putExtra("img4", img4);
                        intent.putExtra("address", addressgolden.getText().toString());
                        intent.putExtra("price", pricegolden.getText().toString());
                        startActivity(intent);
                    }
                }
            }
        });
        hotelkamallayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {if(dob_later_text.getText().equals("Select date")) {
                Toast.makeText(Hyderabad.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Hyderabad.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", kamalname.getText().toString());
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("img1", img5);
                    intent.putExtra("img2", img6);
                    intent.putExtra("img3", img7);
                    intent.putExtra("img4", img8);
                    intent.putExtra("address", addresskamal.getText().toString());
                    intent.putExtra("price", pricekamal .getText().toString());
                    startActivity(intent);
                }
            }
            }
        });
        savvylayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {if(dob_later_text.getText().equals("Select date")) {
                Toast.makeText(Hyderabad.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Hyderabad.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", savvyname.getText().toString());
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("img1",img9 );
                    intent.putExtra("img2", img10);
                    intent.putExtra("img3",img11 );
                    intent.putExtra("img4", img12);
                    intent.putExtra("address", addresssavvy.getText().toString());
                    intent.putExtra("price", privesavvy.getText().toString());
                    startActivity(intent);
                }
            }
            }
        });
        laplacelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {if(dob_later_text.getText().equals("Select date")) {
                Toast.makeText(Hyderabad.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Hyderabad.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", laplacename.getText().toString());
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("img1",img13 );
                    intent.putExtra("img2", img14);
                    intent.putExtra("img3",img15 );
                    intent.putExtra("img4",img16);
                    intent.putExtra("address", addresslaplace.getText().toString());
                    intent.putExtra("price", pricesarovar.getText().toString());
                    startActivity(intent);
                }
            }
            }
        });
        renaissancelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {if(dob_later_text.getText().equals("Select date")) {
                Toast.makeText(Hyderabad.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Hyderabad.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", renaissancename.getText().toString());
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("img1", img17);
                    intent.putExtra("img2",img18);
                    intent.putExtra("img3",img19 );
                    intent.putExtra("img4",img20);
                    intent.putExtra("address", addressrenaissance.getText().toString());
                    intent.putExtra("price", pricerenaissance.getText().toString());
                    startActivity(intent);
                }
            }
            }
        });
    }
    private int price(String a, int b){

        int d = 1000;
        int c=d*2;
        int e = d*3;
        switch (a){

            case "2 Rooms": return c*b;

            case "3 Rooms":  return e*b;

            default: return d*b;


        }

    }
    private int price1(String a, int b){

        int d = 3000;
        int c=d*2;
        int e = d*3;
        switch (a){

            case "2 Rooms": return c*b;

            case "3 Rooms":  return e*b;

            default: return d*b;


        }

    }
    private int price2(String a, int b){

        int d = 7700;
        int c=d*2;
        int e = d*3;
        switch (a){

            case "2 Rooms": return c*b;

            case "3 Rooms":  return e*b;

            default: return d*b;


        }

    }
    private int price3(String a, int b){

        int d =6000;
        int c=d*2;
        int e = d*3;
        switch (a){

            case "2 Rooms": return c*b;

            case "3 Rooms":  return e*b;

            default: return d*b;


        }

    }
    private int price4(String a, int b){

        int d = 8000;
        int c=d*2;
        int e = d*3;
        switch (a){

            case "2 Rooms": return c*b;

            case "3 Rooms":  return e*b;

            default: return d*b;


        }

    }

}
