package com.example.MusouDB.repository;

import com.example.MusouDB.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // JPQL --- NombreCurso
    //@Query("SELECT u FROM u WHERE u.username =? 1")
    Curso findByNombreCurso(String nombreCurso);
    //Usuario findByEmail(String correo_usuario);
    Curso findByModalidadCurso(String modalidadCurso);
}
