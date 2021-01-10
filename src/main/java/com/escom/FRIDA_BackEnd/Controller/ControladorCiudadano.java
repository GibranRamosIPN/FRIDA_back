package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.Entity.Ciudadano;
import com.escom.FRIDA_BackEnd.Service.CiudadanoService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController

public class ControladorCiudadano {
    @Autowired
    CiudadanoService service;
    
    @GetMapping("/appCiudadano/ciudadanos")
    public List<Ciudadano>listar(){
        return service.listarCiudadanos();
    }
    
    @PostMapping("/appCiudadano/registrar/ciudadano")
    public Ciudadano crearCiudadano(@RequestBody Ciudadano ciud) {
        return service.crearCiudadano(ciud);
    }
}
