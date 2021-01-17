package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Recomendacion;
import com.escom.FRIDA_BackEnd.Repository.RecomendacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecomendacionServiceImplement implements RecomendacionService {

    @Autowired
    RecomendacionRepository repositorio;

    @Override
    public Recomendacion recomendacionById(Integer id_recomendacion) {
        return repositorio.findByIdRecomendacion(id_recomendacion);
    }

    @Override
    public List<Recomendacion> listarRecomendaciones() {
        return repositorio.findAll();
    }
    
}
