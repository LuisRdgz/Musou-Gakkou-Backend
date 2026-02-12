package com.example.MusouDB.repository;

import com.example.MusouDB.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {

    // Al ser único en la entidad, devuelve un solo objeto
    Recurso findByNombreRecurso(String nombreRecurso);
}
