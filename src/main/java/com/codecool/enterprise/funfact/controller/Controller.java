package com.codecool.enterprise.funfact.controller;

import com.codecool.enterprise.funfact.service.ApiService;
import com.codecool.enterprise.funfact.service.JsonReader;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class Controller {

    @Autowired
    private ApiService apiService;

    private String EXAMPLEAPIURL = "https://api.chucknorris.io/jokes/random";

    @GetMapping(value = "/getjson")
    public String getJson() throws IOException {
        JSONObject jsonInfo = apiService.getJson(EXAMPLEAPIURL);
        return jsonInfo.toMap().toString();
    }

}