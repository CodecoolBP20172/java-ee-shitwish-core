package com.codecool.enterprise.shitwish.Model;

public class ProductJSON {

    private String name;
    private String price;
    private String description;
    private String userId; //from session

    public ProductJSON(String name, String price, String description, String userId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
