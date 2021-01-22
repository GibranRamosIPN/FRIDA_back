package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Cuestionario;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CuestionarioService {
    
    Cuestionario crearCuestionario(Cuestionario c);
    Cuestionario actualizarCuestionario(Cuestionario c);
    Cuestionario cuestionarioById(Integer idCuestionario);
    Cuestionario eliminarCuestionario(Integer idCuestionario);
    List<Cuestionario> listarCuestionarios();    
    
}