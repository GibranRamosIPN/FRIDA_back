package com.escom.FRIDA_BackEnd.Repository;

import com.escom.FRIDA_BackEnd.Entity.Cuestionario;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface CuestionarioRepository extends Repository<Cuestionario, Integer> {
    Cuestionario save(Cuestionario cuestionario);
    Cuestionario findByIdCuestionario(Integer id);
    Cuestionario delete(Cuestionario cuestionario);
    List<Cuestionario> findAll();
}
