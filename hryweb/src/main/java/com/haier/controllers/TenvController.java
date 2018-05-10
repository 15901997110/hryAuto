package com.haier.controllers;

import com.haier.po.Tenv;
import com.haier.service.TenvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description: 环境维护
 * @Author: luqiwei
 * @Date: 2018/5/8 20:26
 */
@Controller
@RequestMapping("/tenv")
public class TenvController {
    @Autowired
    TenvService tenvService;

    @RequestMapping(value="/all",method = RequestMethod.POST)
    @ResponseBody
    public List<Tenv> tenvList(){
        return tenvService.selectAll();
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ModelAndView findOne(@PathVariable("id")Integer envId){
        ModelAndView modelAndView=new ModelAndView();

        Tenv tenv = tenvService.selectOne(2);
        modelAndView.addObject("tenv",tenv).setViewName("tenvDetail");
        return modelAndView;
    }
}
