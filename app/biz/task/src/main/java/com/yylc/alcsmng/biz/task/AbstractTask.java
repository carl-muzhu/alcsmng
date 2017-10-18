/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2013 All Rights Reserved.
 */
package com.yylc.alcsmng.biz.task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;

import com.yylc.common.lang.StringUtils;
import com.yylc.platform.common.helper.TimeKey;
import com.yylc.platform.common.utils.LogUtil;

/**
 * ����task������
 * 
 * @author qiang.wq
 * @version $Id: AbstractTask.java, v 0.1 2013-10-30 ����5:14:02 WJL Exp $
 */
public abstract class AbstractTask {

    /** logger  */
    private static final Logger                         logger   = Logger
                                                                     .getLogger(AbstractTask.class);

    /** �̷߳��ظ�ִ�й���    */
    protected static final Map<Class<?>, AtomicBoolean> lockMaps = new ConcurrentHashMap<Class<?>, AtomicBoolean>();

    /**
     * ����ִ��,����TimeKey,�������taskִ��ҵ��״��
     */
    public void execute() {
        try {
            if (!preProcess()) {
                LogUtil.warn(logger, this.getClass().getSimpleName() + "ִ���նˣ�ԭ������taskִ����...");
                return;
            }

            if (canProcess()) {
                LogUtil.info(logger, "��ʼִ��task,taskName=>" + this.getClass().getSimpleName());
                process();
            }
        } catch (Throwable e) {
            LogUtil.error(logger, "ִ��task�쳣,taskName=>" + this.getClass().getSimpleName(), e);
        } finally {
            afterProcess();
        }
    }

    /**
     * ҵ����ǰ���ж�
     */
    protected abstract boolean canProcess();

    /**
     * ҵ����
     */
    protected abstract void process();

    /**
     * ��ӡinfo��־
     * 
     * @param message
     */
    protected void printInfoLog(String message) {
        if (StringUtils.isNotBlank(message)) {
            LogUtil.info(logger, message);
        }
    }

    /**
     * taskִ��ǰ�� 
     * <pre>
     *      �����ظ�ִ�д���,�״�ִ�������ִ��class,�ٴ�ִ�оܾ�
     * </pre>
     * 
     * @return
     */
    protected boolean preProcess() {
        // ����ʱ���
        TimeKey.start();
        printInfoLog("ִ�� " + this.getClass().getSimpleName() + " ��ʼ...");
        //�����ǰ��ֵΪtrue��ʾ����ִ�д�task,����״̬��Ϊfalse����ִ��״̬
        if (!lockMaps.containsKey(this.getClass())) {
            lockMaps.put(this.getClass(), new AtomicBoolean(true));
            return true;
        }
        return false;
    }

    /**
     * ɾ��ִ������
     */
    protected void afterProcess() {
        printInfoLog("ִ�� " + this.getClass().getSimpleName() + " ����...");

        //�����ǰ���ڲ���ִ��״̬,������Ϊ��ִ��״̬,��ʾ��ǰ�߳���ִ����,�������������߳�����ִ��
        lockMaps.remove(this.getClass());
        // ���ʱ���
        TimeKey.clear();
    }

}
