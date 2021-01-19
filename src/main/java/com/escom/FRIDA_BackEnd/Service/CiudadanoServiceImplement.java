package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Ciudadano;
import com.escom.FRIDA_BackEnd.Repository.CiudadanoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadanoServiceImplement implements CiudadanoService{
    
    @Autowired
    private CiudadanoRepository repositorio;
    
    @Override
    public Ciudadano crearCiudadano(Ciudadano ciud){
      return repositorio.save(ciud);
    }
    
    @Override
    public Ciudadano actualizarCiudadano(Ciudadano ciud) {
        return repositorio.save(ciud);
    }
    
    @Override
    public Ciudadano listarId(Integer idCiudadano) {
        return repositorio.findByIdCiudadano(idCiudadano);
    }

    @Override
    public Ciudadano eliminarCiudadano(Integer idCiudadano) {
        Ciudadano b = repositorio.findByIdCiudadano(idCiudadano);
        if (b != null) {
            repositorio.delete(b);
        }
        return b;
    }

    @Override
    public List<Ciudadano> listarCiudadanos() {
        return repositorio.findAll();
    }

    @Override
    public Ciudadano getByIdUsuario(Long idUsuario) {
        return repositorio.findByIdUsuario(idUsuario);
    }
}
