package com.mariiapasichna.util;

import com.google.gson.Gson;
import com.mariiapasichna.models.User;

import java.util.List;

public class UserUtil {
    private static Gson gson = new Gson();

    public static String toJson(User user) {
        return gson.toJson(user);
    }

    public static User fromJson(String json) {
        return gson.fromJson(json, User.class);
    }

    public static String toJson(List<User> users) {
        return gson.toJson(users);
    }
}