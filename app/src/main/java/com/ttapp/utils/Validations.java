package com.ttapp.utils;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

    public static void toast(Context ctx, String msg) {
        Toast toast = Toast.makeText(ctx, msg, Toast.LENGTH_LONG);
        try {
            LinearLayout toastLayout = (LinearLayout) toast.getView();
            TextView toastTV = (TextView) toastLayout.getChildAt(0);
            toastTV.setTextSize(16);
//             setFont(toastTV, roboto, "TextView");
            toast.show();
        } catch (Exception e) {
        } finally {
            toast.show();
        }
    }
}
