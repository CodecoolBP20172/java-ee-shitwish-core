package com.codecool.enterprise.funfact.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ApiService {

    @Autowired
    private JsonReader jsonReader;

    public JSONObject getJson(String url) throws IOException {
        return jsonReader.readJsonFromUrl(url);
    }
}
