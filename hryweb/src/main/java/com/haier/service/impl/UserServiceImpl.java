package com.haier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.UserMapper;
import com.haier.po.User;
import com.haier.po.UserExample;
import com.haier.service.UserService;
import com.haier.util.ReflectUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Integer insertOne(User user) {
        //参数校验
        if(user==null||user.getIdentity()==null||user.getPassword()==null
                ||"".equals(user.getIdentity().trim())||"".equals(user.getPassword().trim())){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        //查询是否存在重复用户
        User existUser = userMapper.selectByUsername(user.getIdentity().trim());
        if(existUser!=null){
            throw new HryException(StatusCodeEnum.EXIST_RECORD);
        }

        user.setIdentity(user.getIdentity().trim());//用户名去前后空格
        user.setPassword(DigestUtils.md5Hex(user.getPassword().trim()));//密码md5加密
        return userMapper.insertSelective(user);
    }

    @Override
    public User findUser(String username,String password) {
        if(username==null||password==null||"".equals(username.trim())||"".equals(password.trim())){
            return null;
        }else {
            username=username.trim();
        }

        if(!username.contains("@")){
            username+="@kjtpay.com.cn";//支持只输入邮箱前辍登录
        }
        User finded = userMapper.selectByUsername(username);
        if (finded != null) {
            if (finded.getPassword().equals(DigestUtils.md5Hex(password))) {
                return finded;
            }
        }
        return null;
    }

    @Override
    public User selectOne(Integer id) {
        if(id==null||id==0){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<User> selectByCondition(User user,Integer pageNum,Integer pageSize) {
        if(user!=null){
            ReflectUtil.setStringFields(user,false);
        }
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(user.getId()!=null){
            criteria.andIdEqualTo(user.getId());
        }
        if(user.getIdentity()!=null&&"".equals(user.getIdentity())){
            criteria.andIdentityLike(user.getIdentity());
        }
        if(user.getRealname()!=null&&"".equals(user.getRealname())){
            criteria.andRealnameLike(user.getRealname());
        }
        if(user.getRemark()!=null&&"".equals(user.getRemark())){
            criteria.andRemarkLike(user.getRemark());
        }
        criteria.andStatusGreaterThan((short)0);
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.selectByExample(userExample);
        PageInfo<User> pageInfo=new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public Integer updateOne(Integer id, User user) {
        if(id==null||id==0){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        user.setId(id);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer deleteOne(Integer id) {
        User user=new User();
        user.setStatus((short)-1);
        return updateOne(id,user);
    }
}
