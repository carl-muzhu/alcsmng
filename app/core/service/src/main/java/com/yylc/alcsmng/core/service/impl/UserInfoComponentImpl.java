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
     * 用于登录查询用户信息
     *
     * @param account
     * @return
     */
    @Override
    public UserInfoModel queryUserByAccount(String account) {
        return UserInfoConverter.convertDOToModel(userInfoDAO.queryUserByAccount(account));
    }

    /**
     * 查询user by user id list
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
     * 查询工作人员 by location code
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
     * 查询所有用户
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
     * 分页查询用户
     *
     * @param userInfoQueryPageOrder
     * @return
     */
    @Override
    public PageList<UserInfoModel> selectForPage(UserInfoQueryPageOrder userInfoQueryPageOrder) {
        //【1】计算总数
        int rowCount = userInfoDAO.selectForPageCount();
        Page page = Page.getInstance(new PageAttribute(userInfoQueryPageOrder.getPageNum(),
                userInfoQueryPageOrder.getPageSize()), rowCount);
        //【2】获取分页数据
        List<UserInfoDO> dolist = userInfoDAO.listForPage(
                page.offset(), page.getPageSize());

        //【3】组装返回结果
        List<UserInfoModel> modelList = new ArrayList<UserInfoModel>();
        for (UserInfoDO obj : dolist) {
            modelList.add(UserInfoConverter.convertDOToModel(obj));
        }
        return PageList.getInstance(modelList, page);
    }

    /**
     * 通过user id删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public int deleteByUserId(int userId) {
        return userInfoDAO.deleteByUserId(userId);
    }

    /**
     * 保存用户信息
     *
     * @param userInfoModel
     * @return
     */
    @Override
    public int saveUserInfo(UserInfoModel userInfoModel) {
        return userInfoDAO.saveUserInfo(UserInfoConverter.convertModelToDO(userInfoModel));
    }
}
