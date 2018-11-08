package com.haier.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/20 13:35
 */
@Slf4j
public class DBUtil {


    //数据库连接
    public static JdbcTemplate getJdbcTemplate(String driver, String url, String username, String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    //查询
    public static String query(JdbcTemplate jdbcTemplate, String querySql) {
        return jdbcTemplate.queryForObject(querySql, java.lang.String.class);
    }

    public static Integer insert(JdbcTemplate jdbcTemplate, String insertSql) {
        return update(jdbcTemplate, insertSql);
    }

    public static Integer update(JdbcTemplate jdbcTemplate, String updateSql) {
        return jdbcTemplate.update(updateSql);
    }
}
