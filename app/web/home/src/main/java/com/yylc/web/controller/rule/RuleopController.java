package com.yylc.web.controller.rule;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yylc.alcsmng.core.service.RuleInfoComponent;
import com.yylc.alcsmng.core.service.UserInfoComponent;
import com.yylc.dwdataservice.core.model.RuleInfoModel;
import com.yylc.dwdataservice.core.model.UserInfoModel;
import com.yylc.dwdataservice.core.order.RuleInfoQueryPageOrder;
import com.yylc.platform.common.page.PageList;
import com.yylc.web.controller.constant.AlcsConstant;
import com.yylc.web.controller.enums.rule.DeptEnum;
import com.yylc.web.controller.enums.rule.LocationEnum;
import com.yylc.web.controller.result.RestResponse;
import com.yylc.web.controller.utils.BuildQuery;
import com.yylc.web.controller.utils.PageView;
import com.yylc.web.controller.utils.ResponseUtil;
import com.yylc.web.vo.rep.RuleInfoVo;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yylc-y01909 on 2017/10/16.
 */
@Controller
@RequestMapping("/ruleop")
public class RuleopController {
    private static final Logger logger = Logger.getLogger(RuleopController.class);

    @Resource
    private RuleInfoComponent ruleInfoComponent;
    @Resource
    private UserInfoComponent userInfoComponent;

    @RequestMapping("/toRuleSetPage.htm")
    public ModelAndView toRuleSetPage() {
        return new ModelAndView("rule/rulePage");
    }

    @RequestMapping("/pageRuleInfo.do")
    @ResponseBody
    public String pageRule(HttpServletRequest request, PageView<RuleInfoModel> pageView) {
        UserInfoModel userInfoModel = (UserInfoModel) request.getSession().getAttribute(AlcsConstant.SESSION_USER_KEY);
        //统一分页查询条件
        RuleInfoQueryPageOrder ruleInfoQueryPageOrder = new RuleInfoQueryPageOrder();
        ruleInfoQueryPageOrder = (RuleInfoQueryPageOrder) BuildQuery.buildQuery(pageView, ruleInfoQueryPageOrder);

        //超级管理员分页所有规则
        if (userInfoModel.getUserType() == 3) {
            PageList<RuleInfoModel> pageList = ruleInfoComponent.pageForAdmin(ruleInfoQueryPageOrder);
            //构建返回结果
            PageList<RuleInfoModel> recordList = PageList.getInstance(pageList.getDatas(), pageList.getPage());
            List<RuleInfoModel> ruleInfoModelList = recordList.getDatas();
            if (ruleInfoModelList == null || ruleInfoModelList.size() == 0) {
                return null;
            }
            //取出所有员工map备用
            List<UserInfoModel> userInfoModelList = userInfoComponent.queryAllUser();
            Map<Integer, Object> userInfoMap = transferList2Map(userInfoModelList);
            //结果转换为json
            JSONObject jsonObject = parseRuleModelToJson(ruleInfoModelList, userInfoMap);
            jsonObject.put("count", pageList.getPage().getRowCount());
            return jsonObject.toJSONString();
        } else {//区域主管分页查询规则
            //设置查询条件
            ruleInfoQueryPageOrder.setLocationCode(userInfoModel.getLocationCode());
            ruleInfoQueryPageOrder.setDeptCode(userInfoModel.getDeptCode());
            //分页查询
            PageList<RuleInfoModel> pageList = ruleInfoComponent.selectForPage(ruleInfoQueryPageOrder);
            //构建返回结果
            PageList<RuleInfoModel> recordList = PageList.getInstance(pageList.getDatas(), pageList.getPage());
            List<RuleInfoModel> ruleInfoModelList = recordList.getDatas();
            if (ruleInfoModelList == null || ruleInfoModelList.size() == 0) {
                return null;
            }
            //取出同区域所有员工map备用
            List<UserInfoModel> userInfoModelList = userInfoComponent.queryUserByLocationCode(userInfoModel.getLocationCode());
            Map<Integer, Object> userInfoMap = transferList2Map(userInfoModelList);
            //结果转换为json
            JSONObject jsonObject = parseRuleModelToJson(ruleInfoModelList, userInfoMap);
            jsonObject.put("count", pageList.getPage().getRowCount());
            return jsonObject.toJSONString();
        }
    }

