package com.deb.academiccalendar2020;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {
    AdView mAdView;
    //variable
    Boolean flag = false;
    CompactCalendarView compactCalendar;
    Date mDate = new Date();
    TextView event, date_1, food, status,bondho,month;
    Dictionary mDict,dictionary;
List<String> mDateList;
CompactCalendarView.CompactCalendarViewListener mListener;
    //Date formats

    private SimpleDateFormat asd = new SimpleDateFormat("dd/MM", Locale.getDefault());
    private SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.getDefault());
    private SimpleDateFormat sdfo = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());


    @Override
    protected void onDestroy() {
        super.onDestroy();
        compactCalendar = null;
        mDict=null;
        dictionary = null;
        mDateList = null;
        mAdView.destroy();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //connecting
        event = findViewById(R.id.event_view);
        food = findViewById(R.id.food_view);
        status = findViewById(R.id.status_view);
        mAdView = findViewById(R.id.adView3);
        date_1 = findViewById(R.id.date_view);
        bondho = findViewById(R.id.textView);
        month = findViewById(R.id.month);

        MobileAds.initialize(this, "ca-app-pub-7260156644744320~6674653902");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        getWindow().setStatusBarColor(Color.parseColor("#F5F5F7"));

        //Dictionary
       mDict = new Hashtable();
        mDict.put("15/01", "মাঘ বিহু");mDict.put("16/01", "মাঘ বিহু আৰু টুছু পূজা");mDict.put("23/01", " নেতাজীৰ জন্মদিন");mDict.put("26/01", "গণতন্ত্ৰ দিৱস");
        mDict.put("28/01", "গৌথাৰ বাথৌ চান");mDict.put("31/01", "মে দাম-মেফি");mDict.put("09/02", "বীৰ চিলাৰায় দিৱস");mDict.put("09/03", "দৌল যাত্ৰা");
        mDict.put("10/04", "গুড ফ্ৰাইডে");mDict.put("13/04", " ব’হাগ বিহু");mDict.put("14/04", " ব’হাগ বিহু");mDict.put("15/04", " ব’হাগ বিহু");
        mDict.put("23/04", " দামোদৰদেৱৰ তিথি");mDict.put("01/05", "মে’ দিৱস");mDict.put("07/05", "বুদ্ধ পূণিৰ্মা");mDict.put("25/05", " ঈদ-উল-ফিটৰ");
        mDict.put("06/06", " শ্ৰীশ্ৰীমাধৱদেৱৰ জন্মোত্সৱ");mDict.put("01/08", "ঈদ-উজ-জোহা");mDict.put("15/08", " স্বাধীনতা দিৱস");mDict.put("20/08", "শ্ৰীশ্ৰীশংকৰদেৱৰ তিথি");
        mDict.put("07/09", " শ্ৰীশ্ৰীমাধৱদেৱৰ তিথি");mDict.put("09/09", "জন্মাষ্টমী");mDict.put("26/09", "শ্ৰীশ্ৰীশংকৰদেৱৰ জন্মোত্সৱ");mDict.put("02/10", "গান্ধী জয়ন্তী");
        mDict.put("17/10", " কাতি বিহু");mDict.put("23/10", "দুৰ্গাপূজা");mDict.put("24/10", "দুৰ্গাপূজা");mDict.put("25/10", "দুৰ্গাপূজা");
        mDict.put("26/10", "দুৰ্গাপূজা");mDict.put("14/11", "কালী পূজা আৰু দেৱালী/শিশু দিৱস");mDict.put("20/11", "ষট্ পূজা");mDict.put("24/11", "লাচিত দিৱস");
        mDict.put("30/11", "গুৰু নানকৰ জন্মদিন");mDict.put("02/12", " অসম দিৱস");mDict.put("25/12", " বৰদিন");
        mDict.put("01/07","গ্ৰীষ্ম বন্ধ"); mDict.put("02/07","গ্ৰীষ্ম বন্ধ"); mDict.put("03/07","গ্ৰীষ্ম বন্ধ");
        mDict.put("04/07","গ্ৰীষ্ম বন্ধ"); mDict.put("05/07","গ্ৰীষ্ম বন্ধ"); mDict.put("06/07","গ্ৰীষ্ম বন্ধ");
        mDict.put("07/07","গ্ৰীষ্ম বন্ধ"); mDict.put("08/07","গ্ৰীষ্ম বন্ধ"); mDict.put("08/07","গ্ৰীষ্ম বন্ধ");
        mDict.put("09/07","গ্ৰীষ্ম বন্ধ"); mDict.put("10/07","গ্ৰীষ্ম বন্ধ"); mDict.put("11/07","গ্ৰীষ্ম বন্ধ");
        mDict.put("12/07","গ্ৰীষ্ম বন্ধ"); mDict.put("13/07","গ্ৰীষ্ম বন্ধ"); mDict.put("14/07","গ্ৰীষ্ম বন্ধ");
        mDict.put("15/07","গ্ৰীষ্ম বন্ধ"); mDict.put("16/07","গ্ৰীষ্ম বন্ধ"); mDict.put("17/07","গ্ৰীষ্ম বন্ধ");
        mDict.put("18/07","গ্ৰীষ্ম বন্ধ"); mDict.put("19/07","গ্ৰীষ্ম বন্ধ"); mDict.put("20/07","গ্ৰীষ্ম বন্ধ");
        mDict.put("21/07","গ্ৰীষ্ম বন্ধ"); mDict.put("22/07","গ্ৰীষ্ম বন্ধ"); mDict.put("23/07","গ্ৰীষ্ম বন্ধ");
        mDict.put("24/07","গ্ৰীষ্ম বন্ধ"); mDict.put("25/07","গ্ৰীষ্ম বন্ধ"); mDict.put("26/07","গ্ৰীষ্ম বন্ধ");
        mDict.put("27/07","গ্ৰীষ্ম বন্ধ"); mDict.put("28/07","গ্ৰীষ্ম বন্ধ"); mDict.put("29/07","গ্ৰীষ্ম বন্ধ");
        mDict.put("30/07","গ্ৰীষ্ম বন্ধ"); mDict.put("31/07","গ্ৰীষ্ম বন্ধ");

        //Datelist
        mDateList = new ArrayList<>();
        mDateList.add(sdfo.format(mDate));
        mDateList.add("15/01");mDateList.add("16/01");mDateList.add("23/01");mDateList.add("26/01");
        mDateList.add("28/01");mDateList.add("31/01");mDateList.add("09/02");mDateList.add("09/03");
        mDateList.add("10/04");mDateList.add("13/04");mDateList.add("14/04");mDateList.add("15/04");
        mDateList.add("23/04");mDateList.add("01/05");mDateList.add("07/05");mDateList.add("25/05");
        mDateList.add("06/06");mDateList.add("01/08");mDateList.add("15/08");mDateList.add("20/08");
        mDateList.add("07/09");mDateList.add("09/09");mDateList.add("26/09");mDateList.add("02/10");
        mDateList.add("17/10");mDateList.add("23/10");mDateList.add("24/10");mDateList.add("25/10");
        mDateList.add("26/10");mDateList.add("14/11");mDateList.add("20/11");mDateList.add("30/11");
        mDateList.add("02/12");mDateList.add("25/12"); mDateList.add("01/07");mDateList.add("02/07");
        mDateList.add("03/07");mDateList.add("04/07");mDateList.add("05/07");mDateList.add("06/07");
        mDateList.add("07/07");mDateList.add("08/07");mDateList.add("09/07");mDateList.add("10/07");
        mDateList.add("11/07");mDateList.add("12/07");mDateList.add("13/07");mDateList.add("14/07");
        mDateList.add("15/07");mDateList.add("16/07");mDateList.add("17/07");mDateList.add("18/07");
        mDateList.add("19/07");mDateList.add("20/07");mDateList.add("21/07");mDateList.add("22/07");
        mDateList.add("23/07");mDateList.add("24/07");mDateList.add("25/07");mDateList.add("26/07");
        mDateList.add("27/07");mDateList.add("28/07");mDateList.add("29/07");mDateList.add("30/07");
        mDateList.add("31/07");



        dictionary = new Hashtable();
        dictionary.put("17/01","শিল্পী দিৱস");dictionary.put("29/01","সৰস্বতী পূজা"); dictionary.put("03/02","বাৰ্ষিক খেল-ধেমালি");
        dictionary.put("04/02","বাৰ্ষিক খেল-ধেমালি"); dictionary.put("05/02","বাৰ্ষিক খেল-ধেমালি"); dictionary.put("06/02","বঁটা বিতৰণী অনুষ্ঠান");
        dictionary.put("28/02","ৰাষ্ট্ৰীয় বিজ্ঞান দিৱস");dictionary.put("04/03","শশিশু সুৰক্ষা দিৱস");dictionary.put("07/04","বিশ্ব স্বাস্থ্য দিৱস");
        dictionary.put("25/04","বিশ্ব মেলেৰিয়া দিৱস");dictionary.put("08/05","ৰবীন্দ্ৰ জয়ন্তী");dictionary.put("11/05","ৰাষ্ট্ৰীয় প্ৰযুক্তি দিৱস");
        dictionary.put("05/06","বিশ্ব পৰিৱেশ দিৱস");dictionary.put("20/06","কলাগুৰু বিষ্ণু ৰাভা দিৱস");dictionary.put("05/09","শিক্ষক দিৱস");
        dictionary.put("08/09","বিশ্ব সাক্ষৰতা দিৱস");dictionary.put("21/09","বিশ্ব শান্তি দিৱস");dictionary.put("13/10","আন্তৰ্জাতিক দুৰ্যোগ নিবাৰন দিৱস");
        dictionary.put("14/10","লক্ষ্মীনাথ বেজবৰুৱাৰ জন্ম জয়ন্তী");dictionary.put("15/10","বিশ্ব হাতধোৱা দিৱস");dictionary.put("30/10","শ্ৰীশ্ৰীলক্ষ্মীপূজা");



        //Calendar
        compactCalendar = findViewById(R.id.calendarView);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        //food
        date_1.setText(sdfo.format(mDate));
        check mcheck = new check(mDate);
        food.setText(mcheck.getString());

        //Action Bar
       month.setText(dateFormatMonth.format(new Date()));

        //Checking todays status
        for (int i = 0; i < mDateList.size(); i++) {
            if (mDateList.get(i).equals(asd.format(mDate).toString())) {
                event.setText((String) mDict.get(asd.format(mDate)));
                flag = true;
                break;
            }
        }

        if (sdf.format(mDate).equals("Sunday")) {
//                    Toast.makeText(getApplicationContext(),"বন্ধৰ দিন",Toast.LENGTH_SHORT).show();
            status.setText("বন্ধৰ দিন");
            event.setVisibility(View.VISIBLE);
            bondho.setVisibility(View.VISIBLE);
            food.setText("");

        } else if (flag) {
//                    Toast.makeText(getApplicationContext(),"বন্ধৰ দিন",Toast.LENGTH_SHORT).show();
            flag = false;
            status.setText("বন্ধৰ দিন");
            event.setVisibility(View.VISIBLE);
            bondho.setVisibility(View.VISIBLE);
            food.setText("");


        } else {
//                    Toast.makeText(getApplicationContext(),"শ্ৰেণীৰ দিন",Toast.LENGTH_SHORT).show();
            status.setText("শ্ৰেণীৰ দিন");
            event.setVisibility(View.VISIBLE);
            bondho.setVisibility(View.VISIBLE);
            event.setText((String)dictionary.get(asd.format(mDate)));


        }

        //Calendar listener
        compactCalendar.setListener(mListener= new CompactCalendarView.CompactCalendarViewListener() {

            @Override
            public void onDayClick(Date dateClicked) {
                check mCheck = new check(dateClicked);
                food.setText(mCheck.getString());

                date_1.setText(sdfo.format(dateClicked));


                String dayoftheweek = sdf.format(dateClicked);

                for (int i = 0; i < mDateList.size(); i++) {
                    if (mDateList.get(i).equals(asd.format(dateClicked).toString())) {
                        event.setText((String) mDict.get(asd.format(dateClicked)));
                        flag = true;
                        break;
                    }
                }

                if (dayoftheweek.equals("Sunday")) {
//                    Toast.makeText(getApplicationContext(),"বন্ধৰ দিন",Toast.LENGTH_SHORT).show();
                    status.setText("বন্ধৰ দিন");
                    event.setVisibility(View.INVISIBLE);
                    bondho.setVisibility(View.INVISIBLE);
                    food.setText("");

                } else if (flag) {
//                    Toast.makeText(getApplicationContext(),"বন্ধৰ দিন",Toast.LENGTH_SHORT).show();
                    flag = false;
                    status.setText("বন্ধৰ দিন");
                    event.setVisibility(View.VISIBLE);
                    bondho.setVisibility(View.VISIBLE);
                    food.setText("");
                } else {
//                    Toast.makeText(getApplicationContext(),"শ্ৰেণীৰ দিন",Toast.LENGTH_SHORT).show();
                    status.setText("শ্ৰেণীৰ দিন");

                    event.setVisibility(View.VISIBLE);
                    bondho.setVisibility(View.VISIBLE);
                    event.setText((String)dictionary.get(asd.format(dateClicked)));
                }
                // Toast.makeText(getApplicationContext(),sdf.format(dateClicked),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                check mCHeck = new check(firstDayOfNewMonth);
                food.setText(mCHeck.getString());
                month.setText(dateFormatMonth.format(firstDayOfNewMonth));
                date_1.setText(sdfo.format(firstDayOfNewMonth));

                String dayoftheweek = sdf.format(firstDayOfNewMonth);

                for (int i = 0; i < mDateList.size(); i++) {
                    if (mDateList.get(i).equals(sdfo.format(firstDayOfNewMonth).toString())) {
                        event.setText((String) mDict.get(asd.format(firstDayOfNewMonth)));
                        flag = true;
                        break;
                    }
                }

                if (dayoftheweek.equals("Sunday")) {

                    status.setText("বন্ধৰ দিন");
                    food.setText("");
                    event.setVisibility(View.INVISIBLE);
                    bondho.setVisibility(View.INVISIBLE);
                } else if (flag) {
                    flag = false;
                    status.setText("বন্ধৰ দিন");
                    food.setText("");
                    event.setVisibility(View.VISIBLE);
                    bondho.setVisibility(View.VISIBLE);
                } else {

                    status.setText("শ্ৰেণীৰ দিন");

                    event.setVisibility(View.VISIBLE);
                    bondho.setVisibility(View.VISIBLE);
                     event.setText((String)dictionary.get(asd.format(firstDayOfNewMonth)));


                }

            }

        });

    }
}
