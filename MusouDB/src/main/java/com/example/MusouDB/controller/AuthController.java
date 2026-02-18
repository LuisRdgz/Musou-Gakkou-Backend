package com.example.MusouDB.controller;

import com.example.MusouDB.jwt.JwtUtil;
import com.example.MusouDB.model.Usuario;
import com.example.MusouDB.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UsuarioService usuarioService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder){
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // Metodo para generar el JWT y Authorization a la API
    // POST 201 - 404)
    @PostMapping("/login")
    public ResponseEntity<?> tokenUsername(@RequestParam String correoUsuario, @RequestParam String contrasena){
        Usuario usuarioByCorreoUsuario = usuarioService.findByCorreoUsuario(correoUsuario);

        if (usuarioByCorreoUsuario == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!passwordEncoder.matches(contrasena, usuarioByCorreoUsuario.getContrasenaUsuario())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        else {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(jwtUtil.generateToken(correoUsuario));
        }
    }
}
