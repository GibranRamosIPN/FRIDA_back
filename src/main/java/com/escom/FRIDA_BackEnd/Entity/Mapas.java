package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;

@Entity
public class Mapas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMapas;
    
    @Column
    private String lat;
    
    @Column
    private String lng;
    
    @Column
    private Integer idCaso;

    public Mapas(){}
    
    public Mapas(Integer idMapas, String latitud, String longitud, Integer idCaso) {
        this.idMapas = idMapas;
        this.lat = latitud;
        this.lng = longitud;
        this.idCaso = idCaso;  
    }
    
    public Integer getIdMapas() {
        return idMapas;
    }

    public void setIdMapas(Integer idMapas) {
        this.idMapas = idMapas;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Integer getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Integer idCaso) {
        this.idCaso = idCaso;
    }
}
