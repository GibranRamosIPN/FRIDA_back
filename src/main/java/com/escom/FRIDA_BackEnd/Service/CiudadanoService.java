package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Ciudadano;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CiudadanoService {
    Ciudadano crearCiudadano(Ciudadano ciud);
    Ciudadano actualizarCiudadano(Ciudadano ciud);
    Ciudadano eliminarCiudadano (Integer idCiudadano);
    List<Ciudadano> listarCiudadanos();
    Ciudadano listarId(Integer idCiudadano);
    Ciudadano getByIdUsuario(Long idUsuario);
}
