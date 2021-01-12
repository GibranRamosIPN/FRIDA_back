package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Caso;
import com.escom.FRIDA_BackEnd.Entity.CentroDeAcopio;
import com.escom.FRIDA_BackEnd.Repository.CentroDeAcopioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentroDeAcopioServiceImplement implements CentroDeAcopioService{

    @Autowired
    CentroDeAcopioRepository repositorio;

    @Override
    public CentroDeAcopio crearCentroDeAcopio(CentroDeAcopio centro) {
        return repositorio.save(centro);
    }

    @Override
    public CentroDeAcopio actualizarCentroDeAcopio(CentroDeAcopio centro) {
        return repositorio.save(centro);
    }

    @Override
    public CentroDeAcopio eliminarCentroDeAcopio(Integer idCentro) {
        CentroDeAcopio centro = repositorio.findByIdCentro(idCentro);
        if (centro != null) {
            repositorio.delete(centro);
        }
        return centro;
    }

    @Override
    public List<CentroDeAcopio> listarCentros() {
        return repositorio.findAll();
    }

    @Override
    public CentroDeAcopio listarXId(Integer idCentro) {
        return repositorio.findByIdCentro(idCentro);
    }
    
        
}
