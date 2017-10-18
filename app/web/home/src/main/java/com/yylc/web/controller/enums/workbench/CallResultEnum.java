package com.yylc.web.controller.enums.workbench;

/**
 * Created by yylc-y01909 on 2017/10/13.
 */
public enum CallResultEnum {
    USER_ANSWER_CALL(0, "接听"),
    USER_CALL_BUSY(1, "占线"),
    USER_CALL_SHUTDOWN(2, "关机"),
    USER_CALL_STOP(3, "停机"),
    INVALID_PHONE_NUM(4, "空号"),
    USER_NOT_ANSWER(5, "未接听"),
    TELL_TO_REPAY(6, "转告还款"),
    REFUSE_TO_REPAY(7, "拒绝还款");

    private Integer code;
    private String name;

    CallResultEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    CallResultEnum(String name) {
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
