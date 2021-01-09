package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Repository.RolRepository;
import com.escom.FRIDA_BackEnd.enums.RolNombre;
import com.escom.FRIDA_BackEnd.Entity.Rol;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class RolService {
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
}
