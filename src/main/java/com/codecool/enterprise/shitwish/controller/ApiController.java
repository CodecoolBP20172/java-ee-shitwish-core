package com.codecool.enterprise.shitwish.controller;

import com.codecool.enterprise.shitwish.service.ApiService;
import com.codecool.enterprise.shitwish.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private UserSession session;

    private String reviewURL = "http://shitwish-review.herokuapp.com/get-review/";

    @GetMapping(value = "/api/user/{id}")
    public String getReviews(@PathVariable long id) throws IOException {
        return apiService.getJson(reviewURL + id).toString();
    }
}