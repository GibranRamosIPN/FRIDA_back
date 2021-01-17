package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Mapas;
import java.util.List;

public interface MapasService {
    
    Mapas crearMapas(Mapas mapas);
    Mapas obtenerMapasXId(Integer idMapas);
    List<Mapas>listarMapas();
    Mapas eliminarMapas(Integer idMapas);
        
}

