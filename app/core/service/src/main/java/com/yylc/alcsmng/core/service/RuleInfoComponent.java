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
     * ��ѯ����by rule location code
     *
     * @return
     */
    List<RuleInfoModel> queryM0ByLocationCode(int ruleTypeCode);

    /**
     * ��ѯrule info
     *
     * @param ruleInfoModel
     * @return
     */
    int saveRuleInfo(RuleInfoModel ruleInfoModel);

    /**
     * ɾ��rule by rule id
     *
     * @param ruleId
     * @return
     */
    int deleteByRuleId(int ruleId);

    /**
     * ��ѯrule by rule id
     *
     * @param ruleId
     * @return
     */
    RuleInfoModel queryRuleByRuleId(int ruleId);

    /**
     * ���ڲ�ѯ�鳤���ڵĹ���
     *
     * @param tUserId
     * @return
     */
    List<RuleInfoModel> queryByTeamLeaderId(String tUserId);

    /**
     * ��������Ա��ҳ��ѯ����
     *
     * @param ruleInfoQueryPageOrder
     * @return
     */
    PageList<RuleInfoModel> pageForAdmin(RuleInfoQueryPageOrder ruleInfoQueryPageOrder);

    /**
     * �������ܷ�ҳ��ѯ����
     *
     * @param ruleInfoQueryPageOrder
     * @return
     */
    PageList<RuleInfoModel> selectForPage(RuleInfoQueryPageOrder ruleInfoQueryPageOrder);
}
