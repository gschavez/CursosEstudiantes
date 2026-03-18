package com.trabajo.trabajo.controller;

import com.trabajo.trabajo.model.Curso;
import com.trabajo.trabajo.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    //GET /api/cursos
    @GetMapping
    public ResponseEntity<List<Curso>> obtenerTodos(){
        return ResponseEntity.ok(cursoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(cursoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Curso> guardar(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.guardar(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso>actualizar(@PathVariable Long id, @RequestBody Curso curso){
        return ResponseEntity.ok(cursoService.actualizar(id ,curso));
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void>eliminar(@PathVariable Long id){
        cursoService.eliminar(id);
        return  ResponseEntity.noContent().build();
    }


}
