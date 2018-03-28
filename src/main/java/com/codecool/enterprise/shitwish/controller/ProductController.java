package com.codecool.enterprise.shitwish.controller;

import com.codecool.enterprise.shitwish.Model.ProductJSON;
import com.codecool.enterprise.shitwish.service.ApiService;
import com.codecool.enterprise.shitwish.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.codecool.enterprise.shitwish.util.JsonUtil.toJson;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RestController
public class ProductController {

    private final String productURL = "http://shitwish-product.herokuapp.com/";

    @Autowired
    private ApiService apiService;

    @Autowired
    private UserSession session;

    @PostMapping(value = "/api/saveproduct")
    public String saveProduct(@RequestParam("name") String pName,
                              @RequestParam("price") String pPrice,
                              @RequestParam("description") String pDesc) {
        ProductJSON productData = new ProductJSON(pName, pPrice, pDesc, "1");
        System.out.println(toJson(productData));
        ResponseEntity<String> response = apiService.postJson(productURL + "/products/new-product", toJson(productData));
        HttpStatus status = response.getStatusCode(); // status of the response
        String restCall = response.getBody(); // body of the response
        if (status==HttpStatus.OK) {
            System.out.println(restCall);
            return "index";
        }
        return "error at saving product";
    }
}
