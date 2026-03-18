package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    List<Libro> obtenerTodas();
    Libro obtenerPorId(Long id);
    Libro actualizar(Long id, Libro libro);
    Libro guardar(Libro libro);
    void eliminar(Long id);
}
