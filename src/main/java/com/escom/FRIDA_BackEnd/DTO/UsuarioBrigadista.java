package com.escom.FRIDA_BackEnd.DTO;

public class UsuarioBrigadista {
    private Long idUsuario;
    private Integer idBrigadista;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String ultima_alcaldia_municipio;

    public UsuarioBrigadista() {
    }

    public UsuarioBrigadista(Long idUsuario, Integer idBrigadista, String nombre, String apellido_paterno, String apellido_materno, String ultima_alcaldia_municipio) {
        this.idUsuario = idUsuario;
        this.idBrigadista = idBrigadista;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.ultima_alcaldia_municipio = ultima_alcaldia_municipio;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdBrigadista() {
        return idBrigadista;
    }

    public void setIdBrigadista(Integer idBrigadista) {
        this.idBrigadista = idBrigadista;
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

    public String getUltima_alcaldia_municipio() {
        return ultima_alcaldia_municipio;
    }

    public void setUltima_alcaldia_municipio(String ultima_alcaldia_municipio) {
        this.ultima_alcaldia_municipio = ultima_alcaldia_municipio;
    }
    
    
}
