package com.example.MusouDB.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Long idOrden;

    @Column(name = "total_orden", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double totalOrden;

    @Column(name = "fecha_orden", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaOrden;

    // Constructor vacío
    public Orden() {
    }

    // Constructor con parámetros
    public Orden(Long idOrden, Double totalOrden, LocalDateTime fechaOrden) {
        this.idOrden = idOrden;
        this.totalOrden = totalOrden;
        this.fechaOrden = fechaOrden;
    }

    // Getters y Setters
    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public Double getTotalOrden() {
        return totalOrden;
    }

    public void setTotalOrden(Double totalOrden) {
        this.totalOrden = totalOrden;
    }

    public LocalDateTime getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(LocalDateTime fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    // toString
    @Override
    public String toString() {
        return "Orden{" +
                "idOrden=" + idOrden +
                ", totalOrden=" + totalOrden +
                ", fechaOrden=" + fechaOrden +
                '}';
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orden orden)) return false;
        return Objects.equals(idOrden, orden.idOrden) &&
                Objects.equals(totalOrden, orden.totalOrden) &&
                Objects.equals(fechaOrden, orden.fechaOrden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrden, totalOrden, fechaOrden);
    }
}


