package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Mapas;
import com.escom.FRIDA_BackEnd.Repository.MapasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapasServiceImplement implements MapasService {

    @Autowired
    MapasRepository repositorio;

    @Override
    public Mapas crearMapas(Mapas mapas) {
        return repositorio.save(mapas);
    }

    @Override
    public Mapas obtenerMapasXId(Integer idMapas) {
        return repositorio.findByIdCaso(idMapas);
    }

    @Override
    public List<Mapas> listarMapas() {
        return repositorio.findAll();
    }

    @Override
    public Mapas eliminarMapas(Integer idMapas) {
        Mapas mapas = repositorio.findByIdCaso(idMapas);
        if (mapas != null) {
            repositorio.delete(mapas);
        }
        return mapas;
    }
    
}
