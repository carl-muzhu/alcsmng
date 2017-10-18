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
 * @version $Id: DateUtils.java, v 0.1 2013-4-27 下午2:11:45 WJL Exp $
 */
public class DateUtils extends BasicDateUtils {

    private final static Logger log = Logger.getLogger(DateUtils.class);

    /**
     * 根据出生日期计算年龄
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
     * 判断给定日期是否为月末的一天 
     * 
     * @param date 
     * @return true:是|false:不是 
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

    //如果当前时间在当月26号之前，那么开始时间取上月26号，否则取本月26号
    public static Date getStartDateByPerf() {
        Date fisrtDay = getMonthFirstDay();
        if (getDiffDays(new Date(), fisrtDay) < 25) {
            return addDays(com.yylc.common.lang.DateUtils.addMonths(fisrtDay, -1), 25);
        } else {
            return addDays(fisrtDay, 25);
        }
    }

    /**
     * 上周日日期
     * 
     * @return
     */
    public static Date getLastWeekSunday() {
        Calendar date = Calendar.getInstance(Locale.CHINA);
        date.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
        date.add(Calendar.WEEK_OF_MONTH, -1);//周数减一，即上周
        date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//日子设为星期天
        return date.getTime();
    }

    // 获得当前日期与本周日相差的天数
    public static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; //因为按中国礼拜一 作为第一天所以这里减1
        if (dayOfWeek == 1) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }

    // 获得上一周星期一的日期
    public static Date getPreviousIWeekdayMonday(int i, int mondayPlus) {
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * i);
        return currentDate.getTime();

    }

}
