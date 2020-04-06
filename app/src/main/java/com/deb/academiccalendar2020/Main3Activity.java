package com.deb.academiccalendar2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Calendar;

public class Main3Activity extends AppCompatActivity {
    //Varible
    private Calendar sCalendar;
    ListView list;
    TextView mTextView;
    String mString;
    AdView mAdView1,mAdView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Text
        mTextView = findViewById(R.id.textView7);
        mAdView1 = findViewById(R.id.adView5);
        mAdView2 = findViewById(R.id.adView4);

        MobileAds.initialize(this, "ca-app-pub-7260156644744320~6674653902");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest);
        mAdView2.loadAd(adRequest);
        //get string
        Bundle bundle = getIntent().getExtras();
        mString = bundle.getString("list");

        //ccoding
        if(mString.equals("holiday"))
        {
            mTextView.setText(getString(R.string.holidaylist) +
                    "১৫ জানুৱাৰী -  মাঘ বিহু\n" +
                    "১৬ জানুৱাৰী - মাঘ বিহু আৰু টুছু পূজা\n" +
                    "২৩ জানুৱাৰী - নেতাজীৰ জন্মদিন\n" +
                    "২৬ জানুৱাৰী - গণতন্ত্ৰ দিৱস\n" +
                    "২৮ জানুৱাৰী - গৌথাৰ বাথৌ চান\n" +
                    "৩১  জানুৱাৰী - মে দাম-মেফি\n" +
                    "৯  ফেব্ৰুৱাৰী - বীৰ চিলাৰায় দিৱস\n" +
                    "৯ মাৰ্চ -  দৌল যাত্ৰা\n" +
                    "১০ এপ্ৰিল - গুড ফ্ৰাইডে\n" +
                    "১৩ এপ্ৰিল - ব’হাগ বিহু\n" +
                    "১৪ এপ্ৰিল -  ব’হাগ বিহু\n" +
                    "১৫ এপ্ৰিল - ব’হাগ বিহু\n" +
                    "২৩এপ্ৰিল -  দামোদৰদেৱৰ তিথি\t\n" +
                    "১ মে’ -  মে’ দিৱস\n" +
                    "৭  মে’ - বুদ্ধ পূণিৰ্মা\n" +
                    "২৫ মে’ - ঈদ-উল-ফিটৰ\n" +
                    "৬ জুন - শ্ৰীশ্ৰীমাধৱদেৱৰ জন্মোত্সৱ\n" +
                    "১ আগষ্ট - ঈদ-উজ-জোহা\n" +
                    "১৫ আগষ্ট - স্বাধীনতা দিৱস\n" +
                    "২০ আগষ্ট - শ্ৰীশ্ৰীশংকৰদেৱৰ তিথি\n" +
                    "৭ চেপ্তেম্বৰ - শ্ৰীশ্ৰীমাধৱদেৱৰ তিথি\n" +
                    "৯ চেপ্তেম্বৰ - জন্মাষ্টমী\n" +
                    "২৬ চেপ্তেম্বৰ - শ্ৰীশ্ৰীশংকৰদেৱৰ জন্মোত্সৱ\n" +
                    "২ অক্টোবৰ - গান্ধী জয়ন্তী\n" +
                    "১৭ অক্টোবৰ - কাতি বিহু\n" +
                    "২৩, ২৪, ২৫ আৰু ২৬ অক্টোবৰ - দুৰ্গাপূজা\n" +
                    "১৪ নৱেম্বৰ - কালী পূজা আৰু দেৱালী/শিশু দিৱস\n" +
                    "২০ নৱেম্বৰ - ষট্ পূজা\n" +
                    "২৪ নৱেম্বৰ - লাচিত দিৱস\n" +
                    "৩০ নৱেম্বৰ - গুৰু নানকৰ জন্মদিন\n" +
                    "২ ডিচেম্বৰ - অসম দিৱস\n" +
                    "২৫ ডিচেম্বৰ - বৰদিন");
            mTextView.setTextSize(20);
            mTextView.setMovementMethod(new ScrollingMovementMethod());
        }
        else if(mString.equals("food"))
        {
            mTextView.setText("মধ্যাহ্ন ভোজন আঁচনিৰ অধীনত সাপ্তাহিক খাদ্য তালিকা (আদৰ্শ তালিকা) -\n" +
                    "\n" +
                    "        দিন\t\t\tসামগ্ৰী\n" +
                    "\n" +
                    "     সোমবাৰ:\t\t  ভাত, দাইল, সেউজীয়া শাক-পাচলি ।\n" +
                    "\n" +
                    "\n" +
                    "    মঙ্গলবাৰ:\t\t  খিচিৰি/ছয়াবিন, সেউজীয়া শাক-পাচলি।\n" +
                    "\n" +
                    "\n" +
                    "        বুধবাৰ:\t\t  ভাত, কণীৰ আঞ্জা/স্থানীয় খাদ্য/সেউজীয়া শাক-পাচলি।\n" +
                    "\n" +
                    "\n" +
                    "বৃহস্পতিবাৰ:\t\t  ভাত, দাইল, সেউজীয়া শাক-পাচলি।\n" +
                    "\n" +
                    "\n" +
                    "      শুক্ৰবাৰ:\t\t  ভাত, দাইল, সেউজীয়া শাক-পাচলি।\n" +
                    "\n" +
                    "\n" +
                    "       শনিবাৰ:\t\t  খিচিৰি/পোলাও/স্থানীয়া খাদ্য/সেউজীয়া শাক-পাচলি।\n");

            mTextView.setTextSize(20);
        }
    }
}
