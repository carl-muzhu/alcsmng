package com.yylc.web.controller.caseop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yylc.alcsmng.core.service.*;
import com.yylc.dwdataservice.core.model.*;
import com.yylc.dwdataservice.core.order.AssignInfoQueryPageOrder;
import com.yylc.dwdataservice.core.order.CaseInfoQueryPageOrder;
import com.yylc.platform.common.page.PageList;
import com.yylc.platform.common.utils.LogUtil;
import com.yylc.web.controller.constant.AlcsConstant;
import com.yylc.web.controller.result.RestResponse;
import com.yylc.web.controller.utils.BuildQuery;
import com.yylc.web.controller.utils.PageView;
import com.yylc.web.controller.utils.ResponseUtil;
import com.yylc.web.vo.rep.CaseInfoVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by xm on 2017/9/29.
 */
@Controller
@RequestMapping("/caseop")
public class CaseopController {
    private static final Logger logger = Logger.getLogger(CaseopController.class);

    @Resource
    private AssignInfoComponent assignInfoComponent;

    @Resource
    private CaseInfoComponent caseInfoComponent;
    @Resource
    private UserInfoComponent userInfoComponent;
    @Resource
    private RuleInfoComponent ruleInfoComponent;
    @Resource
    private DebtorInfoComponent debtorInfoComponent;

