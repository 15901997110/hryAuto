package com.haier.controller;

import com.haier.enums.ClientLevelEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.po.Tcustom;
import com.haier.po.Tcustomdetail;
import com.haier.vo.CustomVO;
import com.haier.response.Result;
import com.haier.service.TcustomService;
import com.haier.util.ReflectUtil;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                || customVO.getTcustomdetails() == null || customVO.getTcustomdetails().size() == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "定制名称,定制环境,定制人,定制明细必填!");
        }
        List<Tcustomdetail> list = customVO.getTcustomdetails();
        for (Tcustomdetail tcustomdetail : list) {
            ReflectUtil.setInvalidFieldToNull(tcustomdetail, false);
            //必填校验
            if (tcustomdetail.getClientlevel() == null || tcustomdetail.getClientid() == null || tcustomdetail.getClientname() == null) {
                throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "定制明细中,clientLevel,clientId,clientName必填");
            }
            if (tcustomdetail.getClientlevel() == ClientLevelEnum.SERVICE.getLevel() && tcustomdetail.getClassname() == null) {
                throw new HryException(StatusCodeEnum.PARAMETER_ERROR, tcustomdetail.getClientname() + "服务未指定测试类");
            }
            //当定制明细为接口和用例时,需要校验parentClientId不为0或者null
            if (tcustomdetail.getClientlevel() != ClientLevelEnum.SERVICE.getLevel() &&
                    (tcustomdetail.getParentclientid() == null || tcustomdetail.getParentclientid() == 0)) {
                throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "定制明细中,定制接口和用例时parentClientId必填");
            }
        }
        return ResultUtil.success(tcustomService.insertOne(customVO));
    }

    @PostMapping("/updateOne")
    public Result updateOne(@RequestBody CustomVO customVO) {
        ReflectUtil.setInvalidFieldToNull(customVO, true);
        if (customVO == null || customVO.getId() == null || customVO.getTcustomdetails() == null || customVO.getTcustomdetails().size() == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "更新定制时,定制id,定制明细不可为空!");
        }
        List<Tcustomdetail> list = customVO.getTcustomdetails();
        for (Tcustomdetail tcustomdetail : list) {
            ReflectUtil.setInvalidFieldToNull(tcustomdetail, false);
            if (tcustomdetail.getClientlevel() == null || tcustomdetail.getClientid() == null || tcustomdetail.getClientname() == null) {
                throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "定制明细中,clientLevel,clientId,clientName必填");
            }
            if (tcustomdetail.getClientlevel() == ClientLevelEnum.SERVICE.getLevel() && tcustomdetail.getClassname() == null) {
                throw new HryException(StatusCodeEnum.PARAMETER_ERROR, tcustomdetail.getClientname() + "服务未指定测试类");
            }
        }
        return ResultUtil.success(tcustomService.updateOne(customVO));
    }

    @PostMapping("/deleteOne")
    public Result deleteOne(@RequestBody Map<String, String> map) {
        Integer id;
        if (map.containsKey("id")) {
            id = Integer.parseInt(map.get("id"));
            if (id == null) {
                throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "删除定制信息时id必填!");
            }
        } else {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        return ResultUtil.success(tcustomService.deleteOne(id));
    }

    @PostMapping("/selectOne")
    public Result selectOne(@RequestBody Map<String, String> map) {
        Integer id;
        if (map.containsKey("id")) {
            id = Integer.parseInt(map.get("id"));
            if (id == null) {
                throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "查询定制信息时id必填!");
            }
        } else {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
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
        if (customId == null || customId == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "运行定制测试时,定制测试id必填!");
        }
        return ResultUtil.success(tcustomService.run(customId, executeUserId));
    }
}
