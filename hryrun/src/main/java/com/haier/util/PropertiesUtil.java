package com.haier.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesUtil {

    private static ResourceBundle bundle= ResourceBundle.getBundle("test", Locale.getDefault());
    public static String getEnvPropertity(String key){
        return bundle.getString(key);
    }
}
