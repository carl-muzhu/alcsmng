package com.yylc.dwdataservice.core.model.convert;

import com.yylc.alcsmng.common.dal.dataobject.RuleInfoDO;
import com.yylc.dwdataservice.core.model.RuleInfoModel;

import java.text.SimpleDateFormat;

/**
 * Created by yylc-y01909 on 2017/10/16.
 */
public class RuleInfoConverter {
    /**
     * do convert to model
     *
     * @param ruleInfoDO
     * @return
     */
    public static RuleInfoModel convertDOToModel(RuleInfoDO ruleInfoDO) {
        if (ruleInfoDO == null) {
            return null;
        }
        RuleInfoModel ruleInfoModel = new RuleInfoModel();
        ruleInfoModel.setRuleId(ruleInfoDO.getRuleId());
        ruleInfoModel.setTeamLeaderIds(ruleInfoDO.getTeamLeaderIds());
        ruleInfoModel.setUserIds(ruleInfoDO.getUserIds());
        ruleInfoModel.setLocationCode(ruleInfoDO.getLocationCode());
        ruleInfoModel.setDeptCode(ruleInfoDO.getDeptCode());
        ruleInfoModel.setRuleName(ruleInfoDO.getRuleName());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            ruleInfoModel.setCreateTime(format.format(ruleInfoDO.getCreateTime()));
            ruleInfoModel.setUpdateTime(format.format(ruleInfoDO.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ruleInfoModel;
    }

    public static RuleInfoDO convertModelToDO(RuleInfoModel ruleInfoModel) {
        if (ruleInfoModel == null) {
            return null;
        }
        RuleInfoDO ruleInfoDO = new RuleInfoDO();
        ruleInfoDO.setRuleId(ruleInfoModel.getRuleId());
        ruleInfoDO.setTeamLeaderIds(ruleInfoModel.getTeamLeaderIds());
        ruleInfoDO.setUserIds(ruleInfoModel.getUserIds());
        ruleInfoDO.setLocationCode(ruleInfoModel.getLocationCode());
        ruleInfoDO.setDeptCode(ruleInfoModel.getDeptCode());
        ruleInfoDO.setRuleName(ruleInfoModel.getRuleName());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            ruleInfoDO.setCreateTime(format.parse(ruleInfoModel.getCreateTime()));
            ruleInfoDO.setUpdateTime(format.parse(ruleInfoModel.getUpdateTime()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ruleInfoDO;
    }
}
