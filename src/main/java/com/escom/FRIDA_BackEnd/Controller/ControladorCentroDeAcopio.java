package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.Entity.CentroDeAcopio;
import com.escom.FRIDA_BackEnd.Service.CentroDeAcopioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class ControladorCentroDeAcopio {
    
    @Autowired
    CentroDeAcopioService centroService;
    
    @PostMapping(path = "/crear/centro")
    public CentroDeAcopio crearCentro(@RequestBody CentroDeAcopio centro) {
        return centroService.crearCentroDeAcopio(centro);
    }
    
    @GetMapping(path = "/listar/centros")
    public List<CentroDeAcopio> listarCentros() {
        return centroService.listarCentros();
    }
    
    @GetMapping(path = "/centro/{id}")
    public CentroDeAcopio getCentroById(@PathVariable("id") Integer id) {
        return centroService.listarXId(id);
    }
    
    @PutMapping(path = "/actualizar/centro/{id}")
    public CentroDeAcopio actualizarCentro(@RequestBody CentroDeAcopio centro, @PathVariable("id") Integer id) {
        centro.setIdCentro(id);
        return centroService.actualizarCentroDeAcopio(centro);
    }
    
    @DeleteMapping(path = "/centro/{id}")
    public CentroDeAcopio eliminarCentro(@PathVariable("id") Integer id) {
        return centroService.eliminarCentroDeAcopio(id);
    }
    
}
