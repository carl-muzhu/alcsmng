/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2014 All Rights Reserved.
 */
package com.yylc.alcsmng.common.tags;

import java.io.Serializable;

/**
 * 
 * @author wenbing.zhang
 * @version $Id: EnumDefineClass.java, v 0.1 2014年9月17日 上午11:38:51 yylc025 Exp $
 */
public class EnumDefineClass implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 7895911287376866283L;

    private String code;
    
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    }
