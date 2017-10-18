package com.yylc.dwdataservice.core.order;

import com.yylc.platform.common.base.QueryBase;

/**
 * Created by yylc-y01909 on 2017/10/12.
 */
public class CallResultQueryPageOrder extends QueryBase {
    private static final long serialVersionUID = -2359227828929912785L;

    private int caseId;

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }
}
