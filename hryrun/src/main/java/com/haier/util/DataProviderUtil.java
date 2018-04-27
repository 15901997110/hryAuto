package com.haier.util;


import com.haier.anno.Iuri;
import com.haier.anno.ServiceKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 根据调用方法,返回case
 *
 * */
public class DataProviderUtil {
    private static final Log log = LogFactory.getLog(DataProviderUtil.class);
    private static String envKey= TestPropertiesUtil.getValue("test.env");
    @DataProvider(name="getDataProviderWithIterator")
    public static Iterator<Object[]> getDataProvider(Method method) {

        String uri = method.getAnnotation(Iuri.class).value();
        String serviceKey=method.getDeclaringClass().getAnnotation(ServiceKey.class).value();
        log.info("serviceKey:"+serviceKey+" uri:"+uri);
        List<Object[]> obj=new ArrayList<Object[]>();

        obj.add(new Object[]{"helloworld!"});
        obj.add(new Object[]{"呵呵"});
        return obj.iterator();
    }
    @DataProvider(name="getDataProviderWithObject")
    public static Object[][] getDataProviderWithObject(Method method){
        Object[][] objects=new Object[][]{
                {new Integer(2),new Integer(3)},
                {new Integer(8),new Integer(10)}
        };
        return objects;
    }
}
