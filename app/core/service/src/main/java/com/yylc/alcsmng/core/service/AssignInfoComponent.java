package com.yylc.alcsmng.core.service;

import com.yylc.alcsmng.common.dal.dataobject.AssignInfoDO;
import com.yylc.dwdataservice.core.model.AssignInfoModel;
import com.yylc.dwdataservice.core.model.CaseInfoModel;
import com.yylc.dwdataservice.core.order.AssignInfoQueryPageOrder;
import com.yylc.platform.common.page.PageList;

import java.util.List;

/**
 * assign info component
 * <p>
 * Created by xm on 2017/10/10.
 */
public interface AssignInfoComponent {
    /**
     * ��ѯ�û����հ��ӵ�����̨
     *
     * @param userId
     * @return
     */
    List<AssignInfoModel> listCaseForUser(int userId);

    /**
     * ����ְ�
     *
     * @param assignInfoModel
     * @return
     */
    int saveAssignInfo(AssignInfoModel assignInfoModel);

    /**
     * ɾ���ϵķְ�
     *
     * @param caseIdList
     * @return
     */
    int deleteAssignByCaseIdList(List<Integer> caseIdList);

    /**
     * ��ѯ����assing of mo for admin user
     *
     * @return
     */
    PageList<AssignInfoModel> pageM0ForAdmin(AssignInfoQueryPageOrder assignInfoQueryPageOrder);

    /**
     * ��������and �鳤��ѯ����Ա���ְ�
     *
     * @param assignInfoQueryPageOrder
     * @return
     */
    PageList<AssignInfoModel> selectForPage(AssignInfoQueryPageOrder assignInfoQueryPageOrder);
}
