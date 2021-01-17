package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.DTO.Mensaje;
import com.escom.FRIDA_BackEnd.Entity.Caso;
import com.escom.FRIDA_BackEnd.Entity.Mapas;
import com.escom.FRIDA_BackEnd.Entity.MapasCaso;
import com.escom.FRIDA_BackEnd.Service.CasoService;
import com.escom.FRIDA_BackEnd.Service.MapasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @Autowired
    MapasService mapasService;
    
    @PostMapping("/nuevo/caso")
    public ResponseEntity<?> crearMapasCaso(@RequestBody MapasCaso mapasCaso){
        Caso caso = new Caso(mapasCaso.getPrioridad(),mapasCaso.getTipo_danio(),
        mapasCaso.getCalle_numero(),mapasCaso.getColonia(),mapasCaso.getCp(),mapasCaso.getAlcaldia_municipio(),
        mapasCaso.getEstado(),mapasCaso.getStatus_caso(),mapasCaso.getFecha_reportado(),mapasCaso.getFecha_evaluado(),
        mapasCaso.getIdCuestionario(),mapasCaso.getIdCiudadano());
        
        casoService.crearCaso(caso);
        
        //Caso caso2 = casoService.obtenerCasoXId();
        
        //Mapas mapas = new Mapas(mapasCaso.getLatitud(), mapasCaso.getLongitud(), 1);
        
        //mapasService.crearMapas(mapas);
            
        return new ResponseEntity(new Mensaje("El caso ha sido guardado"), HttpStatus.CREATED);
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
