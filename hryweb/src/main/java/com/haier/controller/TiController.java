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
    public Result insertOne(Ti ti) {
        return ResultUtil.success(tiService.insertOne(ti));
    }

    /**
     * 查询单个接口信息
     */
    @PostMapping("/selectOne.do")
    public Result selectOne(Integer id) {
        return ResultUtil.success(tiService.selectOne(id));
    }


    //查所有

    /**
     * @description: 根据条件查询ti表记录, 关联查询tservice
     * 支持的查询条件有:ti.iuri(like) , ti.remark(like) , ti.idev(like) ,
     * ti.serviceid(equal) , tservice.servicekey(like) , tservice.servicename
     * @params: [tiCustom, pageNum, pageSize]
     * @return: com.haier.response.Result
     * @author: luqiwei
     * @date: 2018-05-24
     */
    @PostMapping("/selectByCondition.do")
    public Result selectByCondition(TiCustom tiCustom, Integer pageNum, Integer pageSize) {
        return ResultUtil.success(tiService.selectByCondition(tiCustom, pageNum, pageSize));
    }

    //改
    @PostMapping("updateOne.do")
    public Result updateOne(Ti ti) {
        return ResultUtil.success(tiService.updateOne(ti.getId(), ti));
    }


    //删

    /**
     * @description: 根据serviceId删除service记录, 并且连带删除tcase表中的记录
     * @params: [id]
     * @return: com.haier.response.Result
     * @author: luqiwei
     * @date: 2018-05-24
     */
    @PostMapping("/deleteOne.do")
    public Result deleteOne(Integer id) {
        return ResultUtil.success(tiService.deleteOne(id));
    }

    /**
     * 根据条件删除ti表中的记录,
     * 注意:
     * 1.现仅支持根据serviceId删除ti表中的记录(直接传serviceId不就可以了吗?为什么要装逼要传Ti?答:主要考虑后期扩展,比如新增某个删除条件)
     * 2.删除ti表时,会连带删除与ti关联的tcase表中的记录,所以需要谨慎
     * @param ti
     * @return
     */
    @PostMapping("/deleteByCondition.do")
    public Result deleteByCondition(Ti ti) {

        return ResultUtil.success(tiService.deleteByCondition(ti));
    }
}
