package com.example.MusouDB.exceptions;

public class CursoNotFoundException extends RuntimeException {
    public CursoNotFoundException(Long idCurso) {
        super("No se encontró al curso con el id: " + idCurso);
    }
}
