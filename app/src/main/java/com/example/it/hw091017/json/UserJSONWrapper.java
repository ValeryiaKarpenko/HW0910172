package com.example.it.hw091017.json;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


class UserJSONWrapper implements IUser {

    private static final String ID = "_id";
    private static final String AGE = "age";
    private static final String NAME = "name";
    private static final String REGISTERED = "registered";

    private final JSONObject mJsonObject;

    UserJSONWrapper(final JSONObject pJsonObject) {
        mJsonObject = pJsonObject;
    }

    @Override
    public String getId() {
        return mJsonObject.optString(ID);
    }

    @Override
    public String getName() {
        return mJsonObject.optString(NAME);
    }

    @Override
    public int getAge() {
        return mJsonObject.optInt(AGE);
    }

    @Override
    public String getRegistered() throws ParseException {
        final long dateLong = mJsonObject.optLong(REGISTERED);
        final Date date = new Date(dateLong);
        final DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, hh:mm:ss", Locale.ENGLISH);
        return dateFormat.format(date);
    }
}
