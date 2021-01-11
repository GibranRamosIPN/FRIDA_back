package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.UsuarioRol;
import com.escom.FRIDA_BackEnd.Repository.UsuarioRolRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioRolService {
    @Autowired
    UsuarioRolRepository usuarioRolRepository;
    
    public List<UsuarioRol> getIdUsuariosBrigadistas(Long rol_id) {
        return usuarioRolRepository.findAllByRolId(rol_id);
    }
}
