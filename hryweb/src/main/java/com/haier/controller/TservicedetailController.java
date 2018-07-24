package com.haier.controller;

import com.haier.po.Tservicedetail;
import com.haier.po.TservicedetailCustom;
import com.haier.response.Result;
import com.haier.service.TservicedetailService;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 服务-环境映射关系
 * @Author: luqiwei
 * @Date: 2018/5/30 19:45
 */
@Slf4j
@RestController
@RequestMapping("/tservicedetail")
public class TservicedetailController {

    @Autowired
    TservicedetailService tservicedetailService;

    //增
    @PostMapping("/insertOne")
    public Result insertOne(Tservicedetail tservicedetail) {
        return ResultUtil.success(tservicedetailService.insertOne(tservicedetail));
    }

    //删
    @PostMapping("/deleteOne")
    public Result deleteOne(Integer id) {
        return ResultUtil.success(tservicedetailService.deleteOne(id));
    }

    //改
    @PostMapping("/updateOne")
    public Result updateOne(Tservicedetail tservicedetail) {
        return ResultUtil.success(tservicedetailService.updateOne(tservicedetail));
    }

    //根据id查一条
    @PostMapping("/selectOne")
    public Result selectOne(Integer id) {
        return ResultUtil.success(tservicedetailService.selectOne(id));
    }


    //返回List<TservicedetailCustom>
    @PostMapping("/selectTservicedetailCustomListByCondition")
    public Result selectTservicedetailCustomListByCondition(TservicedetailCustom tservicedetailCustom) {
        return ResultUtil.success(tservicedetailService.selectByCondition(tservicedetailCustom));
    }


    //查-仅查询tservicedetail表数据,返回list
    @PostMapping("/selectTservicedetailListByCondition")
    public Result selectTservicedetailListByCondition(Tservicedetail tservicedetail) {
        return ResultUtil.success(tservicedetailService.selectByCondition(tservicedetail));
    }


    //查-关联表查询,返回包装类,并且携带pageinfo
    @PostMapping("/selectByCondition")
    public Result selectByCondition(TservicedetailCustom tservicedetailCustom, Integer pageNum, Integer pageSize) {
        return ResultUtil.success(tservicedetailService.selectByCondition(tservicedetailCustom, pageNum, pageSize));
    }
}
