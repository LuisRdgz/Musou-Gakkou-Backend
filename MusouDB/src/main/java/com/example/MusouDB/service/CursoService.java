package com.example.MusouDB.service;

import com.example.MusouDB.exceptions.CursoNotFoundException;
import com.example.MusouDB.exceptions.UsuarioNotFoundException;
import com.example.MusouDB.model.Curso;
import com.example.MusouDB.model.Usuario;
import com.example.MusouDB.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    // Inyectar la dependencia
    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    // Metodo para recuperar a todos los cursos
    public List<Curso> getCursos(){
        return cursoRepository.findAll();
    }

    // Metodo para crear nuevas instancias
    public Curso crearCurso(Curso nuevoCurso){
        return cursoRepository.save(nuevoCurso);
    }


    //findByNombreCurso
    public Curso findByNombreCurso(String nombreCurso){
        return cursoRepository.findByNombreCurso(nombreCurso);
    }

    // findByModalidadCurso
    public Curso findByModalidadCurso(String modalidadCurso){
        return cursoRepository.findByModalidadCurso(modalidadCurso);
    }

    //findByIdCurso
    public Curso findById(Long idCurso){
        return cursoRepository.findById(idCurso)
                .orElseThrow(() -> new CursoNotFoundException(idCurso));
    }

    //delete Curso por Id
    public void deleteCurso(Long idCurso){
        if(cursoRepository.existsById(idCurso)){
            cursoRepository.deleteById(idCurso);
        }else{
            throw new CursoNotFoundException(idCurso);
        }
    }

    //updateCurso by Id
    public Curso updateCurso(Curso curso, Long idCurso){
        return cursoRepository.findById(idCurso)
                .map(cursoData -> {
                    cursoData.setNombreCurso(curso.getNombreCurso());
                    cursoData.setDetalleCurso(curso.getDetalleCurso());
                    cursoData.setDescripcionCurso(curso.getDescripcionCurso());
                    cursoData.setInicioCurso(curso.getInicioCurso());
                    cursoData.setModalidadCurso(curso.getModalidadCurso());
                    cursoData.setFinCurso(curso.getFinCurso());
                    cursoData.setCostoCurso(curso.getCostoCurso());
                    cursoData.setUrlImagenCurso(curso.getUrlImagenCurso());
                    return cursoRepository.save(cursoData);
                })
                .orElseThrow(()->new CursoNotFoundException(idCurso));
    }
}
