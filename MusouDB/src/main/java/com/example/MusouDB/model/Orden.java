package com.example.MusouDB.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double total_orden;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fecha_orden;


    public Orden(LocalDateTime fecha_orden, Double total_orden, Long id_orden) {
        this.fecha_orden = fecha_orden;
        this.total_orden = total_orden;
        this.id_orden = id_orden;
    }

    public Orden(){

    }

    public Long getId_orden() {
        return id_orden;
    }

    public void setId_orden(Long id_orden) {
        this.id_orden = id_orden;
    }

    public Double getTotal_orden() {
        return total_orden;
    }

    public void setTotal_orden(Double total_orden) {
        this.total_orden = total_orden;
    }

    public LocalDateTime getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(LocalDateTime fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id_orden=" + id_orden +
                ", total_orden=" + total_orden +
                ", fecha_orden=" + fecha_orden +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Orden orden)) return false;
        return Objects.equals(id_orden, orden.id_orden) && Objects.equals(total_orden, orden.total_orden) && Objects.equals(fecha_orden, orden.fecha_orden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_orden, total_orden, fecha_orden);
    }
}


