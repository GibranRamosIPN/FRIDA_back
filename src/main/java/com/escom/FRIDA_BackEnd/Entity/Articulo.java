package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;

@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArticulo;
    
    @Column
    private String nombre;

    public Articulo() {
    }
    
    public Articulo(Integer idArticulo, String nombre) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
