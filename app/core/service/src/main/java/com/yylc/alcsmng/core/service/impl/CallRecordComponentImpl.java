package com.yylc.alcsmng.core.service.impl;

import com.yylc.alcsmng.common.dal.daointerface.CallRecordDAO;
import com.yylc.alcsmng.common.dal.dataobject.CallRecordDO;
import com.yylc.alcsmng.core.service.CallRecordComponent;
import com.yylc.dwdataservice.core.model.CallRecordModel;
import com.yylc.dwdataservice.core.model.convert.CallRecordConverter;
import com.yylc.dwdataservice.core.order.CallResultQueryPageOrder;
import com.yylc.platform.common.page.Page;
import com.yylc.platform.common.page.PageAttribute;
import com.yylc.platform.common.page.PageList;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * component for call rec op
 * Created by xm on 2017/10/10.
 */
@Service("callRecordComponent")
public class CallRecordComponentImpl implements CallRecordComponent {
    private static final Logger logger = Logger.getLogger(CallRecordComponentImpl.class);

    @Resource
    private CallRecordDAO callRecordDAO;

    /**
     * 查看案例历史催收标记
     *
     * @param callResultQueryPageOrder
     * @return
     */
    @Override
    public PageList<CallRecordModel> listRecordByCaseId(CallResultQueryPageOrder callResultQueryPageOrder) {
        //【1】计算总数
        int rowCount = callRecordDAO.selectForPageCount(callResultQueryPageOrder.getCaseId());
        Page page = Page.getInstance(new PageAttribute(callResultQueryPageOrder.getPageNum(),
                callResultQueryPageOrder.getPageSize()), rowCount);
        //【2】获取分页数据
        List<CallRecordDO> dolist = callRecordDAO.listRecordByCaseId(
                callResultQueryPageOrder.getCaseId(),
                page.offset(), page.getPageSize());
        //【3】组装返回结果
        List<CallRecordModel> modelList = new ArrayList<CallRecordModel>();
        for (CallRecordDO obj : dolist) {
            modelList.add(CallRecordConverter.convertDOToModel(obj));
        }
        return PageList.getInstance(modelList, page);
    }

    /**
     * 保存催收记录
     *
     * @param callRecordModel
     * @return
     */
    @Override
    public int saveCallRecord(CallRecordModel callRecordModel) {
        return callRecordDAO.saveCallRecord(CallRecordConverter.convertModelToDO(callRecordModel));
    }
}
