package com.haier.service;

import com.haier.po.Tenv;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 9:22
 */
public interface TenvService {
    List<Tenv> selectAll();
    Tenv selectOne(Integer tenvId);
    Integer updateOne(Integer tenvId, Tenv tenv);
    Integer insertOne(Tenv tenv);
}
