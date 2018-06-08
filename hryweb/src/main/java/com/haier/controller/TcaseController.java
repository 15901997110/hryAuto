package com.haier.controller;

import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.po.Tcase;
import com.haier.po.TcaseCustom;
import com.haier.response.Result;
import com.haier.service.TcaseService;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/30 15:05
 */
@Slf4j
@RestController
@RequestMapping("/tcase")
public class TcaseController {

    @Autowired
    TcaseService tcaseService;


    //增
    @PostMapping("/insertOne.do")
    public Result insertOne(Tcase tcase){
        return ResultUtil.success(tcaseService.insertOne(tcase));
    }

    //删
    @PostMapping("/deleteOne.do")
    public Result deleteOne(Integer id){
        return ResultUtil.success(tcaseService.deleteOne(id));
    }


    //改
    @PostMapping("/updateOne.do")
    public Result updateOne(Tcase tcase){
        return ResultUtil.success(tcaseService.updateOne(tcase.getId(),tcase));
    }

    //查-综合查询
    @PostMapping("/selectByCondition.do")
    public Result selectByCondition(TcaseCustom tcaseCustom,Integer pageNum,Integer pageSize){
        return ResultUtil.success(tcaseService.selectByContion(tcaseCustom,pageNum,pageSize));
    }

    //查-主键查询
    @PostMapping("/selectOne.do")
    public Result selectOne(Integer id){
        return ResultUtil.success(tcaseService.selectOne(id));
    }

    //运行单条case,如果不指定运行环境,系统将从服务环境映射表中寻找相应环境
    @PostMapping("/runCaseOne.do")
    public Result runCaseOne(Tcase tcase) throws HttpProcessException {
        return ResultUtil.success(tcaseService.runOne(tcase));
    }
}
