package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.Categoria;
import com.trabajo.trabajo.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> obtenerTodos();
    Curso obtenerPorId(Long id);
    Curso actualizar(Long id, Curso curso);
    Curso guardar(Curso curso);
    void eliminar(Long id);


}
