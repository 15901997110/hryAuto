package com.haier.service;

import com.haier.po.Tcustom;
import com.haier.po.TcustomCustom;
import com.haier.po.Tcustomdetail;
import com.haier.vo.CustomVO;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/28 15:22
 */
public interface TcustomService {

    /**
     * 插入Tcustom时,要求传入Tcustomdetail信息一起插入,不允许单独插入tcustom
     *
     * @param tcustom
     * @param tcustomdetails
     * @return
     */
    Integer insertOne(Tcustom tcustom, List<Tcustomdetail> tcustomdetails);

    Integer insertOne(CustomVO customVO);

    Integer updateOne(Tcustom tcustom);

    Integer updateOne(CustomVO customVO);

    Integer deleteOne(Integer id);

    CustomVO selectOne(Integer id);

    List<Tcustom> selectByCondition(Tcustom tcustom);

    List<TcustomCustom> selectTcustomCustomByCondition(Tcustom tcustom);

    String run(Integer customId, Integer executeUserId);


}
