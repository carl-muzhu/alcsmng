package com.yylc.dwdataservice.core.order;

import com.yylc.platform.common.base.QueryBase;

import java.util.List;

/**
 * Created by yylc-y01909 on 2017/10/12.
 */
public class CaseInfoQueryPageOrder extends QueryBase {
    private static final long serialVersionUID = -2349227828929712785L;

    List<Integer> caseIdList;//用户当前负责案例id 列表

    public List<Integer> getCaseIdList() {
        return caseIdList;
    }

    public void setCaseIdList(List<Integer> caseIdList) {
        this.caseIdList = caseIdList;
    }
}
