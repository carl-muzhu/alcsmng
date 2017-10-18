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
 * @version $Id: EnumOptFunction.java, v 0.1 2014年9月17日 上午11:33:21 yylc025 Exp $
 */
public class EnumOptFunction {

    private static Logger               logger  = Logger.getLogger(EnumOptFunction.class);

    public static Map<String, Class<?>> enumMap = new HashMap<String, Class<?>>();

    static {
        //enumMap.put("auditStatusEnum", AuditStatusEnum.class);


    }

    /**
     * 按照枚举的code返回该枚举message
     * 
     * @param enumName
     *            枚举类Key值
     * @param code
     *            枚举对象code
     * @return 当前枚举message
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
                MessageFormat.format("当前枚举定义{0}，枚举项{1}无定义.", new Object[] { enumName, code }), e);
        }
        return result;
    }

    /**
     * 列举指定枚举定义的所有对象
     * 
     * @param enumName
     *            枚举类Key值
     * @return 枚举对象列表
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
            logger.error(MessageFormat.format("当前枚举定义{0}无定义.", new Object[] { enumName }), e);
        }
        return result;
    }

    /**
     * 列举指定枚举定义的某一类别的对象集合
     * 
     * @param enumName 枚举类Key值
     * @param parentType 指定类别
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
            logger.error(MessageFormat.format("当前枚举定义{0}无定义.", new Object[] { enumName }), e);
        }
        return result;
    }

    public static void main(String[] args) {
        // 按照枚举的code返回该枚举message
        System.out.println(enumCodeOf("linkerRelateTypeEnum", "PARENTS"));

        // 列举指定枚举定义的所有对象
        System.out.println(enumList("linkerRelateTypeEnum"));

        // 列举指定枚举定义的某一类别的对象集合
        System.out.println(enumList("linkerRelateTypeEnum", "FAMILY"));
    }
}
