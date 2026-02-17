package com.example.MusouDB.controller;

import com.example.MusouDB.exceptions.ResenaNotFoundException;
import com.example.MusouDB.model.Resena;
import com.example.MusouDB.service.ResenaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ResenaController {

    private final ResenaService resenaService;

    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @GetMapping("/resenas")
    public List<Resena> findAll() {
        return resenaService.getResenas();
    }

    @PostMapping("/nueva-resena")
    public ResponseEntity<Resena> saveResena(@RequestBody Resena nuevaResena) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(resenaService.crearResena(nuevaResena));
    }

    @GetMapping("/resenas/{idResena}")
    public ResponseEntity<Resena> findById(@PathVariable Long idResena) {
        try {
            return ResponseEntity.ok(resenaService.findById(idResena));
        } catch (ResenaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar-resena/{idResena}")
    public ResponseEntity<Void> deleteById(@PathVariable Long idResena) {
        try {
            resenaService.deleteResena(idResena);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResenaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-resena/{idResena}")
    public ResponseEntity<Resena> updateResena(@RequestBody Resena resena, @PathVariable Long idResena) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(resenaService.updateResena(resena, idResena));
        } catch (ResenaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}