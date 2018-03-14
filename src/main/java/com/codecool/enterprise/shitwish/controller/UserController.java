package com.codecool.enterprise.shitwish.controller;

import com.codecool.enterprise.shitwish.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codecool.enterprise.shitwish.Model.UserJSON;
import static com.codecool.enterprise.shitwish.util.JsonUtil.toJson;

import java.io.IOException;

@Controller
public class UserController {

    private String REGISTERURL = "https://herokublabla/register";

    @Autowired
    private ApiService apiService;

    @PostMapping(value = "/register")
    public String registerUser(@RequestBody UserJSON registerData) throws IOException {
        ResponseEntity<String> response = apiService.postJson(REGISTERURL, toJson(registerData));
        HttpStatus status = response.getStatusCode(); // status of the response
        String restCall = response.getBody(); // body of the response
        if (status==HttpStatus.OK) {
            return "registration ok";
        }
        return "error at registration";
    }

}

