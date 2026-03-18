package com.trabajo.trabajo.controller;

import com.trabajo.trabajo.model.Estudiante;
import com.trabajo.trabajo.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }
    //GET /api/estudiantes
    @GetMapping
    public ResponseEntity<List<Estudiante>>obtenerTodo(){
        return ResponseEntity.ok(estudianteService.obtenerTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante>obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(estudianteService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Estudiante> agregar(@RequestBody Estudiante estudiante){
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.guardar(estudiante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante>actualizar(@PathVariable Long id, @RequestBody Estudiante estudiante){
        return ResponseEntity.ok(estudianteService.actualizar(id ,estudiante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>eliminar(@PathVariable Long id){
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }







}
