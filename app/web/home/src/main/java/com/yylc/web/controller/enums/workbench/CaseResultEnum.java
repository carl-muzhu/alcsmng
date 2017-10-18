package com.yylc.web.controller.enums.workbench;

/**
 * Created by yylc-y01909 on 2017/10/13.
 */
public enum CaseResultEnum {

    NO_CONTACT_ON(0, "ʧ��"),
    REFUSE_TO_REPAY(1, "�ܾ�����"),
    PROMISE_TO_REPAY(2, "��ŵ����");

    private Integer code;
    private String name;

    CaseResultEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    CaseResultEnum(String name) {
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
