package com.yylc.alcsmng.common.utils;

import com.yylc.common.lang.Money;
import com.yylc.common.lang.StringUtils;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

public class StringUtilsExt extends StringUtils {
    private static final Logger logger = Logger.getLogger(StringUtils.class);

    /**
     * ��ȡ�ַ���
     * 
     * @param str
     * @param maxLen
     * @return
     */
    public static String subset(String str, int maxLen) {
        if (str != null) {
            if (str.length() > maxLen) {
                str = str.substring(0, maxLen) + "...";
            }
        }
        return str;
    }

    /**
     * ���ַ�������
     * 
     * @param str
     * @param
     * @return
     */
    public static String getDefaultString(Object str) {
        if (null == str || isBlank(str.toString())) {
            return "--";
        }
        return str.toString();
    }

    /**
     * ���ַ�������
     * 
     * @param str
     * @param
     * @return
     */
    public static String getStringForBlank(String str, String toStr) {
        if (isBlank(str)) {
            return toStr;
        }
        return str;
    }

    public static String subset(String str) {
        return subset(str, 20);
    }

    public static String formatWan(String format, Object num) {
        if ("#,000.00".equals(format)) {//#,##0.00����������#�޷���ǰ̨����
            format = "#,##0.00";
        }
        DecimalFormat df = new DecimalFormat(format);

        Double d = new Double(0);
        if (num != null) {
            if (num instanceof Money) {
                d = ((Money) num).getAmount().doubleValue();
            } else if (num instanceof Integer) {
                d = (Integer) num * 1.0d;
            } else if (num instanceof Long) {
                d = (Long) num * 1.0d;
            } else if (num instanceof Float) {
                d = (Float) num * 1.0d;
            } else if (num instanceof Double) {
                d = (Double) num;
            }
        }
        return df.format(d / 10000.0);
    }

    public static String formatYuan(String format, Object num) {
        if ("#,000.00".equals(format)) {//#,##0.00����������#�޷���ǰ̨����
            format = "#,##0.00";
        }
        DecimalFormat df = new DecimalFormat(format);

        Double d = new Double(0);
        if (num != null) {
            if (num instanceof Money) {
                d = ((Money) num).getAmount().doubleValue();
            } else if (num instanceof Integer) {
                d = (Integer) num * 1.0d;
            } else if (num instanceof Long) {
                d = (Long) num * 1.0d;
            } else if (num instanceof Float) {
                d = (Float) num * 1.0d;
            } else if (num instanceof Double) {
                d = (Double) num;
            }
        }
        return df.format(d);
    }

    /**
     * �������֤��������
     * @param s
     * @return
     */
    public static String toAge(String s) {
        if (isBlank(s)) {
            return "";
        }
        int leh = s.length();
        if (leh != 18 && leh != 15) {
            return "";
        }

        try {
            String dates = null;
            if (leh == 18) {
                dates = s.substring(6, 10) + "-" + s.substring(10, 12) + "-" + s.substring(12, 14);
            } else {
                dates = "19" + s.substring(6, 8) + "-" + s.substring(8, 10) + "-"
                        + s.substring(10, 12);
            }
            Date birthday = DateUtils.parseDate(dates);
            int age = DateUtils.getAgeByBirthday(birthday);
            return age + "";
        } catch (ParseException e) {
            logger.error("���֤���������쳣", e);
        }
        return "";
    }

    //С��ת���ɰٷ�����ȥ����Ч��0
    public static String toPercent(String data) {
        if (isBlank(data)) {
            return "";
        }
        BigDecimal bData = new BigDecimal(data).multiply(new BigDecimal(100));
        //�ж��Ƿ�ȡ�����0
        if (bData.divideAndRemainder(new BigDecimal(1))[1].compareTo(new BigDecimal(0)) == 0) {
            return bData.intValue() + "%";
        } else {
            return bData.floatValue() + "%";
        }
    }

    //���ת������Ԫ��ȥ����Ч��0
    public static String toWanAmount(Double amount) {
        if (amount == null) {
            return "";
        }
        BigDecimal bData = new BigDecimal(amount).divide(new BigDecimal(10000), 2,
            BigDecimal.ROUND_HALF_UP);
        //�ж��Ƿ�ȡ�����0
        if (bData.divideAndRemainder(new BigDecimal(1))[1].compareTo(new BigDecimal(0)) == 0) {
            return bData.intValue() + "��Ԫ";
        } else {
            return bData.floatValue() + "��Ԫ";
        }
    }
}
