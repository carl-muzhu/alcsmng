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
     * 查询用户当日案子到工作台
     *
     * @param userId
     * @return
     */
    List<AssignInfoModel> listCaseForUser(int userId);

    /**
     * 保存分案
     *
     * @param assignInfoModel
     * @return
     */
    int saveAssignInfo(AssignInfoModel assignInfoModel);

    /**
     * 删除老的分案
     *
     * @param caseIdList
     * @return
     */
    int deleteAssignByCaseIdList(List<Integer> caseIdList);

    /**
     * 查询所有assing of mo for admin user
     *
     * @return
     */
    PageList<AssignInfoModel> pageM0ForAdmin(AssignInfoQueryPageOrder assignInfoQueryPageOrder);

    /**
     * 用于主管and 组长查询下属员工分案
     *
     * @param assignInfoQueryPageOrder
     * @return
     */
    PageList<AssignInfoModel> selectForPage(AssignInfoQueryPageOrder assignInfoQueryPageOrder);
}
