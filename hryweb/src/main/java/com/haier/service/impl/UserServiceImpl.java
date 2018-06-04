package com.haier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.RegexEnum;
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
        if(user==null||user.getIdentity()==null||user.getPassword()==null||user.getRealname()==null
                ||"".equals(user.getIdentity().trim())||"".equals(user.getPassword().trim())
                ||"".equals(user.getRealname().trim())){
            throw new HryException(10086,"identity,password,realname必填");
        }
        //用户名校验,只支持邮箱
        if(!user.getIdentity().matches(RegexEnum.EMAIL_REGEX.getRegex())){
            throw new HryException(StatusCodeEnum.REGEX_ERROR);
        }
        //查询是否存在重复用户,将删除的用户激活
        User existUser = userMapper.selectAllByUsername(user.getIdentity().trim());
        if(existUser!=null){
            if(existUser.getStatus()>0){
                throw new HryException(StatusCodeEnum.EXIST_RECORD);
            }
            ReflectUtil.setInvalidFieldToNull(user,false);
            user.setId(existUser.getId());
            user.setStatus((short)1);
            user.setPassword(DigestUtils.md5Hex(user.getPassword().trim()));
            return userMapper.updateByPrimaryKeySelective(user);
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
            ReflectUtil.setInvalidFieldToNull(user,false);
            ReflectUtil.setStringFieldAddPercent(user,false);
        }
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        if(user.getGroupid()!=null){
            criteria.andGroupidEqualTo(user.getGroupid());
        }

        if(user.getId()!=null){
            criteria.andIdEqualTo(user.getId());
        }
        if(user.getIdentity()!=null){
            criteria.andIdentityLike(user.getIdentity());
        }
        if(user.getRealname()!=null){
            criteria.andRealnameLike(user.getRealname());
        }
        if(user.getRemark()!=null){
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
            throw new HryException(StatusCodeEnum.PRIMARYKEY_NULL);
        }
        user.setId(id);
        ReflectUtil.setInvalidFieldToNull(user,false);
        if(user.getIdentity()!=null){
            if(!user.getIdentity().matches(RegexEnum.EMAIL_REGEX.getRegex())){
                throw new HryException(StatusCodeEnum.REGEX_ERROR);
            }
        }
        if(user.getPassword()!=null){
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        }
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer deleteOne(Integer id) {
        User user=new User();
        user.setStatus((short)-1);
        return updateOne(id,user);
    }
}
