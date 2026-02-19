package com.example.MusouDB.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

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

    // ------- Relacion con Usuario N:1
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "orden_id_usuario") // FK
    private Usuario usuario ;

    // -------- Relacion con Cursos N:N
    @ManyToMany
    @JoinTable(
            name = "ordenes_tiene_cursos",
            joinColumns = @JoinColumn(name = "id_orden"),
            inverseJoinColumns = @JoinColumn(name = "id_curso"))
    Set<Curso> ordenesTieneCursos;

    // -------- Relacion con Recursos N:N
    @ManyToMany
    @JoinTable(
            name = "ordenes_tiene_recursos",
            joinColumns = @JoinColumn(name = "id_orden"),
            inverseJoinColumns = @JoinColumn(name = "id_recurso"))
    Set<Recurso> ordenesTieneRecursos;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Curso> getOrdenesTieneCursos() {
        return ordenesTieneCursos;
    }

    public void setOrdenesTieneCursos(Set<Curso> ordenesTieneCursos) {
        this.ordenesTieneCursos = ordenesTieneCursos;
    }

    public Set<Recurso> getOrdenesTieneRecursos() {
        return ordenesTieneRecursos;
    }

    public void setOrdenesTieneRecursos(Set<Recurso> ordenesTieneRecursos) {
        this.ordenesTieneRecursos = ordenesTieneRecursos;
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


