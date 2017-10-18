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
 * ʱ������������ǻ���������Ҫ�̳�ʵ�֣�
 * 
 * @author c.zanda
 * @version $Id: DateUtils.java, v 0.1 2016��5��13�� ����8:29:49 c.zanda Exp $
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

    public final static String    YYYYMMDD_CH          = "yyyy��MM��dd��";
    public final static String    MMDD_CH              = "MM��dd��";

    public final static String    YYYYMMDDHHMISS       = "yyyyMMddHHmmss";
    public final static String    YYYYMMDD             = "yyyyMMdd";
    public final static String    YYYYMM               = "yyyyMM";
    public final static String    YYYY                 = "yyyy";
    public final static String    HHMMSS               = "HHmmss";
    public final static String    MM                   = "MM";
    public final static String    DD                   = "dd";
    public final static String    E                    = "E";

    /**
     * �õ���ǰʱ��
     * 
     * @return
     */
    public static Date now() {
        return new Date();
    }

    /**
     * �õ�DateFormat����ʵ��
     * 
     * @param pattern
     * @return
     */
    public static DateFormat dateFormatInstance(String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        df.setLenient(false);//�ϸ����
        return df;
    }

    /**
     * �õ�ָ��ʱ�伸��֮���ʱ��
     * 
     * @param date
     * @param months
     * @return
     */
    public static Date addMonths(Date date, int months) {
        return com.yylc.common.lang.DateUtils.addMonths(date, months);
    }

    /**
     * �õ�ָ��ʱ�伸��֮���ʱ��
     * 
     * @param date1 ����
     * @param days ����
     * @return
     */
    public static Date addDays(Date date, long days) {
        return addSeconds(date, days * ONE_DAY_SECONDS);
    }

    /**
     * �õ���ǰʱ�伸��֮���ʱ��
     * 
     * @param days
     * @return
     */
    public static Date addDays(long days) {
        return addDays(new Date(), days);
    }

    /**
     * ����ָ��ʱ�伸Сʱ֮���ʱ��
     * 
     * @param date
     * @param hours
     * @return
     */
    public static Date addHours(Date date, long hours) {
        return addMinutes(date, hours * 60);
    }

    /**
     * ���㵱ǰʱ�伸Сʱ֮���ʱ��
     * 
     * @param hours
     * @return
     */
    public static Date addHours(long hours) {
        return addHours(new Date(), hours);
    }

    /**
     * ����ָ��ʱ�伸����֮���ʱ��
     * 
     * @param date
     * @param minutes
     * @return
     */
    public static Date addMinutes(Date date, long minutes) {
        return addSeconds(date, minutes * 60);
    }

    /**
     * ���㵱ǰʱ�伸����֮���ʱ��
     * 
     * @param minutes
     * @return
     */
    public static Date addMinutes(int minutes) {
        return addMinutes(new Date(), minutes);
    }

    /**
     * ����ָ��ʱ�伸��֮���ʱ��
     * @param seconds
     * @return
     */
    public static Date addSeconds(Date date, long seconds) {
        return new Date(date.getTime() + (seconds * 1000));
    }

    /**
     * ���㵱ǰʱ�伸��֮���ʱ��
     * 
     * @param seconds
     * @return
     */
    public static Date addSeconds(int seconds) {
        return addSeconds(new Date(), seconds);
    }

    /**
     * ָ����ʽ���ַ�������ת��Ϊ����
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
     * �ַ�������Ϊyyyy-MM-ddת��������
     * 
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String dateStr) throws ParseException {
        return parseDate(dateStr, SHORT_FORMAT);
    }

    /**
     * ����ת��Ϊָ����ʽ���ַ�������
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
     * ����ת��Ϊyyyy-MM-dd���ַ�������
     * 
     * @param date
     * @return
     */
    public static String formatDate(Date date) {

        return formatDate(date, SHORT_FORMAT);
    }

    /**
     * ȡ���������ڵļ������
     * 
     * @param one
     * @param two
     * @return �������
     */
    public static long getDiffDays(Date one, Date two) {
        return (one.getTime() - two.getTime()) / ONE_DAY_MILL_SECONDS;
    }

    /**
     * ȡ���������ڵļ��Сʱ��
     * 
     * @param one
     * @param two
     * @return ���Сʱ��
     */
    public static long getDiffHours(Date one, Date two) {
        return (one.getTime() - two.getTime()) / (60 * 60 * 1000);
    }

    /**
     * ȡ���������ڵļ��Сʱ������λ��Сʱ����ȷ��2λС����
     * 
     * @param one ǰһ��ʱ��
     * @param two ��һ��ʱ��
     * @return
     */
    public static BigDecimal getDiffHoursDecimal(Date one, Date two) {
        long timeInMillis = one.getTime() - two.getTime();
        return new BigDecimal(timeInMillis).divide(new BigDecimal(60 * 60 * 1000), 2,
            BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ȡ���������ڵļ��������
     * 
     * @param one
     * @param two
     * @return
     */
    public static long getDiffMinutes(Date one, Date two) {
        return (one.getTime() - two.getTime()) / (60 * 1000);
    }

    /**
     * ȡ���������ڼ������������1-����2��
     * 
     * @param one ����1
     * @param two ����2
     * @return �������
     */
    public static long getDiffSeconds(Date one, Date two) {
        return (one.getTime() - two.getTime()) / 1000;
    }

    /**
     * ��ȡָ������ �����
     * 
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        return formatDate(date, YYYY);
    }

    /**
     * ��ȡ��ǰ���ڵ����
     * 
     * @return
     */
    public static String getYear() {
        return getYear(new Date());
    }

    /**
     * ���ָ��ʱ��ĵ��µĵ�һ������
     * 
     * @param sourceDate ָ��ʱ��
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
     * ��õ�ǰʱ��ĵ��µ�һ������
     * 
     * @return Date
     */
    public static Date getMonthFirstDay() {
        return getMonthFirstDay(DateUtils.now());
    }

    /**
     * ���ָ��ʱ��ĵ��µ����һ������
     * 
     * @param sourceDate ָ��ʱ��
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
     * ��õ�ǰʱ��ĵ��µ����һ������
     * 
     * @return
     */
    public static Date getMonthLastDay() {
        return getMonthLastDay(DateUtils.now());
    }

    /**
     * ���ָ��ʱ�������һ����
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
     * ��õ�ǰ���ڵ�����һ����
     * 
     * @return
     */
    public static Date getWeekMonday() {
        return getWeekMonday(DateUtils.now());
    }

    /**
     * ���ָ��ʱ�������������
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
     * ��õ�ǰ���ڵ�����������
     * 
     * @return
     */
    public static Date getWeekSunday() {
        return getWeekSunday(DateUtils.now());
    }

    /**
     * ��ȡָ�����������ڼ�
     * 
     * @param date
     * @return
     */
    public static String getWeekDayWithLocal(Date date) {
        return dateFormatInstance(E).format(date);
    }

    /**
     * ��ȡ��ǰ���������ڼ�
     * 
     * @return
     */
    public static String getWeekDayWithLocal() {
        return getWeekDayWithLocal(new Date());
    }

    /**
     * ��ȡָ�����ڵ��Ǽ���
     * 
     * @param dt ����
     * @return 1..7,��Ӧ:"1=��һ...7=����"
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
     * ��ȡ��ǰ���ڵ��Ǽ���
     * 
     * @return
     */
    public static int getWeekDay() {
        return getWeekDay(new Date());
    }

    /**
     * ��ȡָ�����ڵ�ǰһ������
     * 
     * @param date
     * @return
     */
    public static Date getBeforeDate(Date date) {
        return new Date(date.getTime() - (ONE_DAY_MILL_SECONDS));
    }

    /**
     * ��ȡ��ǰ���ڵ�ǰһ������
     * 
     * @return
     */
    public static Date getBeforeDate() {
        Date date = new Date();
        return new Date(date.getTime() - (ONE_DAY_MILL_SECONDS));
    }

    /**
     * ���һ�������ʱ��
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
     * ���һ������ʱ��
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
     * ��ȡ��ǰʱ���Сʱ
     * 
     * @param
     * @return
     */
    public static int getHour() {
        return getHour(new Date());
    }

    /**
     * ��ȡָ��ʱ���Сʱ
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
     * ��ȡ��ǰʱ��ķ���
     * 
     * @param
     * @return
     */
    public static int getMinute() {
        return getMinute(new Date());
    }

    /**
     * ��ȡָ��ʱ��ķ���
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
     * ǰ���Ƿ�С�ں�������
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
     * ǰ���Ƿ�С�ں�������
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
     * �Ƿ�ǰ�߲�С�ڣ����ڻ���ڣ�����
     * ���е����жϣ�ʹ���ַ��������ܼ��������ʽ���жϣ�
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