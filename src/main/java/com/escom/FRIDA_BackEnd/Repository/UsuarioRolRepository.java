package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.UsuarioRol;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long>{
    List<UsuarioRol> findAllByRolId(Long id);
}
