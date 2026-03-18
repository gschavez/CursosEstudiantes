package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> obtenerTodas();
    Categoria obtenerPorId(Long id);
    Categoria actualizar(Long id, Categoria categoria);
    Categoria guardar(Categoria categoria);
    void eliminar(Long id);
}
