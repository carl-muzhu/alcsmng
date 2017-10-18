package com.yylc.web.controller.session;

import com.yylc.dwdataservice.core.model.UserInfoModel;
import com.yylc.web.controller.constant.AlcsConstant;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * session管理器
 *
 * @author x m
 */
public class SessionManager {
    private static SessionManager sessionManager = new SessionManager();
    private Map<String, HttpSession> sessions = new ConcurrentHashMap<String, HttpSession>(); //session管理map<userId, session>
    private Map<String, String> hashOfUsers = new ConcurrentHashMap<String, String>();    //sessionId 对应 map<sessionId, userId>

    private SessionManager() {

    }

    public static SessionManager getInstance() {
        return sessionManager;
    }

    /**
     * 清空session内容
     *
     * @param httpSession
     */
    public void removeSessionAttributes(HttpSession httpSession) {
        Enumeration<String> enumer = httpSession.getAttributeNames();
        while (enumer.hasMoreElements()) {
            httpSession.removeAttribute(enumer.nextElement());
        }
    }

    /**
     * 是否已经存在session
     *
     * @return
     */
    public boolean containsSession(HttpSession httpSession) {
        return hashOfUsers.containsKey(httpSession.getId());
    }

    /**
     * 加入新的session
     *
     * @param session
     */
    public synchronized void addSession(HttpSession session) {
        UserInfoModel user = (UserInfoModel) session.getAttribute(AlcsConstant.SESSION_USER_KEY);
        if (user == null) return;
        //删除原来的user
        if (this.containsSession(session)) {
            String hisUserId = hashOfUsers.remove(session.getId());
            sessions.remove(hisUserId);
        } else if (sessions.containsKey(user.getUserId())) {//user已经存在的且session不一致，注销原来session
            this.invalidateSession(sessions.get(user.getUserId()));
            sessions.remove(user.getUserId());
        }
        //加入新的session
        hashOfUsers.put(session.getId(), String.valueOf(user.getUserId()));
        sessions.put(String.valueOf(user.getUserId()), session);
    }

    /**
     * 注销用户的session,用户注销时调用
     *
     * @param session
     */
    public synchronized void invalidateSession(HttpSession session) {
        session.invalidate();
    }

    public synchronized void removeSession(HttpSession session) {
        removeSession(session.getId());
    }

    /**
     * 移除管理器中的session,session失效时自动调用
     *
     * @param sessionId
     */
    public synchronized void removeSession(String sessionId) {
        String userId = this.hashOfUsers.remove(sessionId);
        if (userId != null) {
            this.sessions.remove(userId);
        }
    }
}
