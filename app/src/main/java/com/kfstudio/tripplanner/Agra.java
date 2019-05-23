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

public class Agra extends AppCompatActivity {
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
   private final String img1="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fc1.jpg?alt=media&token=624965f2-1d18-4de7-9ff7-dc0c66fbb0ed";
    private final String img2="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fc2.jpg?alt=media&token=95f2c791-00c6-4200-9527-ebafb35c7a81";
    private final String img3="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fc3.jpg?alt=media&token=34fba646-2c0e-4475-ac5c-90e6e7b0481f";
    private final String img4="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fc4.jpg?alt=media&token=49aef651-1ffe-4be6-a5c2-67ddf86fe3dc";
    private final String img5="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fq1.jpg?alt=media&token=e8812c08-1bdc-42fb-b412-49bf2b0b6061";
    private final String img6="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fq2.jpg?alt=media&token=c373ecd0-39af-4c14-9584-747b409a820a";
    private final String img7="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fq3.jpg?alt=media&token=4ba80244-8ec4-45b8-b30f-681d4fffb8e9";
    private final String img8="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fq4.jpg?alt=media&token=77840a41-84d9-4269-8511-93fb655340f3";
    private final String img9="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fd1.jpg?alt=media&token=c9b1c9d4-7d86-47d4-ab9e-f5a531503c21";
    private final String img10="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fd2.jpg?alt=media&token=7a5f4721-65ba-473c-b02b-a56eb433838c";
    private final String img11="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fd3.jpg?alt=media&token=842efb1e-0eb9-4db6-88e4-3670144ebeb2";
    private final String img12="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fd4.jpg?alt=media&token=18e7d801-ee79-4658-893b-c3ff4a69c3d8";
    private final String img13="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fg1.jpg?alt=media&token=07b618d6-5cc7-4a43-8ac2-e55303c7c5a9";
    private final String img14="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fg2.jpg?alt=media&token=85ff2672-447e-42d3-a01c-92c4356615ff";
    private final String img15="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fg3.jpg?alt=media&token=46662016-29ba-4551-a513-0508ce2d9141";
    private final String img16="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fg4.jpg?alt=media&token=adfd9aea-dec0-4432-be7c-12194dc08883";
    private final String img17="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fo1.jpg?alt=media&token=180fc762-5e2f-4d10-822d-0a6dc44825b1";
    private final String img18="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fo2.jpg?alt=media&token=b5e6708e-3298-48d0-aaec-c428bbeddbad";
    private final String img19="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fo3.jpg?alt=media&token=6a7e2557-bec1-4ce9-8716-58b32e30e1f3";
    private final String img20="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/agra%2Fo4.jpg?alt=media&token=516e4a97-bf82-4a97-9c4f-9de7ff2bf443";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agra);
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

                DatePickerDialog datePickerDialog = new DatePickerDialog(Agra.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
        dob_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(Agra.this, date1, myCalendar
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
                final Dialog dialog = new Dialog(Agra.this);
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
                    Toast.makeText(Agra.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
                }else{
                    if(bundle!=null) {
                        String name1 = (String) bundle.get("Name");
                        Intent intent = new Intent(Agra.this, EndBooking.class);
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
                Toast.makeText(Agra.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Agra.this, EndBooking.class);
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
                Toast.makeText(Agra.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Agra.this, EndBooking.class);
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
                Toast.makeText(Agra.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Agra.this, EndBooking.class);
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
                Toast.makeText(Agra.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Agra.this, EndBooking.class);
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
