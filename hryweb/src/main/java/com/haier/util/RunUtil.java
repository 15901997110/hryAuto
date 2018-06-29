package com.haier.util;

import com.haier.testng.listener.HryReporter;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.internal.annotations.IListeners;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/29 15:11
 */
@Slf4j
public class RunUtil {
    public static void run(Integer userId,List<String> clazzs){
        List<String> distinctClazzs = HryUtil.distinct(clazzs);
        if(distinctClazzs==null){
            return;
        }

        List<Class> classList=new ArrayList<>();
        for(String clazz:clazzs){
            try {
                classList.add(Class.forName(clazz));
            } catch (ClassNotFoundException e) {
                log.error("测试类"+clazz+"未找到",e);
            }
        }

        ITestNGListener listener=new HryReporter(userId);
        TestNG testNG=new TestNG();
        testNG.addListener(listener);
        testNG.setTestClasses((Class[]) classList.toArray());
        testNG.run();
    }
}
