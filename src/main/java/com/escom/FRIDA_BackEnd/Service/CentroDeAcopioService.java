package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.CentroDeAcopio;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CentroDeAcopioService  {
    
    CentroDeAcopio crearCentroDeAcopio(CentroDeAcopio centro);
    CentroDeAcopio actualizarCentroDeAcopio(CentroDeAcopio centro);
    CentroDeAcopio eliminarCentroDeAcopio(Integer idCentro);
    List<CentroDeAcopio> listarCentros();
    CentroDeAcopio listarXId(Integer idCentro);
    
}
