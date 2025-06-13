package com.example.demo.controller;

import com.example.demo.model.Sesion;
import com.example.demo.model.Trainer;
import com.example.demo.model.Lugar;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.repository.LugarRepository;
import com.example.demo.service.SesionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sesiones")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private LugarRepository lugarRepository;

    // Mostrar lista de sesiones
    @GetMapping
    public String mostrarSesiones(Model model) {
        model.addAttribute("sesiones", sesionService.listarTodo());
        return "sesiones/lista"; // sesiones/lista.html
    }

    // Mostrar formulario para nueva sesión
    @GetMapping("/nueva")
    public String mostrarFormularioNuevaSesion(Model model) {
        model.addAttribute("sesion", new Sesion());

        List<Trainer> listaTrainers = trainerRepository.findAll();
        List<Lugar> listaLugares = lugarRepository.findAll();

        model.addAttribute("listaTrainers", listaTrainers);
        model.addAttribute("listaLugares", listaLugares);

        return "sesiones/formulario"; // sesiones/formulario.html
    }

    // Guardar sesión desde formulario
    @PostMapping("/guardar")
    public String guardarSesion(@ModelAttribute("sesion") Sesion sesion,
                                @RequestParam("trainer") Integer idTrainer,
                                @RequestParam("lugar") Integer idLugar) {

        Trainer trainer = trainerRepository.findById(idTrainer)
                             .orElseThrow(() -> new IllegalArgumentException("Trainer inválido ID: " + idTrainer));
        Lugar lugar = lugarRepository.findById(idLugar)
                         .orElseThrow(() -> new IllegalArgumentException("Lugar inválido ID: " + idLugar));

        sesion.setTrainer(trainer);
        sesion.setLugar(lugar);

        sesionService.guardar(sesion);

        return "redirect:/sesiones";
    }

    // Eliminar sesión por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarSesion(@PathVariable Integer id) {
        sesionService.eliminar(id);
        return "redirect:/sesiones";
    }
}
