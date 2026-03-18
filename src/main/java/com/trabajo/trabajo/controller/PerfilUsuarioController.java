package com.trabajo.trabajo.controller;

import com.trabajo.trabajo.model.PerfilUsuario;
import com.trabajo.trabajo.service.PerfilUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilUsuarioController {
    private final PerfilUsuarioService perfilUsuarioService;

    public PerfilUsuarioController(PerfilUsuarioService perfilUsuarioService) {
        this.perfilUsuarioService = perfilUsuarioService;
    }

    // GET /api/perfiles
    @GetMapping
    public ResponseEntity<List<PerfilUsuario>> obtenerTodos() {
        return ResponseEntity.ok(perfilUsuarioService.obtenerTodo());
    }

    // GET /api/perfiles/{id}
    @GetMapping("/{id}")
    public ResponseEntity<PerfilUsuario> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(perfilUsuarioService.obtenerPorId(id));
    }

    // PUT /api/perfiles/{id}
    @PutMapping("/{id}")
    public ResponseEntity<PerfilUsuario> actualizar(@PathVariable Long id, @RequestBody PerfilUsuario perfilUsuario) {
        return ResponseEntity.ok(perfilUsuarioService.actualizar(id, perfilUsuario));
    }

    // POST /api/perfiles
    @PostMapping
    public ResponseEntity<PerfilUsuario> agregar(@RequestBody PerfilUsuario perfilUsuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilUsuarioService.guardar(perfilUsuario));
    }


    // DELETE /api/perfiles/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        perfilUsuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

