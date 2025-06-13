package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.DisponibilidadTrainer;
import com.example.demo.service.DisponibilidadTrainerService;

@Controller
@RequestMapping("/dispoTrainers")
public class DisponibilidadTrainerController {
	
	@Autowired
	private DisponibilidadTrainerService disponibilidadTrainerService;
	
    // Mostrar solo la lista de trainers
    @GetMapping
    public String mostrarDispoTrainers(Model model) {
        model.addAttribute("dispoTrainers", disponibilidadTrainerService.listarTodo());
        return "dispoTrainers/lista";  // sesiones/lista.html
    }

    
    // Mostrar formulario para nueva sesión



    // Guardar sesión desde formulario
    @PostMapping("/guardar")
    public String guardarDispoTrainer(@ModelAttribute("disponibilidadTrainer") DisponibilidadTrainer disponibilidadTrainer) {
    	disponibilidadTrainerService.guardar(disponibilidadTrainer);
        return "redirect:/dispoTrainers";
    }

    // Eliminar sesión por id
    @GetMapping("/eliminar/{id}")
    public String eliminarDispoTrainer(@PathVariable Integer id) {
    	disponibilidadTrainerService.eliminar(id);
        return "redirect:/dispoTrainers";
    }
    
   
    
}
