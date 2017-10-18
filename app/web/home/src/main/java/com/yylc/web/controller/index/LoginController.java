package com.yylc.web.controller.index;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import com.yylc.alcsmng.common.service.intergration.enums.AlcsResultCodeEnum;
import com.yylc.alcsmng.core.service.UserInfoComponent;
import com.yylc.dwdataservice.core.model.UserInfoModel;
import com.yylc.web.controller.constant.AlcsConstant;
import com.yylc.web.controller.result.RestResponse;
import com.yylc.web.controller.session.SessionManager;
import com.yylc.web.controller.utils.ResponseUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by xm on 2017/9/26.
 * description controller for user login
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Resource
    private UserInfoComponent userInfoComponent;

    @RequestMapping(value = "/index.htm")
    public ModelAndView index() {
        return new ModelAndView("index");
    }


    /**
     * ��֤�û���¼��Ϣ�Ƿ���ȷ
     *
     * @param request
     * @param userInfoModel
     * @return
     */
    @RequestMapping(value = "/checkLogin.do")
    @ResponseBody
    public RestResponse checkLogin(HttpServletRequest request, UserInfoModel userInfoModel) {
        RestResponse result = ResponseUtil.buildSuccessResponse();
        UserInfoModel userOfDB = userInfoComponent.queryUserByAccount(userInfoModel.getAccount());
        if (userOfDB != null && StringUtils.isNotBlank(userOfDB.getAccount()) && userInfoModel.getPassword().equalsIgnoreCase(userOfDB.getPassword())) {
            HttpSession session = request.getSession();
            SessionManager.getInstance().removeSession(session);//session�������Ƴ�ԭ��session
            //new session saved
            session.setAttribute(AlcsConstant.SESSION_USER_KEY, userOfDB);
            SessionManager.getInstance().addSession(session);
        } else {
            return ResponseUtil.buildExpResponse(AlcsResultCodeEnum.NULL_ARGUMENT,
                    "�˺Ų����ڻ��������");
        }
        return result;
    }

    /**
     * ��֤�ɹ�,������ҳ��
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginMain.htm")
    public ModelAndView loginMain(HttpServletRequest request) {
        //��ֹ�������ֱַ������loginMain.htm��֤session
        if (request.getSession().getAttribute(AlcsConstant.SESSION_USER_KEY) == null) {
            return new ModelAndView("index");
        } else {
            return new ModelAndView("frame/home");
        }
    }

    /**
     * �û��˳���¼
     *
     * @param request
     * @return
     */
    @RequestMapping("/logout.htm")
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SessionManager.getInstance().invalidateSession(session);
        return new ModelAndView("index");
    }
    
    @RequestMapping("/checkcode.htm")
    public void checkcode(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(80, 40, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 80, 40);
        graphics.setFont(new Font("����", Font.BOLD, 20));

        Random random = new Random(System.currentTimeMillis());
        //��֤��д��image
        StringBuffer sb = new StringBuffer(4);
        for (int i = 0; i < 4; i++) {
            int x = random.nextInt(10);
            sb.append(x);
            int y = 10 + random.nextInt(20);
            Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            graphics.setColor(color);
            graphics.drawString("" + x, 5 + i * 20, y);
        }
        //����session
        request.getSession().setAttribute("checkcode", sb.toString());
        //����
        for (int i = 0; i < 6; i++) {
            Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            graphics.setColor(color);
            graphics.drawLine(random.nextInt(80), random.nextInt(40), random.nextInt(80),
                random.nextInt(40));
        }
        graphics.dispose();
        try {
            ImageIO.write(image, "JPG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
