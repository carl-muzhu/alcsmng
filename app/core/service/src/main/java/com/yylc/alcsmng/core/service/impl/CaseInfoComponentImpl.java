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
     * 分页查询案例信息 for user
     *
     * @param caseInfoQueryPageOrder
     * @return
     */
    @Override
    public PageList<CaseInfoModel> selectForPage(CaseInfoQueryPageOrder caseInfoQueryPageOrder) {
        //【1】计算总数
        int rowCount = caseInfoDAO.selectForPageCount(caseInfoQueryPageOrder.getCaseIdList());
        Page page = Page.getInstance(new PageAttribute(caseInfoQueryPageOrder.getPageNum(),
                caseInfoQueryPageOrder.getPageSize()), rowCount);
        //【2】获取分页数据
        List<CaseInfoDO> dolist = caseInfoDAO.queryByCaseIdList(
                caseInfoQueryPageOrder.getCaseIdList(),
                page.offset(), page.getPageSize());

        //【3】组装返回结果
        List<CaseInfoModel> modelList = new ArrayList<CaseInfoModel>();
        for (CaseInfoDO obj : dolist) {
            modelList.add(CaseInfoConverter.convertDOToModel(obj));
        }
        return PageList.getInstance(modelList, page);
    }

    /**
     * 工作台查看借款详情
     *
     * @param caseId
     * @return
     */
    @Override
    public CaseInfoModel queryCaseByCaseId(int caseId) {
        return CaseInfoConverter.convertDOToModel(caseInfoDAO.queryCaseByCaseId(caseId));
    }

    /**
     * 通话结束标记案子还款跟进结果
     *
     * @param caseInfoModel
     * @return
     */
    @Override
    public int updateCaseForCurrentResult(CaseInfoModel caseInfoModel) {
        return caseInfoDAO.updateCaseForCurrentResult(CaseInfoConverter.convertModelToDO(caseInfoModel));
    }

    /**
     * 查询未结清案例
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
     * 更新逾期天数
     *
     * @param caseInfoModel
     * @return
     */
    @Override
    public int updateCaseForDaysOverdue(CaseInfoModel caseInfoModel) {
        return caseInfoDAO.updateCaseForDaysOverdue(CaseInfoConverter.convertModelToDO(caseInfoModel));
    }

    /**
     * 查询m1未结清案例
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
     * 查询案例 by user id list
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
