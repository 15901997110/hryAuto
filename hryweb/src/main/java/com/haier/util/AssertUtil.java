package com.haier.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.config.SpringContextHolder;
import com.haier.enums.AssertTypeEnum;
import com.haier.po.HryTest;
import com.haier.po.Tcase;
import com.haier.po.Ti;
import com.haier.service.TiService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;

import java.util.Map;
import java.util.Objects;
import java.util.regex.PatternSyntaxException;

/**
 * @Description: 实际结果与期望结果比较器
 * @Author: luqiwei
 * @Date: 2018/5/2 17:09
 */
@Slf4j
public class AssertUtil {
    public static Boolean supperAssert(Integer assertType, String expected, String actual, Integer actualType) {
/*        log.info("assertType:" + assertType);
        log.info("expected:" + expected);
        log.info("actual:" + actual);
        log.info("actualType:" + actualType);*/
        Reporter.log("断言类型 : " + AssertTypeEnum.getValue(assertType) + "(" + assertType + ")");
        Reporter.log("期望结果 :" + expected);
        Reporter.log("实际结果 :" + actual);

        switch (assertType) {
            //1.assertType=equal,完全相等
            case 1:
                return StringUtils.equalsIgnoreCase(actual, expected);
            //2.assertType=contain,实际值中包含期望值,或者实际值能够匹配到期望的正则表达式
            case 2:
                if (StringUtils.containsIgnoreCase(actual, expected)) {
                    return true;
                } else if (StringUtils.countMatches(actual, expected) > 0) {
                    return true;
                } else {
                    return false;
                }
                //3.assertType=key-value,实际值中抽取出的key-value与指定值中提取的key-value相等,包含,或者正则匹配
                //注意,此种情况时,期望值必须是以json格式存储于数据库中
            case 3:
                if (Objects.isNull(actualType))
                    return false;
                switch (actualType) {
                    //actualType=json,对于实际返回值类型为json的处理
                    case 1:
                        JSONObject actualJsonObj = JsonUtil.str2JsonObj(actual);
                        JSONObject expectJsonObj = JsonUtil.str2JsonObj(expected);
                        if (actualJsonObj == null || expectJsonObj == null) {
                            return false;
                        }

                        for (Map.Entry<String, Object> entries : expectJsonObj.entrySet()) {
                            Object actualO = actualJsonObj.get(entries.getKey());
                            Object expectO = entries.getValue();
                            //actualO为null,说明get(key)时获取为null,说明返回结果中不存在 此key,故直接返回false
                            if (Objects.isNull(actualO) || Objects.isNull(expectO)) {
                                if (Objects.isNull(actualO) && Objects.isNull(expectO)) {
                                    //两个同时为null时,直接跳过,进行下一个元素的比较
                                    continue;
                                } else {
                                    //一个为null,一个不为null
                                    return false;
                                }
                            }

                            try {
                                if (!(actualO.equals(expectO) || actualO.toString().contains(expectO.toString()) || actualO.toString().matches(expectO.toString()))) {
                                    return false;
                                }
                            } catch (PatternSyntaxException e) {
                                log.error("", e);
                                return false;
                            }
                        }

                        return true;

                    //actualType=map,对于实际返回值类型为map的处理,(暂未实现)
                    case 2:
                        return false;
                    default:
                        log.error("actualType:" + actualType + ",仅支持1-json,2-map");
                        return false;
                }
                //以上情况都未匹配
            default:
                return false;
        }
    }

    public static Boolean supperAssert(String actual, Tcase tcase) {
        TiService tiService = SpringContextHolder.getBean(TiService.class);
        Ti ti = tiService.selectOne(tcase.getIid());
        return supperAssert(tcase.getAsserttype(), tcase.getExpected(), actual, ti.getIresponsetype());
    }

    public static Boolean supperAssert(String actual, HryTest test) {
        return supperAssert(test.getTcase().getAsserttype(), test.getTcase().getExpected(), actual, test.getTi().getIresponsetype());
    }

