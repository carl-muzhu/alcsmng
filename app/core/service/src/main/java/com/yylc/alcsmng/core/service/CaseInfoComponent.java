package com.yylc.alcsmng.core.service;

import com.yylc.dwdataservice.core.model.CaseInfoModel;
import com.yylc.dwdataservice.core.model.RuleInfoModel;
import com.yylc.dwdataservice.core.order.CaseInfoQueryPageOrder;
import com.yylc.platform.common.page.PageList;

import java.util.List;

/**
 * case info component
 * Created by xm on 2017/10/10.
 */
public interface CaseInfoComponent {
    /**
     * 分页查询案例信息 for user
     *
     * @param caseInfoQueryPageOrder
     * @return
     */
    PageList<CaseInfoModel> selectForPage(CaseInfoQueryPageOrder caseInfoQueryPageOrder);

    /**
     * 工作台查看借款详情
     *
     * @param caseId
     * @return
     */
    CaseInfoModel queryCaseByCaseId(int caseId);

    /**
     * 通话结束标记案子还款跟进结果
     *
     * @param caseInfoModel
     * @return
     */
    int updateCaseForCurrentResult(CaseInfoModel caseInfoModel);

    /**
     * 查询未结清案例
     *
     * @return
     */
    List<CaseInfoModel> queryCaseNotClosed();

    /**
     * 更新逾期天数
     *
     * @param caseInfoModel
     * @return
     */
    int updateCaseForDaysOverdue(CaseInfoModel caseInfoModel);

    /**
     * 查询m1未结清案例
     *
     * @return
     */
    List<CaseInfoModel> queryCaseForM1();

    /**
     * 查询案例 by user id list
     *
     * @param userIdList
     * @return
     */
    List<CaseInfoModel> queryCaseByUserIdList(List<Integer> userIdList);
}