    /**
     * 跳转到规则更新页面
     *
     * @param request
     * @param ruleId
     * @return
     */
    @RequestMapping("/toUpdateRulePage.htm")
    public ModelAndView toUpdateRulePage(HttpServletRequest request, int ruleId) {
        ModelAndView modelAndView = new ModelAndView("rule/updateRulePage");
        //查询当前rule信息并转换成vo
        RuleInfoModel ruleInfoModel = ruleInfoComponent.queryRuleByRuleId(ruleId);
        //查询同区域工作人员并生成map
        UserInfoModel userInfoModel = (UserInfoModel) request.getSession().getAttribute(AlcsConstant.SESSION_USER_KEY);
        List<UserInfoModel> userInfoModelList = userInfoComponent.queryUserByLocationCode(userInfoModel.getLocationCode());
        Map<Integer, Object> userInfoMap = transferList2Map(userInfoModelList);
        userInfoMap.remove(userInfoModel.getUserId());//删除本人信息防止列表展示
        //加载科室map
        Map<Integer, String> ruleTypeMap = getDeptMap();
        //加载区域map
        Map<Integer, String> locationMap = getLocationMap();
        //转换model to vo
        RuleInfoVo ruleInfoVo = transferModel2Vo(ruleInfoModel, userInfoMap);
        modelAndView.addObject("ruleInfoVo", ruleInfoVo);
        modelAndView.addObject("userInfoMap", userInfoMap);
        modelAndView.addObject("ruleTypeMap", ruleTypeMap);
        modelAndView.addObject("locationMap", locationMap);
        return modelAndView;
    }

