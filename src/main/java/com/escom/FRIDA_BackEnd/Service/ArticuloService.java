package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Articulo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ArticuloService {
    
    Articulo crearArticulo(Articulo a);
    Articulo actualizarArticulo(Articulo a);
    Articulo articuloById(Integer idArticulo);
    Articulo articuloByNombre(String nombre);
    Articulo eliminarArticulo(Integer idArticulo);
    List<Articulo> listarArticulos();    
    
}
