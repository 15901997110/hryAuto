package com.haier.po;

import com.haier.enums.SqlExecuted;
import com.haier.enums.SqlQueryCols;
import com.haier.enums.SqlTypeEnum;
import lombok.Data;

/**
 * @Description: sql执行结果描述
 * @Author: luqiwei
 * @Date: 2018/11/14 16:55
 */
@Data
public class SqlExecuteResult<T> {
    private SqlExecuted sqlExecuted;//sql执行状态,required
    private SqlTypeEnum sqlType;//sql类型,增删改查
    private SqlQueryCols sqlQueryCols;//查询语句结果列数状态:1-仅一列,2-多列
    private T result;//约定,当status==-1时,result类型恒为java.lang.String
}
