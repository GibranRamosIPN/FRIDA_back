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
    @Column(name = "ultima_alcaldia_municipio")
    private String ultimaAlcaldiaMunicipio;    
    @Column
    private String ultima_estado;  
    @Column
    private String estado;
    @Column
    private Integer idCasoAsignado;
    @Column
    private Long idUsuario;

    public Brigadista() {
    }
    
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

    public String getUltimaAlcaldiaMunicipio() {
        return ultimaAlcaldiaMunicipio;
    }

    public void setUltimaAlcaldiaMunicipio(String ultimaAlcaldiaMunicipio) {
        this.ultimaAlcaldiaMunicipio = ultimaAlcaldiaMunicipio;
    }
    
    public String getUltima_estado() {
        return ultima_estado;
    }

    public void setUltima_estado(String ultima_estado) {
        this.ultima_estado = ultima_estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
