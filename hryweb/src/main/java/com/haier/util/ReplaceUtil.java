package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haier.config.SpringContextHolder;
import com.haier.enums.DBInfoKeyEnum;
import com.haier.enums.RegexEnum;
import com.haier.enums.ReplaceRegexEnum;
import com.haier.po.Temp;
import com.haier.service.TempService;
import com.haier.testng.base.Base;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.Reporter;

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
public class ReplaceUtil {
    private static TempService tempService;

    static {
        tempService = SpringContextHolder.getBean(TempService.class);
    }

    /**
     * 自动将参数中符合BeforeRegexEnum匹配规则的字符串替换
     */
    public static <T extends Base> String replaceBefore(String base, String dbinfo, T entity) {
        if (StringUtils.isNotBlank(base)) {
            Reporter.log("用例设计参数:" + base.replaceAll("<", "＜").replaceAll(">", "＞"));
            base = base.replaceAll("\\n", " ");//所有的换行替换成空格
            while (isNeedReplace(base)) {
                base = replaceAll(base, dbinfo, entity, null, null);
            }
            return base;
        } else {
            Reporter.log("用例设计参数:null");
            return base;
        }
    }

    public static <T extends Base> void replaceAfter(String base, String responseBody, String dbinfo, T entity) {
        if (StringUtils.isBlank(base)) {
            return;
        }
        Reporter.log("后置处理内容:" + base.replaceAll("<", "＜").replaceAll(">", "＞"));
        base = base.replaceAll("\\n", " ");
        while (isNeedReplace(base)) {
            base = replaceAll(base, dbinfo, entity, responseBody, true);
        }
        Reporter.log("后置处理结果:" + base);
    }

    public static Boolean isNeedReplace(String base) {
        ReplaceRegexEnum[] values = ReplaceRegexEnum.values();
        for (ReplaceRegexEnum value : values) {
            //ref的匹配需要SOURCE配合,单独不做替换逻辑
            if (value.equals(ReplaceRegexEnum.REF)) {
                continue;
            }
            if (base.matches(".*" + value.getPattern() + ".*")) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Base> String replaceAll(String base, String dbinfo, T entity, String responseBody, Boolean isAfter) {
        if (isAfter == null) {
            isAfter = false;
        }
        /**
         * 匹配到<uuid>,替换成随机唯一字符串
         */
        if (base.matches(".*" + ReplaceRegexEnum.UUID.getPattern() + ".*")) {
            base = replaceUUID(base);
        }

        /**
         * 匹配到日期和时间,做相应的处理
         */

        if (base.matches(".*" + ReplaceRegexEnum.LONGDATE.getPattern() + ".*")) {
            base = replaceLongDate(base);
        }
        if (base.matches(".*" + ReplaceRegexEnum.DATE.getPattern() + ".*")) {
            base = replaceDate(base);
        }
        if (base.matches(".*" + ReplaceRegexEnum.DATETIME.getPattern() + ".*")) {
            base = replaceDatetime(base);
        }
        if (base.matches(".*" + ReplaceRegexEnum.TIME.getPattern() + ".*")) {
            base = replaceTime(base);
        }

        /**
         * 匹配到随机规则,则生成随机字符替换
         */
        if (base.matches(".*" + ReplaceRegexEnum.RANDOM_I.getPattern() + ".*")) {
            base = replaceRandomI(base);
        }
        if (base.matches(".*" + ReplaceRegexEnum.RANDOM_F.getPattern() + ".*")) {
            base = replaceRandomF(base);
        }

        if (base.matches(".*" + ReplaceRegexEnum.SOURCE.getPattern() + ".*")) {
            base = replaceRef(base);
        }
        /**
         * 匹配到<var(requestNo)>,将此处替换成调用者对象中的字段值,如果调用者中此字段不存在 ,则替换为字符串"{对象名}中不存在此字段"
         */
        if (base.matches(".*" + ReplaceRegexEnum.VAR.getPattern() + ".*")) {
            base = replaceVar(base, entity);
        }

        /**
         * 匹配到<Sql:xxx>,执行sql并使用执行结果来替换此处
         */
        if (base.matches(".*" + ReplaceRegexEnum.SQL.getPattern() + ".*")) {
            base = replaceSql(base, dbinfo);
        }

        if (base.matches(".*" + ReplaceRegexEnum.PUT.getPattern() + ".*")) {
            base = replacePut(base, entity, responseBody, isAfter);
        }

        if (base.matches(".*" + ReplaceRegexEnum.PUTR.getPattern() + ".*")) {
            base = replacePutR(base, entity);
        }

        if (base.matches(".*" + ReplaceRegexEnum.GET.getPattern() + ".*")) {
            base = replaceGet(base, entity);
        }

        return base;
    }

    /**
     * 将字符串base中的关键字"<var(requestNo)>" 替换成调用者对象中字段名requestNo的值
     */
    public static <T> String replaceVar(String base, T entity) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.VAR.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String re = matcher.group();
            String varName = re.substring(re.indexOf("(") + 1, re.lastIndexOf(")"));
            String fieldValue = "［替换var值时发生异常］";
            if (entity != null) {
                try {
                    Field field = entity.getClass().getField(varName);
                    Object o = field.get(entity);
                    fieldValue = o.toString();
                } catch (NoSuchFieldException | IllegalAccessException e) {
                }
            }
            base = matcher.replaceFirst(fieldValue == null ? "null" : fieldValue);
            matcher.reset(base);//重置匹配器
        }
        return base;
    }

