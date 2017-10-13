package com.example.it.hw091017.json;

import java.text.ParseException;


public interface IUser {

    String getId();

    String getName();

    int getAge();

    String getRegistered() throws ParseException;
}
