/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2015 All Rights Reserved.
 */

package com.yylc.alcsmng.common.service.intergration.enums;

import com.yylc.common.lang.StringUtils;
import com.yylc.platform.common.enums.EnumBase;

/**
 * 特殊资产核心操作结果枚举
 * 
 * @author dehong.liu
 * @version $Id: AccsettlecoreResultCodeEnum.java, v 0.1 2016年3月31日 下午3:10:58 liudehong Exp $
 */
public enum AlcsResultCodeEnum implements EnumBase {

    /** 操作成功 */
    SUCCESS("SUCCESS", "操作成功"),

    /** 系统异常*/
    SYSTEM_ERROR("SYSTEM_ERROR", "系统异常，请联系管理员！"),

    /** 外部接口调用异常*/
    INTERFACE_SYSTEM_ERROR("INTERFACE_SYSTEM_ERROR", "外部接口调用异常，请联系管理员！"),

    /** 业务连接处理超时 */
    CONNECT_TIME_OUT("CONNECT_TIME_OUT", "系统超时，请稍后再试!"),

    /** 系统错误 */
    SYSTEM_FAILURE("SYSTEM_FAILURE", "系统错误"),

    /** 非法操作 */
    ILLEGAL_OPERATION("ILLEGAL_OPERATION", "非法操作"),

    /** 参数为空 */
    NULL_ARGUMENT("NULL_ARGUMENT", "参数为空"),

    /** 用户id为空 */
    NULL_USERID("NULL_USERID", "会员id为空!"),

    /** 对象为空 */
    NULL_OBJECT("NULL_OBJECT", "对象为空"),

    /** 参数不正确 */
    ILLEGAL_ARGUMENT("ILLEGAL_ARGUMENT", "参数不正确"),

    /** 逻辑错误 */
    LOGIC_ERROR("LOGIC_ERROR", "逻辑错误"),

    /** 数据异常 */
    DATA_ERROR("DATA_ERROR", "数据异常"),

    /** 金额为负异常*/
    NEGATIVE_AMOUNT_ERROR("NEGATIVE_AMOUNT_ERROR", "金额为负异常"),

    /** 预期外的状态错误*/
    UNEXPECTED_STATUS_ERROR("UNEXPECTED_STATUS_ERROR", "预期外的状态错误"),

    /**系统参数未配置*/
    SYS_CONFIG_NOT_INIT("SYS_CONFIG_NOT_INIT", "系统参数未配置"),

    /**保存失败*/
    CREATE_FAIL("CREATE_FAIL", "保存失败"),

    /**修改失败*/
    MODIFY_FAIL("MODIFY_FAIL", "修改失败"),

    /**删除失败*/
    REMOVE_FAIL("REMOVE_FAIL", "删除失败"),

    ;

    /** 枚举编号 */
    private String code;

    /** 枚举详情 */
    private String message;

    /**
     * 构造方法
     * 
     * @param code         枚举编号
     * @param message      枚举详情
     */
    private AlcsResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过枚举<code>code</code>获得枚举。
     * @param code 枚举值
     * @return  如果不存在返回NUll<br/>如果存在返回相关值
     */
    public static final AlcsResultCodeEnum codeOf(String code) {

        //如果为NUll返回 NUll
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
