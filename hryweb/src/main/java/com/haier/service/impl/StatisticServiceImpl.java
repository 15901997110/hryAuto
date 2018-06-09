package com.haier.service.impl;

import com.haier.mapper.StatisticMapper;
import com.haier.po.RealtimeStatistic;
import com.haier.po.Tcase;
import com.haier.po.Ti;
import com.haier.po.Tservice;
import com.haier.service.StatisticService;
import com.haier.service.TiService;
import com.haier.service.TserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/9 13:24
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    TserviceService tserviceService;

    @Autowired
    StatisticMapper statisticMapper;

    /**
     * 实时统计服务,接口,用例情况
     *
     * @return
     */
    @Override
    public List<RealtimeStatistic> statisticCurrent() {
        List<RealtimeStatistic> list = new ArrayList<>();

        List<Tservice> tservices = tserviceService.selectByCondition(null);

        for (Tservice tservice : tservices) {
            RealtimeStatistic realtimeStatistic = new RealtimeStatistic();
            realtimeStatistic.setServiceKey(tservice.getServicekey());
            realtimeStatistic.setServiceDesc(tservice.getServicename());
            //统计接口总数
            Integer iTotal = statisticMapper.statisticTiByServiceId(tservice.getId());

            //统计用例总数
            Integer cTotal = statisticMapper.statisticTcaseByServiceId(tservice.getId());

            //统计接口用例覆盖数
            Integer iTotalByCase=statisticMapper.statisticTcaseDistinctIidByServiceId(tservice.getId());

            Integer iTotalNoCase=iTotal-iTotalByCase;

            String iRate=String.format("%.2f", (float) iTotalByCase / iTotal * 100) + "%";

            String cFineness=String.format("%.2f", (float) cTotal / iTotalByCase);

            realtimeStatistic.setITotal(iTotal);
            realtimeStatistic.setCTotal(cTotal);
            realtimeStatistic.setITotalByCase(iTotalByCase);
            realtimeStatistic.setITotalNoCase(iTotalNoCase);
            realtimeStatistic.setIRate(iRate);
            realtimeStatistic.setCFineness(cFineness);
            list.add(realtimeStatistic);
        }
        return list;
    }
}
