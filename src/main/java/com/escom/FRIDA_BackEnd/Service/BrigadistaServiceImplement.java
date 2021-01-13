package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import com.escom.FRIDA_BackEnd.Repository.BrigadistaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrigadistaServiceImplement implements BrigadistaService {

    @Autowired
    private BrigadistaRepository repositorio;
    
    @Override
    public Brigadista crearBrigadista(Brigadista brig) {
        return repositorio.save(brig);
    }

    @Override
    public Brigadista actualizarBrigadista(Brigadista brig) {
        return repositorio.save(brig);
    }

    @Override
    public Brigadista eliminarBrigadista(Integer idBrigadista) {
        Brigadista b = repositorio.findByIdBrigadista(idBrigadista);
        if (b != null) {
            repositorio.delete(b);
        }
        return b;
    }

    @Override
    public List<Brigadista> listarBrigadistas() {
        return repositorio.findAll();
    }
    
    @Override
    public Brigadista listarId(Integer idBrigadista) {
        return repositorio.findByIdBrigadista(idBrigadista);
    }

    @Override
    public List<Brigadista> listarXalcaldia(String alcaldia) {
        return repositorio.findByUltimaAlcaldiaMunicipio(alcaldia);
    }    

    @Override
    public Brigadista getBrigadistaByIdUsuario(Long idUsuario) {
        return repositorio.findByIdUsuario(idUsuario);
    }
}
