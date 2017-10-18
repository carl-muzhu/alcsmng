/**
 * DocardCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yylc.alcsmng.common.utils;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间基础方法（非基础方法需要继承实现）
 * 
 * @author c.zanda
 * @version $Id: DateUtils.java, v 0.1 2016年5月13日 下午8:29:49 c.zanda Exp $
 */
public class BasicDateUtils {

    private final static Logger log                  = Logger.getLogger(BasicDateUtils.class);

    public static final DateUtils INSTANCE             = new DateUtils();

    public final static long      ONE_DAY_SECONDS      = 86400;
    public final static long      ONE_DAY_MILL_SECONDS = 86400000;

    public final static String    LONG_FORMAT          = "yyyy-MM-dd HH:mm:ss";
    public final static String    LONG_FORMAT2         = "yyyy/MM/dd HH:mm:ss";

    public final static String    SHORT_FORMAT         = "yyyy-MM-dd";
    public final static String    SHORT_FORMAT2        = "yyyy/MM/dd";

    public final static String    MMDD_EN              = "MM-dd";
    public final static String    HHMI_EN              = "HH:mm";

    public final static String    YYYYMMDD_CH          = "yyyy年MM月dd日";
    public final static String    MMDD_CH              = "MM月dd日";

    public final static String    YYYYMMDDHHMISS       = "yyyyMMddHHmmss";
    public final static String    YYYYMMDD             = "yyyyMMdd";
    public final static String    YYYYMM               = "yyyyMM";
    public final static String    YYYY                 = "yyyy";
    public final static String    HHMMSS               = "HHmmss";
    public final static String    MM                   = "MM";
    public final static String    DD                   = "dd";
    public final static String    E                    = "E";

    /**
     * 得到当前时间
     * 
     * @return
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 得到DateFormat对象实例
     * 
     * @param pattern
     * @return
     */
    public static DateFormat dateFormatInstance(String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        df.setLenient(false);//严格解析
        return df;
    }

    /**
     * 得到指定时间几月之后的时间
     * 
     * @param date
     * @param months
     * @return
     */
    public static Date addMonths(Date date, int months) {
        return com.yylc.common.lang.DateUtils.addMonths(date, months);
    }

    /**
     * 得到指定时间几天之后的时间
     * 
     * @param date1 日期
     * @param days 天数
     * @return
     */
    public static Date addDays(Date date, long days) {
        return addSeconds(date, days * ONE_DAY_SECONDS);
    }

    /**
     * 得到当前时间几天之后的时间
     * 
     * @param days
     * @return
     */
    public static Date addDays(long days) {
        return addDays(new Date(), days);
    }

    /**
     * 计算指定时间几小时之后的时间
     * 
     * @param date
     * @param hours
     * @return
     */
    public static Date addHours(Date date, long hours) {
        return addMinutes(date, hours * 60);
    }

    /**
     * 计算当前时间几小时之后的时间
     * 
     * @param hours
     * @return
     */
    public static Date addHours(long hours) {
        return addHours(new Date(), hours);
    }

    /**
     * 计算指定时间几分钟之后的时间
     * 
     * @param date
     * @param minutes
     * @return
     */
    public static Date addMinutes(Date date, long minutes) {
        return addSeconds(date, minutes * 60);
    }

    /**
     * 计算当前时间几分钟之后的时间
     * 
     * @param minutes
     * @return
     */
    public static Date addMinutes(int minutes) {
        return addMinutes(new Date(), minutes);
    }

    /**
     * 计算指定时间几秒之后的时间
     * @param seconds
     * @return
     */
    public static Date addSeconds(Date date, long seconds) {
        return new Date(date.getTime() + (seconds * 1000));
    }

    /**
     * 计算当前时间几秒之后的时间
     * 
     * @param seconds
     * @return
     */
    public static Date addSeconds(int seconds) {
        return addSeconds(new Date(), seconds);
    }

