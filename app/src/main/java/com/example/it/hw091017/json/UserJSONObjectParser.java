package com.example.it.hw091017.json;

import org.json.JSONObject;

/**
 * Created by IT on 11.10.2017.
 */

public class UserJSONObjectParser implements IUserParser {

    private final String mSource;

    public UserJSONObjectParser(final String pSource) {
        mSource = pSource;
    }

    @Override
    public IUser parse() throws Exception {
        final JSONObject jsonObject = new JSONObject(mSource);
        return new UserJSONWrapper(jsonObject);
    }
}
