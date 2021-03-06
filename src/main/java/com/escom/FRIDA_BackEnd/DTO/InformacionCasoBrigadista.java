package com.escom.FRIDA_BackEnd.DTO;

import com.escom.FRIDA_BackEnd.Entity.Imagen;
import java.util.List;

public class InformacionCasoBrigadista {
    private Integer idCaso;
    private Integer prioridad;
    private String tipo_danio;
    private String calle_numero;
    private String colonia;
    private String cp;
    private String alcaldia_municipio;
    private String estado;
    private Integer status_caso;
    private String fecha_reportado;
    private String fecha_evaluado;
    private Integer idCuestionario;
    private String lat;
    private String lng;
    private List<Imagen> imagenes;

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

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setgetImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }
    
    
}