    /**
     * 指定格式的字符串日期转换为日期
     * 
     * @param dateStr
     * @param dateFormat
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String dateStr, String dateFormat) throws ParseException {
        if (dateStr == null) {
            return null;
        }
        return dateFormatInstance(dateFormat).parse(dateStr);
    }

    /**
     * 字符串日期为yyyy-MM-dd转换成日期
     * 
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String dateStr) throws ParseException {
        return parseDate(dateStr, SHORT_FORMAT);
    }

    /**
     * 日期转换为指定格式的字符串日期
     * 
     * @param date
     * @return
     */
    public static String formatDate(Date date, String dateFormat) {
        if (date == null || dateFormat == null) {
            return null;
        }
        return dateFormatInstance(dateFormat).format(date);
    }

    /**
     * 日期转换为yyyy-MM-dd的字符串日期
     * 
     * @param date
     * @return
     */
    public static String formatDate(Date date) {

        return formatDate(date, SHORT_FORMAT);
    }

    /**
     * 取得两个日期的间隔天数
     * 
     * @param one
     * @param two
     * @return 间隔天数
     */
    public static long getDiffDays(Date one, Date two) {
        return (one.getTime() - two.getTime()) / ONE_DAY_MILL_SECONDS;
    }

    /**
     * 取得两个日期的间隔小时数
     * 
     * @param one
     * @param two
     * @return 间隔小时数
     */
    public static long getDiffHours(Date one, Date two) {
        return (one.getTime() - two.getTime()) / (60 * 60 * 1000);
    }

    /**
     * 取得两个日期的间隔小时数（单位：小时，精确到2位小数）
     * 
     * @param one 前一个时间
     * @param two 后一个时间
     * @return
     */
    public static BigDecimal getDiffHoursDecimal(Date one, Date two) {
        long timeInMillis = one.getTime() - two.getTime();
        return new BigDecimal(timeInMillis).divide(new BigDecimal(60 * 60 * 1000), 2,
            BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 取得两个日期的间隔分钟数
     * 
     * @param one
     * @param two
     * @return
     */
    public static long getDiffMinutes(Date one, Date two) {
        return (one.getTime() - two.getTime()) / (60 * 1000);
    }

    /**
     * 取得两个日期间隔秒数（日期1-日期2）
     * 
     * @param one 日期1
     * @param two 日期2
     * @return 间隔秒数
     */
    public static long getDiffSeconds(Date one, Date two) {
        return (one.getTime() - two.getTime()) / 1000;
    }

    /**
     * 获取指定日期 的年份
     * 
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        return formatDate(date, YYYY);
    }

    /**
     * 获取当前日期的年份
     * 
     * @return
     */
    public static String getYear() {
        return getYear(new Date());
    }

    /**
     * 获得指定时间的当月的第一天日期
     * 
     * @param sourceDate 指定时间
     * @return
     */
    public static Date getMonthFirstDay(Date sourceDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);

        Calendar calendar = Calendar.getInstance();
        calendar.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0,
            0, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获得当前时间的当月第一天日期
     * 
     * @return Date
     */
    public static Date getMonthFirstDay() {
        return getMonthFirstDay(DateUtils.now());
    }

    /**
     * 获得指定时间的当月的最后一天日期
     * 
     * @param sourceDate 指定时间
     * @return
     */
    public static Date getMonthLastDay(Date sourceDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);

        Calendar calendar = Calendar.getInstance();
        calendar.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0,
            0, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获得当前时间的当月的最后一天日期
     * 
     * @return
     */
    public static Date getMonthLastDay() {
        return getMonthLastDay(DateUtils.now());
    }

    /**
     * 获得指定时间的星期一日期
     * 
     * @param date
     * @return
     */
    public static Date getWeekMonday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        Calendar calendar = Calendar.getInstance();
        calendar.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0,
            0, 0);
        Date firstDay = DateUtils.addDays(date,
            c.get(Calendar.DAY_OF_WEEK) == 1 ? -6 : -1 * c.get(Calendar.DAY_OF_WEEK) + 2);

        return firstDay;
    }

