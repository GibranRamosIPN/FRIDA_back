package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Imagen;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface ImagenService {
    
    Imagen crearImagen(Imagen imagen);
    Optional<Imagen> obtenerImagenXNombre(String nombre_imagen);
    List<Imagen>listarImagenes();
    Imagen eliminarImagen(Integer idImagen);
    Imagen actualizarImagen(Imagen imagen);
    
}