package com.yylc.web.controller.user;

import com.yylc.alcsmng.core.service.UserInfoComponent;
import com.yylc.dwdataservice.core.model.UserInfoModel;
import com.yylc.dwdataservice.core.order.UserInfoQueryPageOrder;
import com.yylc.platform.common.page.PageList;
import com.yylc.web.controller.result.RestResponse;
import com.yylc.web.controller.utils.BuildQuery;
import com.yylc.web.controller.utils.PageView;
import com.yylc.web.controller.utils.ResponseUtil;
import com.yylc.web.vo.rep.UserInfoVo;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yylc-y01909 on 2017/10/17.
 */
@Controller
@RequestMapping("/userop")
public class UseropController {
    private static final Logger logger = Logger.getLogger(UseropController.class);

    @Resource
    private UserInfoComponent userInfoComponent;

    @RequestMapping("/toUserManagePage.htm")
    public ModelAndView toUserManagePage(PageView<UserInfoModel> pageView) {
        UserInfoQueryPageOrder userInfoQueryPageOrder = new UserInfoQueryPageOrder();
        PageList<UserInfoModel> pageList = userInfoComponent.selectForPage((UserInfoQueryPageOrder) BuildQuery.buildQuery(pageView, userInfoQueryPageOrder));
        //构建返回结果
        PageList<UserInfoModel> recordList = PageList.getInstance(pageList.getDatas(), pageList.getPage());
        List<UserInfoModel> userInfoModelList = recordList.getDatas();
        List<UserInfoVo> userInfoVoList = new ArrayList<UserInfoVo>();
        if (userInfoModelList != null && userInfoModelList.size() > 0) {
            for (UserInfoModel userInfoModel : userInfoModelList) {
                UserInfoVo userInfoVo = new UserInfoVo();
                BeanUtils.copyProperties(userInfoVo, userInfoModel);
                userInfoVoList.add(userInfoVo);
            }
        }
        PageView<UserInfoVo> voPageView = new PageView<UserInfoVo>();
        voPageView.setRowCount(pageList.getPage().getRowCount());
        voPageView.setRecords(userInfoVoList);
        return new ModelAndView("userManagePage").addObject("voPageView", voPageView);
    }

    @RequestMapping("/updateUser.do")
    @ResponseBody
    public RestResponse updateUser(UserInfoModel userInfoModel) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        //删除老的记录
        userInfoComponent.deleteByUserId(userInfoModel.getUserId());
        //保存新的记录
        userInfoComponent.saveUserInfo(userInfoModel);
        return restP;
    }

    @RequestMapping("/deleteUser.do")
    @ResponseBody
    public RestResponse deleteUser(int userId) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        userInfoComponent.deleteByUserId(userId);
        return restP;
    }

    @RequestMapping("/saveUser.do")
    @ResponseBody
    public RestResponse saveUser(UserInfoModel userInfoModel) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        userInfoComponent.saveUserInfo(userInfoModel);
        return restP;
    }
}
