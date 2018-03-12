package com.codecool.enterprise.funfact.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ApiService {

    public JSONObject getJson(String url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String jsonText = restTemplate.getForEntity(url, String.class).getBody();
        return new JSONObject(jsonText);
    }
}
