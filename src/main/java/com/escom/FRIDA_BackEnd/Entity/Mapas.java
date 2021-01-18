package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;

@Entity
public class Mapas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMapas;
    
    @Column
    private String latitud;
    
    @Column
    private String longitud;
    
    @Column
    private Integer idCaso;

    public Mapas(){}
    
    public Mapas(Integer idMapas, String latitud, String longitud, Integer idCaso) {
        this.idMapas = idMapas;
        this.latitud = latitud;
        this.longitud = longitud;
        this.idCaso = idCaso;  
    }
    
    public Integer getIdMapas() {
        return idMapas;
    }

    public void setIdMapas(Integer idMapas) {
        this.idMapas = idMapas;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Integer getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Integer idCaso) {
        this.idCaso = idCaso;
    }
}
