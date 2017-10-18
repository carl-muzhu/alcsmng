package com.yylc.web.controller.utils;

import com.alibaba.fastjson.JSON;
import com.yylc.alcsmng.common.service.intergration.enums.AlcsResultCodeEnum;
import com.yylc.web.controller.result.RestResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * 
 * 
 * @author herong
 * @version $Id: ResponseUtil.java, v 0.1 2017??9??18?? ????3:29:50 herong Exp $
 */
public class ResponseUtil {
    public static void buildExpResponse(AlcsResultCodeEnum exp, HttpServletResponse response)
                                                                                             throws IOException,
            ServletException {
        RestResponse jsonResp = buildExpResponse(exp);
        jsonResp.setTimeout(true);
        /* ???????text/json */
        response.setContentType("text/json");
        /*??????????'UTF-8'*/
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(jsonResp));
    }

    public static void buildExpResponse(String exp, String errorMsg, HttpServletResponse response)
                                                                                                  throws IOException,
            ServletException {
        RestResponse jsonResp = buildExpResponse(exp, errorMsg);
        /* ???????text/json */
        response.setContentType("text/json");
        /*??????????'UTF-8'*/
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(jsonResp));
    }

    public static RestResponse buildExpResponse(AlcsResultCodeEnum exp) {
        return buildExpResponse(exp.getCode(), exp.message());
    }

    public static RestResponse buildExpResponse(AlcsResultCodeEnum exp, String errorMsg) {
        return buildExpResponse(exp.getCode(), errorMsg);
    }

    public static RestResponse buildExpResponse(String errorCode, String errorMsg) {
        RestResponse jsonResp = new RestResponse();
        jsonResp.setSucc(false);
        jsonResp.setIs_succ(false);
        jsonResp.setErr_code(errorCode);
        jsonResp.setErr_msg(errorMsg);
        return jsonResp;
    }

    public static RestResponse buildExtResponse(boolean isSucc, boolean succ, String code,
                                                String message) {
        RestResponse jsonResp = new RestResponse();
        jsonResp.setIs_succ(isSucc);
        jsonResp.setSucc(succ);
        jsonResp.setErr_msg(message);
        jsonResp.setErr_code(code);
        return jsonResp;
    }

    public static RestResponse buildSuccessResponse() {
        RestResponse jsonResp = new RestResponse();
        jsonResp.setData(new HashMap<String, Object>());
        jsonResp.setIs_succ(true);
        jsonResp.setSucc(true);
        return jsonResp;
    }
}
