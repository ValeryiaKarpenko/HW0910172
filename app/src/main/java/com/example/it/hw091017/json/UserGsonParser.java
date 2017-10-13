package com.example.it.hw091017.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;


public class UserGsonParser implements IUserParser {
    private final String mSource;

    public UserGsonParser(final String pSource) {
        mSource = pSource;
    }


    @Override
    public IUser parse() throws Exception {
        final JsonDeserializer<Date> date = new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement jsonElement,
                                    Type type, JsonDeserializationContext context)
                    throws JsonParseException {
                return jsonElement == null ? null : new Date(jsonElement.getAsLong());
            }
        };

        final Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, date).create();
        return gson.fromJson(mSource, UserGson.class);
    }
}
