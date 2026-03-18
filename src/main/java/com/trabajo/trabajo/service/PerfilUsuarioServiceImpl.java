package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.PerfilUsuario;
import com.trabajo.trabajo.repository.PerfilUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilUsuarioServiceImpl implements PerfilUsuarioService{

    private final PerfilUsuarioRepository perfilUsuarioRepository;

    public PerfilUsuarioServiceImpl(PerfilUsuarioRepository perfilUsuarioRepository) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
    }

    @Override
    public List<PerfilUsuario> obtenerTodo() {
        return perfilUsuarioRepository.findAll();
    }

    @Override
    public PerfilUsuario obtenerPorId(Long id) {
        return perfilUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil de usuario no encontrado con id: " + id));
    }
    @Override
    public PerfilUsuario actualizar(Long id, PerfilUsuario perfilUsuario) {
        PerfilUsuario perfilAc = perfilUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil de usuario no encontrado con id: " + id));
        perfilAc.setDocumento(perfilUsuario.getDocumento());
        perfilAc.setTelefono(perfilUsuario.getTelefono());
        return perfilUsuarioRepository.save(perfilAc);
    }

    @Override
    public PerfilUsuario guardar(PerfilUsuario perfilUsuario) {
        return perfilUsuarioRepository.save(perfilUsuario);
    }

    @Override
    public void eliminar(Long id) {
        PerfilUsuario perfil = perfilUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil de usuario no encontrado con id: " + id));
        perfilUsuarioRepository.delete(perfil);
    }
}
