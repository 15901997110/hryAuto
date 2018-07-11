package com.haier.controller;

import com.haier.po.Tcustom;
import com.haier.response.Result;
import com.haier.service.TcustomService;
import com.haier.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/28 16:05
 */
@RestController
@RequestMapping("/tcustom")
public class TcustomController {
    @Autowired
    TcustomService tcustomService;

    @PostMapping("/insertOne")
    public Result insertOne(Tcustom tcustom) {
        return ResultUtil.success(tcustomService.insertOne(tcustom));
    }

    @PostMapping("/updateOne")
    public Result updateOne(Tcustom tcustom) {
        return ResultUtil.success(tcustomService.updateOne(tcustom));
    }

    @PostMapping("/deleteOne")
    public Result deleteOne(Integer id) {
        return ResultUtil.success(tcustomService.deleteOne(id));
    }

    @PostMapping("/selectOne")
    public Result selectOne(Integer id) {
        return ResultUtil.success(tcustomService.selectOne(id));
    }

    @PostMapping("/selectByCondition")
    public Result selectByCondition(Tcustom tcustom) {
        return ResultUtil.success(tcustomService.selectByCondition(tcustom));
    }

    @PostMapping("/selectTcustomCustomByCondition")
    public Result selectTcustomCustomByCondition(Tcustom tcustom){
        return ResultUtil.success(tcustomService.selectTcustomCustomByCondition(tcustom));
    }

    @PostMapping("/runByTcustomId")
    public Result runByTcustomId(Integer customId,Integer executeUserId){
        tcustomService.run(customId,executeUserId);
        return ResultUtil.success();
    }
}
