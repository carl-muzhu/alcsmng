/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2016 All Rights Reserved.
 */
package com.yylc.alcsmng.common.utils;

import java.util.Date;

/**
 * �汾�����࣬�������ɾ�̬��Դ�汾��
 * @author herong
 * @version $Id: StaticVersionUtil.java, v 0.1 2016��6��17�� ����5:26:37 herong Exp $
 */
public class StaticVersionUtil {
    private final static String timestampt = String.valueOf(new Date().getTime());

    @Override
    public String toString() {
        return timestampt;
    }
}
