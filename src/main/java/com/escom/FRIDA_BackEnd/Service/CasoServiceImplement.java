package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Caso;
import com.escom.FRIDA_BackEnd.Repository.CasoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasoServiceImplement implements CasoService {

    @Autowired
    CasoRepository repositorio;
    
    @Override
    public Caso crearCaso(Caso caso) {
        return repositorio.save(caso);
    }

    @Override
    public Caso obtenerCasoXId(Integer idCaso) {
        return repositorio.findByIdCaso(idCaso);
    }

    @Override
    public Caso actualizarStatusCaso(Caso caso) {        
        return repositorio.save(caso);
    }

    @Override
    public List<Caso> listarCasos() {
        return repositorio.findAll();
    }

    @Override
    public Caso eliminarCaso(Integer idCaso) {
        Caso caso = repositorio.findByIdCaso(idCaso);
        if (caso != null) {
            repositorio.delete(caso);
        }
        return caso;
    }
    
}
