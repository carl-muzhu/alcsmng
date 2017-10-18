package com.yylc.web.controller.call;

import com.yylc.alcsmng.core.service.CallRecordComponent;
import com.yylc.alcsmng.core.service.CaseInfoComponent;
import com.yylc.alcsmng.core.service.ContactInfoComponent;
import com.yylc.dwdataservice.core.model.CallRecordModel;
import com.yylc.dwdataservice.core.model.CaseInfoModel;
import com.yylc.dwdataservice.core.model.ContactInfoModel;
import com.yylc.dwdataservice.core.order.CallResultQueryPageOrder;
import com.yylc.dwdataservice.core.order.ContactInfoQueryPageOrder;
import com.yylc.platform.common.page.PageList;
import com.yylc.platform.common.utils.LogUtil;
import com.yylc.web.controller.enums.workbench.CallResultEnum;
import com.yylc.web.controller.enums.workbench.CaseResultEnum;
import com.yylc.web.controller.result.RestResponse;
import com.yylc.web.controller.utils.BuildQuery;
import com.yylc.web.controller.utils.PageView;
import com.yylc.web.controller.utils.ResponseUtil;
import com.yylc.web.vo.rep.CallRecordVo;
import com.yylc.web.vo.rep.CaseInfoVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * call center controller
 * Created by xm on 2017/10/10.
 */
@Controller
@RequestMapping("/callop")
public class CallopController {
    private static final Logger logger = Logger.getLogger(CallopController.class);

    @Resource
    private CaseInfoComponent caseInfoComponent;

    @Resource
    private ContactInfoComponent contactInfoComponent;

    @Resource
    private CallRecordComponent callRecordComponent;

    @RequestMapping("/pageContactForCase.htm")
    @ResponseBody
    public RestResponse pageContactForCase(int caseId, PageView<CaseInfoModel> pageView) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        try {
            //分页查询用户案例
            CaseInfoModel caseInfoModel = caseInfoComponent.queryCaseByCaseId(caseId);
            ContactInfoQueryPageOrder contactInfoQueryPageOrder = new ContactInfoQueryPageOrder();
            PageList<ContactInfoModel> pageList = contactInfoComponent.listContactByDebtorId((ContactInfoQueryPageOrder) BuildQuery.buildQuery(pageView, contactInfoQueryPageOrder));
            //构建返回结果
            PageList<ContactInfoModel> recordList = PageList.getInstance(pageList.getDatas(), pageList.getPage());
            List<ContactInfoModel> contactInfoModelList = recordList.getDatas();
            List<CaseInfoVo> caseInfoVoList = new ArrayList<CaseInfoVo>();
            if (contactInfoModelList != null && contactInfoModelList.size() > 0) {
                for (ContactInfoModel contactInfoModel : contactInfoModelList) {
                    CaseInfoVo caseInfoVo = new CaseInfoVo();
                    BeanUtils.copyProperties(caseInfoVo, caseInfoModel);
                }
            }
            PageView<CaseInfoVo> voPageView = new PageView<CaseInfoVo>();
            voPageView.setRowCount(pageList.getPage().getRowCount());
            voPageView.setRecords(caseInfoVoList);
            restP.setResult(voPageView);

            restP.setResult(contactInfoModelList);
        } catch (Exception e) {
            LogUtil.error(logger, e, "查询通讯录异常");
            return ResponseUtil.buildExpResponse("SYSTEM_ERROR", "查询通讯录异常");
        }
        return restP;
    }

    @RequestMapping(value = "/pageRecordForCase.htm")
    @ResponseBody
    public RestResponse pageRecordForCase(int caseId, PageView<CallRecordModel> pageView) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        try {
            //分页查询用户案例
            CallResultQueryPageOrder callResultQueryPageOrder = new CallResultQueryPageOrder();
            PageList<CallRecordModel> pageList = callRecordComponent.listRecordByCaseId((CallResultQueryPageOrder) BuildQuery.buildQuery(pageView, callResultQueryPageOrder));
            //构建返回结果
            PageList<CallRecordModel> recordList = PageList.getInstance(pageList.getDatas(), pageList.getPage());
            List<CallRecordModel> callRecordModelList = recordList.getDatas();
            List<CaseInfoVo> caseInfoVoList = new ArrayList<CaseInfoVo>();
            if (callRecordModelList != null && callRecordModelList.size() > 0) {
                for (CallRecordModel contactInfoModel : callRecordModelList) {
                    CallRecordVo callRecordVo = new CallRecordVo();
                    BeanUtils.copyProperties(callRecordVo, contactInfoModel);
                }
            }
            PageView<CaseInfoVo> voPageView = new PageView<CaseInfoVo>();
            voPageView.setRowCount(pageList.getPage().getRowCount());
            voPageView.setRecords(caseInfoVoList);
            restP.setResult(voPageView);
        } catch (Exception e) {
            LogUtil.error(logger, e, "查询通话记录异常");
            return ResponseUtil.buildExpResponse("SYSTEM_ERROR", "查询通话记录异常");
        }
        return restP;
    }

    /**
     * 保存催收结果
     *
     * @param callRecordModel
     * @return
     */
    @RequestMapping("/saveCallRecord")
    @ResponseBody
    public RestResponse saveCallRecord(CallRecordModel callRecordModel) {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        //??????????
        callRecordComponent.saveCallRecord(callRecordModel);
        ContactInfoModel contactInfoModel = new ContactInfoModel();
        //???????????????????call result, call_times +1
        contactInfoModel.setContactId(callRecordModel.getContactId());
        contactInfoModel.setCallResult(callRecordModel.getCallResult());
        contactInfoComponent.updateContactForCallRecord(contactInfoModel);
        return restP;
    }

    @RequestMapping("/getTwoResultMap.htm")
    @ResponseBody
    public RestResponse getTwoResultMap() {
        RestResponse restP = ResponseUtil.buildSuccessResponse();
        Map<Integer, String> callResultMap = new HashMap<Integer, String>();
        Map<Integer, String> caseResultMap = new HashMap<Integer, String>();
        for (CallResultEnum callResultEnum : CallResultEnum.values()) {
            callResultMap.put(callResultEnum.getCode(), callResultEnum.getName());
        }
        for (CaseResultEnum caseResultEnum : CaseResultEnum.values()) {
            caseResultMap.put(caseResultEnum.getCode(), caseResultEnum.getName());
        }
        return restP;
    }
}
