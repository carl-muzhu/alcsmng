package com.yylc.dwdataservice.core.order;

import com.yylc.platform.common.base.QueryBase;

import java.util.List;

/**
 * Created by yylc-y01909 on 2017/10/17.
 */
public class AssignInfoQueryPageOrder extends QueryBase {
    private static final long serialVersionUID = -2349227068929912785L;

    private int assignType;//�ְ����(0,m0;1,����ط�)
    private List<Integer> userIdList;//�û���ǰ������id �б�

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
