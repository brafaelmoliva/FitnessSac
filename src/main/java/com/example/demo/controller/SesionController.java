package com.example.demo.controller;

import com.example.demo.model.Sesion;
import com.example.demo.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sesiones")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    // Mostrar solo la lista de sesiones
    @GetMapping
    public String mostrarSesiones(Model model) {
        model.addAttribute("sesiones", sesionService.listarTodo());
        return "sesiones/lista";  // sesiones/lista.html
    }

    // Mostrar formulario para nueva sesión
    @GetMapping("/nueva")
    public String mostrarFormularioNuevaSesion(Model model) {
        model.addAttribute("sesion", new Sesion());
        return "sesiones/formulario"; // sesiones/formulario.html
    }

    // Guardar sesión desde formulario
    @PostMapping("/guardar")
    public String guardarSesion(@ModelAttribute("sesion") Sesion sesion) {
        sesionService.guardar(sesion);
        return "redirect:/sesiones";
    }

    // Eliminar sesión por id
    @GetMapping("/eliminar/{id}")
    public String eliminarSesion(@PathVariable Integer id) {
        sesionService.eliminar(id);
        return "redirect:/sesiones";
    }
}
