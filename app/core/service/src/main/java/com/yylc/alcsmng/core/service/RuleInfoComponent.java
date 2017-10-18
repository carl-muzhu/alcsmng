package com.yylc.alcsmng.core.service;

import com.yylc.dwdataservice.core.model.RuleInfoModel;
import com.yylc.dwdataservice.core.order.RuleInfoQueryPageOrder;
import com.yylc.platform.common.page.PageList;

import java.util.List;

/**
 * Created by yylc-y01909 on 2017/10/16.
 */
public interface RuleInfoComponent {
    /**
     * 查询规则by rule location code
     *
     * @return
     */
    List<RuleInfoModel> queryM0ByLocationCode(int ruleTypeCode);

    /**
     * 查询rule info
     *
     * @param ruleInfoModel
     * @return
     */
    int saveRuleInfo(RuleInfoModel ruleInfoModel);

    /**
     * 删除rule by rule id
     *
     * @param ruleId
     * @return
     */
    int deleteByRuleId(int ruleId);

    /**
     * 查询rule by rule id
     *
     * @param ruleId
     * @return
     */
    RuleInfoModel queryRuleByRuleId(int ruleId);

    /**
     * 用于查询组长所在的规则
     *
     * @param tUserId
     * @return
     */
    List<RuleInfoModel> queryByTeamLeaderId(String tUserId);

    /**
     * 超级管理员分页查询规则
     *
     * @param ruleInfoQueryPageOrder
     * @return
     */
    PageList<RuleInfoModel> pageForAdmin(RuleInfoQueryPageOrder ruleInfoQueryPageOrder);

    /**
     * 区域主管分页查询规则
     *
     * @param ruleInfoQueryPageOrder
     * @return
     */
    PageList<RuleInfoModel> selectForPage(RuleInfoQueryPageOrder ruleInfoQueryPageOrder);
}