    /**
     * 催收人员查看案例处理情况
     *
     * @param request
     * @param pageView
     * @return
     */
    @RequestMapping(value = "/pageCaseForUser.do")
    @ResponseBody
    public RestResponse pageCaseForUser(HttpServletRequest request, PageView<CaseInfoModel> pageView) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        UserInfoModel userInfoModel = (UserInfoModel) request.getSession().getAttribute(AlcsConstant.SESSION_USER_KEY);
        try {
            //获取用户案例列表
            List<AssignInfoModel> assignInfoModelList = assignInfoComponent.listCaseForUser(userInfoModel.getUserId());
            List<Integer> caseIdList = new ArrayList<Integer>();
            for (AssignInfoModel assignInfoModel : assignInfoModelList) {
                caseIdList.add(assignInfoModel.getCaseId());
            }
            //分页查询用户案例
            CaseInfoQueryPageOrder caseInfoQueryPageOrder = new CaseInfoQueryPageOrder();
            caseInfoQueryPageOrder.setCaseIdList(caseIdList);
            PageList<CaseInfoModel> pageList = caseInfoComponent.selectForPage((CaseInfoQueryPageOrder) BuildQuery.buildQuery(pageView, caseInfoQueryPageOrder));
            //构建返回结果
            PageList<CaseInfoModel> recordList = PageList.getInstance(pageList.getDatas(), pageList.getPage());
            List<CaseInfoModel> caseInfoModelList = recordList.getDatas();
            List<CaseInfoVo> caseInfoVoList = new ArrayList<CaseInfoVo>();
            if (caseInfoModelList != null && caseInfoModelList.size() > 0) {
                for (CaseInfoModel caseInfoModel : caseInfoModelList) {
                    CaseInfoVo caseInfoVo = new CaseInfoVo();
                    BeanUtils.copyProperties(caseInfoVo, caseInfoModel);
                    caseInfoVoList.add(caseInfoVo);
                }
            }
            PageView<CaseInfoVo> voPageView = new PageView<CaseInfoVo>();
            voPageView.setRowCount(pageList.getPage().getRowCount());
            voPageView.setRecords(caseInfoVoList);
            restP.setResult(voPageView);
        } catch (Exception e) {
            LogUtil.error(logger, e, "查询用户案例异常");
            return ResponseUtil.buildExpResponse("SYSTEM_ERROR", "查询用户案例异常");
        }
        return restP;
    }

    /**
     * 工作台查看借款详情
     *
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/queryCaseByCaseId.do")
    @ResponseBody
    public RestResponse queryCaseByCaseId(int caseId) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        restP.setResult(caseInfoComponent.queryCaseByCaseId(caseId));
        return restP;
    }

    /**
     * 通话结束标记案子还款跟进结果
     *
     * @param caseInfoModel
     * @return
     */
    @RequestMapping(value = "/updateCaseForCurrentResult.do")
    @ResponseBody
    public RestResponse updateCaseForCurrentResult(CaseInfoModel caseInfoModel) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        restP.setResult(caseInfoComponent.updateCaseForCurrentResult(caseInfoModel));
        return restP;
    }

    /**
     * 跳转到案例查看页面for admin 主管 组长
     *
     * @return
     */
    @RequestMapping("/toViewCaseInfo.do")
    public ModelAndView toViewCaseInfo() {
        return new ModelAndView("viewCaseInfo");
    }

    /**
     * 用于admin,主管,组长查看M0催收情况
     *
     * @param request
     * @return
     */
    @RequestMapping("/viewCaseInfo.htm")
    @ResponseBody
    public JSONObject toViewCaseInfo(HttpServletRequest request, PageView<AssignInfoModel> pageView) {
        UserInfoModel userInfoModel = (UserInfoModel) request.getSession().getAttribute(AlcsConstant.SESSION_USER_KEY);
        //列出所有用户map备用
        List<UserInfoModel> userInfoModelList = userInfoComponent.queryAllUser();
        Map<Integer, Object> userInfoMap = transferList2Map(userInfoModelList);
        //分页查询参数
        AssignInfoQueryPageOrder assignInfoQueryPageOrder = new AssignInfoQueryPageOrder();
        assignInfoQueryPageOrder = (AssignInfoQueryPageOrder) BuildQuery.buildQuery(pageView, assignInfoQueryPageOrder);
        //admin查看
        if (userInfoModel.getUserType() == 3) {
            //加载所有assign info for mo
            PageList<AssignInfoModel> recordList = assignInfoComponent.pageM0ForAdmin(assignInfoQueryPageOrder);
            List<AssignInfoModel> assignInfoModelList = recordList.getDatas();
            if (assignInfoModelList == null || assignInfoModelList.size() == 0) {
                return null;
            }
            List<CaseInfoVo> caseInfoVoList = generateCaseInfoVoWithAssignList(assignInfoModelList, userInfoMap);
            return generateJson(caseInfoVoList);
            //用户为主管
        } else if (userInfoModel.getUserType() == 2) {
            //加载主管所在区域工作人员案例
            //首先加载rule
            List<RuleInfoModel> ruleInfoModelList = ruleInfoComponent.queryM0ByLocationCode(userInfoModel.getLocationCode());
            //获取所有工作人员id用于查询分案
            List<Integer> userIdList = generateUserId4AssignList(ruleInfoModelList);
            assignInfoQueryPageOrder.setUserIdList(userIdList);
            //分案分页查询
            PageList<AssignInfoModel> recordList = assignInfoComponent.selectForPage(assignInfoQueryPageOrder);
            List<AssignInfoModel> assignInfoModelList = recordList.getDatas();
            if (assignInfoModelList == null || assignInfoModelList.size() == 0) {
                return null;
            }
            List<CaseInfoVo> caseInfoVoList = generateCaseInfoVoWithAssignList(assignInfoModelList, userInfoMap);
            return generateJson(caseInfoVoList);
        } else {//组长查看
            //查询组长所在的规则
            List<RuleInfoModel> ruleInfoModelList = ruleInfoComponent.queryByTeamLeaderId(String.valueOf(userInfoModel.getUserId()));
            List<Integer> userIdList = generateUserId4AssignList(ruleInfoModelList);
            assignInfoQueryPageOrder.setUserIdList(userIdList);
            //分案分页查询
            PageList<AssignInfoModel> recordList = assignInfoComponent.selectForPage(assignInfoQueryPageOrder);
            List<AssignInfoModel> assignInfoModelList = recordList.getDatas();
            if (assignInfoModelList == null || assignInfoModelList.size() == 0) {
                return null;
            }
            List<CaseInfoVo> caseInfoVoList = generateCaseInfoVoWithAssignList(assignInfoModelList, userInfoMap);
            return generateJson(caseInfoVoList);
        }
    }

    /**
     * 把查询结果转换为json
     *
     * @param caseInfoVoList
     * @return
     */
    public JSONObject generateJson(List<CaseInfoVo> caseInfoVoList) {
        JSONObject jsonObject = new JSONObject();
        String data = "";
        JSONArray array = new JSONArray();
        if (caseInfoVoList != null) {
            data = JSONArray.toJSONString(caseInfoVoList);
            array = JSONArray.parseArray(data);
        }
        jsonObject.put("data", array);
        jsonObject.put("code", 0);
        jsonObject.put("succ", true);
        jsonObject.put("err_msg", "");
        return jsonObject;
    }

    /**
     * 从获取的ruleInfoModelList中提取出分配案例的所有工作人员id
     *
     * @param ruleInfoModelList
     * @return
     */
    public List<Integer> generateUserId4AssignList(List<RuleInfoModel> ruleInfoModelList) {
        Set<String> userIdSet = new HashSet<String>();
        for (RuleInfoModel ruleInfoModel : ruleInfoModelList) {
            String tIds = ruleInfoModel.getTeamLeaderIds();
            String uIds = ruleInfoModel.getUserIds();
            if (StringUtils.isNotBlank(tIds)) {
                String[] tempArr = tIds.split(",");
                for (String str : tempArr) {
                    if (StringUtils.isNotBlank(str)) {
                        userIdSet.add(str.trim());
                    }
                }
            }
            if (StringUtils.isNotBlank(uIds)) {
                String[] tempArr = uIds.split(",");
                for (String str : tempArr) {
                    if (StringUtils.isNotBlank(str)) {
                        userIdSet.add(str.trim());
                    }
                }
            }
        }
        List<Integer> userIdList = new ArrayList<Integer>();
        for (String str : userIdSet) {
            userIdList.add(Integer.parseInt(str));
        }
        return userIdList;
    }

    /**
     * 将查询结果转换成caseinfo vo 列表, 方便前端显示
     *
     * @param assignInfoModelList
     * @param userInfoMap
     * @return
     */
    public List<CaseInfoVo> generateCaseInfoVoWithAssignList(List<AssignInfoModel> assignInfoModelList, Map<Integer, Object> userInfoMap) {
        List<CaseInfoVo> caseInfoVoList = new ArrayList<CaseInfoVo>();
        for (AssignInfoModel assignInfoModel : assignInfoModelList) {
            CaseInfoVo caseInfoVo = new CaseInfoVo();

            UserInfoModel userInfoModel = (UserInfoModel) userInfoMap.get(assignInfoModel.getUserId());
            CaseInfoModel caseInfoModel = caseInfoComponent.queryCaseByCaseId(assignInfoModel.getCaseId());
            DebtorInfoModel debtorInfoModel = debtorInfoComponent.queryByDebtorId(caseInfoModel.getDebtorId());

            caseInfoVo.setCaseId(caseInfoModel.getCaseId());
            caseInfoVo.setLoanId(caseInfoModel.getLoanId());
            caseInfoVo.setDebtorId(caseInfoModel.getDebtorId());
            caseInfoVo.setDebtorName(caseInfoModel.getDebtorName());
            caseInfoVo.setItemName(caseInfoModel.getItemName());
            caseInfoVo.setLoanAmount(caseInfoModel.getLoanAmount());
            caseInfoVo.setPendingAmount(caseInfoModel.getPendingAmount());
            caseInfoVo.setRepayAmount(caseInfoModel.getRepayAmount());
            caseInfoVo.setDaysOverdue(caseInfoModel.getDaysOverdue());
            caseInfoVo.setCurrentStatus(caseInfoModel.getCurrentStatus());
            caseInfoVo.setCurrentResult(caseInfoModel.getCurrentResult());
            caseInfoVo.setIdNo(debtorInfoModel.getIdNum());
            caseInfoVo.setPhoneNum(debtorInfoModel.getPhoneNum());
            caseInfoVo.setOperatorName(userInfoModel.getUserName());

            caseInfoVoList.add(caseInfoVo);
        }
        return caseInfoVoList;
    }

    /**
     * 将用户信息列表转换为key(userId) value(UserInfoModel),方便随后使用
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
