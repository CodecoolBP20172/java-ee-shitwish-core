package com.codecool.enterprise.shitwish.controller;

import com.codecool.enterprise.shitwish.service.ApiService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@Controller
public class MainController {

    //for test purpose only
    String testProductsString = "{\"_embedded\" : {\"product\" : [\"listOfTags\" : [ ], \"name\" : \"Prod1\", \"price\" : 10.0, \"description\" : \"Hablaty\", \"status\" : \"ACTIVE\", \"_links\" : {\"self\" : {\"href\" : \"http://localhost:60001/products/1\"} \"product\" : {\"href\" : \"http://localhost:60001/products/1\"}}},{\"listOfTags\" : [ ],\"name\" : \"Prod2\", \"price\" : 200.0, \"description\" : \"Akarmi\", \"status\" : \"ACTIVE\", \"_links\" : {\"self\" : {\"href\" : \"http://localhost:60001/products/2\"}, \"product\" : {\"href\" : \"http://localhost:60001/products/2\"}}} ]}, \"_links\" : { \"self\" : { \"href\" : \"http://localhost:60001/products{?page,size,sort}\", \"templated\" : true}, \"profile\" : {\"href\" : \"http://localhost:60001/profile/products\"}, \"search\" : {\"href\" : \"http://localhost:60001/products/search\"}},\"page\" : {\"size\" : 20, \"totalElements\" : 2, \"totalPages\" : 1, \"number\" : 0}}";

    @Autowired
    private ApiService apiService;

    private String EXAMPLEAPIURL = "https://api.chucknorris.io/jokes/random"; // example api to get

    private String PRODUCTSAPIURL = "https://herokublabla/all-products";

    @GetMapping(value = "/getjson") // example api get
    public String getJson() throws IOException {
        JSONObject jsonInfo = apiService.getJson(EXAMPLEAPIURL);
        return jsonInfo.toMap().toString();
    }

    @GetMapping(value = "/")
    public String landingPage(Model model) throws IOException {
        //commented out till products ms is up on heroku //model.addAttribute("products", apiService.getJson(PRODUCTSAPIURL).toMap().toString());
        model.addAttribute("products", testProductsString); //till products ms not up
        return "/index";
    }

    //todo
    @RequestMapping(value = "/shopping_cart", method = RequestMethod.GET)
    public String renderCart() { return "cart";}

    //todo
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String renderProduct(@PathVariable long id) {
        return "product";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String renderUser(@PathVariable long id) {
        return "userpage";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String renderCheckout() {
        return "checkout";
    }



}