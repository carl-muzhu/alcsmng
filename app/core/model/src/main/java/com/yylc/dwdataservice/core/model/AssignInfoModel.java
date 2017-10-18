package com.yylc.dwdataservice.core.model;

import com.yylc.platform.common.base.ToString;

import java.util.Date;

/**
 * Created by xm on 2017/10/10.
 */
public class AssignInfoModel extends ToString {

    private static final long serialVersionUID = 741231848441822688L;

    //========== properties ==========

    /**
     * This property corresponds to db column <tt>id</tt>.
     */
    private int id;

    /**
     * This property corresponds to db column <tt>case_id</tt>.
     */
    private int caseId;

    /**
     * This property corresponds to db column <tt>user_id</tt>.
     */
    private int userId;

    /**
     * This property corresponds to db column <tt>remark</tt>.
     */
    private String remark;

    /**
     * This property corresponds to db column <tt>create_time</tt>.
     */
    private String createTime;

    /**
     * This property corresponds to db column <tt>assign_type</tt>.
     */
    private int assignType;

    /**
     * This property corresponds to db column <tt>update_time</tt>.
     */
    private String updateTime;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>caseId</tt>.
     *
     * @return property value of caseId
     */
    public int getCaseId() {
        return caseId;
    }

    /**
     * Setter method for property <tt>caseId</tt>.
     *
     * @param caseId value to be assigned to property caseId
     */
    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    /**
     * Getter method for property <tt>assignType</tt>.
     *
     * @return property value of assignType
     */
    public int getAssignType() {
        return assignType;
    }

    /**
     * Setter method for property <tt>assignType</tt>.
     *
     * @param assignType value to be assigned to property assignType
     */
    public void setAssignType(int assignType) {
        this.assignType = assignType;
    }

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
