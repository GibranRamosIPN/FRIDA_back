package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Entity.Cuestionario;
import com.escom.FRIDA_BackEnd.Repository.CuestionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuestionarioServiceImplement implements CuestionarioService {

    @Autowired
    CuestionarioRepository repositorio;

    @Override
    public Cuestionario crearCuestionario(Cuestionario c) {
        return repositorio.save(c);
    }

    @Override
    public Cuestionario actualizarCuestionario(Cuestionario c) {
        return repositorio.save(c);
    }

    @Override
    public Cuestionario cuestionarioById(Integer idCuestionario) {
        return repositorio.findByIdCuestionario(idCuestionario);
    }

    @Override
    public Cuestionario eliminarCuestionario(Integer idCuestionario) {
        Cuestionario cuest = repositorio.findByIdCuestionario(idCuestionario);
        if (cuest != null) {
            repositorio.delete(cuest);
        }
        return cuest;
    }

    @Override
    public List<Cuestionario> listarCuestionarios() {
        return repositorio.findAll();
    }
    
}