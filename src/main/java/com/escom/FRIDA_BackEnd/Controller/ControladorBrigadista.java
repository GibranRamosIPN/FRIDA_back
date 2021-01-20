package com.escom.FRIDA_BackEnd.Controller;

// Clase que hace referencia directamente al proyecto de FrontEnd

import com.escom.FRIDA_BackEnd.DTO.UsuarioBrigadista;
import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import com.escom.FRIDA_BackEnd.Entity.Caso;
import com.escom.FRIDA_BackEnd.Entity.Usuario;
import com.escom.FRIDA_BackEnd.Service.BrigadistaService;
import com.escom.FRIDA_BackEnd.Service.CasoService;
import com.escom.FRIDA_BackEnd.Service.UsuarioService;
import java.util.ArrayList;
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
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/lobby/brigadistas")
    public List<Brigadista>listar() {
        return brigadistaService.listarBrigadistas();
    }
    
    @GetMapping(path = { "/lobby/brigadistas/{id}" })
    public Brigadista listarId(@PathVariable("id") Integer id) {
        return brigadistaService.listarId(id);
    }
    
    @GetMapping(path = "/listar/brigadistas/{alcaldia}")
    public List<UsuarioBrigadista> listarXAlcaldia(@PathVariable("alcaldia") String alcaldia) {
        List<Brigadista> brig = new ArrayList<>();
        List<UsuarioBrigadista> uBrig = new ArrayList<>();
        
        // Se obtienen todos los brigadistas cuya última alcaldía fue la del caso por asignar
        // y que estén disponibles
        brig = brigadistaService.listarXalcaldiaYdisponibles(alcaldia);
        
        for (Brigadista b : brig) {         // Recorriendo lista de brigadistas
            // Se consulta los datos de usuario con el idUsuario contenido en la tabla Brigadista
            // y se agrega a la lista de UsuarioBrigadista
            Usuario usuario = new Usuario();
            UsuarioBrigadista uBrigIndividual = new UsuarioBrigadista();
            usuario = usuarioService.getByIdUsuario(b.getIdUsuario());
            uBrigIndividual.setIdUsuario(usuario.getId());
            uBrigIndividual.setNombre(usuario.getNombre());
            uBrigIndividual.setApellido_paterno(usuario.getApellido_paterno());
            uBrigIndividual.setApellido_materno(usuario.getApellido_materno());            
            uBrigIndividual.setUltima_alcaldia_municipio(b.getUltimaAlcaldiaMunicipio());
            uBrigIndividual.setIdBrigadista(b.getIdBrigadista());            

            uBrig.add(uBrigIndividual);
        }
        
        return uBrig;
    }
    
    /* Este método se manda a llamar si el método anterior de buscar brigadistas disponibles por alcaldía 
       no retorna resultados */
    @GetMapping("/listar/brigadistas/disponibles")
    public List<UsuarioBrigadista> listarBrigadistasDisponibles() {        
        List<Brigadista> brig = new ArrayList<>();
        List<UsuarioBrigadista> uBrig = new ArrayList<>();        
        
        // Se obtienen todos los brigadistas que estén disponibles
        brig = brigadistaService.listarDisponibles();
        
        for (Brigadista b : brig) {         // Recorriendo lista de brigadistas disponibles
            /* Se consulta los datos de usuario con el idUsuario contenido en la tabla Brigadista
               y se agrega a la lista de UsuarioBrigadista */
            Usuario usuario = new Usuario();
            UsuarioBrigadista uBrigIndividual = new UsuarioBrigadista();
            usuario = usuarioService.getByIdUsuario(b.getIdUsuario());
            uBrigIndividual.setIdUsuario(usuario.getId());
            uBrigIndividual.setNombre(usuario.getNombre());
            uBrigIndividual.setApellido_paterno(usuario.getApellido_paterno());
            uBrigIndividual.setApellido_materno(usuario.getApellido_materno());            
            uBrigIndividual.setUltima_alcaldia_municipio(b.getUltimaAlcaldiaMunicipio());
            uBrigIndividual.setIdBrigadista(b.getIdBrigadista());            

            uBrig.add(uBrigIndividual);
        }
        
        return uBrig;
    }
    
    @GetMapping("/listar/brigadista/{idCasoAsignado}")
    public Usuario listarBrigadistaXidCasoAsignado(@PathVariable("idCasoAsignado") Integer idCasoAsignado) {
        Brigadista brig = brigadistaService.getBrigadistaXidCasoAsignado(idCasoAsignado);
        Usuario usuarioBrig = new Usuario();
        
        usuarioBrig = usuarioService.getById(brig.getIdUsuario()).get();
        
        return usuarioBrig;
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
