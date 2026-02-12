package com.example.MusouDB.exceptions;

public class RecursoNotFoundException extends RuntimeException {
    public RecursoNotFoundException(Long idRecurso) {
        super("No se encontró el recurso con el id: " + idRecurso);
    }
}
