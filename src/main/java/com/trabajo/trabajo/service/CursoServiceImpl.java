package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.Curso;
import com.trabajo.trabajo.repository.CursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService{

    private final CursoRepository cursoRepository;


    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    @Override
    public List<Curso> obtenerTodos(){
        return cursoRepository.findAll();
    }
    @Override
    public Curso obtenerPorId(Long id){
        return cursoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro curso con id: " + id));

    }

    @Override
    public Curso actualizar(Long id, Curso curso) {
        Curso cursoAc = cursoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro Curso con id: " + id));
        cursoAc.setNombre(curso.getNombre());
        cursoAc.setCreditos(curso.getCreditos());
        return cursoRepository.save(cursoAc);
    }

    @Override
    public Curso guardar(Curso curso){
        return cursoRepository.save(curso);
    }
    @Override
    public void eliminar(Long id){
        Curso cursoEl= cursoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Categoria no encontrada con id: " + id));
        cursoRepository.delete(cursoEl);
    }
}

