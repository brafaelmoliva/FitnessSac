package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/lista")
    public String listar(Model model) {
        List<Cliente> lista = clienteService.listarTodos();
        model.addAttribute("listaClientes", lista);
        return "gestionClientes";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "nuevoCliente";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Cliente cliente) {
        cliente.setEstado("Activo");
        cliente.setFecha_registro(LocalDate.now());
        clienteService.guardar(cliente);
        return "redirect:/clientes/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        clienteService.eliminar(id);
        return "redirect:/clientes/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Cliente c = clienteService.obtenerPorId(id);
        model.addAttribute("cliente", c);
        return "editarCliente";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Cliente cliente) {
        clienteService.guardar(cliente);
        return "redirect:/clientes/lista";
    }
    
    @GetMapping
    public String redireccion() {
        return "redirect:/clientes/lista";
    }

}
