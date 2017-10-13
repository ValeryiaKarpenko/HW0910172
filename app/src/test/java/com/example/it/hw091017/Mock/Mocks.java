package com.example.it.hw091017.Mock;

import junit.framework.Assert;

import java.io.InputStream;


public class Mocks {
    public static InputStream stream(final String pName) {
        final InputStream resourceAsStream = Mocks.class.getClassLoader().getResourceAsStream(pName);
        Assert.assertNotNull("Resource not found", resourceAsStream);
        return resourceAsStream;
    }
}
