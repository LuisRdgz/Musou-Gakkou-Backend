package com.example.MusouDB.exceptions;

public class OrdenNotFoundException extends RuntimeException {
    public OrdenNotFoundException(Long idOrden) {
        super("No se pudo encontrar la orden con el ID: " + idOrden);
    }
}
