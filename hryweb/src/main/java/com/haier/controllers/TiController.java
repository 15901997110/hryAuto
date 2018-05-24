package com.haier.controllers;

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
