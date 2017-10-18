package com.yylc.dwdataservice.core.model.convert;

import com.yylc.alcsmng.common.dal.dataobject.CaseInfoDO;
import com.yylc.dwdataservice.core.model.CaseInfoModel;

import java.text.SimpleDateFormat;

/**
 * Created by xm on 2017/10/10.
 */
public class CaseInfoConverter {

    /**
     * do convert to model
     *
     * @param caseInfoDO
     * @return
     */
    public static CaseInfoModel convertDOToModel(CaseInfoDO caseInfoDO) {
        if (caseInfoDO == null) {
            return null;
        }
        CaseInfoModel caseInfoModel = new CaseInfoModel();
        caseInfoModel.setCaseId(caseInfoDO.getCaseId());
        caseInfoModel.setLoanId(caseInfoDO.getLoanId());
        caseInfoModel.setDebtorId(caseInfoDO.getDebtorId());
        caseInfoModel.setItemName(caseInfoDO.getItemName());
        caseInfoModel.setLoanAmount(caseInfoDO.getLoanAmount());
        caseInfoModel.setPendingAmount(caseInfoDO.getPendingAmount());
        caseInfoModel.setRepayAmount(caseInfoDO.getRepayAmount());
        caseInfoModel.setCurrentStatus(caseInfoDO.getCurrentStatus());
        caseInfoModel.setCurrentResult(caseInfoDO.getCurrentResult());
        caseInfoModel.setDebtorName(caseInfoDO.getDebtorName());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            caseInfoModel.setCreateTime(format.format(caseInfoDO.getCreateTime()));
            caseInfoModel.setCreateTime(format.format(caseInfoDO.getCreateTime()));
            caseInfoModel.setRepayTime(format.format(caseInfoDO.getRepayTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return caseInfoModel;
    }

    public static CaseInfoDO convertModelToDO(CaseInfoModel caseInfoModel) {
        if (caseInfoModel == null) {
            return null;
        }
        CaseInfoDO caseInfoDO = new CaseInfoDO();
        caseInfoDO.setCaseId(caseInfoModel.getCaseId());
        caseInfoDO.setLoanId(caseInfoModel.getLoanId());
        caseInfoDO.setDebtorId(caseInfoModel.getDebtorId());
        caseInfoDO.setItemName(caseInfoModel.getItemName());
        caseInfoDO.setLoanAmount(caseInfoModel.getLoanAmount());
        caseInfoDO.setPendingAmount(caseInfoModel.getPendingAmount());
        caseInfoDO.setRepayAmount(caseInfoModel.getRepayAmount());
        caseInfoDO.setCurrentStatus(caseInfoModel.getCurrentStatus());
        caseInfoDO.setCurrentResult(caseInfoModel.getCurrentResult());
        caseInfoDO.setDebtorName(caseInfoModel.getDebtorName());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            caseInfoDO.setCreateTime(format.parse(caseInfoModel.getCreateTime()));
            caseInfoDO.setUpdateTime(format.parse(caseInfoModel.getUpdateTime()));
            caseInfoDO.setRepayTime(format.parse(caseInfoModel.getRepayTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return caseInfoDO;
    }
}
