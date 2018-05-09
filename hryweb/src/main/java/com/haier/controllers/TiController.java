package com.haier.controllers;

import com.github.pagehelper.Page;
import com.haier.po.Ti;
import com.haier.service.TiService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 17:18
 */
@Slf4j
@Controller
@RequestMapping("/ti")
public class TiController {
    @Autowired
    TiService tiService;
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Ti> selectAll(){
        List<Ti> tis= tiService.selectByCondition(null,1,5);
        Page<Ti> tiPage=(Page<Ti>) tis;
        log.info("getCountColumn:"+tiPage.getCountColumn());
        log.info("count:"+tiPage.count(true));
        log.info("getPageNum:"+tiPage.getPageNum());
        log.info("getPages:"+tiPage.getPages());
        log.info("getPageSize:"+tiPage.getPageSize());
        log.info("getStartRow:"+tiPage.getStartRow());
        log.info("getEndRow:"+tiPage.getEndRow());
        log.info("getCountColumn:"+tiPage.getCountColumn());
        log.info("getTotal:"+tiPage.getTotal());
        return tis;
    }
}
