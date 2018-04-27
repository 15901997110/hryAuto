package com.haier.mytest;

import com.haier.anno.Iuri;
import com.haier.anno.ServiceKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ServiceKey("User")
public class MyTest2 {

    private static final Log log = LogFactory.getLog(MyTest2.class);
    @Iuri("/hello/world")
    @Test(dataProvider = "getDataProvider",dataProviderClass = com.haier.util.DataProviderUtil.class)
    public void testOutProvider(String str){
        System.out.println(str);
    }
/*
    @Iuri("/hello/world")
    @Test(dataProvider = "getDataProvider2")
    public void test(String str){
        System.out.println(str);
    }
    @DataProvider(name="getDataProvider2")
    public Iterator<Object[]> getDataProvider(Method method) {

       *//* String uri = method.getAnnotation(Iuri.class).value();
        String serviceKey=method.getDeclaringClass().getAnnotation(ServiceKey.class).value();
        log.info("serviceKey:"+serviceKey+" uri:"+uri);*//*
        List<Object[]> obj=new ArrayList<Object[]>();
        obj.add(new Object[]{"helo"});
        return obj.iterator();
    }*/
}
