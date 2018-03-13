package com.codecool.enterprise.shitwish.controller;

import com.codecool.enterprise.shitwish.service.ApiService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class Controller {

    @Autowired
    private ApiService apiService;

    private String EXAMPLEAPIURL = "https://api.chucknorris.io/jokes/random"; // example api to get

    private String PRODUCTSAPIURL = "productsapi.com";
    private String REGISTERURL = "https://herokublabla/register";

    @GetMapping(value = "/getjson") // example api get
    public String getJson() throws IOException {
        JSONObject jsonInfo = apiService.getJson(EXAMPLEAPIURL);
        return jsonInfo.toMap().toString();
    }

    @GetMapping(value = "/")
    public String landingPage(Model model) throws IOException {
        model.addAttribute("products", apiService.getJson(PRODUCTSAPIURL).toMap().toString());
        return "/index";
    }

    @GetMapping(value = "/register")
    public void registerUser() throws IOException {
        String userJsonString = ""; // information from the registration form parsed to json
        apiService.postJson(REGISTERURL, userJsonString);
    }

}