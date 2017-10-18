package com.yylc.alcsmng.core.service.impl;

import com.yylc.alcsmng.common.dal.daointerface.DebtorInfoDAO;
import com.yylc.alcsmng.core.service.DebtorInfoComponent;
import com.yylc.dwdataservice.core.model.DebtorInfoModel;
import com.yylc.dwdataservice.core.model.convert.DebtorInfoConverter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yylc-y01909 on 2017/10/17.
 */
@Service("debtorInfoComponent")
public class DebtorInfoComponentImpl implements DebtorInfoComponent {
    private static final Logger logger = Logger.getLogger(DebtorInfoComponentImpl.class);

    @Resource
    private DebtorInfoDAO debtorInfoDAO;

    /**
     * 查询还款人信息 by debtor id
     *
     * @param debtorId
     * @return
     */
    @Override
    public DebtorInfoModel queryByDebtorId(int debtorId) {
        return DebtorInfoConverter.convertDOToModel(debtorInfoDAO.queryByDebtorId(debtorId));
    }
}
