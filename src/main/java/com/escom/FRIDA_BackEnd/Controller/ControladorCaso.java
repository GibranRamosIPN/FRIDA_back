package com.escom.FRIDA_BackEnd.Controller;

import static com.escom.FRIDA_BackEnd.Controller.ControladorImagen.decompressBytes;
import com.escom.FRIDA_BackEnd.DTO.InformacionCasoBrigadista;
import com.escom.FRIDA_BackEnd.Entity.Caso;
import com.escom.FRIDA_BackEnd.Entity.Mapas;
import com.escom.FRIDA_BackEnd.DTO.MapasCaso;
import com.escom.FRIDA_BackEnd.DTO.Mensaje;
import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import com.escom.FRIDA_BackEnd.Entity.Imagen;
import com.escom.FRIDA_BackEnd.Entity.Usuario;
import com.escom.FRIDA_BackEnd.Service.BrigadistaService;
import com.escom.FRIDA_BackEnd.Service.CasoService;
import com.escom.FRIDA_BackEnd.Service.ImagenService;
import com.escom.FRIDA_BackEnd.Service.MapasService;
import com.escom.FRIDA_BackEnd.Service.UsuarioService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;
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
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    BrigadistaService brigadistaService;
    
    @Autowired
    ImagenService imagenService;
    
    @PostMapping("/nuevo/caso")
    public ResponseEntity<Caso> crearMapasCaso(@RequestBody MapasCaso mapasCaso){
        List<Caso> caso2 = casoService.obtenerCasoXDomicilio(mapasCaso.getCalle_numero(), mapasCaso.getColonia(),
                mapasCaso.getCp(),mapasCaso.getAlcaldia_municipio());
                
        if(caso2.isEmpty()) { 
            Caso caso = new Caso(mapasCaso.getPrioridad(),mapasCaso.getTipo_danio(),
            mapasCaso.getCalle_numero(),mapasCaso.getColonia(),mapasCaso.getCp(),mapasCaso.getAlcaldia_municipio(),
            mapasCaso.getEstado(),mapasCaso.getStatus_caso(),mapasCaso.getFecha_reportado(),mapasCaso.getFecha_evaluado(),
            mapasCaso.getIdCuestionario(),mapasCaso.getIdCiudadano());
            casoService.crearCaso(caso);
            
            caso2 = casoService.obtenerCasoXDomicilio(mapasCaso.getCalle_numero(), mapasCaso.getColonia(),
                mapasCaso.getCp(),mapasCaso.getAlcaldia_municipio());
            
            Mapas mapas = new Mapas();
            mapas.setLat(mapasCaso.getLat());
            mapas.setLng(mapasCaso.getLng());
            mapas.setIdCaso(caso2.get(0).getIdCaso());
            mapasService.actualizarMapas(mapas);
            return new ResponseEntity(caso2.get(0), HttpStatus.OK);
        }
        return new ResponseEntity(caso2.get(0), HttpStatus.OK);
    }
    
    @GetMapping(path = "/listar/casos")
    public List<Caso> listarCasos() {
        return casoService.listarCasos();
    }
    
    @GetMapping(path = "/listar/casoXNombreUsuario/{nombreUsuario}")
    public InformacionCasoBrigadista casoXNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(nombreUsuario);
        Brigadista brigadista = brigadistaService.getBrigadistaByIdUsuario(usuario.get().getId());
        InformacionCasoBrigadista info = new InformacionCasoBrigadista();
        if(brigadista.getIdCasoAsignado() != null){
            Caso caso = casoService.obtenerCasoXId(brigadista.getIdCasoAsignado());
            Mapas mapa = mapasService.obtenerMapasXIdCaso(caso.getIdCaso());
            
            List<Imagen> imagenes = imagenService.obtenerImagenXidCaso(Long.parseLong(caso.getIdCaso().toString()));
            List<Imagen> imgs = new ArrayList<>();
            for(Imagen i: imagenes) {     // Recorriendo lista de imagenes almacenadas del caso
                Imagen img = new Imagen(i.getNombreImagen(), decompressBytes(i.getBytes()), i.getIdCaso());
                imgs.add(img);
            }
            
            info.setIdCaso(caso.getIdCaso());
            info.setPrioridad(caso.getPrioridad());
            info.setTipo_danio(caso.getTipo_danio());
            info.setCalle_numero(caso.getCalle_numero());
            info.setColonia(caso.getColonia());
            info.setAlcaldia_municipio(caso.getAlcaldia_municipio());
            info.setEstado(caso.getEstado());
            info.setStatus_caso(caso.getStatus_caso());
            info.setFecha_reportado(caso.getFecha_reportado());
            info.setIdCuestionario(caso.getIdCuestionario());
            info.setLat(mapa.getLat());
            info.setLng(mapa.getLng());
            info.setgetImagenes(imgs);
        }
        return info;
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
    
    @PutMapping(path = "/confirmar/caso/{nombreUsuario}")
    public ResponseEntity<?> confirmarCasoEvaluado(@PathVariable("nombreUsuario") String nombreUsuario) {
        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(nombreUsuario);
        Brigadista brigadista = brigadistaService.getBrigadistaByIdUsuario(usuario.get().getId());
        Caso caso = casoService.obtenerCasoXId(brigadista.getIdCasoAsignado());
        
        brigadista.setIdCasoAsignado(null);
        brigadista.setEstado("Disponible");
        brigadistaService.actualizarBrigadista(brigadista);
        
        Date dia = new Date();
        Timestamp ts = new Timestamp(dia.getTime());
        System.out.println(ts.toString());
        caso.setIdCaso(caso.getIdCaso());
        caso.setFecha_evaluado(ts.toString());
        caso.setStatus_caso(3);
        casoService.actualizarStatusCaso(caso);
        return new ResponseEntity(new Mensaje("El caso se ha evaluado."), HttpStatus.OK);
    }
    
    @DeleteMapping(path = "/eliminar/caso/{id}")
    public Caso eliminarCaso(@PathVariable("id") Integer id) {
        return casoService.eliminarCaso(id);
    } 
}
