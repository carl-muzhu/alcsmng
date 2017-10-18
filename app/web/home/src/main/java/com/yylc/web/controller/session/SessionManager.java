package com.yylc.web.controller.session;

import com.yylc.dwdataservice.core.model.UserInfoModel;
import com.yylc.web.controller.constant.AlcsConstant;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * session������
 *
 * @author x m
 */
public class SessionManager {
    private static SessionManager sessionManager = new SessionManager();
    private Map<String, HttpSession> sessions = new ConcurrentHashMap<String, HttpSession>(); //session����map<userId, session>
    private Map<String, String> hashOfUsers = new ConcurrentHashMap<String, String>();    //sessionId ��Ӧ map<sessionId, userId>

    private SessionManager() {

    }

    public static SessionManager getInstance() {
        return sessionManager;
    }

    /**
     * ���session����
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
     * �Ƿ��Ѿ�����session
     *
     * @return
     */
    public boolean containsSession(HttpSession httpSession) {
        return hashOfUsers.containsKey(httpSession.getId());
    }

    /**
     * �����µ�session
     *
     * @param session
     */
    public synchronized void addSession(HttpSession session) {
        UserInfoModel user = (UserInfoModel) session.getAttribute(AlcsConstant.SESSION_USER_KEY);
        if (user == null) return;
        //ɾ��ԭ����user
        if (this.containsSession(session)) {
            String hisUserId = hashOfUsers.remove(session.getId());
            sessions.remove(hisUserId);
        } else if (sessions.containsKey(user.getUserId())) {//user�Ѿ����ڵ���session��һ�£�ע��ԭ��session
            this.invalidateSession(sessions.get(user.getUserId()));
            sessions.remove(user.getUserId());
        }
        //�����µ�session
        hashOfUsers.put(session.getId(), String.valueOf(user.getUserId()));
        sessions.put(String.valueOf(user.getUserId()), session);
    }

    /**
     * ע���û���session,�û�ע��ʱ����
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
     * �Ƴ��������е�session,sessionʧЧʱ�Զ�����
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
