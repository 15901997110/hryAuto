package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haier.enums.BeforeRegexEnum;
import com.haier.enums.DBInfoKeyEnum;
import com.haier.enums.DBTypeEnum;
import com.haier.enums.RequestParamTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

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
    /**
     * 自动将参数中符合BeforeRegexEnum匹配规则的字符串替换
     *
     * @param param
     * @param dbinfo
     * @return
     */
    public static String replace(String param, String dbinfo) {
        JSONObject dbinfoJsonObject = null;
        try {
            dbinfoJsonObject = JSON.parseObject(dbinfo);
        } catch (Exception e) {
            log.warn("dbinfo转换异常,系统将当成dbinfo=null来处理");
        }

        if (param != null && !"".equals(param.trim())) {
            param = param.replaceAll("\\n", "");
            while (needReplace(param)) {
                param = replace(param, dbinfoJsonObject);
            }
            return param;
        } else {
            return null;
        }
    }

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

    public static String replace(String base, JSONObject dbinfo) {
        /**
         * 匹配到<<<uuid>>>,替换成随机唯一字符串
         */
        if (base.matches(".*" + BeforeRegexEnum.UUID.getPattern() + ".*")) {
            Pattern pattern = Pattern.compile(BeforeRegexEnum.UUID.getPattern());
            Matcher matcher = pattern.matcher(base);
            while (matcher.find()) {
                log.debug("匹配到:" + matcher.group());
                log.debug("开始索引:" + matcher.start() + " 结束索引:" + matcher.end());
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
                String query = "";
                if (dbinfo != null) {
                    log.info("dbinfo:" + dbinfo);
                    try {
                        //解析dbinfo
                        String driver = dbinfo.getString(DBInfoKeyEnum.DRIVER.name().toLowerCase());
                        String url = dbinfo.getString(DBInfoKeyEnum.URL.name().toLowerCase());
                        String username = dbinfo.getString(DBInfoKeyEnum.USERNAME.name().toLowerCase());
                        String password = dbinfo.getString(DBInfoKeyEnum.PASSWORD.name().toLowerCase());
                        if (driver != null && url != null && username != null && password != null) {
                            try {
                                JdbcTemplate jdbcTemplate = DBUtil.getJdbcTemplate(DBTypeEnum.MYSQL, url, username, password);
                                query = DBUtil.queryForObject(jdbcTemplate, sql);
                                if (query == null) {
                                    query = "查询Sql为null";
                                }
                            } catch (Exception e) {
                                log.error("执行sql异常,查询结果自动转换为字符串'执行sql异常'", e);
                                query = "执行sql异常";
                            }
                        }
                    } catch (Exception e) {
                        log.error("解析dbinfo异常,查询结果自动转换为字符串'解析dbinfo异常'", e);
                        query = "解析dbinfo异常";
                    }
                } else {
                    query = "dbinfo为空,无法执行Sql";
                }
                base = base.substring(0, matcher.start()) + query + base.substring(matcher.end());
            }
        }

        return base;
    }
}
