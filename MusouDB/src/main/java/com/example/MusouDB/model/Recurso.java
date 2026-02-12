package com.example.MusouDB.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "recurso")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recurso")
    private Long idRecurso;

    @Column(name = "nombre_recurso", nullable = false, length = 45, unique = true)
    private String nombreRecurso;

    @Column(name = "costo_recurso", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double costoRecurso;

    @Column(name = "detalle_recurso", nullable = false, length = 1000)
    private String detalleRecurso;

    @Column(name = "descripcion_recurso", nullable = false)
    private String descripcionRecurso;

    @Column(name = "url_imagen_recurso")
    private String urlImagenRecurso;

    @ManyToMany(mappedBy = "usuarioTieneRecursos")
    List<Usuario> recursoTieneUsuarios;

    @ManyToMany(mappedBy = "ordenesTieneRecursos")
    List<Orden> recursoPerteneceOrden;

    /*@ManyToMany
    Set<Orden> Orden;*/
    // Constructor vacío
    public Recurso() {
    }

    // Constructor con parámetros
    public Recurso(Long idRecurso, String nombreRecurso, Double costoRecurso,
                   String detalleRecurso, String descripcionRecurso, String urlImagenRecurso) {
        this.idRecurso = idRecurso;
        this.nombreRecurso = nombreRecurso;
        this.costoRecurso = costoRecurso;
        this.detalleRecurso = detalleRecurso;
        this.descripcionRecurso = descripcionRecurso;
        this.urlImagenRecurso = urlImagenRecurso;
    }

    // Getters y Setters
    public Long getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Long idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public Double getCostoRecurso() {
        return costoRecurso;
    }

    public void setCostoRecurso(Double costoRecurso) {
        this.costoRecurso = costoRecurso;
    }

    public String getDetalleRecurso() {
        return detalleRecurso;
    }

    public void setDetalleRecurso(String detalleRecurso) {
        this.detalleRecurso = detalleRecurso;
    }

    public String getDescripcionRecurso() {
        return descripcionRecurso;
    }

    public void setDescripcionRecurso(String descripcionRecurso) {
        this.descripcionRecurso = descripcionRecurso;
    }

    public String getUrlImagenRecurso() {
        return urlImagenRecurso;
    }

    public void setUrlImagenRecurso(String urlImagenRecurso) {
        this.urlImagenRecurso = urlImagenRecurso;
    }

    public List<Usuario> getRecursoTieneUsuarios() {
        return recursoTieneUsuarios;
    }

    public void setRecursoTieneUsuarios(List<Usuario> recursoTieneUsuarios) {
        this.recursoTieneUsuarios = recursoTieneUsuarios;
    }

    public List<Orden> getRecursoPerteneceOrden() {
        return recursoPerteneceOrden;
    }

    public void setRecursoPerteneceOrden(List<Orden> recursoPerteneceOrden) {
        this.recursoPerteneceOrden = recursoPerteneceOrden;
    }

    // toString
    @Override
    public String toString() {
        return "Recurso{" +
                "idRecurso=" + idRecurso +
                ", nombreRecurso='" + nombreRecurso + '\'' +
                ", costoRecurso=" + costoRecurso +
                ", detalleRecurso='" + detalleRecurso + '\'' +
                ", descripcionRecurso='" + descripcionRecurso + '\'' +
                ", urlImagenRecurso='" + urlImagenRecurso + '\'' +
                '}';
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recurso recurso)) return false;
        return Objects.equals(idRecurso, recurso.idRecurso) &&
                Objects.equals(nombreRecurso, recurso.nombreRecurso) &&
                Objects.equals(costoRecurso, recurso.costoRecurso) &&
                Objects.equals(detalleRecurso, recurso.detalleRecurso) &&
                Objects.equals(descripcionRecurso, recurso.descripcionRecurso) &&
                Objects.equals(urlImagenRecurso, recurso.urlImagenRecurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecurso, nombreRecurso, costoRecurso, detalleRecurso, descripcionRecurso, urlImagenRecurso);
    }
}


