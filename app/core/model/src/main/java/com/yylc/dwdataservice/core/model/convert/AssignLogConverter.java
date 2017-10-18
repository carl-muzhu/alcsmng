package com.yylc.dwdataservice.core.model.convert;

import com.yylc.alcsmng.common.dal.dataobject.AssignLogDO;
import com.yylc.dwdataservice.core.model.AssignLogModel;

import java.text.SimpleDateFormat;

/**
 * Created by yylc-y01909 on 2017/10/16.
 */
public class AssignLogConverter {
    /**
     * do convert to model
     *
     * @param assignLogDO
     * @return
     */
    public static AssignLogModel convertDOToModel(AssignLogDO assignLogDO) {
        if (assignLogDO == null) {
            return null;
        }
        AssignLogModel assignLogModel = new AssignLogModel();
        assignLogModel.setId(assignLogDO.getId());
        assignLogModel.setUserId(assignLogDO.getUserId());
        assignLogModel.setCaseId(assignLogDO.getCaseId());
        assignLogModel.setRemark(assignLogDO.getRemark());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            assignLogModel.setCreateTime(format.format(assignLogDO.getCreateTime()));
            assignLogModel.setUpdateTime(format.format(assignLogDO.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return assignLogModel;
    }

    public static AssignLogDO convertModelToDO(AssignLogModel assignLogModel) {
        if (assignLogModel == null) {
            return null;
        }
        AssignLogDO assignLogDO = new AssignLogDO();
        assignLogDO.setId(assignLogModel.getId());
        assignLogDO.setUserId(assignLogModel.getUserId());
        assignLogDO.setCaseId(assignLogModel.getCaseId());
        assignLogDO.setRemark(assignLogModel.getRemark());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            assignLogDO.setCreateTime(format.parse(assignLogModel.getCreateTime()));
            assignLogDO.setUpdateTime(format.parse(assignLogModel.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return assignLogDO;
    }
}
