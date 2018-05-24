package com.haier.mapper;

import com.github.pagehelper.PageInfo;
import com.haier.po.TiCustom;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/23 14:25
 */
public interface TiCustomMapper {
    List<TiCustom> selectByCondition(TiCustom tiCustom);
}
