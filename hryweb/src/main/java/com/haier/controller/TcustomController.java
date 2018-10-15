package com.haier.controller;

import com.haier.enums.ClientLevelEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.po.Tcustom;
import com.haier.po.Tcustomdetail;
import com.haier.response.Result;
import com.haier.service.TcustomService;
import com.haier.util.ReflectUtil;
import com.haier.util.ResultUtil;
import com.haier.vo.CustomVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/28 16:05
 */
@Slf4j
@RestController
@RequestMapping("/tcustom")
public class TcustomController {
    @Autowired
    TcustomService tcustomService;

    @PostMapping("/insertOne")
    public Result insertOne(@RequestBody CustomVO customVO) {
        if (customVO == null || customVO.getCustomname() == null || customVO.getUserid() == null || customVO.getEnvid() == null
                || customVO.getTcustomdetails() == null || customVO.getTcustomdetails().size() == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "定制名称,定制环境,定制人,定制明细必填!");
        }
        List<Tcustomdetail> list = customVO.getTcustomdetails();
        for (Tcustomdetail tcustomdetail : list) {
            verifyTcustomdetail(tcustomdetail);
        }
        return ResultUtil.success(tcustomService.insertOne(customVO));
    }

    @PostMapping("/updateOne")
    public Result updateOne(@RequestBody CustomVO customVO) {
        if (customVO == null || customVO.getId() == null || customVO.getTcustomdetails() == null || customVO.getTcustomdetails().size() == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "更新定制时,定制id,定制明细不可为空!");
        }
        List<Tcustomdetail> list = customVO.getTcustomdetails();
        for (Tcustomdetail tcustomdetail : list) {
            verifyTcustomdetail(tcustomdetail);
            tcustomdetail.setCustomid(customVO.getId());
        }
        return ResultUtil.success(tcustomService.updateOne(customVO));
    }

    @PostMapping("/deleteOne")
    public Result deleteOne(@RequestBody Map<String, Integer> map) {
        Integer id = map.get("id");
        if (id == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "删除定制信息时id必填!");
        }
        return ResultUtil.success(tcustomService.deleteOne(id));
    }

    @PostMapping("/selectOne")
    public Result selectOne(@RequestBody Map<String, Integer> map) {
        Integer id = map.get("id");
        return ResultUtil.success(tcustomService.selectOne(id));
    }

    @PostMapping("/selectByCondition")
    public Result selectByCondition(Tcustom tcustom) {
        return ResultUtil.success(tcustomService.selectByCondition(tcustom));
    }

    @PostMapping("/selectTcustomCustomByCondition")
    public Result selectTcustomCustomByCondition(Tcustom tcustom, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        return ResultUtil.success(tcustomService.selectTcustomCustomByCondition(tcustom, pageNum, pageSize));
    }

    @PostMapping("/runByTcustomId")
    public Result runByTcustomId(Integer customId, Integer executeUserId) {
        if (customId == null || customId == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "运行定制测试时,定制测试id必填!");
        }
        return ResultUtil.success(tcustomService.run(customId, executeUserId));
    }

    public void verifyTcustomdetail(Tcustomdetail tcustomdetail) {
        //必填校验
        if (tcustomdetail.getClientlevel() == null || tcustomdetail.getClientid() == null || StringUtils.isBlank(tcustomdetail.getClientname())) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "定制明细中,clientLevel,clientId,clientName必填");
        }
        if (tcustomdetail.getClientlevel().equals(ClientLevelEnum.SERVICE.getLevel()) && StringUtils.isBlank(tcustomdetail.getClassname())) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, tcustomdetail.getClientname() + "服务未指定测试类");
        }
        //当定制明细为接口和用例时,需要校验parentClientId不为0或者null
        if (!tcustomdetail.getClientlevel().equals(ClientLevelEnum.SERVICE.getLevel()) && tcustomdetail.getParentclientid() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "定制明细中,定制接口和用例时parentClientId必填");
        }
        //如果未指定父级ID,则默认0
        if (tcustomdetail.getParentclientid() == null) {
            tcustomdetail.setParentclientid(0);
        }
        //如果没有指定优化级,则默认0(最低)
        if (tcustomdetail.getPriority() == null) {
            tcustomdetail.setPriority(0);
        }
    }
}
