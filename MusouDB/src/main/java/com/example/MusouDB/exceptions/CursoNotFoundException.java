package com.example.MusouDB.exceptions;

public class CursoNotFoundException extends RuntimeException {
    public CursoNotFoundException(Long idCurso) {
        super("No se encontró el curso con el id: " + idCurso);
    }
}
