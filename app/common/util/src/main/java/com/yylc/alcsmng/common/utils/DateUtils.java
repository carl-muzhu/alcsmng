/**
 * DocardCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yylc.alcsmng.common.utils;

import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 
 * @author osmund
 * 
 * @version $Id: DateUtils.java, v 0.1 2013-4-27 ����2:11:45 WJL Exp $
 */
public class DateUtils extends BasicDateUtils {

    private final static Logger log = Logger.getLogger(DateUtils.class);

    /**
     * ���ݳ������ڼ�������
     * 
     * @param birthday
     * @return
     */
    public static int getAgeByBirthday(Date birthday) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthday)) {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }

    /** 
     * �жϸ��������Ƿ�Ϊ��ĩ��һ�� 
     * 
     * @param date 
     * @return true:��|false:���� 
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
        if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }

    //�����ǰʱ���ڵ���26��֮ǰ����ô��ʼʱ��ȡ����26�ţ�����ȡ����26��
    public static Date getStartDateByPerf() {
        Date fisrtDay = getMonthFirstDay();
        if (getDiffDays(new Date(), fisrtDay) < 25) {
            return addDays(com.yylc.common.lang.DateUtils.addMonths(fisrtDay, -1), 25);
        } else {
            return addDays(fisrtDay, 25);
        }
    }

    /**
     * ����������
     * 
     * @return
     */
    public static Date getLastWeekSunday() {
        Calendar date = Calendar.getInstance(Locale.CHINA);
        date.setFirstDayOfWeek(Calendar.MONDAY);//��ÿ�ܵ�һ����Ϊ����һ��Ĭ����������
        date.add(Calendar.WEEK_OF_MONTH, -1);//������һ��������
        date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//������Ϊ������
        return date.getTime();
    }

    // ��õ�ǰ�����뱾������������
    public static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // ��ý�����һ�ܵĵڼ��죬�������ǵ�һ�죬���ڶ��ǵڶ���......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; //��Ϊ���й����һ ��Ϊ��һ�����������1
        if (dayOfWeek == 1) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }

    // �����һ������һ������
    public static Date getPreviousIWeekdayMonday(int i, int mondayPlus) {
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * i);
        return currentDate.getTime();

    }

}
