package com.yylc.dwdataservice.core.model;

import com.yylc.platform.common.base.ToString;

/**
 * Created by yylc-y01909 on 2017/10/17.
 */
public class DebtorInfoModel extends ToString {
    private static final long serialVersionUID = 741238858441822681L;

    //========== properties ==========

    /**
     * This property corresponds to db column <tt>debtor_id</tt>.
     */
    private int debtorId;

    /**
     * This property corresponds to db column <tt>name</tt>.
     */
    private String name;

    /**
     * This property corresponds to db column <tt>id_num</tt>.
     */
    private String idNum;

    /**
     * This property corresponds to db column <tt>phone_num</tt>.
     */
    private String phoneNum;

    /**
     * This property corresponds to db column <tt>sex</tt>.
     */
    private String sex;

    /**
     * This property corresponds to db column <tt>age</tt>.
     */
    private int age;

    /**
     * This property corresponds to db column <tt>census</tt>.
     */
    private String census;

    /**
     * This property corresponds to db column <tt>description</tt>.
     */
    private String description;

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
     * Getter method for property <tt>idNum</tt>.
     *
     * @return property value of idNum
     */
    public String getIdNum() {
        return idNum;
    }

    /**
     * Setter method for property <tt>idNum</tt>.
     *
     * @param idNum value to be assigned to property idNum
     */
    public void setIdNum(String idNum) {
        this.idNum = idNum;
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
     * Getter method for property <tt>sex</tt>.
     *
     * @return property value of sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Setter method for property <tt>sex</tt>.
     *
     * @param sex value to be assigned to property sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Getter method for property <tt>age</tt>.
     *
     * @return property value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter method for property <tt>census</tt>.
     *
     * @return property value of census
     */
    public String getCensus() {
        return census;
    }

    /**
     * Setter method for property <tt>census</tt>.
     *
     * @param census value to be assigned to property census
     */
    public void setCensus(String census) {
        this.census = census;
    }

    /**
     * Getter method for property <tt>description</tt>.
     *
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for property <tt>description</tt>.
     *
     * @param description value to be assigned to property description
     */
    public void setDescription(String description) {
        this.description = description;
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
