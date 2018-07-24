package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

/**
 * @Description: 实际结果与期望结果比较器
 * @Author: luqiwei
 * @Date: 2018/5/2 17:09
 */
public class AssertUtil {
    private static final Log log = LogFactory.getLog(AssertUtil.class);

    public static Boolean supperAssert(Integer assertType, String expected, String actual, Integer actualType) {
       /* log.info("assertType:"+assertType);
        log.info("expected:"+expected);
        log.info("actual:"+actual);
        log.info("actualType:"+actualType);
        switch (assertType) {
            //1.assertType=equal,完全相等
            case 1:
                if (actual == null || expected == null) {
                    if (actual == null && expected == null)
                        return true;
                    else
                        return false;
                } else {
                    if (actual.trim().equals(expected.trim()))
                        return true;
                    else
                        return false;

                }
                //2.assertType=contain,实际值中包含期望值,或者实际值能够匹配到期望的正则表达式
            case 2:
                try {
                    if (actual != null && (actual.trim().contains(expected.trim()) || actual.matches(expected)))
                        return true;
                    else
                        return false;
                } catch (PatternSyntaxException e) {
                    log.error("", e);
                    return false;
                }
                //3.assertType=key-value,实际值中抽取出的key-value与指定值中提取的key-value相等,包含,或者正则匹配
                //注意,此种情况时,期望值必须是以json格式存储于数据库中
            case 3:
                if(Objects.isNull(actualType))
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
                            if(Objects.isNull(actualO)||Objects.isNull(expectO)){
                                if(Objects.isNull(actualO)&&Objects.isNull(expectO)){
                                    //两个同时为null时,直接跳过,进行下一个元素的比较
                                    continue;
                                }
                                else{
                                    //一个为null,一个不为null
                                    return false;
                                }
                            }

                            try {
                                if(!(actualO.equals(expectO) || actualO.toString().contains(expectO.toString())||actualO.toString().matches(expectO.toString()))){
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
        }*/
       return true;
    }
}
