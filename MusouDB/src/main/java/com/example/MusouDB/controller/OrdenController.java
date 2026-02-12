package com.example.MusouDB.controller;

import com.example.MusouDB.exceptions.OrdenNotFoundException;
import com.example.MusouDB.model.Orden;
import com.example.MusouDB.service.OrdenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrdenController {

    // Inyectar Orden Service
    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    // Mapear findAll()
    @GetMapping("/ordenes")
    public List<Orden> findAll() {
        return ordenService.getOrdenes();
    }

    // Mapear nueva-orden (POST)
    @PostMapping("/nueva-orden")
    public ResponseEntity<Orden> saveOrden(@RequestBody Orden nuevaOrden) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ordenService.crearOrden(nuevaOrden));
    }

    // Mapear findById (GET)
    @GetMapping("/ordenes/{idOrden}")
    public ResponseEntity<Orden> findById(@PathVariable Long idOrden) {
        try {
            return ResponseEntity.ok(ordenService.findById(idOrden));
        } catch (OrdenNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Mapear borrar-orden (DELETE)
    @DeleteMapping("/borrar-orden/{idOrden}")
    public ResponseEntity<Orden> deleteById(@PathVariable Long idOrden) {
        try {
            ordenService.deleteOrden(idOrden);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OrdenNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Mapear updateOrden (PUT)
    @PutMapping("/update-orden/{idOrden}")
    public ResponseEntity<Orden> updateOrden(@RequestBody Orden orden, @PathVariable Long idOrden) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ordenService.updateOrden(orden, idOrden));
        } catch (OrdenNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}