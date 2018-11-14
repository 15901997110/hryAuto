package com.haier.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haier.enums.*;
import com.haier.po.SqlExecuteResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Map;

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

    public static JdbcTemplate getJdbcTemplate(String dbInfo) {
        JSONObject jsonObject;
        try {
            jsonObject = JSON.parseObject(dbInfo);
        } catch (Exception e) {
            return null;
        }
        String driver = jsonObject.getString(DBInfoKeyEnum.DRIVER.name().toLowerCase());
        String url = jsonObject.getString(DBInfoKeyEnum.URL.name().toLowerCase());
        String username = jsonObject.getString(DBInfoKeyEnum.USERNAME.name().toLowerCase());
        String password = jsonObject.getString(DBInfoKeyEnum.PASSWORD.name().toLowerCase());
        if (StringUtils.isAnyBlank(driver, url, username, password)) {
            return null;
        }
        return getJdbcTemplate(driver, url, username, password);
    }

    public static SqlExecuteResult executeSql(String dbInfo, String sql) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate(dbInfo);
        if (jdbcTemplate == null) {
            SqlExecuteResult<String> ret = new SqlExecuteResult<>();
            ret.setSqlExecuted(SqlExecuted.FAIL);
            ret.setResult("【数据库连接异常】");
            return ret;
        } else {
            if (sql.matches(RegexEnum.SELECT_REGEX.getRegex())) {
                return query(jdbcTemplate, sql);
            } else if (sql.matches(RegexEnum.INSERT_REGEX.getRegex())) {
                return insert(jdbcTemplate, sql);
            } else if (sql.matches(RegexEnum.UPDATE_REGEX.getRegex())) {
                return update(jdbcTemplate, sql);
            } else {
                SqlExecuteResult<String> ret = new SqlExecuteResult<>();
                ret.setSqlExecuted(SqlExecuted.FAIL);
                ret.setResult("【不支持的sql,非select/insert/update开头】");
                return ret;
            }
        }
    }

    public static SqlExecuteResult query(JdbcTemplate jdbcTemplate, String sql) {
        try {
            Map<String, Object> map = jdbcTemplate.queryForMap(sql);
            if (map == null || map.size() == 0) {
                SqlExecuteResult<String> ret = new SqlExecuteResult<>();
                ret.setSqlExecuted(SqlExecuted.SUCCESS);
                ret.setSqlType(SqlTypeEnum.SELECT);
                ret.setSqlQueryCols(SqlQueryCols.ONE);
                ret.setResult("【查询无结果】");
                return ret;
            } else if (map.size() == 1) {
                SqlExecuteResult<String> ret = new SqlExecuteResult<>();
                ret.setSqlExecuted(SqlExecuted.SUCCESS);
                ret.setSqlType(SqlTypeEnum.SELECT);
                ret.setSqlQueryCols(SqlQueryCols.ONE);
                ret.setResult(map.values().toArray()[0].toString());
                return ret;
            } else {
                SqlExecuteResult<Map<String, Object>> ret = new SqlExecuteResult<>();
                ret.setSqlExecuted(SqlExecuted.SUCCESS);
                ret.setSqlType(SqlTypeEnum.SELECT);
                ret.setSqlQueryCols(SqlQueryCols.MORE);
                ret.setResult(map);
                return ret;
            }
        } catch (Exception e) {
            log.info("查询sql执行异常:", e);
            SqlExecuteResult<String> ret = new SqlExecuteResult<>();
            ret.setSqlExecuted(SqlExecuted.FAIL);
            ret.setSqlType(SqlTypeEnum.SELECT);
            ret.setSqlQueryCols(SqlQueryCols.ONE);
            ret.setResult("【sql执行失败】");
            return ret;
        }
    }

    public static SqlExecuteResult insert(JdbcTemplate jdbcTemplate, String sql) {
        return null;
    }

    public static SqlExecuteResult update(JdbcTemplate jdbcTemplate, String sql) {
        return null;
    }
/*    //查询
    public static String query(JdbcTemplate jdbcTemplate, String querySql) {
        return jdbcTemplate.queryForObject(querySql, java.lang.String.class);
    }*/


    public Map<String, Object> queryForMap(JdbcTemplate jdbctemplate, String querySql) {
        return jdbctemplate.queryForMap(querySql);
    }

/*    public static Integer insert(JdbcTemplate jdbcTemplate, String insertSql) {
        return update(jdbcTemplate, insertSql);
    }

    public static Integer update(JdbcTemplate jdbcTemplate, String updateSql) {
        return jdbcTemplate.update(updateSql);
    }*/
}