    public static Boolean isMatch(Map<String, Object> expected, JSONObject actual) {
        if (expected == null || expected.size() == 0) {
            return false;
        }
        for (Map.Entry<String, Object> entry : expected.entrySet()) {
            if (!isMatch(entry.getKey(), entry.getValue(), actual)) {
                return false;
            }
        }
        //所有key-value都已经通过校验,则返回true
        return true;
    }

    /**
     * 将JSONObject解析到不能再解析为止,如果发现key相同,则比较Value的值
     *
     * @param key
     * @param value
     * @param actual
     * @return
     */
    private static Boolean isMatch(String key, Object value, JSONObject actual) {
        /**
         * 迭代解析JSONObject
         */
        for (Map.Entry<String, Object> entry : actual.entrySet()) {
            String actualKey = entry.getKey();
            Object actualValue = entry.getValue();

            /**
             * 如果actualValue是JSONObject
             */
            if (actualValue instanceof JSONObject) {//如果值是一个JSONObject,则迭代
                if (isMatch(key, value, (JSONObject) actualValue)) {
                    return true;
                }


            /**
             * 如果actualValue是JSONArray
             */
            } else if (actualValue instanceof JSONArray) {//如果值是一个JSONArray,
                JSONArray jsonArray = (JSONArray) actualValue;
                if (jsonArray.size() > 0) {//首先判断JSONArray的长度
                    //判断jsonArray的第一个元素,看其是否是对象,
                    //注意这里可能不妥,如果JSONArray中元素类型不一致,则只判断第一个元素的类型,是不够严谨的
                    //但是从实际实践中来看,暂时还没有发现JSONArray中元素类型不一致的情况
                    Object o = jsonArray.get(0);

                    if (o instanceof JSONObject) {//如果JsonArray中的类型为JSONObject,则迭代
                        for (int i = 0; i < jsonArray.size(); i++) {
                            if (isMatch(key, value, (JSONObject) jsonArray.get(i))) {
                                return true;
                            }
                        }
                    } else {//JSONArray中的类型不是JSONObject,此种情况其实绝大情况都是基本类型
                        if (key.equals(actualKey)) {
                            if (isMatch(value, jsonArray.toJSONString())) {
                                return true;
                            }
                        }
                    }
                } else {//如果jsonArray的长度为0,则jsonArray=[]
                    if (key.equals(actualKey)) {
                        if (isMatch(value, jsonArray.toJSONString())) {
                            return true;
                        }
                    }
                }

            /**
             * actualValue不是JSON对象
             */
            } else {
                if (key.equals(actualKey)) {
                    if (isMatch(value, actualValue)) {
                        return true;
                    }
                }
            }
        }
        /**
         * 所有迭代都走完了,没有匹配到结果,则返回false
         */
        return false;
    }

    /**
     * 比较对象
     *
     * @param expected
     * @param actual
     * @return
     */
    private static Boolean isMatch(Object expected, Object actual) {
        if (expected == null || actual == null) {
            if (expected == null && actual == null) {
                return true;
            } else {
                return false;
            }
        }
        if (actual.equals(expected)) {//两个对象相等
            return true;
        }
        String actualStr = actual.toString().trim();
        String expectedStr = expected.toString().trim();
        if (actualStr.equalsIgnoreCase(expectedStr)) {//转换String后忽略大小写相等
            return true;
        }

        if(actualStr.replaceAll("\\s","").equalsIgnoreCase(expectedStr.replaceAll("\\s",""))){
            log.debug("替换所有空字符串后再比较相等");
            return true;
        }

        if (actualStr.contains(expectedStr)) {//实际值包含期望值
            return true;
        }

        if (actualStr.matches(expectedStr)) {//实际值匹配到期望的正则
            return true;
        }

        return false;//以上都不是,返回false
    }


}
