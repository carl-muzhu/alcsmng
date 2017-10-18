package com.yylc.alcsmng.common.utils;

/**
 * ������ʽ������
 * 
 * @author qiang.wq
 * @version $Id: RegexUtils.java, v 0.1 2016��10��22�� ����2:32:57 qiang.wq Exp $
 */
public class RegexUtils {

    /**
     * �ж��Ƿ�Ϊ�绰����  ֻ�ж�11λ�ĵ绰���� ǰ�治����+86
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
