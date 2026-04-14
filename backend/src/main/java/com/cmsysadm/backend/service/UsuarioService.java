package com.cmsysadm.backend.service;

import com.cmsysadm.backend.entity.Usuario;
import com.cmsysadm.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    // ─── READ ────────────────────────────────────────────

    // Listar todos los usuarios
    public List<Usuario> listarTodos() {
        return repo.findAll();
    }

    // Buscar por RUT
    public Optional<Usuario> buscarPorRut(Integer rut) {
        return repo.findById(rut);
    }

    // Buscar por nombre de usuario
    public Optional<Usuario> buscarPorUsuario(String usuUsuario) {
        return repo.findByUsuUsuario(usuUsuario);
    }

    // ─── CREATE ──────────────────────────────────────────

    public Usuario crear(Usuario usuario) {
        // Validar que el RUT no exista
        if (repo.existsById(usuario.getUsuRut())) {
            throw new RuntimeException("Ya existe un usuario con ese RUT");
        }
        // Validar que el username no exista
        if (repo.existsByUsuUsuario(usuario.getUsuUsuario())) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }
        // Validar que el email no exista
        if (repo.existsByUsuEmail(usuario.getUsuEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        // Campos de auditoría automáticos
        usuario.setFecIngReg(LocalDateTime.now());
        usuario.setFecModreg(LocalDateTime.now());
        usuario.setCodEstado(1); // activo por defecto

        return repo.save(usuario);
    }

    // ─── UPDATE ──────────────────────────────────────────

    public Usuario actualizar(Integer rut, Usuario datosNuevos) {
        Usuario existente = repo.findById(rut)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con RUT: " + rut));

        // Actualizar solo los campos permitidos
        existente.setUsuNombres(datosNuevos.getUsuNombres());
        existente.setUsuAPaterno(datosNuevos.getUsuAPaterno());
        existente.setUsuAMaterno(datosNuevos.getUsuAMaterno());
        existente.setUsuEmail(datosNuevos.getUsuEmail());
        existente.setUsuAvatar(datosNuevos.getUsuAvatar());
        existente.setFecVigencia(datosNuevos.getFecVigencia());
        existente.setCodTipoUsuario(datosNuevos.getCodTipoUsuario());

        // Auditoría
        existente.setFecModreg(LocalDateTime.now());
        existente.setUsuModreg(datosNuevos.getUsuModreg());
        existente.setFunModReg(datosNuevos.getFunModReg());

        return repo.save(existente);
    }

    // ─── DELETE ──────────────────────────────────────────

    // Eliminar físicamente
    public void eliminar(Integer rut) {
        if (!repo.existsById(rut)) {
            throw new RuntimeException("Usuario no encontrado con RUT: " + rut);
        }
        repo.deleteById(rut);
    }

    // Eliminar lógicamente (recomendado — solo cambia CodEstado)
    public Usuario desactivar(Integer rut) {
        Usuario usuario = repo.findById(rut)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con RUT: " + rut));
        usuario.setCodEstado(0); // 0 = inactivo
        usuario.setFecModreg(LocalDateTime.now());
        return repo.save(usuario);
    }
}