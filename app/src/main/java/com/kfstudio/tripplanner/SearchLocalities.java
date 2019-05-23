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

import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPickerListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * Created by Kashaf on 14-03-2018.
 */

public class SearchLocalities extends AppCompatActivity {
    private LinearLayout dob_current;
    private LinearLayout dob_later;
    private LinearLayout adult;
    private TextView dob_current_text;
    private TextView dob_later_text;
    private TextView lucknow;
    private TextView sultanpur;
    private TextView kanpur;
    private TextView bengaluru;
    private TextView pune;
    private TextView delhi;
    private TextView agra;
    private TextView hyderabad;
    private TextView goa;
    private TextView chennai;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_localitites);
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        dob_current_text= findViewById(R.id.dob_current_text);
        dob_later_text= findViewById(R.id.dob_later_text);
        dob_current= findViewById(R.id.dob_current);
        dob_later= findViewById(R.id.dob_later);
        adult= findViewById(R.id.adult);
        pune= findViewById(R.id.pune);
        bengaluru= findViewById(R.id.bengaluru);
        agra= findViewById(R.id.agra);
        kanpur= findViewById(R.id.kanpur);
        hyderabad= findViewById(R.id.hyderabad);
        goa= findViewById(R.id.goa);
        chennai= findViewById(R.id.chennai);
        lucknow= findViewById(R.id.lucknow);
        delhi= findViewById(R.id.delhi);
        sultanpur= findViewById(R.id.sultanpur);
        final TextView noofadultss = findViewById(R.id.noofadultss);
        final TextView noofroomss = findViewById(R.id.noofroomss);
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


            }

        };
        dob_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(SearchLocalities.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
        dob_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(SearchLocalities.this, date1, myCalendar
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
        final Dialog dialog = new Dialog(SearchLocalities.this);
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
                dialog.dismiss();
            }
        });
        dialog.show();
    }
});
lucknow.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(bundle!=null) {
            String name1 = (String) bundle.get("Name");
            Intent intent = new Intent(SearchLocalities.this, Lucknow.class);
            intent.putExtra("Today", dob_current_text.getText().toString());
            intent.putExtra("Tomorrow", dob_later_text.getText().toString());
            intent.putExtra("noofrooms", noofroomss.getText().toString());
            intent.putExtra("noofadults", noofadultss.getText().toString());
            intent.putExtra("Name",name1);
            startActivity(intent);
        }
    }
});
        sultanpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(SearchLocalities.this, Sultanpur.class);
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }
            }
        });
        kanpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(SearchLocalities.this, Kanpur.class);
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }
            }
        });
        bengaluru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");

                    Intent intent = new Intent(SearchLocalities.this, Bengaluru.class);
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }
            }
        });
        pune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(SearchLocalities.this, Pune.class);
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }
            }
        });
        delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(SearchLocalities.this, Delhi.class);
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }
            }
        });
        agra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(SearchLocalities.this, Agra.class);
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }
            }
        });
        hyderabad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(SearchLocalities.this, Hyderabad.class);
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }
            }
        });
        goa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(SearchLocalities.this, Goa.class);
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }
            }
        });
        chennai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bundle!=null) {
                    String name1 = (String) bundle.get("Name");
                    Intent intent = new Intent(SearchLocalities.this, Chennai.class);
                    intent.putExtra("Today", dob_current_text.getText().toString());
                    intent.putExtra("Tomorrow", dob_later_text.getText().toString());
                    intent.putExtra("noofrooms", noofroomss.getText().toString());
                    intent.putExtra("noofadults", noofadultss.getText().toString());
                    intent.putExtra("Name",name1);
                    startActivity(intent);
                }
            }
        });
    }
    }
