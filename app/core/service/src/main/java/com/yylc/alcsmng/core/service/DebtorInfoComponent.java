package com.yylc.alcsmng.core.service;

import com.yylc.dwdataservice.core.model.DebtorInfoModel;

/**
 * Created by yylc-y01909 on 2017/10/17.
 */
public interface DebtorInfoComponent {
    /**
     * ��ѯ��������Ϣ by debtor id
     *
     * @param debtorId
     * @return
     */
    DebtorInfoModel queryByDebtorId(int debtorId);
}
