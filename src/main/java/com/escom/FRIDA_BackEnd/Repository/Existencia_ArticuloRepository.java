package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.Existencia_Articulo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface Existencia_ArticuloRepository extends CrudRepository<Existencia_Articulo, Integer> {
    
    Existencia_Articulo save(Existencia_Articulo Eart);
    Existencia_Articulo findByIdCentro(Integer idCentro);
    Existencia_Articulo findByIdCentroAndIdArticulo(Integer idCentro, Integer idArticulo);
    List<Existencia_Articulo> findAllByIdCentro(Integer idCentro);
    Existencia_Articulo findByIdArticulo(Integer idArticulo);    
    List<Existencia_Articulo> deleteByIdCentro(Integer idCentro);
    
}
