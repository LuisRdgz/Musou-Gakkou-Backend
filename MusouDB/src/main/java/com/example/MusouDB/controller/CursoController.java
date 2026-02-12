package com.example.MusouDB.controller;

import com.example.MusouDB.exceptions.CursoNotFoundException;
import com.example.MusouDB.model.Curso;
import com.example.MusouDB.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CursoController {
    // Inyectar Curso Service
    private final CursoService cursoService;
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    // Mapear getCursos()
    @GetMapping("/cursos")
    public List<Curso> findAll(){
        return cursoService.getCursos();
    }

    @PostMapping("/nuevo-curso")
    public ResponseEntity<Curso> saveCurso(@RequestBody Curso nuevoCurso) {
        //
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cursoService.crearCurso(nuevoCurso));
    }

    @GetMapping("/cursos/{idCurso}")
    public ResponseEntity<Curso> findById(@PathVariable Long idCurso){
        try{
            return ResponseEntity.ok(cursoService.findById(idCurso));
        }
        catch(CursoNotFoundException e){
            //return ResponseEntity.notFound().build();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar-curso/{idCurso}")
    public ResponseEntity<Curso> deleteById(@PathVariable Long idCurso) {
        try {
            cursoService.deleteCurso(idCurso);
            //ResponseEntity.notContent().build();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CursoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Mapear updateUser (201 y 404)
    @PutMapping("/update-curso/{idCurso}")
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso,@PathVariable Long idCurso){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(cursoService.updateCurso(curso,idCurso));
            //return ResponseEntity.created(userService.updateUser(user,id)); //(No jalo)
        } catch(CursoNotFoundException e){
            //return ResponseEntity.notFound().build();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
