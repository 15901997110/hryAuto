package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haier.enums.BeforeRegexEnum;
import com.haier.enums.DBInfoKeyEnum;
import com.haier.enums.DBTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
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
    public static <T> String replace(String param, String dbinfo, T entity) {

        if (StringUtils.isNotBlank(param)) {
            param = param.replaceAll("\\n", "");
            while (isNeedReplace(param)) {
                param = replaceAll(param, dbinfo, entity);
            }
            return param;
        } else {
            return null;
        }
    }

    public static Boolean isNeedReplace(String base) {
        Boolean ret = false;
        BeforeRegexEnum[] values = BeforeRegexEnum.values();
        for (BeforeRegexEnum value : values) {
            if (base.matches(".*" + value.getPattern() + ".*")) {
                return true;
            }
        }
        return ret;
    }

    public static <T> String replaceAll(String base, String dbinfo, T entity) {
        /**
         * 匹配到<<<uuid>>>,替换成随机唯一字符串
         */
        if (base.matches(".*" + BeforeRegexEnum.UUID.getPattern() + ".*")) {
            base = replaceUUID(base);
        }

        /**
         * 匹配到<<<var:xxx>>>,将此处替换成调用者对象中的字段值,如果调用者中此字段不存在 ,则替换为字符串"{对象名}中不存在此字段"
         */
        if (base.matches(".*" + BeforeRegexEnum.VAR.getPattern() + ".*")) {
            base = replaceVar(base, entity);
        }

        /**
         * 匹配到<<<Sql:xxx>>>,执行sql并使用执行结果来替换此处
         */
        if (base.matches(".*" + BeforeRegexEnum.SQL.getPattern() + ".*")) {
            base = replaceSql(base, dbinfo);
        }

        return base;
    }

    /**
     * @description: 将字符串base中的关键字<<       <       var:requestNo>>> 替换成调用者对象中字段名为requestNo的值
     * @params: [base-需要替换的字符串, entity-调用此方法的实体对象]
     * @return: java.lang.String
     * @author: luqiwei
     * @date: 2018-08-07
     */
    public static <T> String replaceVar(String base, T entity) {
        Pattern pattern = Pattern.compile(BeforeRegexEnum.VAR.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String varName = matcher.group(2).trim();
            String fieldValue = "";
            if (entity != null) {
                try {
                    Field declaredField = entity.getClass().getDeclaredField(varName);
                    declaredField.setAccessible(true);
                    try {
                        Object o = declaredField.get(entity);
                        fieldValue = o.toString();
                    } catch (IllegalAccessException e) {
                        log.error("获取对象字段值时权限异常:", e.getMessage());

                    }
                } catch (NoSuchFieldException e) {
                    log.error("需要替换的字段(" + varName + ")在对象" + entity.toString() + "未找到", e.getMessage());
                    fieldValue = "需要替换的字段(" + varName + ")在对象" + entity.toString() + "未找到";
                }
            } else {
                log.error("未传入entity");
            }
            base = base.substring(0, matcher.start()) + fieldValue + base.substring(matcher.end());
        }

        return base;
    }

    public static String replaceUUID(String base) {
        Pattern pattern = Pattern.compile(BeforeRegexEnum.UUID.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            log.debug("匹配到:" + matcher.group());
            log.debug("开始索引:" + matcher.start() + " 结束索引:" + matcher.end());
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            base = base.replaceFirst(BeforeRegexEnum.UUID.getPattern(), uuid);
        }
        return base;
    }

    public static String replaceSql(String base, String dbinfo) {

        JSONObject dbinfoJsonObject;
        try {
            dbinfoJsonObject = JSON.parseObject(dbinfo);
        } catch (Exception e) {
            dbinfoJsonObject = null;
            log.warn("dbinfo转换异常,系统将当成dbinfo=null来处理");
        }
        Pattern pattern = Pattern.compile(BeforeRegexEnum.SQL.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String sql = matcher.group(2);//((?i)<<<sql:)((?!.*?<<<).*?)(>>>)中第二个(),即(?!.*?<<<).*?匹配到的内容就是Sql语句
            String queryResult = "";
            if (dbinfoJsonObject != null) {
                log.info("dbinfo:" + dbinfoJsonObject);
                try {
                    //解析dbinfo
                    String driver = dbinfoJsonObject.getString(DBInfoKeyEnum.DRIVER.name().toLowerCase());
                    String url = dbinfoJsonObject.getString(DBInfoKeyEnum.URL.name().toLowerCase());
                    String username = dbinfoJsonObject.getString(DBInfoKeyEnum.USERNAME.name().toLowerCase());
                    String password = dbinfoJsonObject.getString(DBInfoKeyEnum.PASSWORD.name().toLowerCase());
                    if (!StringUtils.isAnyBlank(driver, url, username, password)) {
                        try {
                            JdbcTemplate jdbcTemplate = DBUtil.getJdbcTemplate(DBTypeEnum.MYSQL, url, username, password);
                            queryResult = DBUtil.queryForObject(jdbcTemplate, sql);
                            if (queryResult == null) {
                                queryResult = "查询Sql为null";
                            }
                        } catch (Exception e) {
                            log.error("执行sql异常,查询结果自动转换为字符串'执行sql异常'", e);
                            queryResult = "执行sql异常";
                        }
                    } else {
                        log.error("dbinfo填写有误" + dbinfo);
                        queryResult = "dbinfo填写有误:" + dbinfo;
                    }
                } catch (Exception e) {
                    log.error("解析dbinfo异常,查询结果自动转换为字符串'解析dbinfo异常'", e);
                    queryResult = "解析dbinfo异常";
                }
            } else {
                queryResult = "dbinfo为空,无法执行Sql";
            }
            base = base.substring(0, matcher.start()) + queryResult + base.substring(matcher.end());
        }
        return base;
    }

}
