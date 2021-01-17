package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Recomendacion;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface RecomendacionService {
    
    Recomendacion recomendacionById(Integer idRecomendacion);
    List<Recomendacion> listarRecomendaciones();    
    
}