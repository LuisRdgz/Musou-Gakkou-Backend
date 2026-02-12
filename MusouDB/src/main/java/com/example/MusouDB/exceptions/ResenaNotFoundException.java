package com.example.MusouDB.exceptions;

public class ResenaNotFoundException extends RuntimeException {
    public ResenaNotFoundException(Long idResena) {
        super("No se encontró la reseña con ID: " + idResena);
    }
}