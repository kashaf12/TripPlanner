package com.kfstudio.tripplanner;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.ContentProviderOperation;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Kashaf on 14-02-2018.
 */

public class HotelsPage extends AppCompatActivity {
    private LinearLayout whatsapp;
    private LinearLayout lucknow;
    private LinearLayout sultanpur;
    private LinearLayout kanpur;
    private LinearLayout bengaluru;
    private LinearLayout pune;
    private LinearLayout delhi;
    private LinearLayout searchlocality;
    private LinearLayout agra;
    private LinearLayout ad1;
    private LinearLayout ad2;
    private LinearLayout ad3;
    private LinearLayout ad4;
    private LinearLayout ad5;
    private LinearLayout ad6;
    private LinearLayout ad7;
    private LinearLayout ad8;
    private LinearLayout ad9;
    private ImageButton profile;
    private ImageButton wallet;
    private final String img10="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/bengaluru%2Fm1.jpg?alt=media&token=21640533-83d3-4f49-b47e-c0e661faa4e2";
    private final String img21="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/bengaluru%2Fm2.jpg?alt=media&token=a23b0405-5322-4e9a-8516-33c4619aa210";
    private final String img32="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/bengaluru%2Fm3.jpg?alt=media&token=985028e7-30d3-43d6-869e-cd65c08a22dd";
    private final String img5="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/bengaluru%2Fj1.jpg?alt=media&token=00eea6d9-a0a2-4420-9d12-d802089fba2b";
    private final String img6="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/bengaluru%2Fj2.jpg?alt=media&token=dbc5b8c4-2f53-42d8-8b5b-67bd7c2cd2d6";
    private final String img7="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/bengaluru%2Fj3.jpg?alt=media&token=7c05c923-9091-40af-9031-2cbd836c238c";
    private final String img8="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/bengaluru%2Fj4.jpg?alt=media&token=d765c9e8-a9a2-42f1-be33-720347bbcd2f";
    private final String img43="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/bengaluru%2Fm4.jpg?alt=media&token=7e0a777c-c5a2-4b0c-ae38-027b5c4997be";
    private final String img13="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/delhi%2Fo1.jpg?alt=media&token=737b4362-c2a7-463b-8730-986ca6a0ba26";
    private final String img14="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/delhi%2Fo2.jpg?alt=media&token=58f93585-5a00-4136-9313-7d724ca1421e";
    private final String img15="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/delhi%2Fo3.jpg?alt=media&token=66e76466-582f-46ec-903b-6e9ebb42421e";
    private final String img16="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/delhi%2Fo4.jpg?alt=media&token=95795d77-4a35-4d1a-8522-e294796c0b5f";
    private final String img1="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fp1.jpg?alt=media&token=942f970d-37a3-440c-8a30-101972e21775";
    private final String img2="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fp2.jpg?alt=media&token=c406d1a7-e820-4a7b-bea8-9103842c0357";
    private final String img3="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fp3.jpg?alt=media&token=57c582b4-9a3a-4832-b279-3fd71db7c0e4";
    private final String img4="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/hyderabad%2Fp4.jpg?alt=media&token=4ac31782-b162-437e-a4c6-42908c661882";
    private final String img17="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/goa%2Fq.jpg?alt=media&token=7ae4df47-b294-477d-b071-38bd742f3f26";
    private final String img18="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/goa%2Fr.jpg?alt=media&token=0ca98725-5f4d-4d59-b918-707e13f8a7e7";
    private final String img19="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/goa%2Fs.jpg?alt=media&token=02c95f9d-dfe2-490b-af39-be924bf3f74f";
    private final String img20="https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/goa%2Ft.jpg?alt=media&token=f240d3cc-32f1-45a1-b654-b42567bd9d20";
    private TextView name;
    private Button search;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        setContentView(R.layout.hotels_page);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        Date tomorrow1 = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        final String tomorrowAsString = dateFormat.format(tomorrow);
        final String tomorrowAsString1 = dateFormat.format(tomorrow1);
        CircleImageView iv = findViewById(R.id.nearby);
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                iv,PropertyValuesHolder.ofFloat("scaleX", 0.96f),
                PropertyValuesHolder.ofFloat("scaleY", 0.96f));
        scaleDown.setDuration(300);
        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown.start();
        lucknow= findViewById(R.id.lucknow);
        ad1= findViewById(R.id.ad1);
        ad2= findViewById(R.id.ad2);
        ad3= findViewById(R.id.ad3);
        ad4= findViewById(R.id.ad4);
        ad5= findViewById(R.id.ad5);
        ad6= findViewById(R.id.ad6);
        ad7= findViewById(R.id.ad7);
        ad8= findViewById(R.id.ad8);
        ad9= findViewById(R.id.ad9);
        profile= findViewById(R.id.profile);
        search= findViewById(R.id.searchbox);
        wallet = findViewById(R.id.wallet);
        delhi= findViewById(R.id.delhi);
        searchlocality= findViewById(R.id.searchlocality);
        agra= findViewById(R.id.agra);
        pune= findViewById(R.id.pune);
        bengaluru= findViewById(R.id.bengaluru);
        name = findViewById(R.id.name);
        kanpur= findViewById(R.id.kanpur);
        sultanpur= findViewById(R.id.sultanpur);
        whatsapp= findViewById(R.id.werwhatsapp);

        if(bundle!=null) {
            String name1 = (String) bundle.get("Name");
            name.setText("Hello, "+ name1);
        }
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this,ProfileActivity.class);
                    intent.putExtra("Name", name1);
                    startActivity(intent);

                }else{
                    Intent intent = new Intent(HotelsPage.this,SplashActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this,Booking.class);
                    intent.putExtra("Name", name1);
                    intent.putExtra("order","yes");
                    startActivity(intent);

                }else{
                    Intent intent = new Intent(HotelsPage.this,Booking.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(whatsappInstalledOrNot()){
                    savecontact();
                    Uri uri = Uri.parse("smsto:" + " ");
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                }else {

                    Uri uri = Uri.parse("market://details?id=com.whatsapp");
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(goToMarket);

                }
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                Intent intent = new Intent(HotelsPage.this,SearchLocalities.class);
                intent.putExtra("Name",name1);
                startActivity(intent);
            }}
        });
        searchlocality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this,SearchLocalities.class);
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }}
        });
        lucknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this,Lucknow.class);
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", "Select date");
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }}
        });
        sultanpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this,Sultanpur.class);
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", "Select date");
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }}
        });
        kanpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this,Kanpur.class);
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", "Select date");
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }}
        });
        bengaluru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this,Bengaluru.class);
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", "Select date");
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }}
        });
        pune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this,Pune.class);
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", "Select date");
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }}
        });
        delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this,Delhi.class);
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", "Select date");
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }}
        });
        agra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null){
                    String name1 = (String)bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this,Agra.class);
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", "Select date");
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }}
        });
        ad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", "Renaissance Lucknow Hotel");
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", tomorrowAsString);
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "2 Adults");
                    intent.putExtra("img1", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr1.jpg?alt=media&token=6846798f-0e1a-4681-9ff5-473ca24f18f6");
                    intent.putExtra("img2","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr2.jpg?alt=media&token=07e0b20f-5e0d-4363-92c5-c56647d7b25e");
                    intent.putExtra("img3","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr3.jpg?alt=media&token=6e6c9f7d-ce31-4d3d-91e7-6c8db2f8fcb0" );
                    intent.putExtra("img4","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr4.jpg?alt=media&token=74b00819-5f02-449d-91bf-4c7db31d734a");
                    intent.putExtra("address","Vipin Khand, Gomti Nagar, 226010 Lucknow, India ");
                    intent.putExtra("price", "₹4000");
                    Toast.makeText(HotelsPage.this, "50% discount", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }

        });
        ad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", "Hotel Kamal");
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", tomorrowAsString);
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("img1", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk1.jpg?alt=media&token=59ae6d29-b37d-4393-8967-01541adcb1b7");
                    intent.putExtra("img2", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk2.jpg?alt=media&token=f3003367-1dcb-40a7-842a-20b6c3588ff0");
                    intent.putExtra("img3", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk3.jpg?alt=media&token=d0585d67-6b34-4572-8e91-f02037f261cb");
                    intent.putExtra("img4", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fk4.jpg?alt=media&token=0c43861a-ff74-48d4-82fe-da2e0ec028ee");
                    intent.putExtra("address","55/123, A/2, Chitwapur Road, Husainganj,, 226001 Lucknow, India");
                    intent.putExtra("price", "₹629");
                    Toast.makeText(HotelsPage.this, "83% discount", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }

        });
        ad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", "Novotel Goa Resort and Spa");
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", tomorrowAsString);
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("img1", img17);
                    intent.putExtra("img2", img18);
                    intent.putExtra("img3", img19);
                    intent.putExtra("img4", img20);
                    intent.putExtra("address","Pinto Waddo, Candolim, Bardez, 403515 Candolim, India");
                    intent.putExtra("price", "₹1000");
                    Toast.makeText(HotelsPage.this, "90% discount", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }

        });
        ad4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", "Novotel Goa Resort and Spa");
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", tomorrowAsString);
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("img1", img17);
                    intent.putExtra("img2", img18);
                    intent.putExtra("img3", img19);
                    intent.putExtra("img4", img20);
                    intent.putExtra("address","Pinto Waddo, Candolim, Bardez, 403515 Candolim, India");
                    intent.putExtra("price", "₹4000");
                    Toast.makeText(HotelsPage.this, "you have unlocked premium rooms with 55% discount", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }

        });
        ad5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", "Renaissance Lucknow Hotel");
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", tomorrowAsString1);
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "2 Adults");
                    intent.putExtra("img1", "https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr1.jpg?alt=media&token=6846798f-0e1a-4681-9ff5-473ca24f18f6");
                    intent.putExtra("img2","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr2.jpg?alt=media&token=07e0b20f-5e0d-4363-92c5-c56647d7b25e");
                    intent.putExtra("img3","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr3.jpg?alt=media&token=6e6c9f7d-ce31-4d3d-91e7-6c8db2f8fcb0" );
                    intent.putExtra("img4","https://firebasestorage.googleapis.com/v0/b/tripplanner-b51c5.appspot.com/o/lucknow%2Fr4.jpg?alt=media&token=74b00819-5f02-449d-91bf-4c7db31d734a");
                    intent.putExtra("address","Vipin Khand, Gomti Nagar, 226010 Lucknow, India ");
                    intent.putExtra("price", "₹4000");
                    Toast.makeText(HotelsPage.this, "50% discount for 3 days 2 night", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }

        });
        ad6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", "Park Hyatt");
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", tomorrowAsString);
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("img1", img1);
                    intent.putExtra("img2", img2);
                    intent.putExtra("img3", img3);
                    intent.putExtra("img4", img4);
                    intent.putExtra("address","Road No. 2, Banjara Hills, Srinagar Colony, 500034 Hyderabad, India");
                    intent.putExtra("price", "₹4000");
                    Toast.makeText(HotelsPage.this, "55% discount", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }

        });
        ad7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", "Bengaluru Marriott");
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", tomorrowAsString);
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("img1", img10);
                    intent.putExtra("img2", img21);
                    intent.putExtra("img3", img32);
                    intent.putExtra("img4", img43);
                    intent.putExtra("address","8th Road, Plot No 75,EPIP Area, Whitefield , Whitefield, 560066 Bangalore, India");
                    intent.putExtra("price", "₹699");
                    startActivity(intent);
                }
            }

        });
        ad8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", "JW Marriott");
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", tomorrowAsString);
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("img1", img5);
                    intent.putExtra("img2", img6);
                    intent.putExtra("img3", img7);
                    intent.putExtra("img4", img8);
                    intent.putExtra("address","24/1 Vittal Mallya Road, 560001 Bangalore, India");
                    intent.putExtra("price", "₹1499");
                    Toast.makeText(HotelsPage.this, "pay ₹1499", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }

        });
        ad9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(HotelsPage.this, EndBooking.class);
                    intent.putExtra("Name",name1);
                    intent.putExtra("hotelname", "The Oberoi");
                    intent.putExtra("Today", "Today");
                    intent.putExtra("Tomorrow", tomorrowAsString1);
                    intent.putExtra("noofrooms", "1 Rooms");
                    intent.putExtra("noofadults", "1 Adults");
                    intent.putExtra("img1", img13);
                    intent.putExtra("img2", img14);
                    intent.putExtra("img3", img15);
                    intent.putExtra("img4", img16);
                    intent.putExtra("address","Dr. Zakir Hussain Marg, 110003 New Delhi, India");
                    intent.putExtra("price", "₹999");
                    Toast.makeText(HotelsPage.this, "pay now ₹999", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }

        });
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

   }
