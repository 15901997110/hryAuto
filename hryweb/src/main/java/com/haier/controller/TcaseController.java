package com.haier.controller;

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
        //参数校验,注意,这些参数应该在前端直接js校验效果会更好
        if(tcase==null||tcase.getIid()==null||tcase.getCasename()==null
                ||tcase.getIid()==0||"".equals(tcase.getCasename())){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }

        //插入数据,返回插入的主键
        return ResultUtil.success(tcaseService.insertOne(tcase));
    }

    //删
    @PostMapping("/deleteOne.do")
    public Result deleteOne(Integer tcaseId){
        if(tcaseId==null||tcaseId==0){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        return ResultUtil.success(tcaseService.deleteOne(tcaseId));
    }


    //改
    @PostMapping("/updateOne.do")
    public Result updateOne(Tcase tcase){
        if(tcase==null||tcase.getId()==null||tcase.getId()==0){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }

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
        if(id==null||id==0){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        return ResultUtil.success(tcaseService.selectOne(id));
    }
}
