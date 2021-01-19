package com.escom.FRIDA_BackEnd.Entity;

import javax.persistence.*;

@Entity
@Table(name = "imagen")
public class Imagen {
    public Imagen() {}

    public Imagen(String nombreImagen, byte[] bytes, long idCaso) {
        this.nombreImagen = nombreImagen;
        this.bytes = bytes;
        this.idCaso = idCaso;
    }
    @Id
    @Column(name = "id_imagen")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImagen;

    @Column(name = "nombre_imagen")
    private String nombreImagen;

    @Column(name = "bytes")
    private byte[] bytes;

    @Column(name = "id_caso")
    private long idCaso;

    public Long getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Long idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public long getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(long idCaso) {
        this.idCaso = idCaso;
    }
        
        
}