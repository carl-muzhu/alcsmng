package com.yylc.dwdataservice.core.model.convert;

import com.yylc.alcsmng.common.dal.dataobject.CallRecordDO;
import com.yylc.dwdataservice.core.model.CallRecordModel;

import java.text.SimpleDateFormat;

/**
 * converter for call record info
 * Created by xm on 2017/10/10.
 */
public class CallRecordConverter {

    /**
     * do convert to model
     *
     * @param callRecordDO
     * @return
     */
    public static CallRecordModel convertDOToModel(CallRecordDO callRecordDO) {
        if (callRecordDO == null) {
            return null;
        }
        CallRecordModel callRecordModel = new CallRecordModel();

        callRecordModel.setId(callRecordDO.getId());
        callRecordModel.setCaseId(callRecordDO.getCaseId());
        callRecordModel.setContactId(callRecordDO.getContactId());
        callRecordModel.setRecord(callRecordDO.getRecord());
        callRecordModel.setCallResult(callRecordDO.getCallResult());
        callRecordModel.setPhoneNum(callRecordDO.getPhoneNum());
        callRecordModel.setCallerName(callRecordDO.getCallerName());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            callRecordModel.setCreateTime(format.format(callRecordDO.getCreateTime()));
            callRecordModel.setUpdateTime(format.format(callRecordDO.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return callRecordModel;
    }

    public static CallRecordDO convertModelToDO(CallRecordModel callRecordModel) {
        if (callRecordModel == null) {
            return null;
        }
        CallRecordDO callRecordDO = new CallRecordDO();

        callRecordDO.setId(callRecordModel.getId());
        callRecordDO.setCaseId(callRecordModel.getCaseId());
        callRecordDO.setContactId(callRecordModel.getContactId());
        callRecordDO.setRecord(callRecordModel.getRecord());
        callRecordDO.setCallResult(callRecordModel.getCallResult());
        callRecordDO.setPhoneNum(callRecordModel.getPhoneNum());
        callRecordDO.setCallerName(callRecordModel.getCallerName());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            callRecordDO.setCreateTime(format.parse(callRecordModel.getCreateTime()));
            callRecordDO.setUpdateTime(format.parse(callRecordModel.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return callRecordDO;
    }
}
