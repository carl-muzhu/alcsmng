package com.yylc.dwdataservice.core.model.convert;

import com.yylc.alcsmng.common.dal.dataobject.UserInfoDO;
import com.yylc.dwdataservice.core.model.UserInfoModel;

import java.text.SimpleDateFormat;

/**
 * Created by xm on 2017/9/29.
 */
public class UserInfoConverter {

    /**
     * do convert to model
     *
     * @param userInfoDO
     * @return
     */
    public static UserInfoModel convertDOToModel(UserInfoDO userInfoDO) {
        if (userInfoDO == null) {
            return null;
        }
        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.setUserId(userInfoDO.getUserId());
        userInfoModel.setAccount(userInfoDO.getAccount());
        userInfoModel.setPassword(userInfoDO.getPassword());
        userInfoModel.setUserName(userInfoDO.getUserName());
        userInfoModel.setDeptCode(userInfoDO.getDeptCode());
        userInfoModel.setExtension(userInfoDO.getExtension());
        userInfoModel.setUserType(userInfoDO.getUserType());
        userInfoModel.setLocationCode(userInfoDO.getLocationCode());
        userInfoModel.setRemark(userInfoDO.getRemark());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            userInfoModel.setCreateTime(format.format(userInfoDO.getCreateTime()));
            userInfoModel.setUpdateTime(format.format(userInfoDO.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userInfoModel;
    }

    public static UserInfoDO convertModelToDO(UserInfoModel userInfoModel) {
        if (userInfoModel == null) {
            return null;
        }
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserId(userInfoModel.getUserId());
        userInfoDO.setAccount(userInfoModel.getAccount());
        userInfoDO.setPassword(userInfoModel.getPassword());
        userInfoDO.setUserName(userInfoModel.getUserName());
        userInfoDO.setDeptCode(userInfoModel.getDeptCode());
        userInfoDO.setUserType(userInfoModel.getUserType());
        userInfoDO.setExtension(userInfoModel.getExtension());
        userInfoDO.setLocationCode(userInfoModel.getLocationCode());
        userInfoDO.setRemark(userInfoModel.getRemark());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            userInfoDO.setCreateTime(format.parse(userInfoModel.getCreateTime()));
            userInfoDO.setUpdateTime(format.parse(userInfoModel.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userInfoDO;
    }
}