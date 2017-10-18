/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2015 All Rights Reserved.
 */

package com.yylc.alcsmng.common.service.intergration.enums;

import com.yylc.common.lang.StringUtils;
import com.yylc.platform.common.enums.EnumBase;

/**
 * �����ʲ����Ĳ������ö��
 * 
 * @author dehong.liu
 * @version $Id: AccsettlecoreResultCodeEnum.java, v 0.1 2016��3��31�� ����3:10:58 liudehong Exp $
 */
public enum AlcsResultCodeEnum implements EnumBase {

    /** �����ɹ� */
    SUCCESS("SUCCESS", "�����ɹ�"),

    /** ϵͳ�쳣*/
    SYSTEM_ERROR("SYSTEM_ERROR", "ϵͳ�쳣������ϵ����Ա��"),

    /** �ⲿ�ӿڵ����쳣*/
    INTERFACE_SYSTEM_ERROR("INTERFACE_SYSTEM_ERROR", "�ⲿ�ӿڵ����쳣������ϵ����Ա��"),

    /** ҵ�����Ӵ���ʱ */
    CONNECT_TIME_OUT("CONNECT_TIME_OUT", "ϵͳ��ʱ�����Ժ�����!"),

    /** ϵͳ���� */
    SYSTEM_FAILURE("SYSTEM_FAILURE", "ϵͳ����"),

    /** �Ƿ����� */
    ILLEGAL_OPERATION("ILLEGAL_OPERATION", "�Ƿ�����"),

    /** ����Ϊ�� */
    NULL_ARGUMENT("NULL_ARGUMENT", "����Ϊ��"),

    /** �û�idΪ�� */
    NULL_USERID("NULL_USERID", "��ԱidΪ��!"),

    /** ����Ϊ�� */
    NULL_OBJECT("NULL_OBJECT", "����Ϊ��"),

    /** ��������ȷ */
    ILLEGAL_ARGUMENT("ILLEGAL_ARGUMENT", "��������ȷ"),

    /** �߼����� */
    LOGIC_ERROR("LOGIC_ERROR", "�߼�����"),

    /** �����쳣 */
    DATA_ERROR("DATA_ERROR", "�����쳣"),

    /** ���Ϊ���쳣*/
    NEGATIVE_AMOUNT_ERROR("NEGATIVE_AMOUNT_ERROR", "���Ϊ���쳣"),

    /** Ԥ�����״̬����*/
    UNEXPECTED_STATUS_ERROR("UNEXPECTED_STATUS_ERROR", "Ԥ�����״̬����"),

    /**ϵͳ����δ����*/
    SYS_CONFIG_NOT_INIT("SYS_CONFIG_NOT_INIT", "ϵͳ����δ����"),

    /**����ʧ��*/
    CREATE_FAIL("CREATE_FAIL", "����ʧ��"),

    /**�޸�ʧ��*/
    MODIFY_FAIL("MODIFY_FAIL", "�޸�ʧ��"),

    /**ɾ��ʧ��*/
    REMOVE_FAIL("REMOVE_FAIL", "ɾ��ʧ��"),

    ;

    /** ö�ٱ�� */
    private String code;

    /** ö������ */
    private String message;

    /**
     * ���췽��
     * 
     * @param code         ö�ٱ��
     * @param message      ö������
     */
    private AlcsResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * ͨ��ö��<code>code</code>���ö�١�
     * @param code ö��ֵ
     * @return  ��������ڷ���NUll<br/>������ڷ������ֵ
     */
    public static final AlcsResultCodeEnum codeOf(String code) {

        //���ΪNUll���� NUll
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (AlcsResultCodeEnum item : values()) {
            if (StringUtils.equals(item.getCode(), code)) {
                return item;
            }
        }

        return null;
    }

    /**
     * Setter method for property <tt>message</tt>.
     * 
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /** 
     * @see EnumBase#message()
     */
    @Override
    public String message() {
        return message;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     * 
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /** 
     * @see EnumBase#value()
     */
    @Override
    public Number value() {
        return null;
    }

}
