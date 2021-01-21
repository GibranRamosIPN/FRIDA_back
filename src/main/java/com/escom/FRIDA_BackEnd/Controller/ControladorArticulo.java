package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.DTO.ArticuloExistencia;
import com.escom.FRIDA_BackEnd.DTO.Mensaje;
import com.escom.FRIDA_BackEnd.Entity.Articulo;
import com.escom.FRIDA_BackEnd.Entity.Existencia_Articulo;
import com.escom.FRIDA_BackEnd.Repository.Existencia_ArticuloRepository;
import com.escom.FRIDA_BackEnd.Service.ArticuloService;
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

@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class ControladorArticulo {
    
    @Autowired
    ArticuloService articuloService;
    
    @Autowired
    Existencia_ArticuloRepository EartRepository;
    
    @PostMapping(path = "/crear/articulo")
    public Articulo crearArticulo(@RequestBody Articulo art) {
        return articuloService.crearArticulo(art);
    }
    
    @GetMapping(path = "/listar/articulos")
    public List<Articulo> listarArticulos() {
        return articuloService.listarArticulos();
    }
    
    @GetMapping(path = "/listar/articulo/{id}")
    public Articulo listarById(@PathVariable Integer id) {
        return articuloService.articuloById(id);
    }
    
    @PutMapping(path = "/actualizar/articulo/{id}")
    public Articulo actualizarArticulo(@RequestBody Articulo art, @PathVariable Integer id) {
        art.setIdArticulo(id);
        return articuloService.actualizarArticulo(art);
    }
    
    @DeleteMapping(path = "/eliminar/articulo/{id}")
    public Articulo eliminarArticulo(@PathVariable Integer id) {
        return articuloService.eliminarArticulo(id);
    }
    
    @PutMapping(path = "/crear/articuloExistencia")
    public ResponseEntity<?> crearArticuloExistencia(@RequestBody ArticuloExistencia art) {
        Integer articuloId;
        Articulo articulo = articuloService.articuloByNombre(art.getNombre());
        if(articulo != null){
            articuloId = articulo.getIdArticulo();
        }else{
            Articulo articuloNuevo = new Articulo();
            articuloNuevo.setNombre(art.getNombre());
            
            articuloService.crearArticulo(articuloNuevo);
            articuloId = articuloService.articuloByNombre(art.getNombre()).getIdArticulo();
        }
        
        Existencia_Articulo Earticulo = EartRepository.findByIdCentroAndIdArticulo(art.getId_centro_acopio(), articuloId);
        
        if(Earticulo != null){
            return new ResponseEntity(new Mensaje("El ya estaba en el centro de acopio"), HttpStatus.ALREADY_REPORTED);
        }else{
            Earticulo = new Existencia_Articulo();
            Earticulo.setExistencia(art.getExistencia());
            Earticulo.setUrgencia(1);
            Earticulo.setCant_req(art.getCant_req());
            Earticulo.setIdCentro(art.getId_centro_acopio());
            Earticulo.setIdArticulo(articuloId);
            EartRepository.save(Earticulo);
            return new ResponseEntity(new Mensaje("El articulo se actualizo correctamente"), HttpStatus.OK);
        }
    }
}
