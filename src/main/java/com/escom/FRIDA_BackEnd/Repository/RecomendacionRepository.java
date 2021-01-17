package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.Recomendacion;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface RecomendacionRepository extends Repository<Recomendacion, Integer> {
    Recomendacion findByIdRecomendacion(Integer id);
    List<Recomendacion> findAll();
    
}
