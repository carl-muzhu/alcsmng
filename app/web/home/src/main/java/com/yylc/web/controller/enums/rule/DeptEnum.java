package com.yylc.web.controller.enums.rule;

/**
 * Created by yylc-y01909 on 2017/10/17.
 */
public enum DeptEnum {
    DEPT_M0(0, "MO"),
    DEPT_VISIT_AFTER_LOAN(1, "´ûºó»Ø·Ã");

    private Integer code;
    private String name;

    DeptEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    DeptEnum(String name) {
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

    public static String getNameByCode(int code) {
        for (DeptEnum locationAndTypeEnum : DeptEnum.values()) {
            if (code == locationAndTypeEnum.getCode()) {
                return locationAndTypeEnum.getName();
            }
        }
        return null;
    }
}
