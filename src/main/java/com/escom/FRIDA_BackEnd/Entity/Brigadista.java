package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;

@Entity
@Table(name = "brigadista")
public class Brigadista {
        
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBrigadista;
    @Column
    private String nombre;    
    @Column
    private String apellidoPaterno;    
    @Column
    private String apellidoMaterno;  
    @Column
    private String usuario;
    @Column
    private String psswrd;
    @Column
    private String ultimaL_calleYnumero;    
    @Column
    private String ultimaL_colonia;    
    @Column
    private String ultimaL_cp;    
    @Column
    private String ultimaL_alcaldiaOmunicipio;    
    @Column
    private String ultimaL_estado;  
    @Column
    private int idCasoAsignado;

    public int getIdBrigadista() {
        return idBrigadista;
    }

    public void setIdBrigadista(int idBrigadista) {
        this.idBrigadista = idBrigadista;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPsswrd() {
        return psswrd;
    }

    public void setPsswrd(String psswrd) {
        this.psswrd = psswrd;
    }

    public String getUltimaL_calleYnumero() {
        return ultimaL_calleYnumero;
    }

    public void setUltimaL_calleYnumero(String ultimaL_calleYnumero) {
        this.ultimaL_calleYnumero = ultimaL_calleYnumero;
    }

    public String getUltimaL_colonia() {
        return ultimaL_colonia;
    }

    public void setUltimaL_colonia(String ultimaL_colonia) {
        this.ultimaL_colonia = ultimaL_colonia;
    }

    public String getUltimaL_cp() {
        return ultimaL_cp;
    }

    public void setUltimaL_cp(String ultimaL_cp) {
        this.ultimaL_cp = ultimaL_cp;
    }

    public String getUltimaL_alcaldiaOmunicipio() {
        return ultimaL_alcaldiaOmunicipio;
    }

    public void setUltimaL_alcaldiaOmunicipio(String ultimaL_alcaldiaOmunicipio) {
        this.ultimaL_alcaldiaOmunicipio = ultimaL_alcaldiaOmunicipio;
    }

    public String getUltimaL_estado() {
        return ultimaL_estado;
    }

    public void setUltimaL_estado(String ultimaL_estado) {
        this.ultimaL_estado = ultimaL_estado;
    }

    public int getIdCasoAsignado() {
        return idCasoAsignado;
    }

    public void setIdCasoAsignado(int idCasoAsignado) {
        this.idCasoAsignado = idCasoAsignado;
    }
        
}
