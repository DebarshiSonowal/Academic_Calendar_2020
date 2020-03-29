package com.deb.academiccalendar2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Main4Activity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mWebView = findViewById(R.id.web);

        mWebView.loadUrl("file:///android_asset/food.html");

    }
}
