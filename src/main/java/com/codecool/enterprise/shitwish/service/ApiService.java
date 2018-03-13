package com.codecool.enterprise.shitwish.service;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

    public void postJson(String url, String requestJson) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);
    }
}
