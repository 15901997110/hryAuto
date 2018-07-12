package com.haier.controller;

import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.po.Tcustom;
import com.haier.po.Tcustomdetail;
import com.haier.request.CustomVO;
import com.haier.response.Result;
import com.haier.service.TcustomService;
import com.haier.util.ReflectUtil;
import com.haier.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

/*    @PostMapping("/insertOne")
    public Result insertOne(Tcustom tcustom, List<Tcustomdetail> list) {
        ReflectUtil.setInvalidFieldToNull(tcustom, false);
        if (tcustom == null || tcustom.getUserid() == null || tcustom.getCustomname() == null ||
                tcustom.getEnvid() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "tcustom对象中userid,customname,envid必填");
        }
        if (list == null || list.size() == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "Tcustomdetail必填");
        }
        for (Tcustomdetail tcustomdetail : list) {
            ReflectUtil.setInvalidFieldToNull(tcustomdetail, false);
            if (tcustomdetail.getClientlevel() == null || tcustomdetail.getClientid() == null || tcustomdetail.getClientname() == null) {
                throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "定制详情中,clientLevle,clientId,clientName必填");
            }
        }
        return ResultUtil.success(tcustomService.insertOne(tcustom, list));
    }*/

    @PostMapping("/insertOne")
    public Result insertOne(@RequestBody CustomVO customVO) {
        ReflectUtil.setInvalidFieldToNull(customVO, true);
        if (customVO == null || customVO.getCustomname() == null || customVO.getUserid() == null || customVO.getEnvid() == null
                || customVO.getList() == null || customVO.getList().size() == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "定制名称,定制环境,定制人,定制明细必填!");
        }
        List<Tcustomdetail> list=customVO.getList();
        for(Tcustomdetail tcustomdetail:list ){
            ReflectUtil.setInvalidFieldToNull(tcustomdetail, false);
            if (tcustomdetail.getClientlevel() == null || tcustomdetail.getClientid() == null || tcustomdetail.getClientname() == null) {
                throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "定制明细中,clientLevle,clientId,clientName必填");
            }
        }
        return ResultUtil.success(tcustomService.insertOne(customVO));
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
    public Result selectTcustomCustomByCondition(Tcustom tcustom) {
        return ResultUtil.success(tcustomService.selectTcustomCustomByCondition(tcustom));
    }

    @PostMapping("/runByTcustomId")
    public Result runByTcustomId(Integer customId, Integer executeUserId) {
        tcustomService.run(customId, executeUserId);
        return ResultUtil.success();
    }
}
