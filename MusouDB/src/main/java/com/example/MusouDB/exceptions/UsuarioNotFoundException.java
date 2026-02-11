package com.example.MusouDB.exceptions;


public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long idUsuario) {
        super("No se encontró al usuario con el id: " + idUsuario);
    }
}
