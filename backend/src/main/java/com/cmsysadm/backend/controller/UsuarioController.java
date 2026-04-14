package com.cmsysadm.backend.controller;

import com.cmsysadm.backend.entity.Usuario;
import com.cmsysadm.backend.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Permite conexión desde frontend
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // ─── GET ALL ─────────────────────────────────────────
    // GET http://localhost:8080/api/usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // ─── GET BY RUT ───────────────────────────────────────
    // GET http://localhost:8080/api/usuarios/12345678
    @GetMapping("/{rut}")
    public ResponseEntity<?> buscarPorRut(@PathVariable Integer rut) {
        return service.buscarPorRut(rut)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ─── GET BY USUARIO ───────────────────────────────────
    // GET http://localhost:8080/api/usuarios/username/juanperez
    @GetMapping("/username/{usuUsuario}")
    public ResponseEntity<?> buscarPorUsuario(@PathVariable String usuUsuario) {
        return service.buscarPorUsuario(usuUsuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ─── CREATE ───────────────────────────────────────────
    // POST http://localhost:8080/api/usuarios
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Usuario usuario) {
        try {
            Usuario nuevo = service.crear(usuario);
            return ResponseEntity.status(201).body(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ─── UPDATE ───────────────────────────────────────────
    // PUT http://localhost:8080/api/usuarios/12345678
    @PutMapping("/{rut}")
    public ResponseEntity<?> actualizar(@PathVariable Integer rut,
                                        @RequestBody Usuario usuario) {
        try {
            Usuario actualizado = service.actualizar(rut, usuario);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ─── SOFT DELETE ──────────────────────────────────────
    // PATCH http://localhost:8080/api/usuarios/12345678/desactivar
    @PatchMapping("/{rut}/desactivar")
    public ResponseEntity<?> desactivar(@PathVariable Integer rut) {
        try {
            Usuario desactivado = service.desactivar(rut);
            return ResponseEntity.ok(desactivado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ─── HARD DELETE ──────────────────────────────────────
    // DELETE http://localhost:8080/api/usuarios/12345678
    @DeleteMapping("/{rut}")
    public ResponseEntity<?> eliminar(@PathVariable Integer rut) {
        try {
            service.eliminar(rut);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}