    /**
     * 获得当前日期的星期一日期
     * 
     * @return
     */
    public static Date getWeekMonday() {
        return getWeekMonday(DateUtils.now());
    }

    /**
     * 获得指定时间的星期天日期
     * 
     * @param date
     * @return
     */
    public static Date getWeekSunday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        Calendar calendar = Calendar.getInstance();
        calendar.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0,
            0, 0);
        Date lastDay = DateUtils.addDays(date,
            c.get(Calendar.DAY_OF_WEEK) == 1 ? 0 : 8 - c.get(Calendar.DAY_OF_WEEK));
        return lastDay;
    }

    /**
     * 获得当前日期的星期天日期
     * 
     * @return
     */
    public static Date getWeekSunday() {
        return getWeekSunday(DateUtils.now());
    }

    /**
     * 获取指定日期是星期几
     * 
     * @param date
     * @return
     */
    public static String getWeekDayWithLocal(Date date) {
        return dateFormatInstance(E).format(date);
    }

    /**
     * 获取当前日期是星期几
     * 
     * @return
     */
    public static String getWeekDayWithLocal() {
        return getWeekDayWithLocal(new Date());
    }

    /**
     * 获取指定日期的星级几
     * 
     * @param dt 日期
     * @return 1..7,对应:"1=周一...7=周日"
     */
    public static int getWeekDay(Date dt) {
        Integer[] weekDays = { 7, 1, 2, 3, 4, 5, 6 };
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 获取当前日期的星级几
     * 
     * @return
     */
    public static int getWeekDay() {
        return getWeekDay(new Date());
    }

    /**
     * 获取指定日期的前一天日期
     * 
     * @param date
     * @return
     */
    public static Date getBeforeDate(Date date) {
        return new Date(date.getTime() - (ONE_DAY_MILL_SECONDS));
    }

    /**
     * 获取当前日期的前一天日期
     * 
     * @return
     */
    public static Date getBeforeDate() {
        Date date = new Date();
        return new Date(date.getTime() - (ONE_DAY_MILL_SECONDS));
    }

    /**
     * 获得一天的最早时刻
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getDayBegin(Date date) throws ParseException {
        if (date == null)
            return null;
        return DateUtils.parseDate(DateUtils.formatDate(date));
    }

    /**
     * 获得一天的最后时刻
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getDayEnd(Date date) throws ParseException {
        if (date == null)
            return null;
        date = getDayBegin(date);
        date = DateUtils.addDays(date, 1);
        return DateUtils.addSeconds(date, -1);
    }

    /**
     * 获取当前时间的小时
     * 
     * @param
     * @return
     */
    public static int getHour() {
        return getHour(new Date());
    }

    /**
     * 获取指定时间的小时
     * 
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前时间的分钟
     * 
     * @param
     * @return
     */
    public static int getMinute() {
        return getMinute(new Date());
    }

    /**
     * 获取指定时间的分钟
     * 
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 前者是否小于后者日期
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isLessThan(Date date1, Date date2) {
        if (date2.after(date1)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 前者是否小于后者日期
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isLessThan(String date1, String date2, String format) {
        try {
            DateFormat dateFormat = dateFormatInstance(format);
            Date d1 = dateFormat.parse(date1);
            Date d2 = dateFormat.parse(date2);

            if (d2.after(d1)) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * 是否前者不小于（大于或等于）后者
     * （有等于判断，使用字符串类型能兼容所需格式的判断）
     * @param date1
     * @param date2
     * @param format
     * @return
     */
    public static boolean isNotLessThan(String date1, String date2, String format) {
        try {
            DateFormat dateFormat = dateFormatInstance(format);
            Date d1 = dateFormat.parse(date1);
            Date d2 = dateFormat.parse(date2);

            if (d1.before(d2)) {
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            return false;
        }
    }

}