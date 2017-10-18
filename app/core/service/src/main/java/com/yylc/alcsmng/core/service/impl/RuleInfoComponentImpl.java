package com.yylc.alcsmng.core.service.impl;

import com.yylc.alcsmng.common.dal.daointerface.RuleInfoDAO;
import com.yylc.alcsmng.common.dal.dataobject.RuleInfoDO;
import com.yylc.alcsmng.core.service.RuleInfoComponent;
import com.yylc.dwdataservice.core.model.RuleInfoModel;
import com.yylc.dwdataservice.core.model.convert.RuleInfoConverter;
import com.yylc.dwdataservice.core.order.RuleInfoQueryPageOrder;
import com.yylc.platform.common.page.Page;
import com.yylc.platform.common.page.PageAttribute;
import com.yylc.platform.common.page.PageList;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yylc-y01909 on 2017/10/16.
 */
@Service("ruleInfoComponent")
public class RuleInfoComponentImpl implements RuleInfoComponent {
    private static final Logger logger = Logger.getLogger(ContactInfoComponentImpl.class);

    @Resource
    private RuleInfoDAO ruleInfoDAO;

    /**
     * ��ѯrule info
     *
     * @return
     */
    @Override
    public List<RuleInfoModel> queryM0ByLocationCode(int locationCode) {
        List<RuleInfoModel> ruleInfoModelList = new ArrayList<RuleInfoModel>();
        List<RuleInfoDO> ruleInfoDOList = ruleInfoDAO.selectM0ByLocationCode(locationCode);
        if (ruleInfoDOList != null && ruleInfoDOList.size() > 0) {
            for (RuleInfoDO ruleInfoDO : ruleInfoDOList) {
                ruleInfoModelList.add(RuleInfoConverter.convertDOToModel(ruleInfoDO));
            }
        }
        return ruleInfoModelList;
    }

    /**
     * ��ѯm1��������Ա
     *
     * @return
     */
//    @Override
//    public List<RuleInfoModel> queryRuleForM0() {
////        return ruleInfoDAO.q;
//        return null;
//    }

    /**
     * ����rule info
     *
     * @param ruleInfoModel
     * @return
     */
    @Override
    public int saveRuleInfo(RuleInfoModel ruleInfoModel) {
        return ruleInfoDAO.saveRuleInfo(RuleInfoConverter.convertModelToDO(ruleInfoModel));
    }

    /**
     * ɾ��rule by rule id
     *
     * @param ruleId
     * @return
     */
    @Override
    public int deleteByRuleId(int ruleId) {
        return ruleInfoDAO.deleteByRuleId(ruleId);
    }

    /**
     * ��ѯrule by rule id
     *
     * @param ruleId
     * @return
     */
    @Override
    public RuleInfoModel queryRuleByRuleId(int ruleId) {
        return RuleInfoConverter.convertDOToModel(ruleInfoDAO.queryRuleByRuleId(ruleId));
    }

    /**
     * ���ڲ�ѯ�鳤���ڵĹ���
     *
     * @param tUserId
     * @return
     */
    @Override
    public List<RuleInfoModel> queryByTeamLeaderId(String tUserId) {
        List<RuleInfoModel> ruleInfoModelList = new ArrayList<RuleInfoModel>();
        List<RuleInfoDO> ruleInfoDOList = ruleInfoDAO.selectByTeamLeaderId(tUserId);
        for (RuleInfoDO ruleInfoDO : ruleInfoDOList) {
            ruleInfoModelList.add(RuleInfoConverter.convertDOToModel(ruleInfoDO));
        }
        return ruleInfoModelList;
    }

    /**
     * ��������Ա��ҳ��ѯ����
     *
     * @param ruleInfoQueryPageOrder
     * @return
     */
    @Override
    public PageList<RuleInfoModel> pageForAdmin(RuleInfoQueryPageOrder ruleInfoQueryPageOrder) {
        //��1����������
        int rowCount = ruleInfoDAO.pageCountForAdmin();
        Page page = Page.getInstance(new PageAttribute(ruleInfoQueryPageOrder.getPageNum(),
                ruleInfoQueryPageOrder.getPageSize()), rowCount);
        //��2����ȡ��ҳ����
        List<RuleInfoDO> dolist = ruleInfoDAO.pageRuleForAdmin(
                page.offset(), page.getPageSize());

        //��3����װ���ؽ��
        List<RuleInfoModel> modelList = new ArrayList<RuleInfoModel>();
        for (RuleInfoDO obj : dolist) {
            modelList.add(RuleInfoConverter.convertDOToModel(obj));
        }
        return PageList.getInstance(modelList, page);
    }

    /**
     * �������ܷ�ҳ��ѯ����
     *
     * @param ruleInfoQueryPageOrder
     * @return
     */
    @Override
    public PageList<RuleInfoModel> selectForPage(RuleInfoQueryPageOrder ruleInfoQueryPageOrder) {
        //��1����������
        int rowCount = ruleInfoDAO.selectForPageCount(ruleInfoQueryPageOrder.getLocationCode());
        Page page = Page.getInstance(new PageAttribute(ruleInfoQueryPageOrder.getPageNum(),
                ruleInfoQueryPageOrder.getPageSize()), rowCount);
        //��2����ȡ��ҳ����
        List<RuleInfoDO> dolist = ruleInfoDAO.selectForPage(ruleInfoQueryPageOrder.getLocationCode(), ruleInfoQueryPageOrder.getDeptCode(),
                page.offset(), page.getPageSize());

        //��3����װ���ؽ��
        List<RuleInfoModel> modelList = new ArrayList<RuleInfoModel>();
        for (RuleInfoDO obj : dolist) {
            modelList.add(RuleInfoConverter.convertDOToModel(obj));
        }
        return PageList.getInstance(modelList, page);
    }
}
