package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Trainer")
public class Trainer {

    @Id
    @Column(name = "id_trainer") 
    private Integer idTrainer;

    private String nombre;
    private String estado;

    // Getters y setters
    public Integer getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
