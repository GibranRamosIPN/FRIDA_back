package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.CentroDeAcopio;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface CentroDeAcopioRepository extends Repository<CentroDeAcopio, Integer> {
    
    List<CentroDeAcopio>findAll();
    CentroDeAcopio findByIdCentro(Integer idCentro);
    CentroDeAcopio save(CentroDeAcopio centro);
    CentroDeAcopio delete(CentroDeAcopio centro);
    
}
