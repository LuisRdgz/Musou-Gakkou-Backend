package com.example.MusouDB.controller;

import com.example.MusouDB.exceptions.RecursoNotFoundException;
import com.example.MusouDB.model.Recurso;
import com.example.MusouDB.model.Usuario;
import com.example.MusouDB.service.RecursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RecursoController {

    // Inyectar Recurso Service
    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    // Mapear findAll() para recursos
    @GetMapping("/recursos")
    public List<Recurso> findAll() {
        return recursoService.getRecursos();
    }

    // Mapear nuevo-recurso (POST)
    @PostMapping("/nuevo-recurso")
    public ResponseEntity<Recurso> saveRecurso(@RequestBody Recurso nuevoRecurso) {
        Recurso recursoByNombreRecurso = recursoService.findByNombreRecurso(nuevoRecurso.getNombreRecurso());

        // Se valida que no existe otro recurso con el mismo nombre
        if (recursoByNombreRecurso != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(recursoService.crearRecurso(nuevoRecurso));
            //return ResponseEntity.status(HttpStatus.CREATED);
        }
    }

    // Mapear findById (GET)
    @GetMapping("/recursos/{idRecurso}")
    public ResponseEntity<Recurso> findById(@PathVariable Long idRecurso) {
        try {
            // Asegúrate de que este metodo exista en tu RecursoService
            return ResponseEntity.ok(recursoService.findById(idRecurso));
        } catch (RecursoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Mapear borrar-recurso (DELETE)
    @DeleteMapping("/borrar-recurso/{idRecurso}")
    public ResponseEntity<Void> deleteById(@PathVariable Long idRecurso) {
        try {
            recursoService.deleteRecurso(idRecurso);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RecursoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Mapear updateRecurso (PUT)
    @PutMapping("/update-recurso/{idRecurso}")
    public ResponseEntity<Recurso> updateRecurso(@RequestBody Recurso recurso, @PathVariable Long idRecurso) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(recursoService.updateRecurso(recurso, idRecurso));
        } catch (RecursoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}