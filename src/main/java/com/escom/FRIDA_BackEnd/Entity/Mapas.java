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
    private Integer id_caso;

    public Mapas(){}
    
    public Mapas(String latitud, String longitud, Integer idCaso) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.id_caso = id_caso;  
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
        return id_caso;
    }

    public void setIdCaso(Integer idCaso) {
        this.id_caso = id_caso;
    }
}
