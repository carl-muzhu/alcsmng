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
     * ��ѯ����������ͨѶ¼
     *
     * @param contactInfoQueryPageOrder
     * @return
     */
    @Override
    public PageList<ContactInfoModel> listContactByDebtorId(ContactInfoQueryPageOrder contactInfoQueryPageOrder) {
        //��1����������
        int rowCount = contactInfoDAO.selectForPageCount(contactInfoQueryPageOrder.getDebtorId());
        Page page = Page.getInstance(new PageAttribute(contactInfoQueryPageOrder.getPageNum(),
                contactInfoQueryPageOrder.getPageSize()), rowCount);
        //��2����ȡ��ҳ����
        List<ContactInfoDO> dolist = contactInfoDAO.listByDebtorId(
                contactInfoQueryPageOrder.getDebtorId(),
                page.offset(), page.getPageSize());

        //��3����װ���ؽ��
        List<ContactInfoModel> modelList = new ArrayList<ContactInfoModel>();
        for (ContactInfoDO obj : dolist) {
            modelList.add(ContactInfoConverter.convertDOToModel(obj));
        }
        return PageList.getInstance(modelList, page);
    }

    /**
     * ÿ��ͨ�������������µ�call result, call_times +1
     *
     * @param contactInfoModel
     * @return
     */
    @Override
    public int updateContactForCallRecord(ContactInfoModel contactInfoModel) {
        return contactInfoDAO.updateForCallResult(ContactInfoConverter.convertModelToDO(contactInfoModel));
    }
}
