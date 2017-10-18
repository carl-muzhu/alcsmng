package com.yylc.dwdataservice.core.model;

import com.yylc.platform.common.base.ToString;

import java.util.Date;

/**
 * Created by xm on 2017/9/29.
 */
public class CaseInfoModel extends ToString {

    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

    /**
     * This property corresponds to db column <tt>case_id</tt>.
     */
    private int caseId;

    /**
     * This property corresponds to db column <tt>loan_id</tt>.
     */
    private int loanId;

    /**
     * This property corresponds to db column <tt>debtor_id</tt>.
     */
    private int debtorId;

    /**
     * This property corresponds to db column <tt>item_name</tt>.
     */
    private String itemName;

    /**
     * This property corresponds to db column <tt>loan_amount</tt>.
     */
    private double loanAmount;

    /**
     * This property corresponds to db column <tt>pending_amount</tt>.
     */
    private double pendingAmount;

    /**
     * This property corresponds to db column <tt>repay_amount</tt>.
     */
    private double repayAmount;

    /**
     * This property corresponds to db column <tt>repay_time</tt>.
     */
    private String repayTime;

    /**
     * This property corresponds to db column <tt>days_overdue</tt>.
     */
    private int daysOverdue;

    /**
     * This property corresponds to db column <tt>current_status</tt>.
     */
    private int currentStatus;

    /**
     * This property corresponds to db column <tt>current_result</tt>.
     */
    private String currentResult;

    /**
     * This property corresponds to db column <tt>debtor_name</tt>.
     */
    private String debtorName;

    /**
     * This property corresponds to db column <tt>assign_flag</tt>.
     */
    private int assignFlag;

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
     * Getter method for property <tt>debtorName</tt>.
     *
     * @return property value of debtorName
     */
    public String getDebtorName() {
        return debtorName;
    }

    /**
     * Setter method for property <tt>debtorName</tt>.
     *
     * @param debtorName value to be assigned to property debtorName
     */
    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    /**
     * Getter method for property <tt>loanId</tt>.
     *
     * @return property value of loanId
     */
    public int getLoanId() {
        return loanId;
    }

    /**
     * Setter method for property <tt>loanId</tt>.
     *
     * @param loanId value to be assigned to property loanId
     */
    public void setLoanId(int loanId) {
        this.loanId = loanId;
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
     * Getter method for property <tt>itemName</tt>.
     *
     * @return property value of itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Setter method for property <tt>itemName</tt>.
     *
     * @param itemName value to be assigned to property itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Getter method for property <tt>loanAmount</tt>.
     *
     * @return property value of loanAmount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Setter method for property <tt>loanAmount</tt>.
     *
     * @param loanAmount value to be assigned to property loanAmount
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Getter method for property <tt>pendingAmount</tt>.
     *
     * @return property value of pendingAmount
     */
    public double getPendingAmount() {
        return pendingAmount;
    }

    /**
     * Setter method for property <tt>pendingAmount</tt>.
     *
     * @param pendingAmount value to be assigned to property pendingAmount
     */
    public void setPendingAmount(double pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    /**
     * Getter method for property <tt>repayAmount</tt>.
     *
     * @return property value of repayAmount
     */
    public double getRepayAmount() {
        return repayAmount;
    }

    /**
     * Setter method for property <tt>repayAmount</tt>.
     *
     * @param repayAmount value to be assigned to property repayAmount
     */
    public void setRepayAmount(double repayAmount) {
        this.repayAmount = repayAmount;
    }

    /**
     * Getter method for property <tt>daysOverdue</tt>.
     *
     * @return property value of daysOverdue
     */
    public int getDaysOverdue() {
        return daysOverdue;
    }

    /**
     * Setter method for property <tt>daysOverdue</tt>.
     *
     * @param daysOverdue value to be assigned to property daysOverdue
     */
    public void setDaysOverdue(int daysOverdue) {
        this.daysOverdue = daysOverdue;
    }

    /**
     * Getter method for property <tt>currentStatus</tt>.
     *
     * @return property value of currentStatus
     */
    public int getCurrentStatus() {
        return currentStatus;
    }

    /**
     * Setter method for property <tt>currentStatus</tt>.
     *
     * @param currentStatus value to be assigned to property currentStatus
     */
    public void setCurrentStatus(int currentStatus) {
        this.currentStatus = currentStatus;
    }

    /**
     * Getter method for property <tt>currentResult</tt>.
     *
     * @return property value of currentResult
     */
    public String getCurrentResult() {
        return currentResult;
    }

    /**
     * Setter method for property <tt>currentResult</tt>.
     *
     * @param currentResult value to be assigned to property currentResult
     */
    public void setCurrentResult(String currentResult) {
        this.currentResult = currentResult;
    }

    /**
     * Getter method for property <tt>assignFlag</tt>.
     *
     * @return property value of assignFlag
     */
    public int getAssignFlag() {
        return assignFlag;
    }

    /**
     * Setter method for property <tt>assignFlag</tt>.
     *
     * @param assignFlag value to be assigned to property assignFlag
     */
    public void setAssignFlag(int assignFlag) {
        this.assignFlag = assignFlag;
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

    /**
     * Getter method for property <tt>repayTime</tt>.
     *
     * @return property value of repayTime
     */
    public String getRepayTime() {
        return repayTime;
    }

    /**
     * Setter method for property <tt>repayTime</tt>.
     *
     * @param repayTime value to be assigned to property repayTime
     */
    public void setRepayTime(String repayTime) {
        this.repayTime = repayTime;
    }
}
