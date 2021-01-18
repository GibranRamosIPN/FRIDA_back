package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.Entity.Mapas;
import com.escom.FRIDA_BackEnd.Service.CasoService;
import com.escom.FRIDA_BackEnd.Service.MapasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class ControladorMapas {
    
    @Autowired
    MapasService mapasService;
    
    @Autowired
    CasoService casoService;
    
    @PostMapping(path = "/crearMapas") 
    public Mapas crearMapas(@RequestBody Mapas mapas) {
        return mapasService.crearMapas(mapas);
    }
    
    @GetMapping(path = "/listar/mapas")
    public List<Mapas> listarMapas() {
        return mapasService.listarMapas();
    }
    
    @GetMapping(path = "/listar/mapas/{id}")
    public Mapas listarMapasXId(@PathVariable("id") Integer id) {
        return mapasService.obtenerMapasXIdCaso(id);
    }
    
    @DeleteMapping(path = "/eliminar/mapas/{id}")
    public Mapas eliminarCaso(@PathVariable("id") Integer id) {
        return mapasService.eliminarMapas(id);
    }
}