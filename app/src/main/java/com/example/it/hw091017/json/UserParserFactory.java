package com.example.it.hw091017.json;

import java.io.InputStream;

/**
 * Created by IT on 11.10.2017.
 */

public class UserParserFactory {

    public IUserParser createParser(String pSource) {
        return new UserJSONObjectParser(pSource);
    }

    public IUserParser createGsonParser(final String pSource) {
        return new UserGsonParser(pSource);

    }

    public IUserListParser createGsonListParser(final InputStream pSource) {
        return new UserGsonListParser(pSource);
    }

    public IUserListParser createJsonListParser(final InputStream pString) {
        return new UserJsonListParser(pString);
    }
}
