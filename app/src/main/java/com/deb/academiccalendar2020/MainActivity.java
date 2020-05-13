package com.deb.academiccalendar2020;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    AdView mAdView;
    InterstitialAd mInterstitialAd;
    TextView mDate,mStatus,food_view;
    ImageView cal,lst,foodlist;
    String date_n = new SimpleDateFormat(" dd-MMM-yyyy", Locale.getDefault()).format(new Date());
    SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
    SimpleDateFormat sdfo = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    Date d = new Date();
    String dayOfTheWeek = sdf.format(d);
    private SimpleDateFormat asd = new SimpleDateFormat("dd/MM", Locale.getDefault());
    Boolean flag = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(Color.parseColor("#3c73ff"));
        //Dictionary of holiday


        //Declaration


        //Findviews
        foodlist= findViewById(R.id.imageView4);
        food_view = findViewById(R.id.food_view2);
        mDate = findViewById(R.id.date_view2);
        mStatus = findViewById(R.id.status_view);
        cal = findViewById(R.id.imageView);
        lst = findViewById(R.id.imageView2);
        mAdView = findViewById(R.id.adView);

        //Ads
        MobileAds.initialize(this, "ca-app-pub-7260156644744320~6674653902");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7260156644744320/9067925096");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.show();

        //Creating object of check class
        check mCheck = new check(d);
        food_view.setText(mCheck.getString());

        //On click listeners
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(mIntent);
            }
        });
        lst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(getApplicationContext(),Main3Activity.class);
                m.putExtra("list","holiday");
                startActivity(m);
            }
        });

        foodlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(getApplicationContext(),Main4Activity.class);
                m.putExtra("list","food");

                startActivity(m);
            }
        });

        final List<String> mDateList = new ArrayList<>();
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


        for (int i = 0; i < mDateList.size(); i++) {
            if (mDateList.get(i).equals(asd.format(d))) {
                flag = true;
                break;
            }
        }

        //Set Status
        mDate.setText(date_n);
        if (dayOfTheWeek.equals("Sunday")){
            mStatus.setText("বন্ধৰ দিন");
        }
        else if(flag)
        {
            mStatus.setText("বন্ধৰ দিন");
            food_view.setText("");
        }
        else{
            mStatus.setText("শ্ৰেণীৰ দিন");
        }

    }
}
