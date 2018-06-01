package com.haier.service;

import com.github.pagehelper.PageInfo;
import com.haier.po.User;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/12 15:26
 */
public interface UserService {

    Integer insertOne(User user);
    //如果用户名和密码存在并匹配,返回User,否则返回null
    User findUser(String username,String password);
    //根据id查找用户
    User selectOne(Integer id);
    //综合条件查询用户
    PageInfo<User> selectByCondition(User user,Integer pageNum,Integer pageSize);
    //根据主键更新用户
    Integer updateOne(Integer id,User user);
    //删除用户(逻辑删除)
    Integer deleteOne(Integer id);
}
