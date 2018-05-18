package com.haier.controllers;

import com.haier.po.Tenv;
import com.haier.service.TenvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: 环境维护
 * @Author: luqiwei
 * @Date: 2018/5/8 20:26
 */
@Slf4j
@Controller
@RequestMapping("/tenv")
public class TenvController {
    @Autowired
    TenvService tenvService;

    /**
     * 查询全部环境列表处理
     * */
    @RequestMapping(value="/tenvList",method = RequestMethod.POST)
    @ResponseBody
    public List<Tenv> tenvList(){
        return tenvService.selectAll();
    }

    /**
     * 查询单个环境信息
     * */
    @RequestMapping(value="/tenvOne",method = RequestMethod.POST)
    @ResponseBody
    public Tenv tenvOne(HttpServletRequest request){

        Integer id=Integer.parseInt(request.getParameter("envId"));
        log.info("要查询的环境id="+id);
        Tenv tenv = new Tenv();
        tenv=tenvService.selectOne(id);
        log.info("要查询的环境标识="+tenv.getEnvkey()+"环境描述="+tenv.getRemark());
        return  tenv;
    }

    /**
     * 新增环境处理
     * */
    @RequestMapping(value="/tenvAdd",method = RequestMethod.POST)
    @ResponseBody
    public String  tenvAdd(HttpServletRequest request){
        String envKey = request.getParameter("envKey");
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

    }

    /**
     * 删除环境处理
     * */
    @RequestMapping(value="/tenvDel",method=RequestMethod.POST)
    @ResponseBody
    public String tenvDel(HttpServletRequest request){
        Integer id=Integer.parseInt(request.getParameter("envId"));
        log.info("要删除的环境id="+id);
        try{
            Integer code=tenvService.deleteOne(id);
            return code.toString();
        }catch (Exception e){
            log.error("删除数据异常",e);
            return e.toString();
        }

    }

    /**
     * 编辑环境处理
     * */
    @RequestMapping(value="/tenvEdit",method=RequestMethod.POST)
    @ResponseBody
    public String editTenv(HttpServletRequest request){
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

    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ModelAndView findOne(@PathVariable("id")Integer envId){
        ModelAndView modelAndView=new ModelAndView();

        Tenv tenv = tenvService.selectOne(2);
        modelAndView.addObject("tenv",tenv).setViewName("tenvDetail");
        return modelAndView;
    }


}
