package com.yylc.dwdataservice.core.model;

import com.yylc.platform.common.base.ToString;

import java.util.Date;

/**
 * Created by yylc-y01909 on 2017/10/16.
 */
public class RuleInfoModel extends ToString {
    private static final long serialVersionUID = 741232958441822681L;

    //========== properties ==========

    /**
     * This property corresponds to db column <tt>rule_id</tt>.
     */
    private int ruleId;

    /**
     * This property corresponds to db column <tt>team_leader_ids</tt>.
     */
    private String teamLeaderIds;

    /**
     * This property corresponds to db column <tt>user_ids</tt>.
     */
    private String userIds;

    /**
     * This property corresponds to db column <tt>location_code</tt>.
     */
    private int locationCode;

    /**
     * This property corresponds to db column <tt>dept_code</tt>.
     */
    private int deptCode;

    /**
     * This property corresponds to db column <tt>rule_name</tt>.
     */
    private String ruleName;

    /**
     * This property corresponds to db column <tt>create_time</tt>.
     */
    private String createTime;

    /**
     * This property corresponds to db column <tt>update_time</tt>.
     */
    private String updateTime;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>ruleId</tt>.
     *
     * @return property value of ruleId
     */
    public int getRuleId() {
        return ruleId;
    }

    /**
     * Setter method for property <tt>ruleId</tt>.
     *
     * @param ruleId value to be assigned to property ruleId
     */
    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * Getter method for property <tt>teamLeaderIds</tt>.
     *
     * @return property value of teamLeaderIds
     */
    public String getTeamLeaderIds() {
        return teamLeaderIds;
    }

    /**
     * Setter method for property <tt>teamLeaderIds</tt>.
     *
     * @param teamLeaderIds value to be assigned to property teamLeaderIds
     */
    public void setTeamLeaderIds(String teamLeaderIds) {
        this.teamLeaderIds = teamLeaderIds;
    }

    /**
     * Getter method for property <tt>userIds</tt>.
     *
     * @return property value of userIds
     */
    public String getUserIds() {
        return userIds;
    }

    /**
     * Setter method for property <tt>userIds</tt>.
     *
     * @param userIds value to be assigned to property userIds
     */
    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    /**
     * Getter method for property <tt>locationCode</tt>.
     *
     * @return property value of locationCode
     */
    public int getLocationCode() {
        return locationCode;
    }

    /**
     * Setter method for property <tt>locationCode</tt>.
     *
     * @param locationCode value to be assigned to property locationCode
     */
    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }

    /**
     * Getter method for property <tt>deptCode</tt>.
     *
     * @return property value of deptCode
     */
    public int getDeptCode() {
        return deptCode;
    }

    /**
     * Setter method for property <tt>deptCode</tt>.
     *
     * @param deptCode value to be assigned to property deptCode
     */
    public void setDeptCode(int deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * Getter method for property <tt>ruleName</tt>.
     *
     * @return property value of ruleName
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * Setter method for property <tt>ruleName</tt>.
     *
     * @param ruleName value to be assigned to property ruleName
     */
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    /**
     * Getter method for property <tt>createTime</tt>.
     *
     * @return property value of createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Setter method for property <tt>createTime</tt>.
     *
     * @param createTime value to be assigned to property createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter method for property <tt>updateTime</tt>.
     *
     * @return property value of updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * Setter method for property <tt>updateTime</tt>.
     *
     * @param updateTime value to be assigned to property updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
