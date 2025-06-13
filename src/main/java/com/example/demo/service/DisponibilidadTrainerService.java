package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.DisponibilidadTrainer;
import com.example.demo.repository.DisponibilidadTrainerRepository;

@Service
public class DisponibilidadTrainerService {
	
	@Autowired
	private DisponibilidadTrainerRepository disponibilidadTrainerRepository;
	
	public List<DisponibilidadTrainer> listarTodo() {
        return disponibilidadTrainerRepository.findAll();
    }
	
	public void guardar(DisponibilidadTrainer disponibilidadTrainer) {
		disponibilidadTrainerRepository.save(disponibilidadTrainer);
    }

    public void eliminar(Integer id) {
    	disponibilidadTrainerRepository.deleteById(id);
    }
	
}
