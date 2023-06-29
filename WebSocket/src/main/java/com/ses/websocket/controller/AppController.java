package com.ses.websocket.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    @GetMapping
    public String index(HttpServletRequest request, Model model) {
        String username = (String)request.getSession().getAttribute("username");

        if(username == null || username.isEmpty()) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        return "chat";

    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    @PostMapping("/login")
    public String doLog(HttpServletRequest request, @RequestParam(defaultValue = "") String username) {
        username = username.trim();

        if(username.isEmpty()) {
            return "login";
        }
        request.getSession().setAttribute("username", username);
        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession(true).invalidate();
        return "redirect:/login";
    }
}
