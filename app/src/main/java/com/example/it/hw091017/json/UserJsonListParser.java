package com.example.it.hw091017.json;

import com.example.it.hw091017.utils.IOUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class UserJsonListParser implements IUserListParser {

    private final InputStream mInputStream;

    public UserJsonListParser(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IUsersList parse() throws Exception {
        final JSONArray jsonArray = new JSONArray(IOUtils.toString(mInputStream));
        final List<IUser> usersJsonList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            final JSONObject jsonObject = jsonArray.getJSONObject(i);
            usersJsonList.add(new UserJSONWrapper(jsonObject));
        }
        return new UserJsonList(usersJsonList);
    }
}
