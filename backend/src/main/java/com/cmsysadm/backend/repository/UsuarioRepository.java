package com.cmsysadm.backend.repository;

import com.cmsysadm.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Buscar por nombre de usuario
    Optional<Usuario> findByUsuUsuario(String usuUsuario);

    // Buscar por email
    Optional<Usuario> findByUsuEmail(String usuEmail);

    // Verificar si existe un usuario
    boolean existsByUsuUsuario(String usuUsuario);

    // Verificar si existe un email
    boolean existsByUsuEmail(String usuEmail);
}