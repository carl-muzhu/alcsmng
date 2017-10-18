package com.yylc.web.controller.enums.workbench;

/**
 * Created by yylc-y01909 on 2017/10/16.
 */
public enum SortOfRuleEnum {
    HZ_MO(0, "杭州m0"),
    NC_MO(1, "南昌m0"),
    ZZ_MO(2, "枣庄m0"),
    HZ_CALL_AFTER_LOAN(3, "杭州贷后回访"),
    NC_CALL_AFTER_LOAN(4, "南昌贷后回访"),
    ZZ_CALL_AFTER_LOAN(5, "枣庄贷后回访");

    private Integer code;
    private String name;

    SortOfRuleEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    SortOfRuleEnum(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
