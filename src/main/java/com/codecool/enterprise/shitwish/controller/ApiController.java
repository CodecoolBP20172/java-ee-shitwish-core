package com.codecool.enterprise.shitwish.controller;

import com.codecool.enterprise.shitwish.service.ApiService;
import com.codecool.enterprise.shitwish.session.UserSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;
    private String reviewURL = "http://shitwish-review.herokuapp.com/get-review/";


    @Autowired
    private UserSession session;

    private String EXAMPLEAPIURL = "https://api.chucknorris.io/jokes/random";

    /*@GetMapping(value = "/getjson")
    public String getJson() throws IOException {
        JSONObject jsonInfo = apiService.getJson(EXAMPLEAPIURL);
        return jsonInfo.toMap().toString();
    }*/


    @GetMapping(value = "/api/user/{id}")
    public String getReviews(@PathVariable long id) throws IOException {
        return apiService.getJson(reviewURL + id).toString();
    }
}