package com.codecool.enterprise.shitwish.controller;

import com.codecool.enterprise.shitwish.service.ApiService;
import com.codecool.enterprise.shitwish.session.UserSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class MainController {

    //for test purpose only
    String testAllProductsString = "{\"_embedded\" : {\"product\" : [\"listOfTags\" : [ ], \"name\" : \"Prod1\", \"price\" : 10.0, +" +
            "\"description\" : \"Hablaty\", \"active\" : \"true\", \"_links\" : {\"self\" : {\"href\" : \"http://localhost:60001/products/1\"}" +
            "\"product\" : {\"href\" : \"http://localhost:60001/products/1\"}}},{\"listOfTags\" : [ ],\"name\" : \"Prod2\", \"price\" : 200.0," +
            "\"description\" : \"Akarmi\", \"active\" : \"true\", \"_links\" : {\"self\" : {\"href\" : \"http://localhost:60001/products/2\"}," +
            "\"product\" : {\"href\" : \"http://localhost:60001/products/2\"}}} ]}, \"_links\" : { \"self\" : { \"href\" : " +
            "\"http://localhost:60001/products{?page,size,sort}\", \"templated\" : true}, \"profile\" : {\"href\" : " +
            "\"http://localhost:60001/profile/products\"}, \"search\" : {\"href\" : \"http://localhost:60001/products/search\"}},\"page\" : " +
            "{\"size\" : 20, \"totalElements\" : 2, \"totalPages\" : 1, \"number\" : 0}}";

    //for test purpose only
    String testCartProductsString = "{\"_embedded\" : {\"product\" : [\"listOfTags\" : [ ], \"name\" : \"Prod1\", \"price\" : 10.0, +" +
            "\"description\" : \"Hablaty\", \"active\" : \"true\", \"_links\" : {\"self\" : {\"href\" : \"http://localhost:60001/products/1\"}" +
            "\"product\" : {\"href\" : \"http://localhost:60001/products/1\"}}},{\"listOfTags\" : [ ],\"name\" : \"Prod2\", \"price\" : 200.0," +
            "\"description\" : \"Akarmi\", \"active\" : \"true\", \"_links\" : {\"self\" : {\"href\" : \"http://localhost:60001/products/2\"}," +
            "\"product\" : {\"href\" : \"http://localhost:60001/products/2\"}}} ]}, \"_links\" : { \"self\" : { \"href\" : " +
            "\"http://localhost:60001/products{?page,size,sort}\", \"templated\" : true}, \"profile\" : {\"href\" : " +
            "\"http://localhost:60001/profile/products\"}, \"search\" : {\"href\" : \"http://localhost:60001/products/search\"}},\"page\" : " +
            "{\"size\" : 20, \"totalElements\" : 2, \"totalPages\" : 1, \"number\" : 0}}";

    //for test purpose only
    String testProductString = "{listOfTags : [ ], name : \"Prod1\", price : 10.0, description : \"Hablaty\", status : \"ACTIVE\", _links : " +
            "{self : {href : \"http://localhost:60001/products/1\"}, product : {href : \"http://localhost:60001/products/1\"}}}";

    @Autowired
    private ApiService apiService;

    @Autowired
    private UserSession session;

    private String PRODUCTSAPIURL = "https://herokublabla/all-products";

    private String CARTAPIURL = "https://herokublabla/all-products";

    private String PRODUCTAPIURL = "https://herokublabla/all-products";

    @GetMapping(value = "/")
    public String landingPage(Model model) throws IOException {
        //commented out till products ms is up on heroku:
        //model.addAttribute("products", apiService.getJson(PRODUCTSAPIURL).toMap().toString());
        model.addAttribute("products", testAllProductsString); //till products ms not available
        return "/index";
    }

    @RequestMapping(value = "/shopping_cart", method = RequestMethod.GET)
    public String renderCart(Model model) {
        //commented out till products ms is up on heroku:
        //model.addAttribute("products", apiService.getJson(CARTAPIURL).toMap().toString());
        model.addAttribute("products", testCartProductsString); //till products ms not available
        return "cart";}

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)

    public String renderCart(@PathVariable long id, Model model) {
        //commented out till products ms is up on heroku:
        //model.addAttribute("product", apiService.getJson(PRODUCTAPIURL).toMap().toString());
        model.addAttribute("product", testProductString); //till products ms not availabl
 
        return "product";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String renderUser(@PathVariable long id) {
        return "userpage";
    }



}