package com.yylc.alcsmng.biz.task;

import com.yylc.alcsmng.core.service.AssignInfoComponent;
import com.yylc.alcsmng.core.service.AssignLogComponent;
import com.yylc.alcsmng.core.service.CaseInfoComponent;
import com.yylc.alcsmng.core.service.RuleInfoComponent;
import com.yylc.dwdataservice.core.model.AssignInfoModel;
import com.yylc.dwdataservice.core.model.AssignLogModel;
import com.yylc.dwdataservice.core.model.CaseInfoModel;
import com.yylc.dwdataservice.core.model.RuleInfoModel;
import com.yylc.platform.common.helper.SystemHelper;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yylc-y01909 on 2017/10/13.
 */
public class AutoAssignTask extends AbstractTask {
    protected static final Logger logger = Logger.getLogger(AutoAssignTask.class);

    @Resource
    private CaseInfoComponent caseInfoComponent;
    @Resource
    private RuleInfoComponent ruleInfoComponent;
    @Resource
    private AssignInfoComponent assignInfoComponent;
    @Resource
    private AssignLogComponent assignLogComponent;

    /**
     * ҵ����ǰ���ж�
     */
    @Override
    protected boolean canProcess() {
        return SystemHelper.isTaskServer();
    }

    /**
     * ҵ����
     */
    @Override
    protected void process() {
        logger.warn("�Զ��ְ�����ʼ");
        try {
            //ȡ�������ѯδ���尸��
            List<CaseInfoModel> caseInfoModelList = caseInfoComponent.queryCaseNotClosed();
            //��������ʱ��
            if (caseInfoModelList != null && caseInfoModelList.size() > 0) {
                for (CaseInfoModel caseInfoModel : caseInfoModelList) {
                    caseInfoModel.setDaysOverdue(computeOverdueDays(caseInfoModel.getRepayTime()));
                    caseInfoModelList.add(caseInfoModel);
                }
                for (CaseInfoModel caseInfoModel : caseInfoModelList) {
                    caseInfoComponent.updateCaseForDaysOverdue(caseInfoModel);
                }
            }
            //ȡ��M1ʱ������case���ְ�
            List<CaseInfoModel> m1CaseList = caseInfoComponent.queryCaseForM1();
//            List<RuleInfoModel> ruleInfoModelList = ruleInfoComponent.queryRuleByLocationCode(1);
//            if (m1CaseList != null && m1CaseList.size() > 0 && ruleInfoModelList != null && ruleInfoModelList.size() > 0) {
//                List<AssignInfoModel> newAssignList = generateNewAssign(m1CaseList, ruleInfoModelList);
//                deleteAssignInfo(m1CaseList);
//                saveAssignInfo(newAssignList);
//                saveAssignLogForInfo(newAssignList);
//            }

        } catch (Exception e) {

        }
    }

    /**
     * ������������
     *
     * @param repayTime
     * @return
     */
    public int computeOverdueDays(String repayTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
        Date repayTime0 = format.parse(repayTime);
        Date nowTime = new Date();
        int overdueDays = (int) ((nowTime.getTime() - repayTime0.getTime()) / (24 * 3600));
        return overdueDays;
    }

    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss").format(new Date()));
    }

    public List<AssignInfoModel> generateNewAssign(List<CaseInfoModel> caseInfoModelList, List<RuleInfoModel> ruleInfoModelList) {
        List<AssignInfoModel> assignInfoModelLsit = new ArrayList<AssignInfoModel>();
        final int RULE_SIZE = ruleInfoModelList.size();
        for (CaseInfoModel caseInfoModel : caseInfoModelList) {
            int index = 0;
            if (caseInfoModel.getCurrentStatus() != 2) {
                AssignInfoModel assignInfoModel = new AssignInfoModel();
                assignInfoModel.setCaseId(caseInfoModel.getCaseId());
//                assignInfoModel.setUserId(ruleInfoModelList.get((index++) % RULE_SIZE).getUserIds());
                assignInfoModelLsit.add(assignInfoModel);
            }
        }
        return assignInfoModelLsit;
    }

    public void saveAssignInfo(List<AssignInfoModel> assignInfoModelList) {
        for (AssignInfoModel assignInfoModel : assignInfoModelList) {
            assignInfoComponent.saveAssignInfo(assignInfoModel);
        }
    }

    public void deleteAssignInfo(List<CaseInfoModel> caseInfoModelList) {
        List<Integer> caseIdList = new ArrayList<Integer>();
        for (CaseInfoModel caseInfoModel : caseInfoModelList) {
            caseIdList.add(caseInfoModel.getCaseId());
        }
        assignInfoComponent.deleteAssignByCaseIdList(caseIdList);
    }

    public void saveAssignLogForInfo(List<AssignInfoModel> assignInfoModelList) {
        List<AssignLogModel> assignLogModelList = new ArrayList<AssignLogModel>();
        for (AssignInfoModel assignInfoModel : assignInfoModelList) {
            AssignLogModel assignLogModel = new AssignLogModel();
            assignInfoModel.setCaseId(assignInfoModel.getCaseId());
            assignInfoModel.setUserId(assignInfoModel.getUserId());
            assignInfoModel.setRemark("������");
            assignLogModelList.add(assignLogModel);
        }
        for (AssignLogModel assignLogModel : assignLogModelList) {
            assignLogComponent.saveAssignLog(assignLogModel);
        }
    }
}
