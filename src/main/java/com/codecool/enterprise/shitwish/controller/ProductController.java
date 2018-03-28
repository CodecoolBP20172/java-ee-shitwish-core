package com.codecool.enterprise.shitwish.controller;

import com.codecool.enterprise.shitwish.Model.ProductJSON;
import com.codecool.enterprise.shitwish.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.codecool.enterprise.shitwish.util.JsonUtil.toJson;

@RestController
public class ProductController {

    private String SAVEPRODUCTURL = "https://herokublabla/save-product";

    @Autowired
    private ApiService apiService;

    @PostMapping(value = "/api/saveproduct")
    public String saveProduct(@RequestBody ProductJSON productData) throws IOException {
        System.out.println(productData.toString());

        ResponseEntity<String> response = apiService.postJson(SAVEPRODUCTURL, toJson(productData));
        HttpStatus status = response.getStatusCode(); // status of the response
        String restCall = response.getBody(); // body of the response
        if (status==HttpStatus.OK) {
            System.out.println(restCall);
            return "save product request successfully sent. Body: " + restCall;
        }
        return "error at saving product";
    }
}
