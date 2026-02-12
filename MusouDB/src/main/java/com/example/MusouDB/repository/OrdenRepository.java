package com.example.MusouDB.repository;

import com.example.MusouDB.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
        // JPQL -----
        // No hay ninguno Unique entonces no se hace nada
}
