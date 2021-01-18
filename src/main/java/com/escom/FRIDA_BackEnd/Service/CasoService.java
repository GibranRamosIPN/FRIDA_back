package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Caso;
import java.util.List;

public interface CasoService {
    
    Caso crearCaso(Caso caso);
    Caso obtenerCasoXId(Integer idCaso);
    Caso actualizarStatusCaso(Caso caso);
    List<Caso>listarCasos();
    Caso eliminarCaso(Integer idCaso);
    List<Caso> obtenerCasoXDomicilio(String calle_num, String col, String cp, String alcaldia);
        
}
