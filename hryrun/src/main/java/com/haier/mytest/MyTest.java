package com.haier.mytest;

import com.haier.anno.ServiceKey;
import com.haier.enums.ResponseType;
import com.haier.mapper.TenvMapper;
import com.haier.po.Tenv;
import com.haier.po.TenvdetailCustom;
import com.haier.util.DBUtil;
import com.haier.util.TestPropertiesUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;

@ServiceKey("User")
public class MyTest {
    private static final Log log= LogFactory.getLog(MyTest.class);
    @Test
    public void testLog(){
        log.info("打印log.info");
        log.debug("打印log.debug");
        log.debug("测试占位符{}哈哈{}");
    }
    @Test
    public void enumTest(){
//        System.out.println(ResponseType.JSON.ordinal());
//        System.out.println(ResponseType.TEXT.ordinal());
        System.out.println(ResponseType.JSON.toString());
        System.out.println(ResponseType.JSON.getKey()+ResponseType.JSON.getValue(1));
        System.out.println(ResponseType.TEXT.getKey()+ResponseType.TEXT.getValue(2));
    }
    @Test
    public void mybatisTest() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TenvMapper mapper = sqlSession.getMapper(TenvMapper.class);
        Tenv tenv = mapper.selectByPrimaryKey(1);
        System.out.println(tenv);
    }
    @Test
    public void testUtilTest(){
        String value = TestPropertiesUtil.getValue("test.env");
        System.out.println(value);
    }
    @Test(description = "helloworld")
    public void test1(){
        Class<? extends MyTest> aClass = this.getClass();
        System.out.println(aClass);
        System.out.println(aClass.getAnnotation(ServiceKey.class).value());
    }
    @Test
    public void test2(){
        System.out.println("hellowold");
    }

    @Test(dataProvider = "getDataProviderWithObjectLocaClass")
    public void testAdd(int a,int b){
        int ab=a+b;
        System.out.println(ab);
    }

    @DataProvider(name="getDataProviderWithObjectLocaClass")
    public static Object[][] getDataProviderWithObject(Method method) throws IOException {
        List<TenvdetailCustom> tenvdetail = DBUtil.getTenvdetailCustomList("user", "cs2");
        log.info(tenvdetail);
        Object[][] objects=new Object[][]{
                {new Integer(2),new Integer(3)},
                {new Integer(8),new Integer(10)}
        };
        return objects;
    }
}
