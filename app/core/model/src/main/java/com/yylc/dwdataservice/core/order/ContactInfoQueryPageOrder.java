package com.yylc.dwdataservice.core.order;

import com.yylc.platform.common.base.QueryBase;

/**
 * Created by yylc-y01909 on 2017/10/12.
 */
public class ContactInfoQueryPageOrder extends QueryBase {
    private static final long serialVersionUID = -2349227828929912785L;

    private int debtorId;

    public int getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(int debtorId) {
        this.debtorId = debtorId;
    }
}
