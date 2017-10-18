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
     * ���ڵ�¼��ѯ�û���Ϣ
     *
     * @param account
     * @return
     */
    UserInfoModel queryUserByAccount(String account);

    /**
     * ��ѯuser by user id list
     *
     * @param userIdList
     * @return
     */
    List<UserInfoModel> queryUserByUserIdList(List<Integer> userIdList);

    /**
     * ��ѯ������Ա by location code
     *
     * @param locationCode
     * @return
     */
    List<UserInfoModel> queryUserByLocationCode(int locationCode);

    /**
     * ��ѯ�����û�
     *
     * @return
     */
    List<UserInfoModel> queryAllUser();

    /**
     * ��ҳ��ѯ�û�
     *
     * @param userInfoQueryPageOrder
     * @return
     */
    PageList<UserInfoModel> selectForPage(UserInfoQueryPageOrder userInfoQueryPageOrder);

    /**
     * ͨ��user idɾ���û�
     *
     * @param userId
     * @return
     */
    int deleteByUserId(int userId);

    /**
     * �����û���Ϣ
     *
     * @param userInfoModel
     * @return
     */
    int saveUserInfo(UserInfoModel userInfoModel);
}
