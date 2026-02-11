package com.example.MusouDB.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "resena")
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_resena;

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private Float valoracion_resena;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fecha_resena;

    @Column(nullable = false, length = 45)
    private String titulo_resena;

    @Column(nullable = false)
    private String contenido_resena;

    //Coloque Llave Foranea faltante


    public Resena(Long id_resena, Float valoracion_resena, LocalDateTime fecha_resena, String titulo_resena, String contenido_resena) {
        this.id_resena = id_resena;
        this.valoracion_resena = valoracion_resena;
        this.fecha_resena = fecha_resena;
        this.titulo_resena = titulo_resena;
        this.contenido_resena = contenido_resena;
    }

    public Resena(){

    }

    public Long getId_resena() {
        return id_resena;
    }

    public void setId_resena(Long id_resena) {
        this.id_resena = id_resena;
    }

    public Float getValoracion_resena() {
        return valoracion_resena;
    }

    public void setValoracion_resena(Float valoracion_resena) {
        this.valoracion_resena = valoracion_resena;
    }

    public LocalDateTime getFecha_resena() {
        return fecha_resena;
    }

    public void setFecha_resena(LocalDateTime fecha_resena) {
        this.fecha_resena = fecha_resena;
    }

    public String getTitulo_resena() {
        return titulo_resena;
    }

    public void setTitulo_resena(String titulo_resena) {
        this.titulo_resena = titulo_resena;
    }

    public String getContenido_resena() {
        return contenido_resena;
    }

    public void setContenido_resena(String contenido_resena) {
        this.contenido_resena = contenido_resena;
    }

    @Override
    public String toString() {
        return "Resena{" +
                "id_resena=" + id_resena +
                ", valoracion_resena=" + valoracion_resena +
                ", fecha_resena=" + fecha_resena +
                ", titulo_resena='" + titulo_resena + '\'' +
                ", contenido_resena='" + contenido_resena + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Resena resena)) return false;
        return Objects.equals(id_resena, resena.id_resena) && Objects.equals(valoracion_resena, resena.valoracion_resena) && Objects.equals(fecha_resena, resena.fecha_resena) && Objects.equals(titulo_resena, resena.titulo_resena) && Objects.equals(contenido_resena, resena.contenido_resena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_resena, valoracion_resena, fecha_resena, titulo_resena, contenido_resena);
    }
}
