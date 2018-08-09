package com.haier.controller;

import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.po.Tservicedetail;
import com.haier.po.TservicedetailCustom;
import com.haier.po.TservicedetailExample;
import com.haier.response.Result;
import com.haier.service.TservicedetailService;
import com.haier.util.ReflectUtil;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 服务-环境映射关系
 * @Author: luqiwei
 * @Date: 2018/5/30 19:45
 */
@Slf4j
@RestController
@RequestMapping("/tservicedetail")
public class TservicedetailController {

    @Autowired
    TservicedetailService tservicedetailService;

    //增
    @PostMapping("/insertOne")
    public Result insertOne(Tservicedetail tservicedetail) {
        ReflectUtil.setInvalidFieldToNull(tservicedetail, false);
        if (tservicedetail == null || tservicedetail.getHostinfo() == null || tservicedetail.getServiceid() == null
                || tservicedetail.getEnvid() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "serviceId,envId,hostInfo必填");
        }
        //数据校验
        Tservicedetail condition=new Tservicedetail();
        condition.setServiceid(tservicedetail.getServiceid());
        condition.setEnvid(tservicedetail.getEnvid());
        List<Tservicedetail> tservicedetailList = this.selectList(condition);
        if (tservicedetailList.size() > 0) {
            throw new HryException(StatusCodeEnum.EXIST_RECORD, "tservicedetail表中serviceId=" + tservicedetail.getServiceid() + ",envId=" + tservicedetail.getEnvid() + "的数据已存在");
        }
        //插入数据
        return ResultUtil.success(tservicedetailService.insertOne(tservicedetail));
    }

    //删
    @PostMapping("/deleteOne")
    public Result deleteOne(Integer id) {
        return ResultUtil.success(tservicedetailService.deleteOne(id));
    }

    //改
    @PostMapping("/updateOne")
    public Result updateOne(Tservicedetail tservicedetail) {
        ReflectUtil.setInvalidFieldToNull(tservicedetail, false);
        if (tservicedetail == null || tservicedetail.getId() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        //数据重复性校验
        if (tservicedetail.getServiceid() != null && tservicedetail.getEnvid() != null) {
            Tservicedetail condition=new Tservicedetail();
            condition.setServiceid(tservicedetail.getServiceid());
            condition.setEnvid(tservicedetail.getEnvid());
            List<Tservicedetail> tservicedetailList = this.selectList(condition);
            if (tservicedetailList.size() > 0) {
                for (Tservicedetail t : tservicedetailList) {
                    if (tservicedetail.getServiceid().equals(t.getServiceid()) && tservicedetail.getEnvid().equals(t.getEnvid()) && !tservicedetail.getId().equals(t.getId())) {
                        throw new HryException(StatusCodeEnum.EXIST_RECORD, "请检查serviceKey和envKey");
                    }
                }
            }
        }

        return ResultUtil.success(tservicedetailService.updateOne(tservicedetail));
    }

    //根据id查一条
    @PostMapping("/selectOne")
    public Result selectOne(Integer id) {
        return ResultUtil.success(tservicedetailService.selectOne(id));
    }


    //返回List<TservicedetailCustom>
    @PostMapping("/selectTservicedetailCustomListByCondition")
    public Result selectTservicedetailCustomListByCondition(TservicedetailCustom tservicedetailCustom) {
        return ResultUtil.success(tservicedetailService.selectByCondition(tservicedetailCustom));
    }


    //查-仅查询tservicedetail表数据,返回list,但是使用Result来进行了包装
    @PostMapping("/selectTservicedetailListByCondition")
    public Result selectTservicedetailListByCondition(Tservicedetail tservicedetail) {
        return ResultUtil.success(tservicedetailService.selectByCondition(tservicedetail));
    }

    //返回纯List
    @PostMapping("/selectList")
    public List<Tservicedetail> selectList(Tservicedetail tservicedetail){
        return tservicedetailService.selectByCondition(tservicedetail);
    }

    //查-关联表查询,返回包装类,并且携带pageinfo
    @PostMapping("/selectByCondition")
    public Result selectByCondition(TservicedetailCustom tservicedetailCustom, Integer pageNum, Integer pageSize) {
        return ResultUtil.success(tservicedetailService.selectByCondition(tservicedetailCustom, pageNum, pageSize));
    }
}
