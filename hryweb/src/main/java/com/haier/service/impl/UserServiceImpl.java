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
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/12 15:27
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
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
            throw new HryException(StatusCodeEnum.REGEX_ERROR_EMAIL);
        }
        //密码校验,密码只能是数字,字母,英文符号,不包括空格
        if(!user.getPassword().matches(RegexEnum.PWD_REGEX.getRegex())) {
            throw new HryException(StatusCodeEnum.REGEX_ERROR_PWD);
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
            ReflectUtil.setFieldAddPercentAndCleanZero(user,false);
        }

        if(pageNum==null||pageSize==null){
            pageNum=1;
            pageSize=10;
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
                throw new HryException(StatusCodeEnum.REGEX_ERROR_EMAIL);
            }
        }
        if(user.getPassword()!=null){
            if(!user.getPassword().matches(RegexEnum.PWD_REGEX.getRegex())){
                throw new HryException(StatusCodeEnum.REGEX_ERROR_PWD);
            }
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

    @Override
    public Integer modifyPwd(String identity, String oldPwd, String newPwd) {
        if(Objects.isNull(identity)||Objects.isNull(oldPwd)||Objects.isNull(newPwd)
                ||"".equals(identity.trim())||"".equals(oldPwd.trim())||"".equals(newPwd.trim())){
            throw new HryException(10086,"identity,oldPwd,newPwd不可为空!");
        }
        if(!newPwd.matches(RegexEnum.PWD_REGEX.getRegex())){
            throw new HryException(StatusCodeEnum.REGEX_ERROR_PWD);
        }
        //根据identity查询status>0的用户名
        User user = userMapper.selectByUsername(identity.trim());
        if(user==null){
            throw new HryException(StatusCodeEnum.NOT_FOUND);
        }

        //用户存在 ,并且旧密码输入正确,则使用新密码更新
        if(user.getPassword().equals(DigestUtils.md5Hex(oldPwd.trim()))){
            user.setPassword(DigestUtils.md5Hex(newPwd.trim()));

            return userMapper.updateByPrimaryKeySelective(user);
        }else{
            throw new HryException(10087,"旧密码不匹配");
        }

    }

    @Override
    public List<User> selectByGroupId(Integer groupId) {
        if(groupId==null||groupId==0){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR,"groupId必填");
        }
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andStatusGreaterThan((short)0);
        criteria.andGroupidEqualTo(groupId.shortValue());
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> selectDever(Integer groupId){
        if(groupId==null||groupId==0){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR,"groupId必填");
        }
        if(groupId.toString().matches(RegexEnum.GROUP_SH_REGEX.getRegex())){//如果当前登录用户为上海组,则返回上海开发组
            return this.selectByGroupId(12);
        }
        if(groupId.toString().matches(RegexEnum.GROUP_HZ_REGEX.getRegex())){//如果当前登录用户为杭州组,则返回杭州开发组
            return this.selectByGroupId(22);
        }
        return userMapper.selectByExample(null);//否则返回全部用户
    }

}
