package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Mapas;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MapasService {
    
    Mapas crearMapas(Mapas mapas);
    Mapas obtenerMapasXIdMapas(Integer idMapas);
    Mapas obtenerMapasXIdCaso(Integer idCaso);
    List<Mapas>listarMapas();
    Mapas eliminarMapas(Integer idMapas);
    Mapas actualizarMapas(Mapas mapas);
    
}

