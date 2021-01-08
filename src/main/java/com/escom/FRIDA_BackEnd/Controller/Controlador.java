package com.escom.FRIDA_BackEnd.Controller;

// Clase que hace referencia directamente al proyecto de FrontEnd

import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import com.escom.FRIDA_BackEnd.Service.BrigadistaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
@RestController
//@RequestMapping({"/lobby/brigadistas"})
public class Controlador {
    
    @Autowired
    BrigadistaService service;
    
    @GetMapping("/lobby/brigadistas")
    public List<Brigadista>listar() {
        return service.listarBrigadistas();
    }
}