    /**
     * 替换"<date(1)>",接收数字参数,按数字以天为单位偏移
     */
    public static String replaceDate(String base) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.DATE.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String re = matcher.group();//待替换的字符串
            String date;
            String num = re.substring(re.indexOf("(") + 1, re.lastIndexOf(")")).replaceAll("\\s", "");
            if (num.length() == 0) {//括号中为空,不需要加减日期
                date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            } else {
                int addInt = 0;
                try {
                    addInt = Integer.parseInt(num);
                } catch (NumberFormatException e) {
                    log.error("参数替换中,字符串转化成数字时发生异常:", e);
                }
                date = new SimpleDateFormat("yyyy-MM-dd").format(DateUtils.addDays(new Date(), addInt));
            }
            //替换原字符串中
            base = matcher.replaceFirst(date);
            matcher.reset(base);//重置匹配器
        }
        return base;
    }

    public static String replaceLongDate(String base) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.LONGDATE.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            base = matcher.replaceFirst(System.currentTimeMillis() + "");
            matcher.reset(base);
        }
        return base;
    }

    /**
     * 替换"<datetime(1)>",接收数字参数,以小时为单位偏移
     */
    public static String replaceDatetime(String base) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.DATETIME.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String re = matcher.group();//待替换的字符串
            String date;
            String num = re.substring(re.indexOf("(") + 1, re.lastIndexOf(")")).replaceAll("\\s", "");
            //判断是否需要加减日期
            if (num.length() > 0) {//需要加减日期
                int addInt = 0;
                try {
                    addInt = Integer.parseInt(num);
                } catch (NumberFormatException e) {
                    log.error("参数替换中,字符串转化成数字时发生异常:", e);
                }
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(DateUtils.addHours(new Date(), addInt));
            } else {//不需要加减日期
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            }
            //替换原字符串中的<<<date:xxx>>>
            base = matcher.replaceFirst(date);
            matcher.reset(base);//重置匹配器
        }
        return base;
    }

    /**
     * 替换"<time(1)>",接收数字参数,以分钟为单位偏移
     */
    public static String replaceTime(String base) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.TIME.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String re = matcher.group();//待替换的字符串
            String date;
            String num = re.substring(re.indexOf("(") + 1, re.lastIndexOf(")")).replaceAll("\\s", "");
            //判断是否需要加减日期
            if (num.length() > 0) {//需要加减日期
                int addInt = 0;
                try {
                    addInt = Integer.parseInt(num);
                } catch (NumberFormatException e) {
                    log.error("参数替换中,字符串转化成数字时发生异常:", e);
                }
                date = new SimpleDateFormat("HH:mm:ss").format(DateUtils.addMinutes(new Date(), addInt));
            } else {//不需要加减日期
                date = new SimpleDateFormat("HH:mm:ss").format(new Date());
            }
            //替换原字符串
            base = matcher.replaceFirst(date);
            matcher.reset(base);//重置匹配器
        }
        return base;
    }

    /**
     * 将"<uuid>"随机替换为uuid
     */
    public static String replaceUUID(String base) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.UUID.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String uuidRegex = matcher.group();
            int cutLength = 0;
            if (uuidRegex.contains("(") && uuidRegex.contains(")")) {
                String cutNum = uuidRegex.substring(uuidRegex.indexOf("(") + 1, uuidRegex.lastIndexOf(")"));
                try {
                    cutLength = Integer.parseInt(cutNum);
                } catch (RuntimeException e) {
                }
            }

            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            if (cutLength > 0) {
                uuid = uuid.substring(0, cutLength);
            }
            base = matcher.replaceFirst(uuid);
            matcher.reset(base);//重置匹配器
        }
        return base;
    }

    /**
     * 使用"<$10(xxx)" 替换"<ref(10)>"
     */
    public static String replaceRef(String base) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.SOURCE.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            //首先处理<$1(xxx)>
            String sourceRegex = matcher.group();
            String sourceIndex = sourceRegex.substring(sourceRegex.indexOf("$") + 1, sourceRegex.indexOf("("));
            String sourceValue = sourceRegex.substring(sourceRegex.indexOf("(") + 1, sourceRegex.lastIndexOf(")"));
            base = matcher.replaceFirst(sourceValue);
            Pattern refPattern = Pattern.compile("<ref\\(" + sourceIndex + "\\)>");
            Matcher refMatcher = refPattern.matcher(base);
            if (refMatcher.find()) {
                base = refMatcher.replaceAll(sourceValue);
            }
            matcher.reset(base);//重置匹配器
        }
        return base;
    }

    /**
     * 将"<randomI(10,100)>",接收参数起始边界,在区间[start,end)中随机生成一个整形数字
     */
    public static String replaceRandomI(String base) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.RANDOM_I.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String re = matcher.group();
            String params = re.substring(re.indexOf("(") + 1, re.lastIndexOf(")")).replaceAll("\\s", "");
            if (params.contains(",")) {
                try {
                    int start = Integer.parseInt(params.substring(0, params.indexOf(",")));
                    int end = Integer.parseInt(params.substring(params.indexOf(",") + 1));
                    base = matcher.replaceFirst(RandomUtils.nextInt(start, end) + "");
                } catch (RuntimeException e) {
                    base = matcher.replaceFirst(RandomUtils.nextInt(0, 100) + "");
                }
            } else {
                base = matcher.replaceFirst(RandomUtils.nextInt(0, 100) + "");
            }
            matcher.reset(base);//重置匹配器
        }
        return base;
    }

    /**
     * 将"<randomF(3.5,10.8)>"替换,随机生成一个[3.5,10.8)区间的浮点数,并且此随机生成的浮点数的精度与3.5的精度保持一致
     */
    public static String replaceRandomF(String base) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.RANDOM_F.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String re = matcher.group();//<randomF()> 或者 <randomF(1.1,2.2)>
            String params = re.substring(re.indexOf("(") + 1, re.lastIndexOf(")")).replaceAll("\\s", "");

            float f = RandomUtils.nextFloat(0.00f, 1.00f);
            Integer pointLong = 2;
            if (params.length() > 0) {//填写了区间参数
                if (params.contains(",")) {
                    String startF = params.substring(0, params.indexOf(","));
                    String endF = params.substring(params.indexOf(",") + 1);
                    try {
                        pointLong = startF.split("\\.")[1].length();//以开始参数的精度为随机数的精度
                        f = RandomUtils.nextFloat(Float.parseFloat(startF), Float.parseFloat(endF));
                    } catch (RuntimeException exception) {

                    }
                }
            }
            String replacedStr = String.format("%." + pointLong + "f", f);//%.3f  %.:表示小数点前任意数,3:3位小数,f:浮点数
            base = matcher.replaceFirst(replacedStr);
            matcher.reset(base);//重置匹配器
        }
        return base;
    }

    /**
     * 将"<sql:xxx>"替换,使用Sql执行结果替换匹配到的正则项
     */
    public static String replaceSql(String base, String dbinfo) {
        String queryResult;
        JSONObject dbinfoJsonObject = null;
        try {
            dbinfoJsonObject = JSON.parseObject(dbinfo);
        } catch (Exception e) {
        }
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.SQL.getPattern());
        Matcher matcher = pattern.matcher(base);
        //连接数据库
        JdbcTemplate jdbcTemplate = null;
        try {
            //解析dbinfo
            String driver = dbinfoJsonObject.getString(DBInfoKeyEnum.DRIVER.name().toLowerCase());
            String url = dbinfoJsonObject.getString(DBInfoKeyEnum.URL.name().toLowerCase());
            String username = dbinfoJsonObject.getString(DBInfoKeyEnum.USERNAME.name().toLowerCase());
            String password = dbinfoJsonObject.getString(DBInfoKeyEnum.PASSWORD.name().toLowerCase());
            jdbcTemplate = DBUtil.getJdbcTemplate(driver, url, username, password);
        } catch (RuntimeException e) {
            log.info("dbinfo信息:" + dbinfoJsonObject.toJSONString());
            log.error("", e);
        }

        while (matcher.find()) {
            String re = matcher.group();//<sql:xxx>
            String sql = re.substring(re.indexOf(":") + 1, re.lastIndexOf(">")).trim();
            if (dbinfoJsonObject == null || jdbcTemplate == null) {
                queryResult = "［异常:数据库连接异常,dbinfo为空,或者dbinfo不为空,但是连接时出现异常］,dbInfo=" + dbinfo;
                base = matcher.replaceFirst(queryResult);
                matcher.reset(base);
                continue;
            }
            try {
                if (sql.matches(RegexEnum.SELECT_REGEX.getRegex())) {
                    queryResult = DBUtil.query(jdbcTemplate, sql);
                } else if (sql.matches(RegexEnum.INSERT_REGEX.getRegex())) {
                    queryResult = DBUtil.insert(jdbcTemplate, sql) + "";
                } else if (sql.matches(RegexEnum.UPDATE_REGEX.getRegex())) {
                    queryResult = DBUtil.update(jdbcTemplate, sql) + "";
                } else {
                    queryResult = "［异常:sql未执行,sql不是以select/insert/update开头,无法执行］";
                }
            } catch (Exception e) {
                log.error("", e);
                log.info("要执行的sql语句:" + sql);
                queryResult = "［异常:执行sql异常］";
            }

            base = matcher.replaceFirst(queryResult == null ? "null" : queryResult);
            matcher.reset(base);//重置匹配器
        }
        return base;
    }

    public static <T extends Base> String replacePut(String base, T entity, String responseBody, Boolean isAfter) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.PUT.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            Temp temp = new Temp();

            String group = matcher.group();//<putH(key,value)>
            String key = group.substring(group.indexOf("(") + 1, group.indexOf(","));
            String value = group.substring(group.indexOf(",") + 1, group.lastIndexOf(")")).trim();

            //如果是后置处理,并且putValue匹配到后置处理表达式,则将value进一步处理
            //$abc,从返回值中找到第一个key名字为abc的值
            //${aaa{bbb[ccc,从返回值按json解析层级找出abc的值
            if (isAfter && (value.matches(RegexEnum.SIMPLE_JSONKEY.getRegex()) || value.matches(RegexEnum.HARD_JSONKEY.getRegex()))) {
                String getValueFromResponseBody = JSONUtil.getValue(responseBody, value);
                value = getValueFromResponseBody == null ? "【后置处理结果为null】" : getValueFromResponseBody;
            }


            if (value.length() > 500) {
                value = value.substring(0, 499);
            }

            temp.setTestingid(entity.testingId);
            temp.setTempkey(key);
            temp.setTempvalue(value);
            temp.setServicekey(entity.tservice.getServicekey());
            tempService.insertOne(temp);

            base = matcher.replaceFirst(value);
            matcher.reset(base);
        }
        return base;
    }

    public static <T extends Base> String replacePutR(String base, T entity) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.PUTR.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            Temp temp = new Temp();

            String group = matcher.group();//<putR(key,value)>
            String key = group.substring(group.indexOf("(") + 1, group.indexOf(","));
            String value = group.substring(group.indexOf(",") + 1, group.lastIndexOf(")"));
            if (value.length() > 500) {
                value = value.substring(0, 499);
            }

            temp.setTestingid(entity.testingId);
            temp.setTempkey(key);
            temp.setTempvalue(value);
            temp.setServicekey(entity.tservice.getServicekey());
            tempService.insertOne(temp);

            base = matcher.replaceFirst("");
            matcher.reset(base);
        }
        return base;
    }

    public static <T extends Base> String replaceGet(String base, T entity) {
        Pattern pattern = Pattern.compile(ReplaceRegexEnum.GET.getPattern());
        Matcher matcher = pattern.matcher(base);
        while (matcher.find()) {
            String group = matcher.group();//<get(key)>
            String key = group.substring(group.indexOf("(") + 1, group.indexOf(")"));
            String tempValue = tempService.getTempValue(entity.testingId, key);
            base = matcher.replaceFirst(tempValue);
            matcher.reset(base);
        }
        return base;
    }
}
