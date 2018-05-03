package com.haier.mytest;

import com.haier.anno.ServiceKey;
import com.haier.po.TcaseCustom;
import com.haier.util.AssertUtil;
import com.haier.util.DBUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;


@ServiceKey("User")
public class MyTest {
    private static final Log log= LogFactory.getLog(MyTest.class);//第一种方式 :common-logging
    @Test
    public void myTest() throws IOException {
        List<TcaseCustom> tcaseCustomList = DBUtil.getTcaseCustomList(1, "/loginFacade/generateCode", 2);
/*        List<TenvdetailCustom> tenvdetailCustomList = DBUtil.getTenvdetailCustomList("user", "cs2");
        System.out.println(tenvdetailCustomList);*/
    }

    @Test
    public void mytest2(){
        Boolean aBoolean = AssertUtil.supperAssert(3, "{\"name\":\"[a-z]+\",\"ages\":\"\\\\d{2}\"}", "{\"name\":\"lunimei\",\"age\":18,\"toys\":\"灰机\"}", 1);
        log.debug(aBoolean);
    }
    @Test
    public void test3(){

    }

}
