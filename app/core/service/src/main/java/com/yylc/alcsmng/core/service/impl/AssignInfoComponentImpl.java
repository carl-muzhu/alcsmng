package com.yylc.alcsmng.core.service.impl;

import com.yylc.alcsmng.common.dal.daointerface.AssignInfoDAO;
import com.yylc.alcsmng.common.dal.dataobject.AssignInfoDO;
import com.yylc.alcsmng.common.dal.dataobject.AssignLogDO;
import com.yylc.alcsmng.common.dal.dataobject.CaseInfoDO;
import com.yylc.alcsmng.core.service.AssignInfoComponent;
import com.yylc.dwdataservice.core.model.AssignInfoModel;
import com.yylc.dwdataservice.core.model.CaseInfoModel;
import com.yylc.dwdataservice.core.model.convert.AssignInfoConverter;
import com.yylc.dwdataservice.core.order.AssignInfoQueryPageOrder;
import com.yylc.platform.common.page.Page;
import com.yylc.platform.common.page.PageAttribute;
import com.yylc.platform.common.page.PageList;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xm on 2017/10/10.
 */
@Service("assignInfoComponent")
public class AssignInfoComponentImpl implements AssignInfoComponent {
    private static final Logger logger = Logger.getLogger(AssignInfoComponentImpl.class);

    @Resource
    private AssignInfoDAO assignInfoDAO;

    /**
     * ��ѯ�û����հ��ӵ�����̨
     *
     * @param userId
     * @return
     */
    @Override
    public List<AssignInfoModel> listCaseForUser(int userId) {
        List<AssignInfoModel> assignInfoModelList = new ArrayList<AssignInfoModel>();
        List<AssignInfoDO> assignInfoDOList = assignInfoDAO.queryByUserId(userId);
        if (assignInfoDOList != null && assignInfoDOList.size() > 0) {
            for (AssignInfoDO assignInfoDO : assignInfoDOList) {
                assignInfoModelList.add(AssignInfoConverter.convertDOToModel(assignInfoDO));
            }
        }
        return assignInfoModelList;
    }

    /**
     * ����ְ�
     *
     * @param assignInfoModel
     * @return
     */
    @Override
    public int saveAssignInfo(AssignInfoModel assignInfoModel) {
        return 0;
    }

    /**
     * ɾ���ϵķְ�
     *
     * @param caseIdList
     * @return
     */
    @Override
    public int deleteAssignByCaseIdList(List<Integer> caseIdList) {
        return assignInfoDAO.deleteAssignByCaseIdList(caseIdList);
    }

    /**
     * ��ѯ����assing of mo for admin user
     *
     * @return
     */
    @Override
    public PageList<AssignInfoModel> pageM0ForAdmin(AssignInfoQueryPageOrder assignInfoQueryPageOrder) {
        //��1����������
        int rowCount = assignInfoDAO.countM0ForAdmin();
        Page page = Page.getInstance(new PageAttribute(assignInfoQueryPageOrder.getPageNum(),
                assignInfoQueryPageOrder.getPageSize()), rowCount);
        //��2����ȡ��ҳ����
        List<AssignInfoDO> dolist = assignInfoDAO.pageM0ForAdmin(
                page.offset(), page.getPageSize());

        //��3����װ���ؽ��
        List<AssignInfoModel> modelList = new ArrayList<AssignInfoModel>();
        for (AssignInfoDO obj : dolist) {
            modelList.add(AssignInfoConverter.convertDOToModel(obj));
        }
        return PageList.getInstance(modelList, page);
    }

    /**
     * ��������and �鳤��ѯ����Ա���ְ�
     *
     * @param assignInfoQueryPageOrder
     * @return
     */
    @Override
    public PageList<AssignInfoModel> selectForPage(AssignInfoQueryPageOrder assignInfoQueryPageOrder) {
        //��1����������
        int rowCount = assignInfoDAO.selectForPageCount(assignInfoQueryPageOrder.getUserIdList(), assignInfoQueryPageOrder.getAssignType());
        Page page = Page.getInstance(new PageAttribute(assignInfoQueryPageOrder.getPageNum(),
                assignInfoQueryPageOrder.getPageSize()), rowCount);
        //��2����ȡ��ҳ����
        List<AssignInfoDO> dolist = assignInfoDAO.selectForPage(assignInfoQueryPageOrder.getUserIdList(), assignInfoQueryPageOrder.getAssignType(),
                page.offset(), page.getPageSize());

        //��3����װ���ؽ��
        List<AssignInfoModel> modelList = new ArrayList<AssignInfoModel>();
        for (AssignInfoDO obj : dolist) {
            modelList.add(AssignInfoConverter.convertDOToModel(obj));
        }
        return PageList.getInstance(modelList, page);
    }
}
