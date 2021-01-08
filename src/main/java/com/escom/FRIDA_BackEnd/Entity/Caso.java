package com.escom.FRIDA_BackEnd.Entity;

import java.sql.Date;
import javax.persistence.*;

@Entity
public class Caso {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCaso;    
    @Column
    private String nombre;    
    @Column
    private String tipoDeDanio;    
    @Column
    private String calleYnumero;
    @Column
    private String colonia;    
    @Column
    private String cp;    
    @Column
    private String alcaldiaOmunicipio;    
    @Column
    private String estado;    
    @Column
    private Integer statusCaso;    
    @Column
    private Date fechaReportado;    
    @Column
    private Date fechaEvaluado;    
    @Column
    private Integer idCuestionario;    
    @Column
    private Integer idCiudadano;

    public Integer getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Integer idCaso) {
        this.idCaso = idCaso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDeDanio() {
        return tipoDeDanio;
    }

    public void setTipoDeDanio(String tipoDeDanio) {
        this.tipoDeDanio = tipoDeDanio;
    }

    public String getCalleYnumero() {
        return calleYnumero;
    }

    public void setCalleYnumero(String calleYnumero) {
        this.calleYnumero = calleYnumero;
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

    public String getAlcaldiaOmunicipio() {
        return alcaldiaOmunicipio;
    }

    public void setAlcaldiaOmunicipio(String alcaldiaOmunicipio) {
        this.alcaldiaOmunicipio = alcaldiaOmunicipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getStatusCaso() {
        return statusCaso;
    }

    public void setStatusCaso(Integer statusCaso) {
        this.statusCaso = statusCaso;
    }

    public Date getFechaReportado() {
        return fechaReportado;
    }

    public void setFechaReportado(Date fechaReportado) {
        this.fechaReportado = fechaReportado;
    }

    public Date getFechaEvaluado() {
        return fechaEvaluado;
    }

    public void setFechaEvaluado(Date fechaEvaluado) {
        this.fechaEvaluado = fechaEvaluado;
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
    
}
