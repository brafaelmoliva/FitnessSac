package com.example.demo.service;

import com.example.demo.model.Sesion;
import com.example.demo.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionService {

    @Autowired
    private SesionRepository sesionRepository;

    public List<Sesion> listarTodo() {
        return sesionRepository.findAll();
    }

    public void guardar(Sesion sesion) {
        sesionRepository.save(sesion);
    }

    public void eliminar(Integer id) {
        sesionRepository.deleteById(id);
    }
}
