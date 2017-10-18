package com.yylc.web.controller.utils;


import com.yylc.dwdataservice.core.order.CaseInfoQueryPageOrder;
import com.yylc.platform.common.base.QueryBase;

/**
 * @author zhouhang.jin
 * @version $Id: BuildQuery on 2017/1/5 15:07.
 */
public class BuildQuery {

    public static  QueryBase buildQuery(PageView pageView, QueryBase query){
        query.setPageSize(pageView.getPageSize());
        query.setPageNum(pageView.getPageNow());
        return query;
    }

}
