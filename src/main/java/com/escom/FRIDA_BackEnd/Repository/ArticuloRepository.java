package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.Articulo;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface ArticuloRepository extends Repository<Articulo, Integer> {
    
    Articulo save(Articulo articulo);
    Articulo findByIdArticulo(Integer id);
    Articulo findByNombre(String nombre);
    Articulo delete(Articulo articulo);
    List<Articulo> findAll();
    
}
