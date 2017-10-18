package com.yylc.alcsmng.core.service;

import com.yylc.dwdataservice.core.model.UserInfoModel;
import com.yylc.dwdataservice.core.order.UserInfoQueryPageOrder;
import com.yylc.platform.common.page.PageList;

import java.util.List;

/**
 * Created by yylc-y01909 on 2017/10/12.
 */
public interface UserInfoComponent {
    /**
     * 用于登录查询用户信息
     *
     * @param account
     * @return
     */
    UserInfoModel queryUserByAccount(String account);

    /**
     * 查询user by user id list
     *
     * @param userIdList
     * @return
     */
    List<UserInfoModel> queryUserByUserIdList(List<Integer> userIdList);

    /**
     * 查询工作人员 by location code
     *
     * @param locationCode
     * @return
     */
    List<UserInfoModel> queryUserByLocationCode(int locationCode);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<UserInfoModel> queryAllUser();

    /**
     * 分页查询用户
     *
     * @param userInfoQueryPageOrder
     * @return
     */
    PageList<UserInfoModel> selectForPage(UserInfoQueryPageOrder userInfoQueryPageOrder);

    /**
     * 通过user id删除用户
     *
     * @param userId
     * @return
     */
    int deleteByUserId(int userId);

    /**
     * 保存用户信息
     *
     * @param userInfoModel
     * @return
     */
    int saveUserInfo(UserInfoModel userInfoModel);
}
