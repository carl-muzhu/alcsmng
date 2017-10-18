package com.yylc.alcsmng.core.service;

import com.yylc.dwdataservice.core.model.CallRecordModel;
import com.yylc.dwdataservice.core.order.CallResultQueryPageOrder;
import com.yylc.platform.common.page.PageList;

import java.util.List;

/**
 * component for call record op
 * Created by xm on 2017/10/10.
 */
public interface CallRecordComponent {
    /**
     * �鿴������ʷ���ձ��
     *
     * @param callResultQueryPageOrder
     * @return
     */
    PageList<CallRecordModel> listRecordByCaseId(CallResultQueryPageOrder callResultQueryPageOrder);

    /**
     * ������ռ�¼
     *
     * @param callRecordModel
     * @return
     */
    int saveCallRecord(CallRecordModel callRecordModel);
}
