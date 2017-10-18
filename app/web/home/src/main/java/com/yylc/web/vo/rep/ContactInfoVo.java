package com.yylc.web.vo.rep;

import com.yylc.platform.common.base.ToString;

/**
 * Created by yylc-y01909 on 2017/10/13.
 */
public class ContactInfoVo extends ToString {
    private static final long serialVersionUID = 4743816321689751115L;

    /**
     * This property corresponds to db column <tt>contact_id</tt>.
     */
    private int contactId;

    /**
     * This property corresponds to db column <tt>debtor_id</tt>.
     */
    private int debtorId;

    /**
     * This property corresponds to db column <tt>phone_num</tt>.
     */
    private String phoneNum;

    /**
     * This property corresponds to db column <tt>name</tt>.
     */
    private String name;

    /**
     * This property corresponds to db column <tt>relation</tt>.
     */
    private String relation;

    /**
     * This property corresponds to db column <tt>call_result</tt>.
     */
    private String callResult;

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
     * Getter method for property <tt>debtorId</tt>.
     *
     * @return property value of debtorId
     */
    public int getDebtorId() {
        return debtorId;
    }

    /**
     * Setter method for property <tt>debtorId</tt>.
     *
     * @param debtorId value to be assigned to property debtorId
     */
    public void setDebtorId(int debtorId) {
        this.debtorId = debtorId;
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
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>relation</tt>.
     *
     * @return property value of relation
     */
    public String getRelation() {
        return relation;
    }

    /**
     * Setter method for property <tt>relation</tt>.
     *
     * @param relation value to be assigned to property relation
     */
    public void setRelation(String relation) {
        this.relation = relation;
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
