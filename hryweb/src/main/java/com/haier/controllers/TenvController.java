package com.haier.controllers;

import com.haier.enums.StatusCodeEnum;
import com.haier.po.Tenv;
import com.haier.response.Result;
import com.haier.service.TenvService;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @Description: 环境维护
 * @Author: luqiwei
 * @Date: 2018/5/8 20:26
 */
@Slf4j
@RestController
@RequestMapping("/tenv")
public class TenvController {
    @Autowired
    TenvService tenvService;

    /**
     * 查询全部环境列表处理
     * */
    @PostMapping(value="/tenvList")
    public Result tenvList(){
        return ResultUtil.success(tenvService.selectAll());
    }

    /**
     * 查询单个环境信息
     * */
    @PostMapping(value="/tenvOne")
    public Result tenvOne(Integer envId){
        Tenv tenv=tenvService.selectOne(envId);
        return ResultUtil.success(tenv);
    }

    /**
     * 新增环境处理
     * */
    @PostMapping(value="/tenvAdd")
    public Result tenvAdd(Tenv tenv){
        return ResultUtil.success(tenvService.insertOne(tenv));
       /* String envKey = request.getParameter("envKey");
        String remark = request.getParameter("remark");
        log.info("环境名称=" + envKey + "，描述=" + remark);

        Tenv tenv = new Tenv();
        tenv.setEnvkey(envKey);
        tenv.setRemark(remark);
        try{
            Integer i=tenvService.insertOne(tenv);
            if(i==1){
                return "1";
            }else{
                return "插入数据失败！";
            }

        }catch (Exception e){
            log.error("插入数据异常",e);
            return e.toString();
        }
        */
    }

    /**
     * 删除环境处理
     * */
    @PostMapping(value="/tenvDel")
    public Result tenvDel(Integer envId){
        return ResultUtil.success(tenvService.deleteOne(envId));
    }
/*    public String tenvDel(HttpServletRequest request){
        Integer id=Integer.parseInt(request.getParameter("envId"));
        log.info("要删除的环境id="+id);
        try{
            Integer code=tenvService.deleteOne(id);
            return code.toString();
        }catch (Exception e){
            log.error("删除数据异常",e);
            return e.toString();
        }

    }*/

    /**
     * 编辑环境处理
     * */
    @PostMapping(value="/tenvEdit")
    public Result tenvEdit(Tenv tenv){
        if(Objects.isNull(tenv.getId())||Objects.isNull(tenv.getEnvkey())){
            return ResultUtil.error(StatusCodeEnum.PARAMETER_ERROR);
        }
        tenvService.updateOne(tenv.getId(),tenv);
        return ResultUtil.success();
    }
    /*public String editTenv(HttpServletRequest request){
        Integer id=Integer.parseInt(request.getParameter("envId").trim());
        String envKey = request.getParameter("envKey");
        String remark = request.getParameter("remark");
        log.info("更新的环境id="+id+"更新的环境名称=" + envKey + "，描述=" + remark);

        Tenv tenv = new Tenv();
        tenv.setEnvkey(envKey);
        tenv.setRemark(remark);

        try{
            Integer i=tenvService.updateOne(id,tenv);
            if(i==1){
                return "1";
            }else{
                return "修改数据失败！";
            }

        }catch (Exception e){
            log.error("修改数据异常",e);
            return e.toString();
        }

    }*/

}
