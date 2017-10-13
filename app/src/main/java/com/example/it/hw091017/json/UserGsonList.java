package com.example.it.hw091017.json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT on 12.10.2017.
 */

public class UserGsonList implements IUsersList {

    private List<IUser> mUsersLists;

    public UserGsonList(List<IUser> mUsersLists) {
        this.mUsersLists = mUsersLists;
    }


    @Override
    public List<IUser> getUsersList() {
        List<IUser> mUsersList = new ArrayList<>();
        mUsersList.addAll(mUsersList);
        return mUsersLists;
    }

}
