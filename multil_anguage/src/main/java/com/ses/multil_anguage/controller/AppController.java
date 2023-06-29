package com.ses.multil_anguage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping(value = { "/", "/login1" })
    public String staticResource(Model model) {
        return "login1";
    }
}
