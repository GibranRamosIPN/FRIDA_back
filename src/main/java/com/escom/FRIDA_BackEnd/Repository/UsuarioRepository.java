package com.escom.FRIDA_BackEnd.Repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.escom.FRIDA_BackEnd.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByNombreUsuario(String nu);    
    boolean existsByNombre(String nu);
    boolean existsByEmail(String email);
}
