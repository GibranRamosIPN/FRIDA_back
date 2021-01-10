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
    private String apellido_paterno;    
    @Column
    private String apellido_materno;    
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
    private String email;    
    @Column
    private String psswrd;    
    @Column
    private Integer id_recomendacion;

    public Integer getId_ciudadano() {
        return idCiudadano;
    }

    public void setId_ciudadano(Integer id_ciudadano) {
        this.idCiudadano = id_ciudadano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
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

    public Integer getId_recomendacion() {
        return id_recomendacion;
    }

    public void setId_recomendacion(Integer id_recomendacion) {
        this.id_recomendacion = id_recomendacion;
    }

}
