package com.haier.util;

import com.haier.mapper.TcaseCustomMapper;
import com.haier.mapper.TcaseMapper;
import com.haier.mapper.TenvdetailCustomMapper;
import com.haier.mapper.TserviceMapper;
import com.haier.po.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class DBUtil {
    private static final Log log= LogFactory.getLog(DBUtil.class);
    private static SqlSession sqlSession = null;

    public static SqlSession getSqlSession() throws IOException {
        if (sqlSession == null) {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = factory.openSession();
        }
        return sqlSession;
    }
    /**
     *@description:根据serviceKey得到服务id(表service.id)
     *@params: [serviceKey]
     *@return: java.lang.Integer
     *@author: luqiwei
     *@date: 2018-04-27
     */
    public static Integer getServiceKeyId(String serviceKey) throws IOException {

        TserviceExample tserviceExample=new TserviceExample();
        TserviceExample.Criteria tserviceExampleCriteria = tserviceExample.createCriteria();
        tserviceExampleCriteria.andServicekeyEqualTo(serviceKey).andIsdelNotEqualTo((short)1);
        List<Tservice> tserviceList = null;
        tserviceList = getSqlSession().getMapper(TserviceMapper.class).selectByExample(tserviceExample);
        if(tserviceList!=null){
            return tserviceList.get(0).getId();
        }
        log.error("tservice表中未找到serviceKey="+serviceKey+"&isDel<>0的记录");
        return null;
    }
    /**
     *@description: 获取Tenvdetail包装类(TenvDetailCustom)
     *@params: [serviceKey, envKey]
     *@return: java.util.List<com.haier.po.TenvdetailCustom>
     *@author: luqiwei
     *@date: 2018-04-27
     */
    public static List<TenvdetailCustom> getTenvdetailCustomList(String serviceKey, String envKey) throws IOException {
        Tservice tservice=new Tservice();
        tservice.setServicekey(serviceKey);
        Tenv tenv=new Tenv();
        tenv.setEnvkey(envKey);

        TenvdetailCustom tenvdetailCustom=new TenvdetailCustom();
        tenvdetailCustom.setTservice(tservice);
        tenvdetailCustom.setTenv(tenv);

        SqlSession session=getSqlSession();
        TenvdetailCustomMapper mapper = session.getMapper(TenvdetailCustomMapper.class);
        List<TenvdetailCustom> tenvdetailCustomList = mapper.getTenvdetailCustomList(tenvdetailCustom);
        return tenvdetailCustomList;

    }
    public static List<TcaseCustom> getTcaseCustomList(Integer serviceId,String iUri, Integer envId) throws IOException {
        //构建Tcase包装类
        Ti ti=new Ti();
        ti.setServiceid(serviceId);
        ti.setIuri(iUri);

        TcaseCustom tcaseCustom=new TcaseCustom();
        tcaseCustom.setTi(ti);
        tcaseCustom.setEnvid(envId);
        
        //查询数据
        SqlSession sqlSession=getSqlSession();
        TcaseCustomMapper tcaseCustomMapper = sqlSession.getMapper(TcaseCustomMapper.class);
        List<TcaseCustom> tcaseCustomList = tcaseCustomMapper.getTcaseCustomList(tcaseCustom);
        return tcaseCustomList;
    }
    public static Tcase getTcaseByPrimaryKey(Integer id) throws IOException {
        SqlSession sqlSession=getSqlSession();
        TcaseMapper tcaseMapper = sqlSession.getMapper(TcaseMapper.class);
        Tcase tcase = tcaseMapper.selectByPrimaryKey(id);
        return tcase;
    }
}
