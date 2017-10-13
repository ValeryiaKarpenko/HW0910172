package com.example.it.hw091017.Http;

import java.io.InputStream;

public interface IHttpClient {

    InputStream request(String url);
}