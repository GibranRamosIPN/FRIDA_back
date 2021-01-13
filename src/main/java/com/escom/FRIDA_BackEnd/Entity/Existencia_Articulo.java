package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;

@Entity
@Table(name = "existencia_articulo_centro")
public class Existencia_Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExistenciaArticuloCentro;
    @Column
    private Integer existencia;
    @Column
    private Integer cant_req;
    @Column
    private Integer idCentro;
    @Column
    private Integer idArticulo;

    public Existencia_Articulo() {
    }

    public Existencia_Articulo(Integer idExistenciaArticuloCentro, Integer existencia, Integer cant_req, Integer idCentro, Integer idArticulo) {
        this.idExistenciaArticuloCentro = idExistenciaArticuloCentro;
        this.existencia = existencia;
        this.cant_req = cant_req;
        this.idCentro = idCentro;
        this.idArticulo = idArticulo;
    }

    public Integer getIdExistenciaArticuloCentro() {
        return idExistenciaArticuloCentro;
    }

    public void setIdExistenciaArticuloCentro(Integer idExistenciaArticuloCentro) {
        this.idExistenciaArticuloCentro = idExistenciaArticuloCentro;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public Integer getCant_req() {
        return cant_req;
    }

    public void setCant_req(Integer cant_req) {
        this.cant_req = cant_req;
    }

    public Integer getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Integer idCentro) {
        this.idCentro = idCentro;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }
    
}
