package com.example.it.hw091017.json;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class UserGson implements IUser {

    @SerializedName("_id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("age")
    private int mAge;

    @SerializedName("registered")
    private Date mRegistered;

    @Override
    public String getId() {
        return mId;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public int getAge() {
        return mAge;
    }

    @Override
    public String getRegistered() throws ParseException {
        final DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, hh:mm:ss", Locale.ENGLISH);
        return dateFormat.format(mRegistered);
    }
}
