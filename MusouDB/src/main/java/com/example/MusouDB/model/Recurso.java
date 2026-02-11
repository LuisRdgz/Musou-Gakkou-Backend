package com.example.MusouDB.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "recurso")
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_recurso;

    @Column(nullable = false, length = 45, unique = true)
    private String nombre_recurso;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double costo_recurso;

    @Column(nullable = false, length = 1000) //Comprobar que se ejecute correctamente
    private String detalle_recurso;

    @Column(nullable = false)
    private String descripcion_recurso;

    @Column()
    private String urlImagen_recurso;

    public Recurso(Long id_recurso, String urlImagen_recurso, String descripcion_recurso, String detalle_recurso, Double costo_recurso, String nombre_recurso) {
        this.id_recurso = id_recurso;
        this.urlImagen_recurso = urlImagen_recurso;
        this.descripcion_recurso = descripcion_recurso;
        this.detalle_recurso = detalle_recurso;
        this.costo_recurso = costo_recurso;
        this.nombre_recurso = nombre_recurso;
    }

    public Recurso(){

    }

    public Long getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(Long id_recurso) {
        this.id_recurso = id_recurso;
    }

    public String getNombre_recurso() {
        return nombre_recurso;
    }

    public void setNombre_recurso(String nombre_recurso) {
        this.nombre_recurso = nombre_recurso;
    }

    public Double getCosto_recurso() {
        return costo_recurso;
    }

    public void setCosto_recurso(Double costo_recurso) {
        this.costo_recurso = costo_recurso;
    }

    public String getDetalle_recurso() {
        return detalle_recurso;
    }

    public void setDetalle_recurso(String detalle_recurso) {
        this.detalle_recurso = detalle_recurso;
    }

    public String getDescripcion_recurso() {
        return descripcion_recurso;
    }

    public void setDescripcion_recurso(String descripcion_recurso) {
        this.descripcion_recurso = descripcion_recurso;
    }

    public String getUrlImagen_recurso() {
        return urlImagen_recurso;
    }

    public void setUrlImagen_recurso(String urlImagen_recurso) {
        this.urlImagen_recurso = urlImagen_recurso;
    }

    @Override
    public String toString() {
        return "Recurso{" +
                "id_recurso=" + id_recurso +
                ", nombre_recurso='" + nombre_recurso + '\'' +
                ", costo_recurso=" + costo_recurso +
                ", detalle_recurso='" + detalle_recurso + '\'' +
                ", descripcion_recurso='" + descripcion_recurso + '\'' +
                ", urlImagen_recurso='" + urlImagen_recurso + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Recurso recurso)) return false;
        return Objects.equals(id_recurso, recurso.id_recurso) && Objects.equals(nombre_recurso, recurso.nombre_recurso) && Objects.equals(costo_recurso, recurso.costo_recurso) && Objects.equals(detalle_recurso, recurso.detalle_recurso) && Objects.equals(descripcion_recurso, recurso.descripcion_recurso) && Objects.equals(urlImagen_recurso, recurso.urlImagen_recurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_recurso, nombre_recurso, costo_recurso, detalle_recurso, descripcion_recurso, urlImagen_recurso);
    }
}


