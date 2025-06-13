package com.example.demo.service;

import com.example.demo.model.PlanC;
import com.example.demo.repository.PlanCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanCService {

    @Autowired
    private PlanCRepository planCRepository;

    public List<PlanC> listarTodo() {
        return planCRepository.findAll();
    }

    public void guardar(PlanC planC) {
        planCRepository.save(planC);
    }

    public void eliminar(Integer id) {
        planCRepository.deleteById(id);
    }
}
