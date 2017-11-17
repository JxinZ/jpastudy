package org.spring.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {


    @RequestMapping(value = "/login")
    public ModelAndView toLogin(Model model) {
        return new ModelAndView("login");
    }

}