    /**
     * 更新规则
     *
     * @param userIds
     * @param ruleInfoModel
     * @return
     */
    @RequestMapping("/updateRuleInfo.do")
    @ResponseBody
    public RestResponse updateRuleInfo(String userIds, RuleInfoModel ruleInfoModel) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        //先删除对应的rule
        ruleInfoComponent.deleteByRuleId(ruleInfoModel.getRuleId());
        //更新rule
        ruleInfoComponent.saveRuleInfo(ruleInfoModel);
        return restP;
    }

    @RequestMapping("/toAddRulePage.htm")
    public ModelAndView toAddRulePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("rule/addRulePage");
        //查询同区域工作人员并生成map
        UserInfoModel userInfoModel = (UserInfoModel) request.getSession().getAttribute(AlcsConstant.SESSION_USER_KEY);
        List<UserInfoModel> userInfoModelList = userInfoComponent.queryUserByLocationCode(userInfoModel.getLocationCode());
        Map<Integer, Object> userInfoMap = transferList2Map(userInfoModelList);
        userInfoMap.remove(userInfoModel.getUserId());//删除本人信息防止列表展示
        //加载科室map
        Map<Integer, String> ruleTypeMap = getDeptMap();
        //加载区域map
        Map<Integer, String> locationMap = getLocationMap();
        modelAndView.addObject("userInfoMap", userInfoMap);
        modelAndView.addObject("ruleTypeMap", ruleTypeMap);
        modelAndView.addObject("locationMap", locationMap);
        return modelAndView;
    }

    /**
     * 保存规则
     *
     * @param ruleInfoModel
     * @return
     */
    @RequestMapping("/saveRuleInfo.do")
    @ResponseBody
    public RestResponse saveRuleInfo(RuleInfoModel ruleInfoModel) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        ruleInfoComponent.saveRuleInfo(ruleInfoModel);
        return restP;
    }

    /**
     * 删除规则
     *
     * @param ruleInfoModel
     * @return
     */
    @RequestMapping("/deleteRuleInfo.do")
    @ResponseBody
    public RestResponse deleteRuleInfo(RuleInfoModel ruleInfoModel) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        ruleInfoComponent.deleteByRuleId(ruleInfoModel.getRuleId());
        return restP;
    }


    /**
     * 将每页数据列表转换为vo对象列表的json对象
     *
     * @param ruleInfoModelList
     * @param userInfoMap
     * @return
     */
    public JSONObject parseRuleModelToJson(List<RuleInfoModel> ruleInfoModelList, Map<Integer, Object> userInfoMap) {
        //转换成vo返回
        List<RuleInfoVo> ruleInfoVoList = new ArrayList<RuleInfoVo>();
        for (RuleInfoModel ruleInfoModel : ruleInfoModelList) {
            RuleInfoVo ruleInfoVo = transferModel2Vo(ruleInfoModel, userInfoMap);
            ruleInfoVoList.add(ruleInfoVo);
        }
        JSONObject jsonObject = new JSONObject();
        String data = "";
        JSONArray array = new JSONArray();
        if (ruleInfoVoList != null) {
            data = JSONArray.toJSONString(ruleInfoVoList);
            array = JSONArray.parseArray(data);
        }
        jsonObject.put("data", array);
        jsonObject.put("code", 0);
        jsonObject.put("succ", true);
        jsonObject.put("err_msg", "");
        return jsonObject;
    }

    /**
     * 把rule model 和 user info 转换为 rule vo 对象
     *
     * @param ruleInfoModel
     * @param userInfoMap
     * @return
     */
    public RuleInfoVo transferModel2Vo(RuleInfoModel ruleInfoModel, Map<Integer, Object> userInfoMap) {
        RuleInfoVo ruleInfoVo = new RuleInfoVo();
        ruleInfoVo.setRuleId(ruleInfoModel.getRuleId());
        ruleInfoVo.setRuleName(ruleInfoModel.getRuleName());
        ruleInfoVo.setLocationName(LocationEnum.getNameByCode(ruleInfoModel.getLocationCode()));
        ruleInfoVo.setDeptName(DeptEnum.getNameByCode(ruleInfoModel.getDeptCode()));
        String userIds = ruleInfoModel.getUserIds();
        if (StringUtils.isNotBlank(userIds)) {
            StringBuffer sb = new StringBuffer();
            String[] userIdArr = userIds.split(",");
            for (String str : userIdArr) {
                sb.append(((UserInfoModel) userInfoMap.get(Integer.parseInt(str))).getUserName()).append(",");
            }
            ruleInfoVo.setUserNames(sb.toString());
        }
        return ruleInfoVo;
    }


    /**
     * 加载科室map
     *
     * @return
     */
    public Map<Integer, String> getDeptMap() {
        Map<Integer, String> ruleTypeMap = new HashMap<Integer, String>();
        for (DeptEnum deptEnum : DeptEnum.values()) {
            ruleTypeMap.put(deptEnum.getCode(), deptEnum.getName());
        }
        return ruleTypeMap;
    }

    /**
     * 加载区域map
     *
     * @return
     */
    public Map<Integer, String> getLocationMap() {
        Map<Integer, String> locationMap = new HashMap<Integer, String>();
        for (LocationEnum locationEnum : LocationEnum.values()) {
            locationMap.put(locationEnum.getCode(), locationEnum.getName());
        }
        return locationMap;
    }

    /**
     * 转换user info list 为 map key(userId) value(user info obj)
     *
     * @param userInfoModelList
     * @return
     */
    public Map<Integer, Object> transferList2Map(List<UserInfoModel> userInfoModelList) {
        if (userInfoModelList != null && userInfoModelList.size() > 0) {
            Map<Integer, Object> userInfoMap = new HashMap<Integer, Object>(userInfoModelList.size());
            for (UserInfoModel userInfoModel : userInfoModelList) {
                userInfoMap.put(userInfoModel.getUserId(), userInfoModel);
            }
            return userInfoMap;
        } else {
            return null;
        }
    }

}
