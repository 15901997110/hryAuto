package com.haier.util;

import com.haier.enums.BeforeRegexEnum;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/19 9:47
 */
public class BeforeUtil {
    public static Boolean needReplace(String base) {
        Boolean ret = false;
        BeforeRegexEnum[] values = BeforeRegexEnum.values();
        for (BeforeRegexEnum value : values) {
            if (base.matches(".*" + value.getPattern() + ".*")) {
                return true;
            }
        }
        return ret;
    }

    public static String replace(String base) {
        /**
         * 匹配到<<<uuid>>>,替换成随机唯一字符串
         */
        if (base.matches(".*" + BeforeRegexEnum.UUID.getPattern() + ".*")) {
            Pattern pattern = Pattern.compile(BeforeRegexEnum.UUID.getPattern());
            Matcher matcher = pattern.matcher(base);
            while (matcher.find()) {
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                base = base.replaceFirst(BeforeRegexEnum.UUID.getPattern(), uuid);
            }
        }

        if(base.matches(".*"+BeforeRegexEnum.SQL.getPattern()+".*")){
            Pattern pattern=Pattern.compile(BeforeRegexEnum.SQL.getPattern());
            Matcher matcher=pattern.matcher(base);
            while(matcher.find()){

            }
        }

        return base;
    }
}
