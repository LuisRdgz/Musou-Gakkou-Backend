package com.example.MusouDB.service;

import com.example.MusouDB.exceptions.ResenaNotFoundException;
import com.example.MusouDB.model.Resena;
import com.example.MusouDB.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenaService {

    private final ResenaRepository resenaRepository;

    @Autowired
    public ResenaService(ResenaRepository resenaRepository) {
        this.resenaRepository = resenaRepository;
    }

    // Obtener todas las reseñas
    public List<Resena> getResenas() {
        return resenaRepository.findAll();
    }

    // Crear una nueva reseña
    public Resena crearResena(Resena nuevaResena) {
        return resenaRepository.save(nuevaResena);
    }

    // Buscar por ID
    public Resena findById(Long idResena) {
        return resenaRepository.findById(idResena)
                .orElseThrow(() -> new ResenaNotFoundException(idResena));
    }

    // Eliminar reseña por ID
    public void deleteResena(Long idResena) {
        if (resenaRepository.existsById(idResena)) {
            resenaRepository.deleteById(idResena);
        } else {
            throw new ResenaNotFoundException(idResena);
        }
    }

    // Actualizar reseña por ID
    public Resena updateResena(Resena resena, Long idResena) {
        return resenaRepository.findById(idResena)
                .map(resenaData -> {
                    resenaData.setValoracionResena(resena.getValoracionResena());
                    resenaData.setFechaResena(resena.getFechaResena());
                    resenaData.setTituloResena(resena.getTituloResena());
                    resenaData.setContenidoResena(resena.getContenidoResena());
                    return resenaRepository.save(resenaData);
                })
                .orElseThrow(() -> new ResenaNotFoundException(idResena));
    }
}