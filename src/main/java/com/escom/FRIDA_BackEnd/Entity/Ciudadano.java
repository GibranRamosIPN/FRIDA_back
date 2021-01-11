package com.escom.FRIDA_BackEnd.Entity;

import java.sql.Date;
import javax.persistence.*;

@Entity
public class Ciudadano {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCiudadano;
    @Column
    private Date fecha_nacimiento;    
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
    private Integer idRecomendacion;
    @Column
    private Long idUsuario;

    public Ciudadano(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Integer getId_ciudadano() {
        return idCiudadano;
    }

    public void setId_ciudadano(Integer id_ciudadano) {
        this.idCiudadano = id_ciudadano;
    }
    
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public Integer getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(Integer idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }
    
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

}
