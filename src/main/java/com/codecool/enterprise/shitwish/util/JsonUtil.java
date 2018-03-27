package com.codecool.enterprise.shitwish.util;

import com.google.gson.Gson;

public class JsonUtil {

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

}
