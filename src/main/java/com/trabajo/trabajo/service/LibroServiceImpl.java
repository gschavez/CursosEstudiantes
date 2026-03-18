package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.Libro;
import com.trabajo.trabajo.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> obtenerTodas() {
        return libroRepository.findAll();
    }

    @Override
    public Libro obtenerPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con id: " + id));
    }
    @Override
    public Libro actualizar(Long id, Libro libro) {
        Libro libroAc = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con id: " + id));
        libroAc.setTitulo(libro.getTitulo());
        libroAc.setAutor(libro.getAutor());
        libroAc.setAnioPublicacion(libro.getAnioPublicacion());
        return libroRepository.save(libroAc);
    }

    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void eliminar(Long id) {
        Libro libroEl = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con id: " + id));
        libroRepository.delete(libroEl);
    }
}
