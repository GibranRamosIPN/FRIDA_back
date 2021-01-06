package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import java.util.List;

public interface BrigadistaService {
    
    Brigadista crearBrigdadista(Brigadista brig);
    Brigadista actualizarBrigdadista(Brigadista brig);
    Brigadista eliminarBrigdadista(int idBrigadista);    
    List<Brigadista>listarBrigadistas();
    List<Brigadista>listarXalcaldia(String alcaldia);    
    
}
