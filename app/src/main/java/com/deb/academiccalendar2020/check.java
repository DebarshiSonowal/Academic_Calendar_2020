package com.deb.academiccalendar2020;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class check {
    private Date mDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.getDefault());
    private String mString;

    public check(Date date) {
        mDate = date;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getString() {
        if(sdf.format(mDate).equals("Monday"))
        {
            mString = "ভাত, দাইল, সেউজীয়া শাক-পাচলি";
        }
        else if (sdf.format(mDate).equals("Tuesday"))
        {
            mString = "খিচিৰি/ছয়াবিন, সেউজীয়া শাক-পাচলি";
        }
        else if(sdf.format(mDate).equals("Wednesday"))
        {
            mString = "ভাত, কণীৰ আঞ্জা/স্থানীয় খাদ্য/সেউজীয়া শাক-পাচলি";
        }
        else if(sdf.format(mDate).equals("Thursday"))
        {
            mString = "ভাত, দাইল, সেউজীয়া শাক-পাচলি";
        }
        else if(sdf.format(mDate).equals("Friday"))
        {
            mString = "ভাত, দাইল, সেউজীয়া শাক-পাচলি";
        }
        else if(sdf.format(mDate).equals("Saturday"))
        {
            mString = "খিচিৰি/পোলাও/স্থানীয়া খাদ্য/সেউজীয়া শাক-পাচলি";
        }
        else {
            mString = "";
        }
        return mString;
    }

    public void setString(String string) {
        mString = string;
    }
}
