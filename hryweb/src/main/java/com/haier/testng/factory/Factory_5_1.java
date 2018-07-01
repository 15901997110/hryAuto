package com.haier.testng.factory;

import com.haier.testng.cases.PgwTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description: 测试类工厂
 * @Author: luqiwei
 * @Date: 2018/6/27 15:51
 */
public class Factory_5_1 {


    @Factory
    public Object[] getPgwTestFactory() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*Class<?> clazz = Class.forName("com.haier.testng.cases.PgwTest");
        Constructor<?> constructor = clazz.getDeclaredConstructor(Integer.class, Integer.class, String.class);
        Object o = constructor.newInstance(5, 1, null);*/
        Object o=new PgwTest(5,1,null);
        return new Object[]{o};
    }
}
