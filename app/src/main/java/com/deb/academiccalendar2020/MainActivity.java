package com.deb.academiccalendar2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.text.SimpleDateFormat;
import java.util.Date;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //Set Status
        mDate.setText(date_n);
        if (dayOfTheWeek.equals("Sunday")){
            mStatus.setText("বন্ধৰ দিন");
        }
        else{
            mStatus.setText("শ্ৰেণীৰ দিন");
        }

    }
}
