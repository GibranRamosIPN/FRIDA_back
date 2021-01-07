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
    private String nombre;    
    @Column
    private String apellidoPaterno;    
    @Column
    private String apellidoMaterno;    
    @Column
    private Date fechaNacimiento;    
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
    private String email;    
    @Column
    private String psswrd;    
    @Column
    private Integer idRecomendacion;

    public Integer getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(Integer idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsswrd() {
        return psswrd;
    }

    public void setPsswrd(String psswrd) {
        this.psswrd = psswrd;
    }

    public Integer getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(Integer idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }
    
}
