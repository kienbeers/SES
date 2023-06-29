package com.ses.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping(value = { "/", "/test" })
    public String test(Model model) {
        return "test";
    }

    // Chuyển hướng sang /admin/login
    @Deprecated
    @RequestMapping(value = { "/admin/oldlog" })
    public String oldLogin(Model model) {
        return "oldLogin";
    }

    @RequestMapping(value = { "/admin/login" })
    public String login(Model model) {
        return "login";
    }
}
