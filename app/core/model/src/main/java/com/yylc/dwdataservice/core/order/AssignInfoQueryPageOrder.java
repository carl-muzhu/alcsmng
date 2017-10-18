package com.yylc.dwdataservice.core.order;

import com.yylc.platform.common.base.QueryBase;

import java.util.List;

/**
 * Created by yylc-y01909 on 2017/10/17.
 */
public class AssignInfoQueryPageOrder extends QueryBase {
    private static final long serialVersionUID = -2349227068929912785L;

    private int assignType;//分案类别(0,m0;1,贷后回访)
    private List<Integer> userIdList;//用户当前负责案例id 列表

    public List<Integer> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Integer> caseIdList) {
        this.userIdList = userIdList;
    }

    public int getAssignType() {
        return assignType;
    }

    public void setAssignType(int assignType) {
        this.assignType = assignType;
    }
}
