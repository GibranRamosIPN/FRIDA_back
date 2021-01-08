package com.escom.FRIDA_BackEnd.Controller;

// Clase que hace referencia directamente al proyecto de FrontEnd

import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import com.escom.FRIDA_BackEnd.Service.BrigadistaService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
//@RequestMapping({"/lobby/brigadistas"})
public class ControladorBrigadista {
    
    @Autowired
    BrigadistaService service;
    
    @GetMapping("/lobby/brigadistas")
    public List<Brigadista>listar() {
        return service.listarBrigadistas();
    }
    
    @GetMapping(path = { "/lobby/brigadistas/{id}" })
    public Brigadista listarId(@PathVariable("id") Integer id) {
        return service.listarId(id);
    }
    
    @PostMapping("/lobby/registrar/brigadista")
    public Brigadista crearBrigadista(@RequestBody Brigadista brig) {
        return service.crearBrigadista(brig);
    }
    
    @PutMapping(path = { "lobby/editar/brigadista/{id}" } )
    public Brigadista actualizarBrigadista (@RequestBody Brigadista brig, @PathVariable("id") Integer id) {
        brig.setIdBrigadista(id);
        return service.actualizarBrigadista(brig);
    }
    
    @DeleteMapping(path = { "/lobby/brigadistas/{id}" })
    public Brigadista eliminarBrigadista(@PathVariable("id") Integer id) {        
        return service.eliminarBrigadista(id);
    }
    
}
