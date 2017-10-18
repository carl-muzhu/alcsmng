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
     * ������Ա�鿴�����������
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
            //��ȡ�û������б�
            List<AssignInfoModel> assignInfoModelList = assignInfoComponent.listCaseForUser(userInfoModel.getUserId());
            List<Integer> caseIdList = new ArrayList<Integer>();
            for (AssignInfoModel assignInfoModel : assignInfoModelList) {
                caseIdList.add(assignInfoModel.getCaseId());
            }
            //��ҳ��ѯ�û�����
            CaseInfoQueryPageOrder caseInfoQueryPageOrder = new CaseInfoQueryPageOrder();
            caseInfoQueryPageOrder.setCaseIdList(caseIdList);
            PageList<CaseInfoModel> pageList = caseInfoComponent.selectForPage((CaseInfoQueryPageOrder) BuildQuery.buildQuery(pageView, caseInfoQueryPageOrder));
            //�������ؽ��
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
            LogUtil.error(logger, e, "��ѯ�û������쳣");
            return ResponseUtil.buildExpResponse("SYSTEM_ERROR", "��ѯ�û������쳣");
        }
        return restP;
    }

    /**
     * ����̨�鿴�������
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
     * ͨ��������ǰ��ӻ���������
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
     * ��ת�������鿴ҳ��for admin ���� �鳤
     *
     * @return
     */
    @RequestMapping("/toViewCaseInfo.do")
    public ModelAndView toViewCaseInfo() {
        return new ModelAndView("viewCaseInfo");
    }

    /**
     * ����admin,����,�鳤�鿴M0�������
     *
     * @param request
     * @return
     */
    @RequestMapping("/viewCaseInfo.htm")
    @ResponseBody
    public JSONObject toViewCaseInfo(HttpServletRequest request, PageView<AssignInfoModel> pageView) {
        UserInfoModel userInfoModel = (UserInfoModel) request.getSession().getAttribute(AlcsConstant.SESSION_USER_KEY);
        //�г������û�map����
        List<UserInfoModel> userInfoModelList = userInfoComponent.queryAllUser();
        Map<Integer, Object> userInfoMap = transferList2Map(userInfoModelList);
        //��ҳ��ѯ����
        AssignInfoQueryPageOrder assignInfoQueryPageOrder = new AssignInfoQueryPageOrder();
        assignInfoQueryPageOrder = (AssignInfoQueryPageOrder) BuildQuery.buildQuery(pageView, assignInfoQueryPageOrder);
        //admin�鿴
        if (userInfoModel.getUserType() == 3) {
            //��������assign info for mo
            PageList<AssignInfoModel> recordList = assignInfoComponent.pageM0ForAdmin(assignInfoQueryPageOrder);
            List<AssignInfoModel> assignInfoModelList = recordList.getDatas();
            if (assignInfoModelList == null || assignInfoModelList.size() == 0) {
                return null;
            }
            List<CaseInfoVo> caseInfoVoList = generateCaseInfoVoWithAssignList(assignInfoModelList, userInfoMap);
            return generateJson(caseInfoVoList);
            //�û�Ϊ����
        } else if (userInfoModel.getUserType() == 2) {
            //��������������������Ա����
            //���ȼ���rule
            List<RuleInfoModel> ruleInfoModelList = ruleInfoComponent.queryM0ByLocationCode(userInfoModel.getLocationCode());
            //��ȡ���й�����Աid���ڲ�ѯ�ְ�
            List<Integer> userIdList = generateUserId4AssignList(ruleInfoModelList);
            assignInfoQueryPageOrder.setUserIdList(userIdList);
            //�ְ���ҳ��ѯ
            PageList<AssignInfoModel> recordList = assignInfoComponent.selectForPage(assignInfoQueryPageOrder);
            List<AssignInfoModel> assignInfoModelList = recordList.getDatas();
            if (assignInfoModelList == null || assignInfoModelList.size() == 0) {
                return null;
            }
            List<CaseInfoVo> caseInfoVoList = generateCaseInfoVoWithAssignList(assignInfoModelList, userInfoMap);
            return generateJson(caseInfoVoList);
        } else {//�鳤�鿴
            //��ѯ�鳤���ڵĹ���
            List<RuleInfoModel> ruleInfoModelList = ruleInfoComponent.queryByTeamLeaderId(String.valueOf(userInfoModel.getUserId()));
            List<Integer> userIdList = generateUserId4AssignList(ruleInfoModelList);
            assignInfoQueryPageOrder.setUserIdList(userIdList);
            //�ְ���ҳ��ѯ
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
     * �Ѳ�ѯ���ת��Ϊjson
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
     * �ӻ�ȡ��ruleInfoModelList����ȡ�����䰸�������й�����Աid
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
     * ����ѯ���ת����caseinfo vo �б�, ����ǰ����ʾ
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
     * ���û���Ϣ�б�ת��Ϊkey(userId) value(UserInfoModel),�������ʹ��
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
