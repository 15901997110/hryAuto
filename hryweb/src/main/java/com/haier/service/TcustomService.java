package com.haier.service;

import com.haier.po.Tcustom;
import com.haier.po.TcustomCustom;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/28 15:22
 */
public interface TcustomService {
    Integer insertOne(Tcustom tcustom);

    Integer updateOne(Tcustom tcustom);

    Integer deleteOne(Integer id);

    Tcustom selectOne(Integer id);

    List<Tcustom> selectByCondition(Tcustom tcustom);

    List<TcustomCustom> selectTcustomCustomByCondition(Tcustom tcustom);

    void run(Integer customId, Integer executeUserId);
}
