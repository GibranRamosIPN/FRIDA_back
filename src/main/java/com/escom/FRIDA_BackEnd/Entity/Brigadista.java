package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;

@Entity
public class Brigadista {
        
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBrigadista;
    @Column
    private String ultima_calle_numero;    
    @Column
    private String ultima_colonia;    
    @Column
    private String ultima_cp;    
    @Column
    private String ultima_alcaldia_municipio;    
    @Column
    private String ultima_estado;  
    @Column
    private Integer idCasoAsignado;
    @Column
    private Long idUsuario;

    public Brigadista(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Integer getIdBrigadista() {
        return idBrigadista;
    }

    public void setIdBrigadista(Integer idBrigadista) {
        this.idBrigadista = idBrigadista;
    }

    public String getUltima_calle_numero() {
        return ultima_calle_numero;
    }

    public void setUltima_calle_numero(String ultima_calle_numero) {
        this.ultima_calle_numero = ultima_calle_numero;
    }

    public String getUltima_colonia() {
        return ultima_colonia;
    }

    public void setUltima_colonia(String ultima_colonia) {
        this.ultima_colonia = ultima_colonia;
    }

    public String getUltima_cp() {
        return ultima_cp;
    }

    public void setUltima_cp(String ultima_cp) {
        this.ultima_cp = ultima_cp;
    }

    public String getUltima_alcaldia_municipio() {
        return ultima_alcaldia_municipio;
    }

    public void setUltima_alcaldia_municipio(String ultima_alcaldia_municipio) {
        this.ultima_alcaldia_municipio = ultima_alcaldia_municipio;
    }

    public String getUltima_estado() {
        return ultima_estado;
    }

    public void setUltima_estado(String ultima_estado) {
        this.ultima_estado = ultima_estado;
    }

    public Integer getIdCasoAsignado() {
        return idCasoAsignado;
    }

    public void setIdCasoAsignado(Integer idCasoAsignado) {
        this.idCasoAsignado = idCasoAsignado;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
        
}
