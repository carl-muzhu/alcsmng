package com.yylc.dwdataservice.core.order;

import com.yylc.platform.common.base.QueryBase;

/**
 * Created by yylc-y01909 on 2017/10/17.
 */
public class RuleInfoQueryPageOrder extends QueryBase {
    private static final long serialVersionUID = -2349227968929912785L;

    private int deptCode;//部门代码(0,M0,1,贷后回访)
    private int locationCode;//位置代码

    public int getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(int deptCode) {
        this.deptCode = deptCode;
    }

    public int getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }
}
