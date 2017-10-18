package com.yylc.web.vo.rep;

import com.yylc.platform.common.base.ToString;

/**
 * Created by yylc-y01909 on 2017/10/17.
 */
public class RuleInfoVo extends ToString {
    private static final long serialVersionUID = 4743816301689751115L;

    private int ruleId;//规则id
    private String teamLeaderNames;//组长姓名用逗号分隔
    private String userNames;//组员姓名用逗号分隔
    private String locationName;//位置
    private String deptName;//可是名称(0,m0;1,贷后回访)
    private String ruleName;//规则名称
    private String createTime;//创建时间
    private String updateTime;//更新时间


    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public String getTeamLeaderNames() {
        return teamLeaderNames;
    }

    public void setTeamLeaderNames(String teamLeaderNames) {
        this.teamLeaderNames = teamLeaderNames;
    }

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
