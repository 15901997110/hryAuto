package com.haier.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestPropertiesUtil {

    private static ResourceBundle bundle= ResourceBundle.getBundle("test", Locale.getDefault());
    public static String getValue(String key){
        return bundle.getString(key);
    }
}
