package com.yylc.alcsmng.core.service;

import com.yylc.dwdataservice.core.model.CallRecordModel;
import com.yylc.dwdataservice.core.model.ContactInfoModel;
import com.yylc.dwdataservice.core.order.ContactInfoQueryPageOrder;
import com.yylc.platform.common.page.PageList;

import java.util.List;

/**
 * contact info op service
 * Created by xm on 2017/10/10.
 */
public interface ContactInfoComponent {
    /**
     * 查询还款人有序通讯录
     *
     * @param contactInfoQueryPageOrder
     * @return
     */
    PageList<ContactInfoModel> listContactByDebtorId(ContactInfoQueryPageOrder contactInfoQueryPageOrder);

    /**
     * 每次通话结束保存最新的call result, call_times +1
     *
     * @param contactInfoModel
     * @return
     */
    int updateContactForCallRecord(ContactInfoModel contactInfoModel);
}
