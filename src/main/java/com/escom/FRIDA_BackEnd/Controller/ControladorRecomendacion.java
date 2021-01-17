package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.Entity.Recomendacion;
import com.escom.FRIDA_BackEnd.Service.RecomendacionService;
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

@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class ControladorRecomendacion {
    
    @Autowired
    RecomendacionService recomendacionService;
    
    @GetMapping(path = "/listar/recomendaciones")
    public List<Recomendacion> listarRecomendaciones() {
        return recomendacionService.listarRecomendaciones();
    }
    
    @GetMapping(path = "/listar/recomendacion/{id}")
    public Recomendacion listarById(@PathVariable Integer id) {
        return recomendacionService.recomendacionById(id);
    }
    
}
