package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.Entity.Caso;
import com.escom.FRIDA_BackEnd.Service.CasoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorCaso {
    
    @Autowired
    CasoService casoService;
    
    @PostMapping(path = "/crearCaso") 
    public Caso crearCaso(@RequestBody Caso caso) {
        return casoService.crearCaso(caso);
    }
    
    @GetMapping(path = "/listar/casos")
    public List<Caso> listarCasos() {
        return casoService.listarCasos();
    }
    
    @GetMapping(path = "/listar/caso/{id}")
    public Caso listarCasoXId(@PathVariable("id") Integer id) {
        return casoService.obtenerCasoXId(id);
    }
    
    @PutMapping(path = "/actualizar/caso/{id}/{status}")
    public Caso actualizarStatusCaso(@RequestBody Caso caso, @PathVariable("id") Integer id, @PathVariable("status") Integer status) {
        caso.setIdCaso(id);
        caso.setStatus_caso(status);
        return casoService.actualizarStatusCaso(caso);
    }
    
    @DeleteMapping(path = "/eliminar/caso/{id}")
    public Caso eliminarCaso(@PathVariable("id") Integer id) {
        return casoService.eliminarCaso(id);
    }
}
