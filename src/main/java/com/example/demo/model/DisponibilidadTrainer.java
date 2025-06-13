package com.example.demo.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DisponibilidadTrainer")
public class DisponibilidadTrainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisponibilidadTrainer;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTrainer", nullable = false)
    private Trainer trainer;
	
	private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    
    
	public Integer getIdDisponibilidadTrainer() {
		return idDisponibilidadTrainer;
	}
	public void setIdDisponibilidadTrainer(Integer idDisponibilidadTrainer) {
		this.idDisponibilidadTrainer = idDisponibilidadTrainer;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
    
    
    
}
