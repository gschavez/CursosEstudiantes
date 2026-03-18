package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.Estudiante;
import com.trabajo.trabajo.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    private final EstudianteRepository estudianteRepository;
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }


    @Override
    public List<Estudiante> obtenerTodo() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante obtenerPorId(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro estudiante con id: " + id));
    }

    @Override
    public Estudiante actualizar(Long id, Estudiante estudiante) {
        Estudiante estudianteAc = estudianteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro estudiante con id: " + id));
        estudianteAc.setNombre(estudiante.getNombre());
        estudianteAc.setCorreo(estudiante.getCorreo());
        return estudianteRepository.save(estudianteAc);
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminar(Long id) {
        Estudiante estudianteEl = estudianteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro estudiante con id:" + id));
        estudianteRepository.delete(estudianteEl);

    }
}
