package com.escom.FRIDA_BackEnd.Controller;

// Clase que hace referencia directamente al proyecto de FrontEnd

import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import com.escom.FRIDA_BackEnd.Entity.Caso;
import com.escom.FRIDA_BackEnd.Service.BrigadistaService;
import com.escom.FRIDA_BackEnd.Service.CasoService;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class ControladorBrigadista {
    
    @Autowired
    BrigadistaService brigadistaService;
    
    @Autowired
    CasoService casoService;
    
    @GetMapping("/lobby/brigadistas")
    public List<Brigadista>listar() {
        return brigadistaService.listarBrigadistas();
    }
    
    @GetMapping(path = { "/lobby/brigadistas/{id}" })
    public Brigadista listarId(@PathVariable("id") Integer id) {
        return brigadistaService.listarId(id);
    }
    
    @GetMapping(path = "/listar/brigadistas/{alcaldia}")
    public List<Brigadista> listarXAlcaldia(@PathVariable("alcaldia") String alcaldia) {
        return brigadistaService.listarXalcaldia(alcaldia);
    }
    
    @PostMapping("/lobby/registrar/brigadista")
    public Brigadista crearBrigadista(@RequestBody Brigadista brig) {
        return brigadistaService.crearBrigadista(brig);
    }
    
    @PutMapping(path = { "/actualizar/estado/brigadista/{idUsuario}/{idCaso}/{estado}" } )
    public Brigadista actualizarEstadoBrigadista (@PathVariable("idUsuario") Long id, @PathVariable("idCaso") Integer idCaso,
            @PathVariable("estado") String estado) {
        
        // Obtención de datos de brigadista de la tabla Brigadista a partir de su idUsuario
        Brigadista brig = brigadistaService.getBrigadistaByIdUsuario(id);
        
        // Obtención de datos del Caso
        Caso caso = casoService.obtenerCasoXId(idCaso);
        
        // Estableciendo el estado (Ocupado o Disponible) y su última ubicación (último caso evaluado)        
        /*System.out.println("idUsuario: " + id + " idCaso: " + idCaso + " estado: " + estado
        + "idBrigadista: " + brig.getIdBrigadista()); */
        String aux = estado;
        brig.setEstado(aux);
        brig.setUltima_calle_numero(caso.getCalle_numero());
        brig.setUltima_colonia(caso.getColonia());
        brig.setUltima_cp(caso.getCp());
        brig.setUltimaAlcaldiaMunicipio(caso.getAlcaldia_municipio());
        brig.setUltima_estado(caso.getEstado());
        brig.setIdCasoAsignado(idCaso);
        
        if (estado.equals("Ocupado")) {
            // Modificando status del caso a 2 - En atención
            caso.setStatus_caso(2);            
        } else if (estado.equals("Disponible")) {
            // Modificando el status del caso a 3 - Evaluado y liberando de caso asignado a brigadista
            caso.setStatus_caso(3);
            // Estableciendo la fecha de evaluado del caso
            Calendar c = Calendar.getInstance();
            String fechaEval = Integer.toString(c.get(Calendar.YEAR)) + "-" +
                    Integer.toString(c.get(Calendar.MONTH) + 1) + "-" +
                    Integer.toString(c.get(Calendar.DATE));
            
            caso.setFecha_evaluado(fechaEval);
            brig.setIdCasoAsignado(null);
        }
        
        casoService.actualizarStatusCaso(caso);
        
        return brigadistaService.actualizarBrigadista(brig);
    }
    
    @DeleteMapping(path = { "/lobby/brigadistas/{id}" })
    public Brigadista eliminarBrigadista(@PathVariable("id") Integer id) {        
        return brigadistaService.eliminarBrigadista(id);
    }
    
}
