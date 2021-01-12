package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.Caso;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface CasoRepository extends Repository<Caso, Integer> {
    
    List<Caso>findAll();
    Caso findByIdCaso(Integer idCaso);
    Caso save(Caso caso);
    Caso delete(Caso caso);
    
}
