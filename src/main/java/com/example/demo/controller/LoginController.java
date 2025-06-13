package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping({"/", "/login"})
    public String loginForm() {
        return "login"; // Thymeleaf: login.html
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password, 
                              Model model, HttpSession session) {
        Usuario usuario = usuarioService.login(username, password);
        if (usuario != null && "admin".equalsIgnoreCase(usuario.getRol())) {
            session.setAttribute("usuario", usuario);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos, o no es admin.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}