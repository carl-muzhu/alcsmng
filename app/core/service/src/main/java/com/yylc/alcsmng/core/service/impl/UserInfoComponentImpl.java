package com.yylc.alcsmng.core.service.impl;

import com.yylc.alcsmng.common.dal.daointerface.UserInfoDAO;
import com.yylc.alcsmng.common.dal.dataobject.UserInfoDO;
import com.yylc.alcsmng.core.service.UserInfoComponent;
import com.yylc.dwdataservice.core.model.UserInfoModel;
import com.yylc.dwdataservice.core.model.convert.UserInfoConverter;
import com.yylc.dwdataservice.core.order.UserInfoQueryPageOrder;
import com.yylc.platform.common.page.Page;
import com.yylc.platform.common.page.PageAttribute;
import com.yylc.platform.common.page.PageList;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yylc-y01909 on 2017/10/12.
 */
@Service("userInfoComponent")
public class UserInfoComponentImpl implements UserInfoComponent {
    private static final Logger logger = Logger.getLogger(UserInfoComponentImpl.class);

    @Resource
    private UserInfoDAO userInfoDAO;

    /**
     * ���ڵ�¼��ѯ�û���Ϣ
     *
     * @param account
     * @return
     */
    @Override
    public UserInfoModel queryUserByAccount(String account) {
        return UserInfoConverter.convertDOToModel(userInfoDAO.queryUserByAccount(account));
    }

    /**
     * ��ѯuser by user id list
     *
     * @param userIdList
     * @return
     */
    @Override
    public List<UserInfoModel> queryUserByUserIdList(List<Integer> userIdList) {
        List<UserInfoDO> userInfoDOList = userInfoDAO.queryUserByUserIdList(userIdList);
        List<UserInfoModel> userInfoModelList = new ArrayList<UserInfoModel>();
        if (userInfoDOList != null && userInfoDOList.size() > 0) {
            for (UserInfoDO userInfoDO : userInfoDOList) {
                userInfoModelList.add(UserInfoConverter.convertDOToModel(userInfoDO));
            }
        }
        return userInfoModelList;
    }

    /**
     * ��ѯ������Ա by location code
     *
     * @param locationCode
     * @return
     */
    @Override
    public List<UserInfoModel> queryUserByLocationCode(int locationCode) {
        List<UserInfoDO> userInfoDOList = userInfoDAO.queryUserByLocationCode(locationCode);
        List<UserInfoModel> userInfoModelList = new ArrayList<UserInfoModel>();
        if (userInfoDOList != null && userInfoDOList.size() > 0) {
            for (UserInfoDO userInfoDO : userInfoDOList) {
                userInfoModelList.add(UserInfoConverter.convertDOToModel(userInfoDO));
            }
        }
        return userInfoModelList;
    }

    /**
     * ��ѯ�����û�
     *
     * @return
     */
    @Override
    public List<UserInfoModel> queryAllUser() {
        List<UserInfoDO> userInfoDOList = userInfoDAO.queryAllUserInfo();
        List<UserInfoModel> userInfoModelList = new ArrayList<UserInfoModel>();
        if (userInfoDOList != null && userInfoDOList.size() > 0) {
            for (UserInfoDO userInfoDO : userInfoDOList) {
                userInfoModelList.add(UserInfoConverter.convertDOToModel(userInfoDO));
            }
        }
        return userInfoModelList;
    }

    /**
     * ��ҳ��ѯ�û�
     *
     * @param userInfoQueryPageOrder
     * @return
     */
    @Override
    public PageList<UserInfoModel> selectForPage(UserInfoQueryPageOrder userInfoQueryPageOrder) {
        //��1����������
        int rowCount = userInfoDAO.selectForPageCount();
        Page page = Page.getInstance(new PageAttribute(userInfoQueryPageOrder.getPageNum(),
                userInfoQueryPageOrder.getPageSize()), rowCount);
        //��2����ȡ��ҳ����
        List<UserInfoDO> dolist = userInfoDAO.listForPage(
                page.offset(), page.getPageSize());

        //��3����װ���ؽ��
        List<UserInfoModel> modelList = new ArrayList<UserInfoModel>();
        for (UserInfoDO obj : dolist) {
            modelList.add(UserInfoConverter.convertDOToModel(obj));
        }
        return PageList.getInstance(modelList, page);
    }

    /**
     * ͨ��user idɾ���û�
     *
     * @param userId
     * @return
     */
    @Override
    public int deleteByUserId(int userId) {
        return userInfoDAO.deleteByUserId(userId);
    }

    /**
     * �����û���Ϣ
     *
     * @param userInfoModel
     * @return
     */
    @Override
    public int saveUserInfo(UserInfoModel userInfoModel) {
        return userInfoDAO.saveUserInfo(UserInfoConverter.convertModelToDO(userInfoModel));
    }
}
