package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.Mapas;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface MapasRepository extends Repository<Mapas, Integer> {
    
    List<Mapas>findAll();
    Mapas findByIdCaso(Integer idMapas);
    Mapas save(Mapas mapas);
    Mapas delete(Mapas mapas);
    
}
