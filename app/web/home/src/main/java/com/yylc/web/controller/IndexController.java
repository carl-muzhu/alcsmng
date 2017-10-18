/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2013 All Rights Reserved.
 */
package com.yylc.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author qiang.wq
 * @version $Id: IndexController.java, v 0.1 2013-9-22 ����5:30:36 WJL Exp $
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, ModelMap modelMap) {
        return new ModelAndView("index");
    }
}
