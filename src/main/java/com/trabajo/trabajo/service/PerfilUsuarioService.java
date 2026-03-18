package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.PerfilUsuario;
import com.trabajo.trabajo.repository.PerfilUsuarioRepository;

import java.util.List;
import java.util.Optional;

public interface PerfilUsuarioService {
    List<PerfilUsuario> obtenerTodo();
    PerfilUsuario obtenerPorId(Long id);
    PerfilUsuario actualizar(Long id, PerfilUsuario perfilUsuario);
    PerfilUsuario guardar(PerfilUsuario perfilUsuario);
    void eliminar(Long id);
}
