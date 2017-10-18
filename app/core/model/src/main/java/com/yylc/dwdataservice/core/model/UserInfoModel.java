package com.yylc.dwdataservice.core.model;

import com.yylc.platform.common.base.ToString;

import java.util.Date;

/**
 * Created by xm on 2017/9/29.
 */
public class UserInfoModel extends ToString {
    private static final long serialVersionUID = 741231858441822681L;

    //========== properties ==========

    /**
     * This property corresponds to db column <tt>user_id</tt>.
     */
    private int userId;

    /**
     * This property corresponds to db column <tt>account</tt>.
     */
    private String account;

    /**
     * This property corresponds to db column <tt>password</tt>.
     */
    private String password;

    /**
     * This property corresponds to db column <tt>user_name</tt>.
     */
    private String userName;

    /**
     * This property corresponds to db column <tt>dept_code</tt>.
     */
    private int deptCode;

    /**
     * This property corresponds to db column <tt>location_code</tt>.
     */
    private int locationCode;

    /**
     * This property corresponds to db column <tt>user_type</tt>.
     */
    private int userType;

    /**
     * This property corresponds to db column <tt>extension</tt>.
     */
    private String extension;

    /**
     * This property corresponds to db column <tt>remark</tt>.
     */
    private String remark;

    /**
     * This property corresponds to db column <tt>create_time</tt>.
     */
    private String createTime;

    /**
     * This property corresponds to db column <tt>update_time</tt>.
     */
    private String updateTime;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>userId</tt>.
     *
     * @return property value of userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Setter method for property <tt>userId</tt>.
     *
     * @param userId value to be assigned to property userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Getter method for property <tt>account</tt>.
     *
     * @return property value of account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Setter method for property <tt>account</tt>.
     *
     * @param account value to be assigned to property account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Getter method for property <tt>password</tt>.
     *
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property <tt>password</tt>.
     *
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     *
     * @param userName value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter method for property <tt>deptCode</tt>.
     *
     * @return property value of deptCode
     */
    public int getDeptCode() {
        return deptCode;
    }

    /**
     * Setter method for property <tt>deptCode</tt>.
     *
     * @param deptCode value to be assigned to property deptCode
     */
    public void setDeptCode(int deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * Getter method for property <tt>locationCode</tt>.
     *
     * @return property value of locationCode
     */
    public int getLocationCode() {
        return locationCode;
    }

    /**
     * Setter method for property <tt>locationCode</tt>.
     *
     * @param locationCode value to be assigned to property locationCode
     */
    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }

    /**
     * Getter method for property <tt>userType</tt>.
     *
     * @return property value of userType
     */
    public int getUserType() {
        return userType;
    }

    /**
     * Setter method for property <tt>userType</tt>.
     *
     * @param userType value to be assigned to property userType
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * Getter method for property <tt>extension</tt>.
     *
     * @return property value of extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Setter method for property <tt>extension</tt>.
     *
     * @param extension value to be assigned to property extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Getter method for property <tt>remark</tt>.
     *
     * @return property value of remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Setter method for property <tt>remark</tt>.
     *
     * @param remark value to be assigned to property remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Getter method for property <tt>createTime</tt>.
     *
     * @return property value of createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Setter method for property <tt>createTime</tt>.
     *
     * @param createTime value to be assigned to property createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter method for property <tt>updateTime</tt>.
     *
     * @return property value of updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * Setter method for property <tt>updateTime</tt>.
     *
     * @param updateTime value to be assigned to property updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
