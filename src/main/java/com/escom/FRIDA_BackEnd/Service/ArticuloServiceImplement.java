package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Articulo;
import com.escom.FRIDA_BackEnd.Repository.ArticuloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImplement implements ArticuloService {

    @Autowired
    ArticuloRepository repositorio;
    
    @Override
    public Articulo crearArticulo(Articulo a) {
        return repositorio.save(a);
    }

    @Override
    public Articulo actualizarArticulo(Articulo a) {
        return repositorio.save(a);
    }

    @Override
    public Articulo articuloById(Integer idArticulo) {
        return repositorio.findByIdArticulo(idArticulo);
    }

    @Override
    public Articulo eliminarArticulo(Integer idArticulo) {
        Articulo art = repositorio.findByIdArticulo(idArticulo);
        if (art != null) {
            repositorio.delete(art);
        }
        return art;
    }

    @Override
    public List<Articulo> listarArticulos() {
        return repositorio.findAll();
    }

    @Override
    public Articulo articuloByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }
    
}
