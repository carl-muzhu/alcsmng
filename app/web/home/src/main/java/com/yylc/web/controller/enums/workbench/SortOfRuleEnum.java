package com.yylc.web.controller.enums.workbench;

/**
 * Created by yylc-y01909 on 2017/10/16.
 */
public enum SortOfRuleEnum {
    HZ_MO(0, "����m0"),
    NC_MO(1, "�ϲ�m0"),
    ZZ_MO(2, "��ׯm0"),
    HZ_CALL_AFTER_LOAN(3, "���ݴ���ط�"),
    NC_CALL_AFTER_LOAN(4, "�ϲ�����ط�"),
    ZZ_CALL_AFTER_LOAN(5, "��ׯ����ط�");

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
