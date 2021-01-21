package com.escom.FRIDA_BackEnd.DTO;

public class ArticuloExistencia {
    private String nombre;
    private Integer existencia;
    private Integer cant_req;
    private Integer id_centro_acopio;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public Integer getCant_req() {
        return cant_req;
    }

    public void setCant_req(Integer cant_req) {
        this.cant_req = cant_req;
    }

    public Integer getId_centro_acopio() {
        return id_centro_acopio;
    }

    public void setId_centro_acopio(Integer id_centro_acopio) {
        this.id_centro_acopio = id_centro_acopio;
    }
    
    
}
