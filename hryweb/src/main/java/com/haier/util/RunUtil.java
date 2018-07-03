package com.haier.util;

import com.haier.testng.listener.HryReporter;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.internal.annotations.IListeners;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/29 15:11
 */
@Slf4j
public class RunUtil {
    public static void run(Integer userId, List<String> clazzs) {
        log.info("运行的测试集合:" + clazzs.toString());
        List<String> distinctClazzs = HryUtil.distinct(clazzs);
        if (distinctClazzs == null) {
            return;
        }

        List<Class> classList = new ArrayList<>();
        for (String clazz : clazzs) {
            try {
                classList.add(Class.forName(clazz));
            } catch (ClassNotFoundException e) {
                log.error("测试类" + clazz + "未找到", e);
            }
        }

        Class[] ccc = new Class[classList.size()];

        ITestNGListener listener = new HryReporter(userId);
        TestNG testNG = new TestNG();
        testNG.addListener(listener);
        testNG.setTestClasses(classList.toArray(ccc));
        testNG.run();
    }

    private static void runNG(Map<String, String> params, List<String> classes) {
        if (classes == null || classes.size() == 0) {
            return;
        }

        String dateStr = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

        //构建class
        List<XmlClass> xmlClasses = new ArrayList<>();
        for(String clazz:classes){
            xmlClasses.add(new XmlClass(clazz));
        }

        //构建suite
        XmlSuite suite = new XmlSuite();
        suite.setName("AutoSuite_" + dateStr);
        suite.setParameters(params);

        //构建test
        XmlTest test = new XmlTest(suite);
        test.setName("AutuTest_" + dateStr);
        test.setClasses(xmlClasses);


        List<XmlSuite> xmlSuites=new ArrayList<>();
        xmlSuites.add(suite);

        List<Class<? extends ITestNGListener>> listeners=new ArrayList<>();
        listeners.add(com.haier.testng.listener.ExtentTestNGIReporterListener.class);

        TestNG ng=new TestNG();
        ng.setXmlSuites(xmlSuites);
        ng.setListenerClasses(listeners);

        ng.run();

    }
}
