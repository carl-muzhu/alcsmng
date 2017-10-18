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
     * 查看案例历史催收标记
     *
     * @param callResultQueryPageOrder
     * @return
     */
    PageList<CallRecordModel> listRecordByCaseId(CallResultQueryPageOrder callResultQueryPageOrder);

    /**
     * 保存催收记录
     *
     * @param callRecordModel
     * @return
     */
    int saveCallRecord(CallRecordModel callRecordModel);
}
