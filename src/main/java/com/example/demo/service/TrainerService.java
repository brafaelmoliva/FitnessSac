package com.example.demo.service;

import com.example.demo.model.Trainer;
import com.example.demo.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
	
	@Autowired
	private TrainerRepository trainerRepository;
	
	public List<Trainer> listarTodo() {
        return trainerRepository.findAll();
    }
	
	public void guardar(Trainer trainer) {
		trainerRepository.save(trainer);
    }

    public void eliminar(Integer id) {
    	trainerRepository.deleteById(id);
    }
}

