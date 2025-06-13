package com.example.demo.controller;

import com.example.demo.model.PlanC;
import com.example.demo.service.PlanCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/planc")
public class PlanCController {

    @Autowired
    private PlanCService planCService;

    @GetMapping
    public String mostrarPlanes(Model model) {
        model.addAttribute("planes", planCService.listarTodo());
        return "planc/lista"; // planc/lista.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoPlan(Model model) {
        model.addAttribute("planC", new PlanC());
        return "planc/formulario"; // planc/formulario.html
    }

    @PostMapping("/guardar")
    public String guardarPlan(@ModelAttribute("planC") PlanC planC) {
        planCService.guardar(planC);
        return "redirect:/planc";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPlan(@PathVariable Integer id) {
        planCService.eliminar(id);
        return "redirect:/planc";
    }
}
