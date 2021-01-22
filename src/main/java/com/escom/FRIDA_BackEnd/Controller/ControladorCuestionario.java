package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.Entity.Cuestionario;
import com.escom.FRIDA_BackEnd.Service.CuestionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class ControladorCuestionario {
    
    @Autowired
    CuestionarioService centroService;
    
    @PostMapping(path = "/crear/cuestionario")
    public Cuestionario crearCuestionario(@RequestBody Cuestionario cuestionario) {
        return centroService.crearCuestionario(cuestionario);
    }
    
    @GetMapping(path = "/listar/cuestionarios")
    public List<Cuestionario> listarCuestionarios() {
        return centroService.listarCuestionarios();
    }
    
    @GetMapping(path = "/cuestionario/{id}")
    public Cuestionario getCuestionarioById(@PathVariable("id") Integer id) {
        return centroService.cuestionarioById(id);
    }
    
    @PutMapping(path = "/actualizar/cuestionario/{id}")
    public Cuestionario actualizarCuestionario(@RequestBody Cuestionario cuestionario, @PathVariable("id") Integer id) {
        cuestionario.setIdCuestionario(id);
        return centroService.actualizarCuestionario(cuestionario);
    }
    
    @DeleteMapping(path = "/cuestionario/{id}")
    public Cuestionario eliminarCuestionario(@PathVariable("id") Integer id) {
        return centroService.eliminarCuestionario(id);
    }
    
}