package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;

@Entity
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImagen;
    
    @Column
    private String imagen_caso;
    
    @Column
    private Integer idCaso;

    public Imagen() {
    }

    public Long getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Long idImagen) {
        this.idImagen = idImagen;
    }

    public String getImagen_caso() {
        return imagen_caso;
    }

    public void setImagen_caso(String imagen_caso) {
        this.imagen_caso = imagen_caso;
    }

    public Integer getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Integer idCaso) {
        this.idCaso = idCaso;
    }
    
    
    
    
}
