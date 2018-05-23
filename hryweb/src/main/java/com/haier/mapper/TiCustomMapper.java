package com.haier.mapper;

import com.github.pagehelper.PageInfo;
import com.haier.po.TiCustom;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/23 14:25
 */
public interface TiCustomMapper {
    PageInfo<TiCustom> selectByCondition(TiCustom tiCustom);
}
