package com.haier.mapper;

import com.haier.po.Tenvdetail;
import com.haier.po.TenvdetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TenvdetailMapper {
    long countByExample(TenvdetailExample example);

    int deleteByExample(TenvdetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tenvdetail record);

    int insertSelective(Tenvdetail record);

    List<Tenvdetail> selectByExample(TenvdetailExample example);

    Tenvdetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tenvdetail record, @Param("example") TenvdetailExample example);

    int updateByExample(@Param("record") Tenvdetail record, @Param("example") TenvdetailExample example);

    int updateByPrimaryKeySelective(Tenvdetail record);

    int updateByPrimaryKey(Tenvdetail record);
}