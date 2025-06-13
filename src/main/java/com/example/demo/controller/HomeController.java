package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        if(session.getAttribute("usuario") == null){
            return "redirect:/login";
        }
        model.addAttribute("username", ((com.example.demo.model.Usuario)session.getAttribute("usuario")).getUsername());
        return "home"; 
    }
}