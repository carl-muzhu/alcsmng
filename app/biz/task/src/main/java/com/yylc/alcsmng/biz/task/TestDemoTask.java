/**
 * binguolife.com Inc.
 * Copyright (c) 2013-2017 All Rights Reserved.
 */
package com.yylc.alcsmng.biz.task;

import org.apache.log4j.Logger;

import com.yylc.platform.common.helper.SystemHelper;
import com.yylc.platform.common.utils.LogUtil;

/**
 * ���r����demo
 * 
 * @author qiang.wq
 * @version $Id: TestDemoTask.java, v 0.1 2017��9��27�� ����1:06:04 qiang.wq Exp $
 */
public class TestDemoTask extends AbstractTask {

    /** logger  */
    private static final Logger logger = Logger.getLogger(TestDemoTask.class);

    /** 
     * ָ��TASK�������ſ������У�TODO δ���л�ֵ����ƽ̨���ߣ�
     * 
     * @see com.yylc.alcsmng.biz.task.AbstractTask#canProcess()
     */
    @Override
    protected boolean canProcess() {
        return SystemHelper.isTaskServer();
    }

    /** 
     * @see com.yylc.alcsmng.biz.task.AbstractTask#process()
     */
    @Override
    protected void process() {
        LogUtil.info(logger, "===============start TestDemoTask process =========================");

        LogUtil.info(logger, "===============en TestDemoTask process =========================");
    }

}
