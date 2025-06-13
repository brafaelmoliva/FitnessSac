package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Sesion")
public class Sesion {
    @Id
    @Column(name = "id_sesion")
    private Integer idSesion;

    private LocalDate fecha;
    private String tipo;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    private Integer duracion;
    private Integer capacidad;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    // Relaciones con Trainer y Lugar
    @ManyToOne
    @JoinColumn(name = "id_trainer")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "id_lugar")
    private Lugar lugar;

    // Getters y setters
    public Integer getIdSesion() { return idSesion; }
    public void setIdSesion(Integer idSesion) { this.idSesion = idSesion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }

    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Trainer getTrainer() { return trainer; }
    public void setTrainer(Trainer trainer) { this.trainer = trainer; }

    public Lugar getLugar() { return lugar; }
    public void setLugar(Lugar lugar) { this.lugar = lugar; }
}
