package com.haier.controller;

import com.github.pagehelper.PageInfo;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.po.Treport;
import com.haier.response.Result;
import com.haier.service.TreportService;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/7/5 13:14
 */
@RestController
@Slf4j
@RequestMapping("/report")
public class TreportController {
    @Autowired
    TreportService treportService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @PostMapping("/deleteOne")
    public Result deleteOne(@RequestParam("id") Integer id) {
        if (null == id || 0 == id) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        return ResultUtil.success(treportService.deleteOne(id));
    }

    @PostMapping("/getStatus")
    public Result getStatus(@RequestParam("reportname") String reportname) {
        return ResultUtil.success(treportService.getStatus(reportname));
    }

    @PostMapping("/selectByCondition")
    public Result selectByCondition(Treport treport, Date startTime, Date endTime, Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        if (endTime != null) {
            endTime = DateUtils.addDays(endTime, 1);//如果前端传的结束时间为2018-10-01,那将转成2018-10-02,查询时使用<2018-10-02
        }
        PageInfo<Treport> pageInfo = treportService.selectByCondition(treport, startTime, endTime, pageNum, pageSize);
        return ResultUtil.success(pageInfo);
    }
}
