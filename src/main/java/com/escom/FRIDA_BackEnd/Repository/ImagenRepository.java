package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.Imagen;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface ImagenRepository extends Repository<Imagen, Integer> {
    List<Imagen>findAll();
    Optional<Imagen> findByNombreImagen(String nombre_imagen);
    Imagen save(Imagen imagen);
    Imagen delete(Imagen imagen);
    
}
