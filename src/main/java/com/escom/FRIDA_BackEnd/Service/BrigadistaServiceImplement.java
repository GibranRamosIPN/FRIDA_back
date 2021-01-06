package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import com.escom.FRIDA_BackEnd.Repository.BrigadistaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrigadistaServiceImplement implements BrigadistaService {

    @Autowired
    private BrigadistaRepository repositorio;
    
    @Override
    @Transactional
    public Brigadista crearBrigdadista(Brigadista brig) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Brigadista actualizarBrigdadista(Brigadista brig) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Brigadista eliminarBrigdadista(int idBrigadista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Brigadista> listarBrigadistas() {
        return repositorio.findAll();
    }

    @Override
    public List<Brigadista> listarXalcaldia(String alcaldia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
