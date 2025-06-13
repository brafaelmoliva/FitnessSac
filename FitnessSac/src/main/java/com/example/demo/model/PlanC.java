package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PlanC")
public class PlanC {
    @Id
    private Integer idPlan;

    private String nombre;
    private Integer duracion;
    private Integer cantidadMes;
    private Integer cantidadGrupal;
    private Integer cantidadPersonal;
    private String categoria;
    private BigDecimal precio;
    private Integer diasAntesRenovacion;

    // Getters y setters
    public Integer getIdPlan() { return idPlan; }
    public void setIdPlan(Integer idPlan) { this.idPlan = idPlan; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }

    public Integer getCantidadMes() { return cantidadMes; }
    public void setCantidadMes(Integer cantidadMes) { this.cantidadMes = cantidadMes; }

    public Integer getCantidadGrupal() { return cantidadGrupal; }
    public void setCantidadGrupal(Integer cantidadGrupal) { this.cantidadGrupal = cantidadGrupal; }

    public Integer getCantidadPersonal() { return cantidadPersonal; }
    public void setCantidadPersonal(Integer cantidadPersonal) { this.cantidadPersonal = cantidadPersonal; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Integer getDiasAntesRenovacion() { return diasAntesRenovacion; }
    public void setDiasAntesRenovacion(Integer diasAntesRenovacion) { this.diasAntesRenovacion = diasAntesRenovacion; }
}
