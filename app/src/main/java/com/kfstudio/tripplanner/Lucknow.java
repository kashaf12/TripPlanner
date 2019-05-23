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

public class Lucknow extends AppCompatActivity {
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
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lucknow);
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

                DatePickerDialog datePickerDialog = new DatePickerDialog(Lucknow.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
        dob_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(Lucknow.this, date1, myCalendar
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
                final Dialog dialog = new Dialog(Lucknow.this);
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
        golden.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fg1.jpg?alt=media&token=ef23d97e-ae0b-4091-9093-e7978f1e3ba2"));
        golden.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fg2.jpg?alt=media&token=a05770a5-285c-4515-b0a5-d8a8d04d0c52"));
        golden.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fg3.jpg?alt=media&token=5c743035-cfb4-4006-96dc-aed2e0f16cf8"));
        go  lden.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fg4.jpg?alt=media&token=f52a41d7-3054-44a0-a818-96c07948837a"));
        goldentulip.setBanners(golden);
        kamal.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk1.jpg?alt=media&token=59ae6d29-b37d-4393-8967-01541adcb1b7"));
        kamal.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk2.jpg?alt=media&token=f3003367-1dcb-40a7-842a-20b6c3588ff0"));
        kamal.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk3.jpg?alt=media&token=d0585d67-6b34-4572-8e91-f02037f261cb"));
        kamal.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk4.jpg?alt=media&token=0c43861a-ff74-48d4-82fe-da2e0ec028ee"));
        hotelkamal.setBanners(kamal);
        savvy.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fs1.jpg?alt=media&token=96d9bd4a-926b-4928-8bdb-741d5a7bc4e0"));
        savvy.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fs2.jpg?alt=media&token=9654f7d7-b06f-4c56-bd7d-2ab2f7d1bb7a"));
        savvy.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fs3.jpg?alt=media&token=ee27a3e5-8fbe-44eb-adc7-fdb5084b553e"));
        savvy.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fs4.jpg?alt=media&token=565bd13b-9fce-4770-a62c-ec1cca87dc5e"));
        savvygrand.setBanners(savvy);
        rovar.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fl1.jpg?alt=media&token=f908cab2-f1af-4873-9262-e0b1887689b3"));
        rovar.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fl2.jpg?alt=media&token=aaff866a-c4fb-4f4d-b1a5-ab8cb990600c"));
        rovar.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fl3.jpg?alt=media&token=cafbc100-e08d-4b63-b8a3-75caa8554e80"));
        rovar.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fl4.jpg?alt=media&token=ba25b4d7-d590-4a46-89c5-ee77ae9472a1"));
        placesarovar.setBanners(rovar);
        renaissance.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr1.jpg?alt=media&token=6846798f-0e1a-4681-9ff5-473ca24f18f6"));
        renaissance.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr2.jpg?alt=media&token=07e0b20f-5e0d-4363-92c5-c56647d7b25e"));
        renaissance.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr3.jpg?alt=media&token=6e6c9f7d-ce31-4d3d-91e7-6c8db2f8fcb0"));
        renaissance.add(new RemoteBanner("https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr4.jpg?alt=media&token=74b00819-5f02-449d-91bf-4c7db31d734a"));
        renaissanc.setBanners(renaissance);
        goldentuliplayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dob_later_text.getText().equals("Select date")) {
                    Toast.makeText(Lucknow.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
                }else{
                    if(bundle!=null) {
                        String name1 = (String) bundle.get("Name");
                        Intent intent = new Intent(Lucknow.this, EndBooking.class);
                        intent.putExtra("Name",name1);
                        intent.putExtra("hotelname", goldenname.getText().toString());
                        intent.putExtra("Today", dob_current_text.getText().toString());
                        intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                        intent.putExtra("noofrooms", noofroomss.getText().toString());
                        intent.putExtra("noofadults", noofadultss.getText().toString());
                        intent.putExtra("img1", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fg1.jpg?alt=media&token=ef23d97e-ae0b-4091-9093-e7978f1e3ba2");
                        intent.putExtra("img2", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fg2.jpg?alt=media&token=a05770a5-285c-4515-b0a5-d8a8d04d0c52");
                        intent.putExtra("img3", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fg3.jpg?alt=media&token=5c743035-cfb4-4006-96dc-aed2e0f16cf8");
                        intent.putExtra("img4", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fg4.jpg?alt=media&token=f52a41d7-3054-44a0-a818-96c07948837a");
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
                Toast.makeText(Lucknow.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Lucknow.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", kamalname.getText().toString());
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("img1", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk1.jpg?alt=media&token=59ae6d29-b37d-4393-8967-01541adcb1b7");
                    intent.putExtra("img2", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk2.jpg?alt=media&token=f3003367-1dcb-40a7-842a-20b6c3588ff0");
                    intent.putExtra("img3", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk3.jpg?alt=media&token=d0585d67-6b34-4572-8e91-f02037f261cb");
                    intent.putExtra("img4", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk4.jpg?alt=media&token=0c43861a-ff74-48d4-82fe-da2e0ec028ee");
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
                Toast.makeText(Lucknow.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Lucknow.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", savvyname.getText().toString());
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("img1","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fs1.jpg?alt=media&token=96d9bd4a-926b-4928-8bdb-741d5a7bc4e0" );
                    intent.putExtra("img2", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fs2.jpg?alt=media&token=9654f7d7-b06f-4c56-bd7d-2ab2f7d1bb7a");
                    intent.putExtra("img3","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fs3.jpg?alt=media&token=ee27a3e5-8fbe-44eb-adc7-fdb5084b553e" );
                    intent.putExtra("img4", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fs4.jpg?alt=media&token=565bd13b-9fce-4770-a62c-ec1cca87dc5e");
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
                Toast.makeText(Lucknow.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Lucknow.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", laplacename.getText().toString());
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("img1","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fl1.jpg?alt=media&token=f908cab2-f1af-4873-9262-e0b1887689b3" );
                    intent.putExtra("img2", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fl2.jpg?alt=media&token=aaff866a-c4fb-4f4d-b1a5-ab8cb990600c");
                    intent.putExtra("img3","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fl3.jpg?alt=media&token=cafbc100-e08d-4b63-b8a3-75caa8554e80" );
                    intent.putExtra("img4","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fl4.jpg?alt=media&token=ba25b4d7-d590-4a46-89c5-ee77ae9472a1");
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
                Toast.makeText(Lucknow.this, "Please choose departing date !!", Toast.LENGTH_SHORT).show();
            }else{
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(Lucknow.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", renaissancename.getText().toString());
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("img1", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr1.jpg?alt=media&token=6846798f-0e1a-4681-9ff5-473ca24f18f6");
                    intent.putExtra("img2","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr2.jpg?alt=media&token=07e0b20f-5e0d-4363-92c5-c56647d7b25e");
                    intent.putExtra("img3","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr3.jpg?alt=media&token=6e6c9f7d-ce31-4d3d-91e7-6c8db2f8fcb0" );
                    intent.putExtra("img4","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr4.jpg?alt=media&token=74b00819-5f02-449d-91bf-4c7db31d734a");
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
