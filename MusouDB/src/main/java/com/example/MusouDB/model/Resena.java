package com.example.MusouDB.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "resena")
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena")
    private Long idResena;

    @Column(name = "valoracion_resena", nullable = false, columnDefinition = "DECIMAL(2,1)")
    private Float valoracionResena;

    @Column(name = "fecha_resena", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaResena;

    @Column(name = "titulo_resena", nullable = false, length = 45)
    private String tituloResena;

    @Column(name = "contenido_resena", nullable = false)
    private String contenidoResena;

    // ------- Relacion con Curso N:1
    @ManyToOne
    @JoinColumn(name = "resena_id_curso")// FK
    private Curso curso;

    // ------- Relacion con Usuario N:1
    @ManyToOne
    @JoinColumn(name = "resena_id_usuario")// FK
    private Usuario usuario;

    // Constructor vacío
    public Resena() {
    }

    // Constructor con parámetros
    public Resena(Long idResena, Float valoracionResena, LocalDateTime fechaResena, String tituloResena, String contenidoResena) {
        this.idResena = idResena;
        this.valoracionResena = valoracionResena;
        this.fechaResena = fechaResena;
        this.tituloResena = tituloResena;
        this.contenidoResena = contenidoResena;
    }

    // Getters y Setters
    public Long getIdResena() {
        return idResena;
    }

    public void setIdResena(Long idResena) {
        this.idResena = idResena;
    }

    public Float getValoracionResena() {
        return valoracionResena;
    }

    public void setValoracionResena(Float valoracionResena) {
        this.valoracionResena = valoracionResena;
    }

    public LocalDateTime getFechaResena() {
        return fechaResena;
    }

    public void setFechaResena(LocalDateTime fechaResena) {
        this.fechaResena = fechaResena;
    }

    public String getTituloResena() {
        return tituloResena;
    }

    public void setTituloResena(String tituloResena) {
        this.tituloResena = tituloResena;
    }

    public String getContenidoResena() {
        return contenidoResena;
    }

    public void setContenidoResena(String contenidoResena) {
        this.contenidoResena = contenidoResena;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public String toString() {
        return "Resena{" +
                "idResena=" + idResena +
                ", valoracionResena=" + valoracionResena +
                ", fechaResena=" + fechaResena +
                ", tituloResena='" + tituloResena + '\'' +
                ", contenidoResena='" + contenidoResena + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resena resena)) return false;
        return Objects.equals(idResena, resena.idResena) &&
                Objects.equals(valoracionResena, resena.valoracionResena) &&
                Objects.equals(fechaResena, resena.fechaResena) &&
                Objects.equals(tituloResena, resena.tituloResena) &&
                Objects.equals(contenidoResena, resena.contenidoResena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResena, valoracionResena, fechaResena, tituloResena, contenidoResena);
    }
}
