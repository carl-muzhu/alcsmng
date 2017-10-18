package com.yylc.alcsmng.core.service.impl;

import com.yylc.alcsmng.common.dal.daointerface.ContactInfoDAO;
import com.yylc.alcsmng.common.dal.dataobject.ContactInfoDO;
import com.yylc.alcsmng.core.service.ContactInfoComponent;
import com.yylc.dwdataservice.core.model.ContactInfoModel;
import com.yylc.dwdataservice.core.model.convert.ContactInfoConverter;
import com.yylc.dwdataservice.core.order.ContactInfoQueryPageOrder;
import com.yylc.platform.common.page.Page;
import com.yylc.platform.common.page.PageAttribute;
import com.yylc.platform.common.page.PageList;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xm on 2017/10/10.
 */
@Service("contactInfoComponent")
public class ContactInfoComponentImpl implements ContactInfoComponent {
    private static final Logger logger = Logger.getLogger(ContactInfoComponentImpl.class);

    @Resource
    private ContactInfoDAO contactInfoDAO;

    /**
     * 查询还款人有序通讯录
     *
     * @param contactInfoQueryPageOrder
     * @return
     */
    @Override
    public PageList<ContactInfoModel> listContactByDebtorId(ContactInfoQueryPageOrder contactInfoQueryPageOrder) {
        //【1】计算总数
        int rowCount = contactInfoDAO.selectForPageCount(contactInfoQueryPageOrder.getDebtorId());
        Page page = Page.getInstance(new PageAttribute(contactInfoQueryPageOrder.getPageNum(),
                contactInfoQueryPageOrder.getPageSize()), rowCount);
        //【2】获取分页数据
        List<ContactInfoDO> dolist = contactInfoDAO.listByDebtorId(
                contactInfoQueryPageOrder.getDebtorId(),
                page.offset(), page.getPageSize());

        //【3】组装返回结果
        List<ContactInfoModel> modelList = new ArrayList<ContactInfoModel>();
        for (ContactInfoDO obj : dolist) {
            modelList.add(ContactInfoConverter.convertDOToModel(obj));
        }
        return PageList.getInstance(modelList, page);
    }

    /**
     * 每次通话结束保存最新的call result, call_times +1
     *
     * @param contactInfoModel
     * @return
     */
    @Override
    public int updateContactForCallRecord(ContactInfoModel contactInfoModel) {
        return contactInfoDAO.updateForCallResult(ContactInfoConverter.convertModelToDO(contactInfoModel));
    }
}
