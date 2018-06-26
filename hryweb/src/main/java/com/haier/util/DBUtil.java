package com.haier.util;

import com.haier.enums.DBTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/20 13:35
 */
@Slf4j
public class DBUtil {


    //数据库连接
    public static JdbcTemplate getJdbcTemplate(DBTypeEnum dbTypeEnum,String url,String username,String password){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(dbTypeEnum.getDriverName());
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    //执行查询语句
    public static String queryForObject(JdbcTemplate jdbcTemplate,String querySql){
        return jdbcTemplate.queryForObject(querySql,java.lang.String.class);
    }
}
