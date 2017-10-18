/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2016 All Rights Reserved.
 */
package com.yylc.web.controller.utils;

/**
 * 
 * @author c.zanda
 * @version $Id: MysqlSubPage.java, v 0.1 2016年4月21日 下午2:32:25 c.zanda Exp $
 */
public class MysqlSubPage {
    private int offset;
    private int limit;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
