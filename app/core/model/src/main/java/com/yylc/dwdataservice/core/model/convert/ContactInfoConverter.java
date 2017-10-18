package com.yylc.dwdataservice.core.model.convert;

import com.yylc.alcsmng.common.dal.dataobject.ContactInfoDO;
import com.yylc.dwdataservice.core.model.ContactInfoModel;

import java.text.SimpleDateFormat;

/**
 * Created by xm on 2017/10/10.
 */
public class ContactInfoConverter {

    /**
     * do convert to model
     *
     * @param contactInfoDO
     * @return
     */
    public static ContactInfoModel convertDOToModel(ContactInfoDO contactInfoDO) {
        if (contactInfoDO == null) {
            return null;
        }
        ContactInfoModel contactInfoModel = new ContactInfoModel();
        contactInfoModel.setContactId(contactInfoDO.getContactId());
        contactInfoModel.setDebtorId(contactInfoDO.getDebtorId());
        contactInfoModel.setPhoneNum(contactInfoDO.getPhoneNum());
        contactInfoModel.setName(contactInfoDO.getName());
        contactInfoModel.setRelation(contactInfoDO.getRelation());
        contactInfoModel.setCallResult(contactInfoDO.getCallResult());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            contactInfoModel.setCreateTime(format.format(contactInfoDO.getCreateTime()));
            contactInfoModel.setUpdateTime(format.format(contactInfoDO.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return contactInfoModel;
    }

    public static ContactInfoDO convertModelToDO(ContactInfoModel contactInfoModel) {
        if (contactInfoModel == null) {
            return null;
        }
        ContactInfoDO contactInfoDO = new ContactInfoDO();
        contactInfoDO.setContactId(contactInfoModel.getContactId());
        contactInfoDO.setDebtorId(contactInfoModel.getDebtorId());
        contactInfoDO.setPhoneNum(contactInfoModel.getPhoneNum());
        contactInfoDO.setName(contactInfoModel.getName());
        contactInfoDO.setRelation(contactInfoModel.getRelation());
        contactInfoDO.setCallResult(contactInfoModel.getCallResult());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            contactInfoDO.setCreateTime(format.parse(contactInfoModel.getCreateTime()));
            contactInfoDO.setUpdateTime(format.parse(contactInfoModel.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return contactInfoDO;
    }
}
