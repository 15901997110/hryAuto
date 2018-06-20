package com.haier.util;

import com.haier.enums.BeforeRegexEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/19 9:47
 */
@Slf4j
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
                log.debug("匹配到:"+matcher.group());
                log.debug("开始索引:"+matcher.start()+" 结束索引:"+matcher.end());
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                base = base.replaceFirst(BeforeRegexEnum.UUID.getPattern(), uuid);
            }
        }
        /**
         * 匹配到<<<Sql:...>>>,执行sql并使用执行结果来替换此处
         */
        if (base.matches(".*" + BeforeRegexEnum.SQL.getPattern() + ".*")) {
            Pattern pattern = Pattern.compile(BeforeRegexEnum.SQL.getPattern());
            Matcher matcher = pattern.matcher(base);
            while (matcher.find()) {
                String sql = matcher.group(2);//((?i)<<<sql:)((?!.*?<<<).*?)(>>>)中第二个(),即(?!.*?<<<).*?匹配到的内容就是Sql语句
                base = base.replaceFirst(BeforeRegexEnum.SQL.getPattern(), matcher.start() + "被替换的" + matcher.end());
            }
        }

        return base;
    }
}
