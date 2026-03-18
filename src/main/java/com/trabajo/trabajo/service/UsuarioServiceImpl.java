package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.Usuario;
import com.trabajo.trabajo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }
    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);

    }
    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario usuarioAc = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        usuarioAc.setNombre(usuario.getNombre());
        usuarioAc.setCorreo(usuario.getCorreo());
        return usuarioRepository.save(usuarioAc);
    }

    @Override
    public void eliminar (Long id){
        usuarioRepository.deleteById(id);
    }

}
