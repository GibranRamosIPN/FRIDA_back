package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Existencia_Articulo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface Existencia_ArticuloService {
    
    Existencia_Articulo crearExistenciaArticuloXCentro(Existencia_Articulo existenciaArticulo);
    Existencia_Articulo actualizarExistenciaArticuloByCentro(Existencia_Articulo existenciaArticulo);
    Existencia_Articulo eliminarExistenciaArticuloByCentro(Integer idCentro);
    Existencia_Articulo listarExistenciaArticuloByCentro(Integer idArticulo);
    List<Existencia_Articulo> listarExistenciaArticulosByIdCentro(Integer idCentro);
    
}
