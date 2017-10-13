package com.example.it.hw091017.json;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * Created by IT on 12.10.2017.
 */

public class UserGsonListParser implements IUserListParser {

    private final InputStream mIntputStream;

    public UserGsonListParser(InputStream pIntputStream) {
        this.mIntputStream = pIntputStream;
    }

    @Override
    public IUsersList parse() throws Exception {
        Reader reader = new InputStreamReader(mIntputStream);
        UserGson[] result = new Gson().fromJson(reader, UserGson[].class);
        return new UserGsonList(Arrays.<IUser>asList(result));
    }


}
