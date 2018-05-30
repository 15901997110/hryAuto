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
     *@description: 统一将po对象中String类型的字段的值加上%sourceFieldValue%,在做like查询时可先调用此方法给字段加上%
     *@params: [t-需要统一设置的对象,isExtendsClass-是否是继承类,如果是继承类,则会自动获取设置父类属性值]
     *@return: T
     *@author: luqiwei
     *@date: 2018-05-23
     */
    public static <T>void setStringFields(T t, Boolean isExtendsClass) {
        Field[] declaredFields = t.getClass().getDeclaredFields();
        setField(t, declaredFields);
        //如果是继承类,则这里再处理父类的字段值
        if(isExtendsClass){
            Field[] supperDeclaredFields = t.getClass().getSuperclass().getDeclaredFields();
            setField(t, supperDeclaredFields);
        }
    }

    private static <T> void setField(T t, Field[] declaredFields) {
        for(Field field:declaredFields){
            if(field.getType()==String.class){//设置String类型字段
                field.setAccessible(true);
                try {
                    String fieldValue=(String) field.get(t);
                    if(fieldValue!=null&&!"".equals(fieldValue.trim())){
                        field.set(t,"%"+fieldValue.trim()+"%");
                    }
                } catch (IllegalAccessException e) {
                    log.error("javabean前后添加%时出现异常!!");
                }
            }
        }
    }
}
