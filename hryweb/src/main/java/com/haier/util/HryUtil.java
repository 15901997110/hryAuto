package com.haier.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
