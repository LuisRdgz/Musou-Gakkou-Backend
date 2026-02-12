package com.example.MusouDB.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario", nullable = false, length = 50)
    private String nombreUsuario;

    @Column(name = "apellido_usuario", nullable = false, length = 50)
    private String apellidoUsuario;

    @Column(name = "correo_usuario", nullable = false, unique = true)
    private String correoUsuario;

    @Column(name = "contrasena_usuario", nullable = false, length = 50)
    private String contrasenaUsuario;

    @Column(name = "telefono_usuario", nullable = false, length = 15)
    private String telefonoUsuario;

    @Column(name = "rol_usuario", nullable = false)
    private Integer rolUsuario; // 1 - Alumno. 2 - Profesor. 3 - Admin

    // ------ Relacion con order 1:N
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Orden> ordenes = new ArrayList<>();

    // ------ Relacion con resena 1:N
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Resena> resenas = new ArrayList<>();

    // -------- Relacion con Cursos N:N
    @ManyToMany
    @JoinTable(
            name = "usuario_tiene_cursos",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_curso"))
            List<Curso> usuarioTieneCursos;

    // -------- Relacion con Recursos N:N
    @ManyToMany
    @JoinTable(
            name = "usuario_tiene_recursos",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_recurso"))
    List<Recurso> usuarioTieneRecursos;

    // Constructor vacío (Obligatorio para JPA)
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(Long idUsuario, String nombreUsuario, String apellidoUsuario, String correoUsuario,
                   String contrasenaUsuario, String telefonoUsuario, Integer rolUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.rolUsuario = rolUsuario;
    }

    // Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public Integer getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(Integer rolUsuario) {
        this.rolUsuario = rolUsuario;
    }


    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }

    public List<Curso> getUsuarioTieneCursos() {
        return usuarioTieneCursos;
    }

    public void setUsuarioTieneCursos(List<Curso> usuarioTieneCursos) {
        this.usuarioTieneCursos = usuarioTieneCursos;
    }

    public List<Recurso> getUsuarioTieneRecursos() {
        return usuarioTieneRecursos;
    }

    public void setUsuarioTieneRecursos(List<Recurso> usuarioTieneRecursos) {
        this.usuarioTieneRecursos = usuarioTieneRecursos;
    }


    // Métodos de utilidad
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", apellidoUsuario='" + apellidoUsuario + '\'' +
                ", correoUsuario='" + correoUsuario + '\'' +
                ", contrasenaUsuario='" + contrasenaUsuario + '\'' +
                ", telefonoUsuario='" + telefonoUsuario + '\'' +
                ", rolUsuario=" + rolUsuario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(idUsuario, usuario.idUsuario) &&
                Objects.equals(nombreUsuario, usuario.nombreUsuario) &&
                Objects.equals(apellidoUsuario, usuario.apellidoUsuario) &&
                Objects.equals(correoUsuario, usuario.correoUsuario) &&
                Objects.equals(contrasenaUsuario, usuario.contrasenaUsuario) &&
                Objects.equals(telefonoUsuario, usuario.telefonoUsuario) &&
                Objects.equals(rolUsuario, usuario.rolUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombreUsuario, apellidoUsuario, correoUsuario, contrasenaUsuario, telefonoUsuario, rolUsuario);
    }
}
