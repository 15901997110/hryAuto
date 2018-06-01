package com.haier.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @Description: 反射相关的工具
 * @Author: luqiwei
 * @Date: 2018/5/23 20:14
 */
@Slf4j
public class ReflectUtil {
    /**
     * @description: 统一将po对象中String类型的字段的值加上%sourceFieldValue%,在做like查询时可先调用此方法给字段加上%
     * @params: [po-需要统一设置的对象,isExtendsClass-是否是继承类,如果是继承类,则会自动获取设置父类属性值]
     * @return: T
     * @author: luqiwei
     * @date: 2018-05-23
     */
    public static <T> void setStringFieldAddPercent(T po, Boolean isExtendsClass) {
        Field[] declaredFields = po.getClass().getDeclaredFields();
        setField(po, declaredFields);
        //如果是继承类,则这里再处理父类的字段值
        if (isExtendsClass) {
            Field[] supperDeclaredFields = po.getClass().getSuperclass().getDeclaredFields();
            setField(po, supperDeclaredFields);
        }
    }

    private static <T> void setField(T t, Field[] declaredFields) {
        for (Field field : declaredFields) {
            if (field.getType() == String.class) {//设置String类型字段
                field.setAccessible(true);
                try {
                    String fieldValue = (String) field.get(t);
                    if (fieldValue != null && !"".equals(fieldValue.trim())) {
                        field.set(t, "%" + fieldValue.trim() + "%");
                    }
                } catch (IllegalAccessException e) {
                    log.error("javabean前后添加%时出现异常!!");
                    continue;
                }
            }
        }
    }


    /**
     *@description: 过滤对象中无用的字段,将其设置为null,比如String类型的字段值为"",Integer类型的字段值为0,
     * 都将统一设置为null
     *@params: [po, isExtendsClass]
     *@return: void
     *@author: luqiwei
     *@date: 2018-06-01
     */
    public static <T> void setInvalidFieldToNull(T po, Boolean isExtendsClass) {
        Field[] declaredFields = po.getClass().getDeclaredFields();
        setFieldToNull(po, declaredFields);
        if (isExtendsClass) {
            Field[] supperDeclaredFields = po.getClass().getSuperclass().getDeclaredFields();
            setFieldToNull(po, supperDeclaredFields);
        }
    }

    private static <T> void setFieldToNull(T t, Field[] declaredFields) {
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.getType() == String.class) {//如果默认值为"",设置为null
                String str;
                try {
                    str = (String) field.get(t);
                } catch (IllegalAccessException e) {
                    continue;
                }
                if (str != null) {
                    if ("".equals(str.trim())) {
                        try {
                            field.set(t, null);
                        } catch (IllegalAccessException e) {
                            continue;
                        }
                    }else{
                        try {
                            field.set(t, str.trim());
                        } catch (IllegalAccessException e) {
                            continue;
                        }
                    }

                }

            }

            if (field.getType() == Integer.class || field.getType() == Short.class) {//如果值为0,设置为null
                Integer value;
                try {
                    value = (Integer) field.get(t);
                } catch (IllegalAccessException e) {
                    continue;
                }
                if (value != null && value == 0) {
                    try {
                        field.set(t, null);
                    } catch (IllegalAccessException e) {
                        continue;
                    }
                }
            }
        }
    }
}
