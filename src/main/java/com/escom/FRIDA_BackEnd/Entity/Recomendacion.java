package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;

@Entity
public class Recomendacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecomendacion;
    
    @Column
    private String texto_recomendacion;

    public Recomendacion() {
    }
    
    public Recomendacion(Integer idRecomendacion, String texto) {
        this.idRecomendacion = idRecomendacion;
        this.texto_recomendacion = texto;
    }

    public Integer getId_recomendacion() {
        return idRecomendacion;
    }

    public void setId_recomendacion(Integer id_recomendacion) {
        this.idRecomendacion = id_recomendacion;
    }

    public String getTexto_recomendacion() {
        return texto_recomendacion;
    }

    public void setTexto_recomendacion(String texto_recomendacion) {
        this.texto_recomendacion = texto_recomendacion;
    }
    
    
}
