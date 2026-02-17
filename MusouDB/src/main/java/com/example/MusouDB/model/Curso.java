package com.example.MusouDB.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(name = "nombre_curso", nullable = false, length = 45)
    private String nombreCurso;

    @Column(name = "descripcion_curso", nullable = false)
    private String descripcionCurso;

    @Column(name = "detalle_curso", nullable = false, length = 1000)
    private String detalleCurso;

    @Column(name = "modalidad_curso", nullable = false, length = 45)
    private String modalidadCurso;

    @Column(name = "inicio_curso", nullable = false, columnDefinition = "DATE")
    private LocalDate inicioCurso;

    @Column(name = "fin_curso", nullable = false, columnDefinition = "DATE")
    private LocalDate finCurso;

    @Column(name = "costo_curso", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double costoCurso;

    @Column(name = "url_imagen_curso", length = 1000)
    private String urlImagenCurso;

    // ------ Relacion con resena 1:N
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Resena> resenas = new ArrayList<>();

    @ManyToMany(mappedBy = "usuarioTieneCursos")
    List<Usuario> cursosTieneEstudiantes;

    @ManyToMany(mappedBy = "ordenesTieneCursos")
    List<Orden> cursoPerteneceOrden;
    /*@ManyToMany(mappedBy = "cursos")
    private List<Usuario> usuarios = new ArrayList<>();
    // Constructor vacío*/

    public Curso() {
    }

    // Constructor con parámetros
    public Curso(Long idCurso, String nombreCurso, String detalleCurso, String descripcionCurso,
                 LocalDate inicioCurso, String modalidadCurso, LocalDate finCurso,
                 Double costoCurso, String urlImagenCurso) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.detalleCurso = detalleCurso;
        this.descripcionCurso = descripcionCurso;
        this.inicioCurso = inicioCurso;
        this.modalidadCurso = modalidadCurso;
        this.finCurso = finCurso;
        this.costoCurso = costoCurso;
        this.urlImagenCurso = urlImagenCurso;
    }

    // Getters y Setters
    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public String getDetalleCurso() {
        return detalleCurso;
    }

    public void setDetalleCurso(String detalleCurso) {
        this.detalleCurso = detalleCurso;
    }

    public String getModalidadCurso() {
        return modalidadCurso;
    }

    public void setModalidadCurso(String modalidadCurso) {
        this.modalidadCurso = modalidadCurso;
    }

    public LocalDate getInicioCurso() {
        return inicioCurso;
    }

    public void setInicioCurso(LocalDate inicioCurso) {
        this.inicioCurso = inicioCurso;
    }

    public LocalDate getFinCurso() {
        return finCurso;
    }

    public void setFinCurso(LocalDate finCurso) {
        this.finCurso = finCurso;
    }

    public Double getCostoCurso() {
        return costoCurso;
    }

    public void setCostoCurso(Double costoCurso) {
        this.costoCurso = costoCurso;
    }

    public String getUrlImagenCurso() {
        return urlImagenCurso;
    }

    public void setUrlImagenCurso(String urlImagenCurso) {
        this.urlImagenCurso = urlImagenCurso;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }

    public List<Usuario> getCursosTieneEstudiantes() {
        return cursosTieneEstudiantes;
    }

    public void setCursosTieneEstudiantes(List<Usuario> cursosTieneEstudiantes) {
        this.cursosTieneEstudiantes = cursosTieneEstudiantes;
    }

    public List<Orden> getCursoPerteneceOrden() {
        return cursoPerteneceOrden;
    }

    public void setCursoPerteneceOrden(List<Orden> cursoPerteneceOrden) {
        this.cursoPerteneceOrden = cursoPerteneceOrden;
    }

    // toString
    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", nombreCurso='" + nombreCurso + '\'' +
                ", descripcionCurso='" + descripcionCurso + '\'' +
                ", detalleCurso='" + detalleCurso + '\'' +
                ", modalidadCurso='" + modalidadCurso + '\'' +
                ", inicioCurso=" + inicioCurso +
                ", finCurso=" + finCurso +
                ", costoCurso=" + costoCurso +
                ", urlImagenCurso='" + urlImagenCurso + '\'' +
                '}';
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso curso)) return false;
        return Objects.equals(idCurso, curso.idCurso) &&
                Objects.equals(nombreCurso, curso.nombreCurso) &&
                Objects.equals(descripcionCurso, curso.descripcionCurso) &&
                Objects.equals(detalleCurso, curso.detalleCurso) &&
                Objects.equals(modalidadCurso, curso.modalidadCurso) &&
                Objects.equals(inicioCurso, curso.inicioCurso) &&
                Objects.equals(finCurso, curso.finCurso) &&
                Objects.equals(costoCurso, curso.costoCurso) &&
                Objects.equals(urlImagenCurso, curso.urlImagenCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, nombreCurso, descripcionCurso, detalleCurso, modalidadCurso, inicioCurso, finCurso, costoCurso, urlImagenCurso);
    }
}


