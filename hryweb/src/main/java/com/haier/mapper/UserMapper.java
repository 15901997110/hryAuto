package com.haier.mapper;

import com.haier.po.User;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/12 14:34
 */
public interface UserMapper {
    User selectByUsername(String username);
}
