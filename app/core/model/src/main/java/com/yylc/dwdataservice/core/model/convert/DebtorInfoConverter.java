package com.yylc.dwdataservice.core.model.convert;

import com.yylc.alcsmng.common.dal.dataobject.DebtorInfoDO;
import com.yylc.dwdataservice.core.model.DebtorInfoModel;

import java.text.SimpleDateFormat;

/**
 * Created by yylc-y01909 on 2017/10/17.
 */
public class DebtorInfoConverter {

    /**
     * do convert to model
     *
     * @param debtorInfoDO
     * @return
     */
    public static DebtorInfoModel convertDOToModel(DebtorInfoDO debtorInfoDO) {
        if (debtorInfoDO == null) {
            return null;
        }
        DebtorInfoModel debtorInfoModel = new DebtorInfoModel();
        debtorInfoModel.setDebtorId(debtorInfoDO.getDebtorId());
        debtorInfoModel.setName(debtorInfoDO.getName());
        debtorInfoModel.setIdNum(debtorInfoDO.getIdNum());
        debtorInfoModel.setPhoneNum(debtorInfoDO.getPhoneNum());
        debtorInfoModel.setSex(debtorInfoDO.getSex());
        debtorInfoModel.setAge(debtorInfoDO.getAge());
        debtorInfoModel.setCensus(debtorInfoDO.getCensus());
        debtorInfoModel.setDescription(debtorInfoDO.getDescription());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            debtorInfoModel.setCreateTime(format.format(debtorInfoDO.getCreateTime()));
            debtorInfoModel.setUpdateTime(format.format(debtorInfoDO.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return debtorInfoModel;
    }

    public static DebtorInfoDO convertModelToDO(DebtorInfoModel debtorInfoModel) {
        if (debtorInfoModel == null) {
            return null;
        }
        DebtorInfoDO debtorInfoDO = new DebtorInfoDO();
        debtorInfoDO.setDebtorId(debtorInfoModel.getDebtorId());
        debtorInfoDO.setName(debtorInfoModel.getName());
        debtorInfoDO.setIdNum(debtorInfoModel.getIdNum());
        debtorInfoDO.setPhoneNum(debtorInfoModel.getPhoneNum());
        debtorInfoDO.setSex(debtorInfoModel.getSex());
        debtorInfoDO.setAge(debtorInfoModel.getAge());
        debtorInfoDO.setCensus(debtorInfoModel.getCensus());
        debtorInfoDO.setDescription(debtorInfoModel.getDescription());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            debtorInfoDO.setCreateTime(format.parse(debtorInfoModel.getCreateTime()));
            debtorInfoDO.setUpdateTime(format.parse(debtorInfoModel.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return debtorInfoDO;
    }
}
