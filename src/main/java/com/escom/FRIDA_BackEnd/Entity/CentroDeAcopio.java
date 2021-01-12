package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;

@Entity
@Table(name = "centro_acopio")
public class CentroDeAcopio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCentro;
    @Column
    private String nombre;
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

    public CentroDeAcopio() {
    }

    public Integer getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Integer idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
}
