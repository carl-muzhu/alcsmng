package com.yylc.web.controller.result;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by zhangweijie .
 * 2017/5/10
 */
public class RestResponse  implements Serializable {

    private static final long   serialVersionUID = -802482953469560837L;
    // ????????
    private boolean           is_succ          = true;

    // ?????????
    private boolean           succ             = true;

    // ????????
    private boolean           timeout          = false;

    // ?????????
    private boolean           overdue          = false;

    private String            err_msg          = "";

    private String            err_code         = "";

    private Object            result           = "";

    private Map<String, Object> data;

    public boolean is_succ() {
        return is_succ;
    }

    public void setIs_succ(boolean is_succ) {
        this.is_succ = is_succ;
    }

    public boolean isSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public boolean isTimeout() {
        return timeout;
    }

    public void setTimeout(boolean timeout) {
        this.timeout = timeout;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
