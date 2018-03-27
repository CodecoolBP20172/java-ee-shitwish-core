package com.codecool.enterprise.shitwish.controller;

import com.codecool.enterprise.shitwish.service.ApiService;
import com.codecool.enterprise.shitwish.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codecool.enterprise.shitwish.Model.*;
import org.springframework.web.bind.annotation.RestController;

import static com.codecool.enterprise.shitwish.util.JsonUtil.toJson;

import java.io.IOException;

@RestController
public class UserController {

    private String REGISTERURL = "https://shitwish-user.herokuapp.com/register";

    private String LOGINURL = "https://shitwish-user.herokuapp.com/login";

    @Autowired
    private ApiService apiService;

    @Autowired
    private UserSession session;

    @PostMapping(value = "/api/register")
    public String registerUser(@RequestBody UserJSON registerData) throws IOException {
        System.out.println(registerData.toString());

        ResponseEntity<String> response = apiService.postJson(REGISTERURL, toJson(registerData));
        HttpStatus status = response.getStatusCode(); // status of the response
        String restCall = response.getBody(); // body of the response
        if (status==HttpStatus.OK) {
            return "register request successfully sent. Body: " + restCall;
        }
        return "error at registration";
    }

    @PostMapping(value = "/api/login")
    public String loginUser(@RequestBody LoginJSON loginData) throws IOException {
        ResponseEntity<String> response = apiService.postJson(LOGINURL, toJson(loginData));
        HttpStatus status = response.getStatusCode(); // status of the response
        String restCall = response.getBody(); // body of the response
        if (status==HttpStatus.OK) {
            return "login request successfully sent. Body: " + restCall;
        }
        return "error at login";
    }

}

