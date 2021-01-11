package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "usuario_rol")
public class UsuarioRol {
    @Id    
    @Column(name = "usuario_id")
    private Long usuarioId;
    
    @Column(name = "rol_id")
    private Long rolId;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

}