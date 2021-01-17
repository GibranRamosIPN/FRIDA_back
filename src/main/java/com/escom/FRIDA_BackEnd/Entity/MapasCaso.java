package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;

@Entity
public class MapasCaso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCaso;
    @Column
    private Integer prioridad;
    @Column
    private String tipo_danio;    
    @Column
    private String calle_numero;
    @Column
    private String colonia;    
    @Column
    private String cp;    
    @Column
    private String alcaldia_municipio;    
    @Column
    private String estado;    
    @Column
    private Integer status_caso;    
    @Column(name="fecha_reportado")
    private String fecha_reportado;    
    @Column(name="fecha_evaluado")
    private String fecha_evaluado;
    @Column
    private Integer idCuestionario;    

    public Integer getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Integer idCaso) {
        this.idCaso = idCaso;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getTipo_danio() {
        return tipo_danio;
    }

    public void setTipo_danio(String tipo_danio) {
        this.tipo_danio = tipo_danio;
    }

    public String getCalle_numero() {
        return calle_numero;
    }

    public void setCalle_numero(String calle_numero) {
        this.calle_numero = calle_numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getAlcaldia_municipio() {
        return alcaldia_municipio;
    }

    public void setAlcaldia_municipio(String alcaldia_municipio) {
        this.alcaldia_municipio = alcaldia_municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getStatus_caso() {
        return status_caso;
    }

    public void setStatus_caso(Integer status_caso) {
        this.status_caso = status_caso;
    }

    public String getFecha_reportado() {
        return fecha_reportado;
    }

    public void setFecha_reportado(String fecha_reportado) {
        this.fecha_reportado = fecha_reportado;
    }

    public String getFecha_evaluado() {
        return fecha_evaluado;
    }

    public void setFecha_evaluado(String fecha_evaluado) {
        this.fecha_evaluado = fecha_evaluado;
    }

    public Integer getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Integer idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public Integer getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(Integer idCiudadano) {
        this.idCiudadano = idCiudadano;
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
    @Column
    private Integer idCiudadano;
    @Column
    private String latitud;
    @Column
    private String longitud;
}