/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2014 All Rights Reserved.
 */
package com.yylc.alcsmng.common.tags;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


/**
 * 
 * @author wenbing.zhang
 * @version $Id: EnumOptFunction.java, v 0.1 2014��9��17�� ����11:33:21 yylc025 Exp $
 */
public class EnumOptFunction {

    private static Logger               logger  = Logger.getLogger(EnumOptFunction.class);

    public static Map<String, Class<?>> enumMap = new HashMap<String, Class<?>>();

    static {
        //enumMap.put("auditStatusEnum", AuditStatusEnum.class);


    }

    /**
     * ����ö�ٵ�code���ظ�ö��message
     * 
     * @param enumName
     *            ö����Keyֵ
     * @param code
     *            ö�ٶ���code
     * @return ��ǰö��message
     */
    public static String enumCodeOf(String enumName, String code) {
        String result = null;
        try {
            Class<?> clazz = enumMap.get(enumName);
            Method method = clazz.getDeclaredMethod("getCode");
            Method method2 = clazz.getDeclaredMethod("getMessage");
            if (clazz.isEnum()) {
                List<?> list = Arrays.asList(clazz.getEnumConstants());
                String temp = null;
                for (Object enu : list) {
                    temp = (String) method.invoke(enu);
                    if (temp.equals(code)) {
                        result = (String) method2.invoke(enu);
                    }
                }
            }
        } catch (Throwable e) {
            logger.error(
                MessageFormat.format("��ǰö�ٶ���{0}��ö����{1}�޶���.", new Object[] { enumName, code }), e);
        }
        return result;
    }

    /**
     * �о�ָ��ö�ٶ�������ж���
     * 
     * @param enumName
     *            ö����Keyֵ
     * @return ö�ٶ����б�
     */
    public static List<EnumDefineClass> enumList(String enumName) {
        List<EnumDefineClass> result = new ArrayList<EnumDefineClass>();
        try {
            Class<?> clazz = enumMap.get(enumName);
            Method method = clazz.getDeclaredMethod("getCode");
            Method method2 = clazz.getDeclaredMethod("getMessage");

            EnumDefineClass temp = null;
            if (clazz.isEnum()) {
                List<?> list = Arrays.asList(clazz.getEnumConstants());
                for (Object enu : list) {
                    temp = new EnumDefineClass();
                    temp.setCode((String) method.invoke(enu));
                    temp.setMessage((String) method2.invoke(enu));
                    result.add(temp);
                }
            }
        } catch (Throwable e) {
            logger.error(MessageFormat.format("��ǰö�ٶ���{0}�޶���.", new Object[] { enumName }), e);
        }
        return result;
    }

    /**
     * �о�ָ��ö�ٶ����ĳһ���Ķ��󼯺�
     * 
     * @param enumName ö����Keyֵ
     * @param parentType ָ�����
     * @return
     */
    public static List<EnumDefineClass> enumList(String enumName, String type) {
        List<EnumDefineClass> result = new ArrayList<EnumDefineClass>();
        try {
            Class<?> clazz = enumMap.get(enumName);
            Method method = clazz.getDeclaredMethod("getCode");
            Method method2 = clazz.getDeclaredMethod("getMessage");
            Method method3 = clazz.getDeclaredMethod("getType");

            EnumDefineClass temp = null;
            if (clazz.isEnum()) {
                List<?> list = Arrays.asList(clazz.getEnumConstants());
                for (Object enu : list) {
                    if (type != null && type.equals((String) method3.invoke(enu))) {
                        temp = new EnumDefineClass();
                        temp.setCode((String) method.invoke(enu));
                        temp.setMessage((String) method2.invoke(enu));
                        result.add(temp);
                    }
                }
            }
        } catch (Throwable e) {
            logger.error(MessageFormat.format("��ǰö�ٶ���{0}�޶���.", new Object[] { enumName }), e);
        }
        return result;
    }

    public static void main(String[] args) {
        // ����ö�ٵ�code���ظ�ö��message
        System.out.println(enumCodeOf("linkerRelateTypeEnum", "PARENTS"));

        // �о�ָ��ö�ٶ�������ж���
        System.out.println(enumList("linkerRelateTypeEnum"));

        // �о�ָ��ö�ٶ����ĳһ���Ķ��󼯺�
        System.out.println(enumList("linkerRelateTypeEnum", "FAMILY"));
    }
}
