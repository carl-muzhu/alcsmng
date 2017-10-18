package com.yylc.web.controller.utils;

/**
 * ����һ����ҳ����
 * ��Ҫ������ʾҳ��
 *��pagecode��Ҫ��ü�¼�Ŀ�ʼ������������ʼҳ��
 *  pageNow ����ǰҳ
 *��pageCount ��ҳ��
 *
 *  ��������ࡡ���ص���ҳ������PageIndex
 * @author wenbing.zhang
 * 2013-11-19
 * @Email: mmm333zzz520@163.com 
 * @version 1.0v 
 */
public class WebTool {

    public static PageIndex getPageIndex(long pagecode, int pageNow, long pageCount) {
        long startpage = pageNow - (pagecode % 2 == 0 ? pagecode / 2 - 1 : pagecode / 2);
        long endpage = pageNow + pagecode / 2;
        if (startpage < 1) {
            startpage = 1;
            if (pageCount >= pagecode)
                endpage = pagecode;
            else
                endpage = pageCount;
        }
        if (endpage > pageCount) {
            endpage = pageCount;
            if ((endpage - pagecode) > 0)
                startpage = endpage - pagecode + 1;
            else
                startpage = 1;
        }
        return new PageIndex(startpage, endpage);
    }
}
