package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.Imagen;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface ImagenRepository extends Repository<Imagen, Integer> {
    List<Imagen>findAll();
    List<Imagen> findByIdCaso(Integer idCaso);
    Imagen save(Imagen imagen);
    Imagen delete(Imagen imagen);    
}
