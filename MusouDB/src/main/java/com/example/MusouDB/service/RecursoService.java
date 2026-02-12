package com.example.MusouDB.service;


import com.example.MusouDB.exceptions.RecursoNotFoundException;
import com.example.MusouDB.model.Recurso;
import com.example.MusouDB.model.Usuario;
import com.example.MusouDB.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {
    private final RecursoRepository recursoRepository;

    @Autowired
    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public List<Recurso> getRecursos() {
        return recursoRepository.findAll();
    }

    // Metodo para crear nuevas instancias
    public Recurso crearRecurso(Recurso nuevoRecurso){
        return recursoRepository.save(nuevoRecurso);
    }

    public Recurso saveRecurso(Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    // findByNombreRecurso
    public Recurso findByNombreRecurso(String nombreRecurso){
        return recursoRepository.findByNombreRecurso(nombreRecurso);
    }

    //findByIdCurso
    public Recurso findById(Long idRecurso){
        return recursoRepository.findById(idRecurso)
                .orElseThrow(() -> new RecursoNotFoundException(idRecurso));
    }

    //delete Curso por Id
    public void deleteRecurso(Long idRecurso){
        if(recursoRepository.existsById(idRecurso)){
            recursoRepository.deleteById(idRecurso);
        }else{
            throw new RecursoNotFoundException(idRecurso);
        }
    }
    public Recurso updateRecurso(Recurso recurso, Long idRecurso) {
        return recursoRepository.findById(idRecurso)
                .map(recursoData -> {
                    recursoData.setNombreRecurso(recurso.getNombreRecurso());
                    recursoData.setCostoRecurso(recurso.getCostoRecurso());
                    recursoData.setDetalleRecurso(recurso.getDetalleRecurso());
                    recursoData.setDescripcionRecurso(recurso.getDescripcionRecurso());
                    recursoData.setUrlImagenRecurso(recurso.getUrlImagenRecurso());
                    return recursoRepository.save(recursoData);
                }).orElseThrow(() -> new RecursoNotFoundException(idRecurso));
    }
}