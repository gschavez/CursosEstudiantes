package com.trabajo.trabajo.service;

import com.trabajo.trabajo.model.Categoria;
import com.trabajo.trabajo.repository.CatergoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CatergoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CatergoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();  //findAll()  =   SELEC*FROM tabla
    }

    @Override
    public Categoria obtenerPorId(Long id) {
        return categoriaRepository.findById(id) //findById()    =   SELECT * FROM tabla WHERE id = ?
                .orElseThrow(()->new RuntimeException("No se encontro categoria con id: " + id));

    }

    @Override
    public Categoria actualizar(Long id, Categoria categoria) {
        Categoria categoriaAc = categoriaRepository.findById(id).  //findById()    =   SELECT * FROM tabla WHERE id = ?
                orElseThrow(()-> new RuntimeException("no se encontro categoria con id : " + id));
        categoriaAc.setDescripcion(categoria.getDescripcion());
        categoriaAc.setNombre(categoria.getNombre());
        return categoriaRepository.save(categoriaAc);           //save()    =   INSERT INTO tabla (campos) VALUES (...)
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);             //save()    =   INSERT INTO tabla (campos) VALUES (...)
    }

    @Override
    public void eliminar(Long id) {
        Categoria categoriaEl = categoriaRepository.findById(id)        //findById()    =   SELECT * FROM tabla WHERE id = ?
                .orElseThrow(()->new RuntimeException("Categoria no encontrada con id: " + id));
        categoriaRepository.delete(categoriaEl);                //delete()  =   DELETE FROM tabla WHERE id = ?
    }
}