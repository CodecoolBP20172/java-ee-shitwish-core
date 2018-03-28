package com.codecool.enterprise.shitwish.controller;

import com.codecool.enterprise.shitwish.Model.ReviewJSON;
import com.codecool.enterprise.shitwish.service.ApiService;
import com.codecool.enterprise.shitwish.session.UserSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.codecool.enterprise.shitwish.util.JsonUtil.toJson;


import java.io.IOException;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private UserSession session;

    private String reviewURL = "http://shitwish-review.herokuapp.com/";

    @GetMapping(value = "/api/user/{id}")
    public String getReviews(@PathVariable long id) throws IOException {
        return apiService.getJson(reviewURL + "get-review/" + id).toString();
    }


    @PostMapping(value = "/api/add-review")
    public String postReview(@RequestBody ReviewJSON json) {

        return "redirect:" + reviewURL + "add-review/?userId=" + json.getUserId() +
                "&authorId=" + session.getAttribute("userId") +
                "&title=" + json.getTitle() +
                "&reviewText=" + json.getComment() +
                "&rating=" + json.getRating();
    };



}