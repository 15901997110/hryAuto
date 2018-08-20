package com.haier.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.config.SpringContextHolder;
import com.haier.enums.RegexEnum;
import com.haier.po.*;
import com.haier.service.RunService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/29 11:14
 */
@Slf4j
public class HryUtil {

    /**
     * @description: 将形如"1,2,3"的字符串转换成Integer[]
     * @params: [arrayStr]
     * @return: java.lang.Integer[]
     * @author: luqiwei
     * @date: 2018-06-29
     */
    public static Integer[] convert(String arrayStr) {
        if (arrayStr == null || "".equals(arrayStr.trim())) {
            return null;
        }
        Integer[] ret;
        List<Integer> list = new ArrayList<>();
        if (arrayStr.contains(",")) {
            String[] split = arrayStr.split(",");
            ret = new Integer[split.length];
            for (int i = 0; i < split.length; i++) {
                try {
                    ret[i] = Integer.parseInt(split[i]);
                } catch (NumberFormatException e) {
                    log.error("字符串转换为Integer[]失败:", e);
                }
            }
        } else {
            try {
                ret = new Integer[]{Integer.parseInt(arrayStr)};
            } catch (NumberFormatException e) {
                log.error("字符串转换为Integer[]失败:", e);
                return null;
            }
        }
        return ret;
    }

    public static <T> List<T> distinct(List<T> list) {
        if (list == null) {
            return null;
        }
        Set<T> set = new HashSet<>();
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (set.add(t)) {
                newList.add(t);
            }
        }
        return newList;
    }

    /**
     * @description: 将用例封装成HryTest对象返回
     * @params: [tservice, tservicedetail, caseDesigner, i_c_JSONObject, i_c_zdy_JSONObject, method]
     * @return: java.lang.Object[]   其实是HryTest[]数组对象
     * @author: luqiwei
     * @date: 2018-08-13
     */
    public static Object[] getTests(Tservice tservice, Tservicedetail tservicedetail, String caseDesigner,
                                    JSONObject i_c, JSONObject i_c_zdy, Method method) {
        RunService runService = SpringContextHolder.getBean(RunService.class);
        Object[] ret;
        String iUri;
        //testName可能未填写
        iUri = method.getAnnotation(Test.class).testName();
        if (StringUtils.isBlank(iUri)) {
            throw new SkipException("测试方法(" + method.getName() + ")上@Test.testName注解异常");
        }

        Ti ti = runService.getTi(tservice.getId(), iUri);
        if (ti == null) {
            throw new SkipException("测试服务(id=" + tservice.getId() + ")未找到此接口" + iUri);
        }

        /**
         * 用户有自定义的Case,则返回用户自定义的Case
         */

        if (i_c_zdy != null && i_c_zdy.size() > 0) {
            JSONArray zdyCaseArray = i_c_zdy.getJSONArray(method.getName());
            if (zdyCaseArray != null && zdyCaseArray.size() > 0) {
                ret = new Object[zdyCaseArray.size()];
                for (int i = 0; i < zdyCaseArray.size(); i++) {
                    HryTest test = new HryTest();
                    test.setTservice(tservice);
                    test.setTservicedetail(tservicedetail);
                    test.setTi(ti);
                    test.setTcase((Tcase) zdyCaseArray.get(i));
                }
                return ret;
            }
        }


        /**
         * 用户没有自定义的Case,则使用数据库的Case,选择对应环境的所有Case(注意,未指定envId的Case也会被选择出来)
         * 然后根据用户的定制需求,过滤出用户定制的Case
         */
        List<Tcase> tcases = runService.getTcase(ti.getId(), tservicedetail.getEnvid(), caseDesigner);
        if (tcases.size() == 0) {
            throw new SkipException("此接口(" + iUri + ")无可用的测试用例");
        }

        /**
         * 处理用户定制的Case
         */
        if (i_c != null && i_c.size() > 0) {
            JSONArray customCaseArray = i_c.getJSONArray(method.getName());
            if (customCaseArray != null && customCaseArray.size() > 0) {
                Iterator<Tcase> iterator = tcases.iterator();
                while (iterator.hasNext()) {
                    Tcase tcase = iterator.next();
                    //数据库中查到的caseid不在定制列表中,则移除掉
                    if (!customCaseArray.contains(tcase.getId())) {
                        iterator.remove();
                    }
                }
            }
        }
        ret = new Object[tcases.size()];
        for (int i = 0; i < tcases.size(); i++) {
            HryTest test = new HryTest();
            test.setTservice(tservice);
            test.setTservicedetail(tservicedetail);
            test.setTi(ti);
            test.setTcase(tcases.get(i));
            ret[i] = test;
        }
        return ret;
    }

    public static String iUri2MethodName(String iUri) {
        if (StringUtils.isBlank(iUri)) {
            return iUri;
        }
        String testMethodName;//对应测试类中的测试方法名
        if (iUri.startsWith("/")) {
            testMethodName=iUri.substring(1);
        }
        testMethodName = iUri.replaceAll(RegexEnum.INVALID_CHAR_REGEX.getRegex(), "_");
        return testMethodName;
    }
}
