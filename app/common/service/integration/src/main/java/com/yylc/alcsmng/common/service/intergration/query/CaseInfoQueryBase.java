package com.yylc.alcsmng.common.service.intergration.query;

import com.yylc.platform.common.base.QueryBase;

/**
 * Created by xm on 2017/9/29.
 */
public class CaseInfoQueryBase extends QueryBase {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 378123052256069645L;

    private String debtorName;//还款人姓名
    private String debtorIdNo;//还款人身份证
    private String debtorTelNo;//还款人电话
    private String userName;//跟进人员姓名
    private Integer currentStatus;//当前状态
    private Integer currentResult;//标签
    private String createTimeStart;//创建时间范围下限
    private String createTimeEnd;//创建时间范围上限

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public String getDebtorIdNo() {
        return debtorIdNo;
    }

    public void setDebtorIdNo(String debtorIdNo) {
        this.debtorIdNo = debtorIdNo;
    }

    public String getDebtorTelNo() {
        return debtorTelNo;
    }

    public void setDebtorTelNo(String debtorTelNo) {
        this.debtorTelNo = debtorTelNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Integer currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Integer getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(Integer currentResult) {
        this.currentResult = currentResult;
    }

    public String getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
