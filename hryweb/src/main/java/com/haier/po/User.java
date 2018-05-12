package com.haier.po;

import lombok.Data;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/12 14:33
 */
@Data
public class User {
    private Integer id;
    private Integer groupid;
    private String identity;
    private String password;
    private String remark;
}
