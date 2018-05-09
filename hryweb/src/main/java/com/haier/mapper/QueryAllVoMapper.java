package com.haier.mapper;

import com.haier.po.QueryAllVo;

import java.util.List;

public interface QueryAllVoMapper {
    List<QueryAllVo> queryAllVoListByCondition(QueryAllVo vo);
}
