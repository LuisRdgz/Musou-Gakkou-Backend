package com.example.MusouDB.service;

import com.example.MusouDB.exceptions.OrdenNotFoundException;
import com.example.MusouDB.model.Orden;
import com.example.MusouDB.model.Usuario;
import com.example.MusouDB.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;

    @Autowired
    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    // Obtener todas las órdenes
    public List<Orden> getOrdenes() {
        return ordenRepository.findAll();
    }

    // Crear una nueva orden
    public Orden crearOrden(Orden nuevaOrden) {
        return ordenRepository.save(nuevaOrden);
    }

    // Buscar por ID
    public Orden findById(Long idOrden) {
        return ordenRepository.findById(idOrden)
                .orElseThrow(() -> new OrdenNotFoundException(idOrden));
    }

    // Eliminar orden por ID
    public void deleteOrden(Long idOrden) {
        if (ordenRepository.existsById(idOrden)) {
            ordenRepository.deleteById(idOrden);
        } else {
            throw new OrdenNotFoundException(idOrden);
        }
    }

    // Actualizar orden por ID
    public Orden updateOrden(Orden orden, Long idOrden) {
        return ordenRepository.findById(idOrden)
                .map(ordenData -> {
                    ordenData.setTotalOrden(orden.getTotalOrden());
                    ordenData.setFechaOrden(orden.getFechaOrden());
                    return ordenRepository.save(ordenData);
                })
                .orElseThrow(() -> new OrdenNotFoundException(idOrden));
    }
}