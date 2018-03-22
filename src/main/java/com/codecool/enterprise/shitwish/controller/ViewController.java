package com.codecool.enterprise.shitwish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderRegisterPage() {
        return "index";
    }

    @RequestMapping(value = "/shopping_cart", method = RequestMethod.GET)
    public String renderCart() { return "cart";}

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String renderCart(@PathVariable long id) {
        return "product";
    }

}
