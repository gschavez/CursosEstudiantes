package com.trabajo.trabajo.controller;
import com.trabajo.trabajo.model.Libro;
import com.trabajo.trabajo.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    //GET /api/libros
    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodas() {
        return ResponseEntity.ok(libroService.obtenerTodas());
    }
    //GET /api/libros/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.obtenerPorId(id));
    }
    //PUT /api/libros/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.actualizar(id, libro));
    }

    //POST /api/libros
    @PostMapping
    public ResponseEntity<Libro> guardar(@RequestBody Libro libro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.guardar(libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        libroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}


