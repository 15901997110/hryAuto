package com.haier.util;

import com.alibaba.druid.sql.ast.statement.SQLForeignKeyImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haier.enums.BeforeRegexEnum;
import com.haier.enums.DBInfoKeyEnum;
import com.haier.enums.RegexEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
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
         * 匹配到日期和时间,做相应的处理
         */
        if (base.matches(".*" + BeforeRegexEnum.DATE.getPattern() + ".*")) {
            base = replaceDate(base);
        }
        if (base.matches(".*" + BeforeRegexEnum.DATETIME.getPattern() + ".*")) {
            base = replaceDatetime(base);
        }
        if (base.matches(".*" + BeforeRegexEnum.TIME.getPattern() + ".*")) {
            base = replaceTime(base);
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
     * @description: 将字符串base中的关键字"<<<var:requestNo>>>" 替换成调用者对象中字段名requestNo的值
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
                    Field field = entity.getClass().getField(varName);
                    Object o = field.get(entity);
                    fieldValue = o.toString();
                } catch (NoSuchFieldException e) {
                    log.error("需要替换的字段(" + varName + ")在对象" + entity.toString() + "未找到", e.getMessage());
                    fieldValue = "需要替换的表达式(＜＜＜ｖａｒ：" + varName + "＞＞＞)在对象" + entity.toString() + "中未找到";
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                log.error("未传入entity");
            }
            base = base.substring(0, matcher.start()) + fieldValue + base.substring(matcher.end());
        }

        return base;
    }

    public static String replaceDate(String base) {
        Pattern pattern = Pattern.compile(BeforeRegexEnum.DATE.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String re = matcher.group();//待替换的字符串
            String date;
            //判断是否需要加减日期
            if (re.contains(":")) {//需要加减日期
                String addStr = re.substring(re.indexOf(":") + 1, re.indexOf(">>>"));
                int addInt = 0;
                try {
                    addInt = Integer.parseInt(addStr);
                } catch (NumberFormatException e) {
                    log.error("参数替换中,字符串转化成数字时发生异常:", e);
                }
                date = new SimpleDateFormat("yyyy-MM-dd").format(DateUtils.addDays(new Date(), addInt));
            } else {//不需要加减日期
                date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            }
            //替换原字符串中的<<<date:xxx>>>
            base = base.substring(0, matcher.start()) + date + base.substring(matcher.end());
        }
        return base;
    }

    public static String replaceDatetime(String base) {
        Pattern pattern = Pattern.compile(BeforeRegexEnum.DATETIME.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String re = matcher.group();//待替换的字符串
            String date;
            //判断是否需要加减日期
            if (re.contains(":")) {//需要加减日期
                String addStr = re.substring(re.indexOf(":") + 1, re.indexOf(">>>"));
                int addInt = 0;
                try {
                    addInt = Integer.parseInt(addStr);
                } catch (NumberFormatException e) {
                    log.error("参数替换中,字符串转化成数字时发生异常:", e);
                }
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(DateUtils.addHours(new Date(), addInt));
            } else {//不需要加减日期
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            }
            //替换原字符串中的<<<date:xxx>>>
            base = base.substring(0, matcher.start()) + date + base.substring(matcher.end());
        }
        return base;
    }

    public static String replaceTime(String base) {
        Pattern pattern = Pattern.compile(BeforeRegexEnum.TIME.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String re = matcher.group();//待替换的字符串
            String date;
            //判断是否需要加减日期
            if (re.contains(":")) {//需要加减日期
                String addStr = re.substring(re.indexOf(":") + 1, re.indexOf(">>>"));
                int addInt = 0;
                try {
                    addInt = Integer.parseInt(addStr);
                } catch (NumberFormatException e) {
                    log.error("参数替换中,字符串转化成数字时发生异常:", e);
                }
                date = new SimpleDateFormat("HH:mm:ss").format(DateUtils.addMinutes(new Date(), addInt));
            } else {//不需要加减日期
                date = new SimpleDateFormat("HH:mm:ss").format(new Date());
            }
            //替换原字符串中的<<<date:xxx>>>
            base = base.substring(0, matcher.start()) + date + base.substring(matcher.end());
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

    /**
     *
     */
    public static String replaceRandomI(String base) {
        Pattern pattern = Pattern.compile(BeforeRegexEnum.RANDOM_I.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String re = matcher.group();//"<<<random()>>>"或者"<<<random(a,b)>>>"
            String params = re.substring(re.indexOf("(") + 1, re.indexOf(")"));
            if (params.contains(",")) {
                int start = Integer.parseInt(re.substring(0, re.indexOf(",")));
                int end = Integer.parseInt(re.substring(re.indexOf(",") + 1));
                try {
                    base = matcher.replaceFirst(RandomUtils.nextInt(start, end) + "");
                } catch (RuntimeException e) {
                    base = matcher.replaceFirst(RandomUtils.nextInt(0, 100) + "");
                }
            } else {
                base = matcher.replaceFirst(RandomUtils.nextInt(0, 100) + "");
            }
        }
        return base;
    }

    /**
     * 将"<<<randomF(3.5,10.8)>>>"替换,随机生成一个[3.5,10.8)区间的浮点数,并且此随机生成的浮点数的精度与3.5的精度保持一致
     */
    public static String replaceRandomF(String base) {
        Pattern pattern = Pattern.compile(BeforeRegexEnum.RANDOM_F.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String re = matcher.group();//<<<randomF(1.54,100.26)>>>
            String startF = re.substring(re.indexOf("(") + 1, re.indexOf(","));
            String endF = re.substring(re.indexOf(",") + 1, re.indexOf(")"));
            Integer pointLong = startF.split("\\.")[1].length();//小数点精度的长度,即小数点后还有几位
            float f = RandomUtils.nextFloat(Float.parseFloat(startF), Float.parseFloat(endF));
            String replacedStr = String.format("%." + pointLong + "f", f);//%.3f  %.:表示小数点前任意数,3:3位小数,f:浮点数
            base = matcher.replaceFirst(replacedStr);
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
            String queryResult;
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
                            JdbcTemplate jdbcTemplate = DBUtil.getJdbcTemplate(driver, url, username, password);
                            if (sql.trim().matches(RegexEnum.SELECT_REGEX.getRegex())) {
                                queryResult = DBUtil.query(jdbcTemplate, sql);
                            } else if (sql.trim().matches(RegexEnum.INSERT_REGEX.getRegex())) {
                                queryResult = DBUtil.insert(jdbcTemplate, sql) + "";
                            } else if (sql.trim().matches(RegexEnum.UPDATE_REGEX.getRegex())) {
                                queryResult = DBUtil.update(jdbcTemplate, sql) + "";
                            } else {
                                queryResult = "异常:sql未执行,sql不是以select/insert/update开头,无法执行";
                            }

                            if (queryResult == null) {
                                queryResult = "异常:sql执行结果为null";
                            }
                        } catch (Exception e) {
                            log.error("", e);
                            queryResult = "异常:执行sql异常";
                        }
                    } else {
                        log.error("dbinfo填写有误" + dbinfo);
                        queryResult = "异常:dbinfo填写错误-" + dbinfo;
                    }
                } catch (Exception e) {
                    log.error("解析dbinfo异常,查询结果自动转换为字符串'解析dbinfo异常'", e);
                    queryResult = "异常:解析dbinfo异常";
                }
            } else {
                queryResult = "异常:dbinfo为空,无法执行Sql";
            }
            base = base.substring(0, matcher.start()) + queryResult + base.substring(matcher.end());
        }
        return base;
    }

}
