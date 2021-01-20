package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface BrigadistaRepository extends Repository<Brigadista, Integer> {
    List<Brigadista>findAll();
    Brigadista findByIdBrigadista(Integer idBrigadista);
    Brigadista save(Brigadista b);
    Brigadista delete(Brigadista b);
    Brigadista findByIdUsuario(Long idUsuario);
    Brigadista findByIdCasoAsignado(Integer idCasoAsignado);
    List<Brigadista> findByUltimaAlcaldiaMunicipioAndEstado(String alcaldia_municipio, String estado);
    List<Brigadista> findByEstado(String estado);
}
