package com.haier.service;

import com.haier.po.User;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/12 15:26
 */
public interface UserService {
    //如果用户名和密码存在并匹配,返回User,否则返回null
    User findUser(String username,String password);
}
