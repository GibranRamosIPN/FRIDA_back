package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Imagen;
import com.escom.FRIDA_BackEnd.Repository.ImagenRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenServiceImplement implements ImagenService{

    @Autowired
    ImagenRepository repositorio;

    @Override
    public Imagen crearImagen(Imagen imagen) {
        return repositorio.save(imagen);
    }

    @Override
    public List<Imagen> listarImagenes() {
        return repositorio.findAll();
    }

    @Override
    public List<Imagen> obtenerImagenXidCaso(Long idCaso) {
        return repositorio.findByIdCaso(idCaso);
    }
    
    @Override
    public Imagen eliminarImagen(Integer idImagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Imagen actualizarImagen(Imagen imagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }       
}
