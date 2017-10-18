package com.yylc.alcsmng.core.service.impl;

import com.yylc.alcsmng.common.dal.daointerface.CaseInfoDAO;
import com.yylc.alcsmng.common.dal.dataobject.CaseInfoDO;
import com.yylc.alcsmng.common.dal.dataobject.RuleInfoDO;
import com.yylc.alcsmng.core.service.CaseInfoComponent;
import com.yylc.dwdataservice.core.model.CaseInfoModel;
import com.yylc.dwdataservice.core.model.RuleInfoModel;
import com.yylc.dwdataservice.core.model.convert.CaseInfoConverter;
import com.yylc.dwdataservice.core.order.CaseInfoQueryPageOrder;
import com.yylc.platform.common.page.Page;
import com.yylc.platform.common.page.PageAttribute;
import com.yylc.platform.common.page.PageList;
import net.sf.dozer.util.mapping.converters.CalendarConverter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xm on 2017/10/10.
 */
@Service("caseInfoComponent")
public class CaseInfoComponentImpl implements CaseInfoComponent {
    private static final Logger logger = Logger.getLogger(CaseInfoComponentImpl.class);

    @Resource
    private CaseInfoDAO caseInfoDAO;

    /**
     * ��ҳ��ѯ������Ϣ for user
     *
     * @param caseInfoQueryPageOrder
     * @return
     */
    @Override
    public PageList<CaseInfoModel> selectForPage(CaseInfoQueryPageOrder caseInfoQueryPageOrder) {
        //��1����������
        int rowCount = caseInfoDAO.selectForPageCount(caseInfoQueryPageOrder.getCaseIdList());
        Page page = Page.getInstance(new PageAttribute(caseInfoQueryPageOrder.getPageNum(),
                caseInfoQueryPageOrder.getPageSize()), rowCount);
        //��2����ȡ��ҳ����
        List<CaseInfoDO> dolist = caseInfoDAO.queryByCaseIdList(
                caseInfoQueryPageOrder.getCaseIdList(),
                page.offset(), page.getPageSize());

        //��3����װ���ؽ��
        List<CaseInfoModel> modelList = new ArrayList<CaseInfoModel>();
        for (CaseInfoDO obj : dolist) {
            modelList.add(CaseInfoConverter.convertDOToModel(obj));
        }
        return PageList.getInstance(modelList, page);
    }

    /**
     * ����̨�鿴�������
     *
     * @param caseId
     * @return
     */
    @Override
    public CaseInfoModel queryCaseByCaseId(int caseId) {
        return CaseInfoConverter.convertDOToModel(caseInfoDAO.queryCaseByCaseId(caseId));
    }

    /**
     * ͨ��������ǰ��ӻ���������
     *
     * @param caseInfoModel
     * @return
     */
    @Override
    public int updateCaseForCurrentResult(CaseInfoModel caseInfoModel) {
        return caseInfoDAO.updateCaseForCurrentResult(CaseInfoConverter.convertModelToDO(caseInfoModel));
    }

    /**
     * ��ѯδ���尸��
     *
     * @return
     */
    @Override
    public List<CaseInfoModel> queryCaseNotClosed() {
        List<CaseInfoModel> caseInfoModelList = new ArrayList<CaseInfoModel>();
        List<CaseInfoDO> caseInfoDOList = caseInfoDAO.queryCaseNotClosed();
        if (caseInfoDOList != null && caseInfoDOList.size() > 0) {
            for (CaseInfoDO caseInfoDO : caseInfoDOList) {
                caseInfoModelList.add(CaseInfoConverter.convertDOToModel(caseInfoDO));
            }
        }
        return caseInfoModelList;
    }

    /**
     * ������������
     *
     * @param caseInfoModel
     * @return
     */
    @Override
    public int updateCaseForDaysOverdue(CaseInfoModel caseInfoModel) {
        return caseInfoDAO.updateCaseForDaysOverdue(CaseInfoConverter.convertModelToDO(caseInfoModel));
    }

    /**
     * ��ѯm1δ���尸��
     *
     * @return
     */
    @Override
    public List<CaseInfoModel> queryCaseForM1() {
        List<CaseInfoModel> caseInfoModelList = new ArrayList<CaseInfoModel>();
        List<CaseInfoDO> caseInfoDOList = caseInfoDAO.queryCaseForM1();
        if (caseInfoDOList != null && caseInfoDOList.size() > 0) {
            for (CaseInfoDO caseInfoDO : caseInfoDOList) {
                caseInfoModelList.add(CaseInfoConverter.convertDOToModel(caseInfoDO));

            }
        }
        return caseInfoModelList;
    }

    /**
     * ��ѯ���� by user id list
     *
     * @param userIdList
     * @return
     */
    @Override
    public List<CaseInfoModel> queryCaseByUserIdList(List<Integer> userIdList) {
        List<CaseInfoDO> caseInfoDOList = caseInfoDAO.queryByUserIdList(userIdList);
        List<CaseInfoModel> caseInfoModelList = new ArrayList<CaseInfoModel>();
        for (CaseInfoDO caseInfoDO : caseInfoDOList) {
            caseInfoModelList.add(CaseInfoConverter.convertDOToModel(caseInfoDO));
        }
        return caseInfoModelList;
    }
}
