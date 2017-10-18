package com.yylc.dwdataservice.core.model;

import com.yylc.platform.common.base.ToString;

/**
 * call record model
 * Created by xm on 2017/10/10.
 */
public class CallRecordModel extends ToString {
    private static final long serialVersionUID = 741251858441822688L;

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
     * This property corresponds to db column <tt>contact_id</tt>.
     */
    private int contactId;

    /**
     * This property corresponds to db column <tt>record</tt>.
     */
    private String record;

    /**
     * This property corresponds to db column <tt>call_result</tt>.
     */
    private String callResult;

    /**
     * This property corresponds to db column <tt>phone_num</tt>.
     */
    private String phoneNum;

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
     * This property corresponds to db column <tt>caller_name</tt>.
     */
    private String callerName;

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
     * Getter method for property <tt>contactId</tt>.
     *
     * @return property value of contactId
     */
    public int getContactId() {
        return contactId;
    }

    /**
     * Setter method for property <tt>contactId</tt>.
     *
     * @param contactId value to be assigned to property contactId
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    /**
     * Getter method for property <tt>record</tt>.
     *
     * @return property value of record
     */
    public String getRecord() {
        return record;
    }

    /**
     * Setter method for property <tt>record</tt>.
     *
     * @param record value to be assigned to property record
     */
    public void setRecord(String record) {
        this.record = record;
    }

    /**
     * Getter method for property <tt>callResult</tt>.
     *
     * @return property value of callResult
     */
    public String getCallResult() {
        return callResult;
    }

    /**
     * Setter method for property <tt>callResult</tt>.
     *
     * @param callResult value to be assigned to property callResult
     */
    public void setCallResult(String callResult) {
        this.callResult = callResult;
    }

    /**
     * Getter method for property <tt>callerName</tt>.
     *
     * @return property value of callerName
     */
    public String getCallerName() {
        return callerName;
    }

    /**
     * Setter method for property <tt>callerName</tt>.
     *
     * @param callerName value to be assigned to property callerName
     */
    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    /**
     * Getter method for property <tt>phoneNum</tt>.
     *
     * @return property value of phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Setter method for property <tt>phoneNum</tt>.
     *
     * @param phoneNum value to be assigned to property phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
