package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.Ciudadano;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface CiudadanoRepository extends Repository<Ciudadano, Integer> {
    List<Ciudadano>findAll();
    Ciudadano findByIdCiudadano(Integer idCiudadano);
    Ciudadano save(Ciudadano b);
    Ciudadano delete(Ciudadano b);
}
