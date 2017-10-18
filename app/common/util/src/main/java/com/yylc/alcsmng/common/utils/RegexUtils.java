package com.yylc.alcsmng.common.utils;

/**
 * 正则表达式工具类
 * 
 * @author qiang.wq
 * @version $Id: RegexUtils.java, v 0.1 2016年10月22日 下午2:32:57 qiang.wq Exp $
 */
public class RegexUtils {

    /**
     * 判断是否为电话号码  只判断11位的电话号码 前面不包含+86
     * 
     * @param cell
     * @return
     */
    public static boolean isCellNumber(String cell) {
        if (cell == null) {
            return false;
        }
        return cell.matches("^[1][2-9]\\d{9}$");
    }

}
