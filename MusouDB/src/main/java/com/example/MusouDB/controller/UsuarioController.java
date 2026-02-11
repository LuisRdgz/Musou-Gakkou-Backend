package com.example.MusouDB.controller;

import com.example.MusouDB.exceptions.UsuarioNotFoundException;
import com.example.MusouDB.model.Usuario;
import com.example.MusouDB.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    // Inyectar Usuario Service
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    // Mapear getUsers()
    @GetMapping("/usuarios")
    public List<Usuario> findAll(){
        return usuarioService.getUsuarios();
    }

    @PostMapping("/nuevo-usuario")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario nuevoUsuario) {
        // Recuperar el username y el email de un newUser usando getters y métodos JPA Query
        Usuario usuarioByNombreUsuario = usuarioService.findByNombreUsuario(nuevoUsuario.getNombreUsuario());
        Usuario usuarioByCorreoUsuario = usuarioService.findByCorreoUsuario(nuevoUsuario.getCorreoUsuario());
        // Evaluar si los valores de una instancia ya existen
        // Implementar dos códigos de estado (409 y 201)
        //if (userByUsername != null || userByEmail != null) // Esto se movio para prueba
        if (usuarioByNombreUsuario != null || usuarioByCorreoUsuario != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(usuarioService.crearUsuario(nuevoUsuario));
            //return ResponseEntity.status(HttpStatus.CREATED);
        }
    }


    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Usuario> findById(@PathVariable Long idUsuario){
        try{
            return ResponseEntity.ok(usuarioService.findById(idUsuario));
        }
        catch(UsuarioNotFoundException e){
            //return ResponseEntity.notFound().build();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Mapear (204 y 404)
    @DeleteMapping("/borrar-usuario/{idUsuario}")
    public ResponseEntity<Usuario> deleteById(@PathVariable Long idUsuario) {
        try {
            usuarioService.deleteUsuario(idUsuario);
            //ResponseEntity.notContent().build();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (UsuarioNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Mapear updateUser (201 y 404)
    @PutMapping("/update-usuario/{idUsuario}")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario,@PathVariable Long idUsuario){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(usuarioService.updateUsuario(usuario,idUsuario));
            //return ResponseEntity.created(userService.updateUser(user,id)); //(No jalo)
        } catch(UsuarioNotFoundException e){
            //return ResponseEntity.notFound().build();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    }
