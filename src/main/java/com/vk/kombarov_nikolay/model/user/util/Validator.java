package com.vk.kombarov_nikolay.model.user.util;

/**
 * Created by nikolaykombarov on 13.01.17.
 */
public class Validator {
    private static boolean validateUsername(String username) {
        return username.length() >= 3 && username.length() < 16;
    }

    private static boolean validatePassword(String password) {
        return password.length() >= 3 && password.length() < 32;
    }

    public static boolean validate(String username, String password) {
        return validateUsername(username) && validatePassword(password);
    }
}
