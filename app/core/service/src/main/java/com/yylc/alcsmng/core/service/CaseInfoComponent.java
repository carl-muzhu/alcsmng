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
     * ��ҳ��ѯ������Ϣ for user
     *
     * @param caseInfoQueryPageOrder
     * @return
     */
    PageList<CaseInfoModel> selectForPage(CaseInfoQueryPageOrder caseInfoQueryPageOrder);

    /**
     * ����̨�鿴�������
     *
     * @param caseId
     * @return
     */
    CaseInfoModel queryCaseByCaseId(int caseId);

    /**
     * ͨ��������ǰ��ӻ���������
     *
     * @param caseInfoModel
     * @return
     */
    int updateCaseForCurrentResult(CaseInfoModel caseInfoModel);

    /**
     * ��ѯδ���尸��
     *
     * @return
     */
    List<CaseInfoModel> queryCaseNotClosed();

    /**
     * ������������
     *
     * @param caseInfoModel
     * @return
     */
    int updateCaseForDaysOverdue(CaseInfoModel caseInfoModel);

    /**
     * ��ѯm1δ���尸��
     *
     * @return
     */
    List<CaseInfoModel> queryCaseForM1();

    /**
     * ��ѯ���� by user id list
     *
     * @param userIdList
     * @return
     */
    List<CaseInfoModel> queryCaseByUserIdList(List<Integer> userIdList);
}
