package com.example.demo.controller;

import com.example.demo.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.TrainerService;

@Controller
@RequestMapping("/trainers")
public class TrainerController {
	
	@Autowired
	private TrainerService trainerService;
	
    // Mostrar solo la lista de trainers
    @GetMapping
    public String mostrarTrainers(Model model) {
        model.addAttribute("trainers", trainerService.listarTodo());
        return "trainers/lista";  // trainer/lista.html
    }
	
    // Mostrar formulario para nuevo trainer
    @GetMapping("/nueva")
    public String mostrarFormularioNuevoTrainer(Model model) {
        model.addAttribute("trainer", new Trainer());
        return "trainers/formulario"; // trainer/formulario.html
    }


    // Guardar sesión desde formulario
    @PostMapping("/guardar")
    public String guardarTrainer(@ModelAttribute("trainer") Trainer trainer) {
        trainerService.guardar(trainer);
        return "redirect:/trainers";
    }

    // Eliminar sesión por id
    @GetMapping("/eliminar/{id}")
    public String eliminarTrainer(@PathVariable Integer id) {
        trainerService.eliminar(id);
        return "redirect:/trainers";
    }

}
