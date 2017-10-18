package com.yylc.web.controller.enums.rule;

/**
 * Created by yylc-y01909 on 2017/10/17.
 */
public enum LocationEnum {
    LOCATION_HZ(0, "º¼ÖÝ"),
    LOCATION_NC(1, "ÄÏ²ý"),
    LOCATION_ZZ(2, "Ôæ×¯");

    private Integer code;
    private String name;

    LocationEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    LocationEnum(String name) {
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
        for (LocationEnum locationAndTypeEnum : LocationEnum.values()) {
            if (code == locationAndTypeEnum.getCode()) {
                return locationAndTypeEnum.getName();
            }
        }
        return null;
    }
}
