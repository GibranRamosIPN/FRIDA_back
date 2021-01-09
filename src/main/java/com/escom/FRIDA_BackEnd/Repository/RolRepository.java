package com.escom.FRIDA_BackEnd.Repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.escom.FRIDA_BackEnd.Entity.Rol;
import com.escom.FRIDA_BackEnd.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
