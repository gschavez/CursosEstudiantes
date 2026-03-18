package com.trabajo.trabajo.controller;

import com.trabajo.trabajo.model.Categoria;
import com.trabajo.trabajo.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;  //Se crea el tipo de dato CategoriaSerevice para asi llamar los metodos logicos del service

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    //GET /api/categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerTodas(){
       return ResponseEntity.ok(categoriaService.obtenerTodas());
    }
    //GET /api/categorias/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.obtenerPorId(id));
    }
    //PUT /api/categorias{id}
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.actualizar(id, categoria));
    }
    //POST /api/categorias
    @PostMapping
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.guardar(categoria));
    }
    //DELETE /api/categorias{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}