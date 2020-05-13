package com.deb.academiccalendar2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Main4Activity extends AppCompatActivity {
    WebView mWebView;
    AdView mAdView1,mAdView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mWebView = findViewById(R.id.web);

//        mWebView.loadUrl("file:///android_asset/food.html");
        mWebView.loadUrl("file:///android_asset/MDM.html");
        mAdView1 = findViewById(R.id.adView6);
        mAdView2 = findViewById(R.id.adView7);

        MobileAds.initialize(this, "ca-app-pub-7260156644744320~6674653902");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest);
        mAdView2.loadAd(adRequest);

    }
}
