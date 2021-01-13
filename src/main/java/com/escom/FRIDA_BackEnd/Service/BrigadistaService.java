package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface BrigadistaService {
    
    Brigadista crearBrigadista(Brigadista brig);
    Brigadista actualizarBrigadista(Brigadista brig);
    Brigadista eliminarBrigadista(Integer idBrigadista); 
    List<Brigadista>listarBrigadistas();
    Brigadista listarId(Integer idBrigadista);
    List<Brigadista>listarXalcaldia(String alcaldia);   
    Brigadista getBrigadistaByIdUsuario(Long idUsuario);
    
}
