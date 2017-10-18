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
     * ��ѯ����������ͨѶ¼
     *
     * @param contactInfoQueryPageOrder
     * @return
     */
    PageList<ContactInfoModel> listContactByDebtorId(ContactInfoQueryPageOrder contactInfoQueryPageOrder);

    /**
     * ÿ��ͨ�������������µ�call result, call_times +1
     *
     * @param contactInfoModel
     * @return
     */
    int updateContactForCallRecord(ContactInfoModel contactInfoModel);
}
