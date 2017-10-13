package com.example.it.hw091017.json;

import java.util.List;


public class UserJsonList implements IUsersList {

    private final List<IUser> mUserList;

    public UserJsonList(final List<IUser> pUserList) {
        mUserList = pUserList;
    }

    @Override
    public List<IUser> getUsersList() {
        return mUserList;
    }
}
