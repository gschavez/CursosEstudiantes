package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> obtenerTodos();
    Usuario obtenerPorId(Long id);
    Usuario actualizar(Long id, Usuario usuario);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
}
