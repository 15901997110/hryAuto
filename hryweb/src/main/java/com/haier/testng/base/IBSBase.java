package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: IBSBase
 * @Author: 自动生成
 * @Date: 2018/11/12 14:21:00
 */
@SKey("IBS")
public class IBSBase extends Base {
    public IBSBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Uri(value = "/ibsFrontFacade/closeIntelligentInvest", desc = "关闭智能投资")
    public String _ibsFrontFacade_closeIntelligentInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/getUserPermissionInfoOfIntelligent", desc = "获取智能投资的用户权限信息")
    public String _ibsFrontFacade_getUserPermissionInfoOfIntelligent(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/modifyIntelligentInvest", desc = "修改智能投资方案")
    public String _ibsFrontFacade_modifyIntelligentInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/openIntelligentInvest", desc = "开启智能投资")
    public String _ibsFrontFacade_openIntelligentInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/pauseIntelligentInvest", desc = "暂停智能投资")
    public String _ibsFrontFacade_pauseIntelligentInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/queryBlankContract", desc = "获取智能投资签订合同空模板信息")
    public String _ibsFrontFacade_queryBlankContract(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/queryLatestPlanInfo", desc = "查询最新的用户投资方案详情")
    public String _ibsFrontFacade_queryLatestPlanInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/queryPlanStatus", desc = "根据用户Id查询用户智能投资开启状态")
    public String _ibsFrontFacade_queryPlanStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/queryPlatformLimit", desc = "查询平台当前限额")
    public String _ibsFrontFacade_queryPlatformLimit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/querySysRetentionLimit", desc = "查询智投系统配置")
    public String _ibsFrontFacade_querySysRetentionLimit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/queryUserBiddingOrders", desc = "查询用户智能投资记录")
    public String _ibsFrontFacade_queryUserBiddingOrders(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/queryUserInvestStaticAmount", desc = "查询用户投资统计金额")
    public String _ibsFrontFacade_queryUserInvestStaticAmount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsFrontFacade/resetIntelligentInvest", desc = "恢复智能投资")
    public String _ibsFrontFacade_resetIntelligentInvest(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsSystemConfigFacade/querySystemConfig", desc = "查询参数配置-【console使用】")
    public String _ibsSystemConfigFacade_querySystemConfig(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsSystemConfigFacade/querySystemSupportBidType", desc = "查询系统支持标的类型-【console使用】")
    public String _ibsSystemConfigFacade_querySystemSupportBidType(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsSystemConfigFacade/updateSystemConfig", desc = "更新参数配置-【console使用】")
    public String _ibsSystemConfigFacade_updateSystemConfig(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/ibsSystemConfigFacade/updateSystemSupportBidType", desc = "更新标的类型-【console使用】")
    public String _ibsSystemConfigFacade_updateSystemSupportBidType(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/intelligentBiddingPlanDetailFacade/queryIntelligentBiddingPlanDetail", desc = "智投投标方案明细查询-【console使用】")
    public String _intelligentBiddingPlanDetailFacade_queryIntelligentBiddingPlanDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/statisticsFacade/queryAllFastEarnStatistics", desc = "全部用户的快准赚统计")
    public String _statisticsFacade_queryAllFastEarnStatistics(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/statisticsFacade/queryFastEarnStatisticsByUser", desc = "单个用户的快准赚统计")
    public String _statisticsFacade_queryFastEarnStatisticsByUser(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/systemDailyLimitFacade/getSystemDailyLimit", desc = "查询限额-【console使用】")
    public String _systemDailyLimitFacade_getSystemDailyLimit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/systemDailyLimitFacade/updateSystemDailyLimit", desc = "更新限额")
    public String _systemDailyLimitFacade_updateSystemDailyLimit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
