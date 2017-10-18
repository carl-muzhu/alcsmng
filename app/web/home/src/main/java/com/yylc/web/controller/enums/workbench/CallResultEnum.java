package com.yylc.web.controller.enums.workbench;

/**
 * Created by yylc-y01909 on 2017/10/13.
 */
public enum CallResultEnum {
    USER_ANSWER_CALL(0, "����"),
    USER_CALL_BUSY(1, "ռ��"),
    USER_CALL_SHUTDOWN(2, "�ػ�"),
    USER_CALL_STOP(3, "ͣ��"),
    INVALID_PHONE_NUM(4, "�պ�"),
    USER_NOT_ANSWER(5, "δ����"),
    TELL_TO_REPAY(6, "ת�滹��"),
    REFUSE_TO_REPAY(7, "�ܾ�����");

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
