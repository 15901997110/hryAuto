package com.haier.controller;


import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.po.Ti;
import com.haier.po.TiCustom;
import com.haier.response.Result;
import com.haier.service.TiService;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/24 10:26
 */
@Slf4j
@RestController
@RequestMapping("/ti")
public class TiController {
    @Autowired
    TiService tiService;
    //增
    @PostMapping("/insertOne.do")
    public Result insertOne(Ti ti){
        //简单参数校验
        if(ti==null||ti.getServiceid()==null||
                ti.getServiceid()==0||ti.getIuri()==null
                ||"".equals(ti.getIuri())){
            throw new HryException(10086,"入参错误:"+ti.toString());
        }
        return ResultUtil.success(tiService.insertOne(ti));
    }

    /**
     * 查询单个接口信息
     * */
    @PostMapping("/selectOne.do")
    public Result selectOne(Integer id){
        Ti ti=tiService.selectOne(id);
        log.info("查询单个接口id="+id);
        return ResultUtil.success(ti);
    }



    //查所有
    /**
     *@description: 根据条件查询ti表记录,关联查询tservice
     * 支持的查询条件有:ti.iuri(like) , ti.remark(like) , ti.idev(like) ,
     * ti.serviceid(equal) , tservice.servicekey(like) , tservice.servicename
     *@params: [tiCustom, pageNum, pageSize]
     *@return: com.haier.response.Result
     *@author: luqiwei
     *@date: 2018-05-24
     */
    @PostMapping("/selectByCondition.do")
    public Result selectByCondition(TiCustom tiCustom,Integer pageNum,Integer pageSize){
        return ResultUtil.success(tiService.selectByCondition(tiCustom,pageNum,pageSize));
    }

    //改
    @PostMapping("updateOne.do")
    public Result updateOne(Ti ti){
        //参数校验
        if(ti==null||ti.getId()==null){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        //更新数据
        return ResultUtil.success(tiService.updateOne(ti.getId(),ti));
    }


    //删
    /**
     *@description: 根据serviceId删除service记录,并且连带删除tcase表中的记录
     *@params: [id]
     *@return: com.haier.response.Result
     *@author: luqiwei
     *@date: 2018-05-24
     */
    @PostMapping("/deleteOne.do")
    public Result deleteOne(Integer id){
        return ResultUtil.success(tiService.deleteOne(id));
    }
}
