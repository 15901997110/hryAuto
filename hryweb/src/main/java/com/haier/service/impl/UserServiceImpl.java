package com.haier.service.impl;

import com.haier.mapper.UserMapper;
import com.haier.po.User;
import com.haier.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/12 15:27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUser(String username,String password) {
        if(!username.contains("@")){
            username+="@kjtpay.com.cn";//支持只输入邮箱前辍登录
        }
        User finded = userMapper.selectByUsername(username);
        if (finded == null) {
            return null;
        }
        if (finded.getPassword().equals(DigestUtils.md5Hex(password))) {
            return finded;
        } else return null;
    }
}
