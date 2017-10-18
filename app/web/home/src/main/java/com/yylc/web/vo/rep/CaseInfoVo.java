package com.yylc.web.vo.rep;

import com.yylc.platform.common.base.ToString;

/**
 * Created by yylc-y01909 on 2017/10/12.
 */
public class CaseInfoVo extends ToString {
    private static final long serialVersionUID = 2743816321689751115L;

    private int caseId;//����id
    private int loanId;//�����
    private int debtorId;//������id
    private String debtorName;//����������
    private String idNo;//���������֤����
    private String phoneNum;//�����˵绰
    private String operatorName;//������Ա����
    private String itemName;//��Ŀ����
    private double loanAmount;//����ܶ�
    private double pendingAmount;//���軹����
    private double repayAmount;//������
    private int daysOverdue;//��������
    private int currentStatus;//��ǰ״̬ 0 δ���䣬 1 �����У� 2 �ѽ���
    private String currentResult;//��ǰ���ս�� (��ŵ����,�ܾ�����)
    private String createTime;
    private String updateTime;

    public int getCaseId() {
        return caseId;
    }


    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }


    public int getLoanId() {
        return loanId;
    }


    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }


    public int getDebtorId() {
        return debtorId;
    }


    public void setDebtorId(int debtorId) {
        this.debtorId = debtorId;
    }


    public String getItemName() {
        return itemName;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public double getLoanAmount() {
        return loanAmount;
    }


    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(double pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public double getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(double repayAmount) {
        this.repayAmount = repayAmount;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }

    public void setDaysOverdue(int daysOverdue) {
        this.daysOverdue = daysOverdue;
    }

    public int getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(int currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(String currentResult) {
        this.currentResult = currentResult;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
