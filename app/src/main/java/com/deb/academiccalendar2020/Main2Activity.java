package com.deb.academiccalendar2020;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    //variable
    Calendar sCalendar;
    Boolean flag = false;
    CompactCalendarView compactCalendar;
    Date mDate = new Date();
    TextView event, date_1, food, status,bondho;

    //Date formats
    Locale locale;
    private SimpleDateFormat asd = new SimpleDateFormat("dd/MM", Locale.getDefault());
    private SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.getDefault());
    private SimpleDateFormat sdfo = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //Dictionary
        final Dictionary mDict = new Hashtable();
        mDict.put("15/01", "মাঘ বিহু");mDict.put("16/01", "মাঘ বিহু আৰু টুছু পূজা");mDict.put("23/01", " নেতাজীৰ জন্মদিন");mDict.put("26/01", "গণতন্ত্ৰ দিৱস");
        mDict.put("28/01", "গৌথাৰ বাথৌ চান");mDict.put("31/01", "মে দাম-মেফি");mDict.put("09/02", "বীৰ চিলাৰায় দিৱস");mDict.put("09/03", "দৌল যাত্ৰা");
        mDict.put("10/04", "গুড ফ্ৰাইডে");mDict.put("13/04", " ব’হাগ বিহু");mDict.put("14/04", " ব’হাগ বিহু");mDict.put("15/04", " ব’হাগ বিহু");
        mDict.put("23/04", " দামোদৰদেৱৰ তিথি");mDict.put("01/05", "মে’ দিৱস");mDict.put("07/05", "বুদ্ধ পূণিৰ্মা");mDict.put("25/05", " ঈদ-উল-ফিটৰ");
        mDict.put("06/06", " শ্ৰীশ্ৰীমাধৱদেৱৰ জন্মোত্সৱ");mDict.put("01/08", "ঈদ-উজ-জোহা");mDict.put("15/08", " স্বাধীনতা দিৱস");mDict.put("20/08", "শ্ৰীশ্ৰীশংকৰদেৱৰ তিথি");
        mDict.put("07/09", " শ্ৰীশ্ৰীমাধৱদেৱৰ তিথি");mDict.put("09/09", "জন্মাষ্টমী");mDict.put("26/09", "শ্ৰীশ্ৰীশংকৰদেৱৰ জন্মোত্সৱ");mDict.put("02/10", "গান্ধী জয়ন্তী");
        mDict.put("17/10", " কাতি বিহু");mDict.put("23/10", "দুৰ্গাপূজা");mDict.put("24/10", "দুৰ্গাপূজা");mDict.put("25/10", "দুৰ্গাপূজা");
        mDict.put("26/10", "দুৰ্গাপূজা");mDict.put("14/11", "কালী পূজা আৰু দেৱালী/শিশু দিৱস");mDict.put("20/11", "ষট্ পূজা");mDict.put("24/11", "লাচিত দিৱস");
        mDict.put("30/11", "গুৰু নানকৰ জন্মদিন");mDict.put("02/12", " অসম দিৱস");mDict.put("25/12", " বৰদিন");

        //Datelist
        final List<String> mDateList = new ArrayList<>();
        mDateList.add(sdfo.format(mDate));
        mDateList.add("15/01");mDateList.add("16/01");mDateList.add("23/01");mDateList.add("26/01");
        mDateList.add("28/01");mDateList.add("31/01");mDateList.add("09/02");mDateList.add("09/03");
        mDateList.add("10/04");mDateList.add("13/04");mDateList.add("14/04");mDateList.add("15/04");
        mDateList.add("23/04");mDateList.add("01/05");mDateList.add("07/05");mDateList.add("25/05");
        mDateList.add("06/06");mDateList.add("01/08");mDateList.add("15/08");mDateList.add("20/08");
        mDateList.add("07/09");mDateList.add("09/09");mDateList.add("26/09");mDateList.add("02/10");
        mDateList.add("17/10");mDateList.add("23/10");mDateList.add("24/10");mDateList.add("25/10");
        mDateList.add("26/10");mDateList.add("14/11");mDateList.add("20/11");mDateList.add("30/11");
        mDateList.add("02/12");mDateList.add("25/12");

        //connecting
        event = findViewById(R.id.event_view);
        food = findViewById(R.id.food_view);
        status = findViewById(R.id.status_view);
        date_1 = findViewById(R.id.date_view);
        bondho = findViewById(R.id.textView);
        //Calendar
        compactCalendar = findViewById(R.id.calendarView);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        //food
        date_1.setText(sdfo.format(mDate));
        check mcheck = new check(mDate);
        food.setText(mcheck.getString());

        //Action Bar
        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(dateFormatMonth.format(new Date()));

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
            event.setText("");
            event.setVisibility(View.INVISIBLE);
            bondho.setVisibility(View.INVISIBLE);


        }

        //Calendar listener
        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {

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
                    event.setText("");
                    event.setVisibility(View.INVISIBLE);
                    bondho.setVisibility(View.INVISIBLE);
                }
                // Toast.makeText(getApplicationContext(),sdf.format(dateClicked),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                check mCHeck = new check(firstDayOfNewMonth);
                food.setText(mCHeck.getString());

                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
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
                    event.setVisibility(View.VISIBLE);
                    bondho.setVisibility(View.VISIBLE);
                } else if (flag) {
                    flag = false;
                    status.setText("বন্ধৰ দিন");
                    food.setText("");
                    event.setVisibility(View.VISIBLE);
                    bondho.setVisibility(View.VISIBLE);
                } else {

                    status.setText("শ্ৰেণীৰ দিন");
                    event.setText("");
                    event.setVisibility(View.INVISIBLE);
                    bondho.setVisibility(View.INVISIBLE);
                }

            }

        });

    }
}
