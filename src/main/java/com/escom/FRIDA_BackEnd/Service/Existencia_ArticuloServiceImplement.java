package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Existencia_Articulo;
import com.escom.FRIDA_BackEnd.Repository.Existencia_ArticuloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Existencia_ArticuloServiceImplement implements Existencia_ArticuloService {

    @Autowired
    Existencia_ArticuloRepository repositorio;
    
    @Override
    public Existencia_Articulo crearExistenciaArticuloXCentro(Existencia_Articulo existenciaArticulo) {
        return repositorio.save(existenciaArticulo);
    }

    @Override
    public Existencia_Articulo actualizarExistenciaArticuloByCentro(Existencia_Articulo existenciaArticulo) {
        return repositorio.save(existenciaArticulo);
    }

    @Override
    public Existencia_Articulo listarExistenciaArticuloByCentro(Integer idArticulo) {
        return repositorio.findByIdArticulo(idArticulo);
    }

    @Override
    public List<Existencia_Articulo> listarExistenciaArticulosByIdCentro(Integer idCentro) {
        return repositorio.findAllByIdCentro(idCentro);
    }

    @Override
    public Existencia_Articulo eliminarExistenciaArticuloByCentro(Integer idCentro) {
        Existencia_Articulo ear = new Existencia_Articulo();
        repositorio.deleteByIdCentro(idCentro);
        return ear;
    }
    
}
