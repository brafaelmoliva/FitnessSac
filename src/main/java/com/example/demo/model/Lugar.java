package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Lugar")
public class Lugar {
    @Id
    @Column(name = "id_lugar")
    private Integer idLugar;

    private String nombre;
    private String tipo;
    private String direccion;

    // Getters y setters
    public Integer getIdLugar() { return idLugar; }
    public void setIdLugar(Integer idLugar) { this.idLugar = idLugar; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}
