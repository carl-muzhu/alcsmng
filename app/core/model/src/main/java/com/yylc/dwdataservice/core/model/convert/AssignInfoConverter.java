package com.yylc.dwdataservice.core.model.convert;

import com.yylc.alcsmng.common.dal.dataobject.AssignInfoDO;
import com.yylc.dwdataservice.core.model.AssignInfoModel;

import java.text.SimpleDateFormat;

/**
 * Created by xm on 2017/10/10.
 */
public class AssignInfoConverter {
    /**
     * do convert to model
     *
     * @param assignInfoDO
     * @return
     */
    public static AssignInfoModel convertDOToModel(AssignInfoDO assignInfoDO) {
        if (assignInfoDO == null) {
            return null;
        }
        AssignInfoModel assignInfoModel = new AssignInfoModel();
        assignInfoModel.setId(assignInfoDO.getId());
        assignInfoModel.setUserId(assignInfoDO.getUserId());
        assignInfoModel.setCaseId(assignInfoDO.getCaseId());
        assignInfoModel.setRemark(assignInfoDO.getRemark());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            assignInfoModel.setCreateTime(format.format(assignInfoDO.getCreateTime()));
            assignInfoModel.setUpdateTime(format.format(assignInfoDO.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return assignInfoModel;
    }

    public static AssignInfoDO convertModelToDO(AssignInfoModel assignInfoModel) {
        if (assignInfoModel == null) {
            return null;
        }
        AssignInfoDO assignInfoDO = new AssignInfoDO();
        assignInfoDO.setId(assignInfoModel.getId());
        assignInfoDO.setUserId(assignInfoModel.getUserId());
        assignInfoDO.setCaseId(assignInfoModel.getCaseId());
        assignInfoDO.setRemark(assignInfoModel.getRemark());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            assignInfoDO.setCreateTime(format.parse(assignInfoModel.getCreateTime()));
            assignInfoDO.setUpdateTime(format.parse(assignInfoModel.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return assignInfoDO;
    }
}
