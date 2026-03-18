package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {
    List<Estudiante>obtenerTodo();
    Estudiante obtenerPorId(Long id);
    Estudiante actualizar(Long id, Estudiante estudiante);
    Estudiante guardar(Estudiante estudiante);
    void eliminar(Long id);
}


