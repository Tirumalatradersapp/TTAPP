package com.ttapp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by halya on 1/7/17.
 */

public class Validations {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String PHONE_NUMBER_PATTERN = "\\d{10}";

    public static boolean isMobileValid(String phoneNumber) {
        pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
