package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.Entity.Articulo;
import com.escom.FRIDA_BackEnd.Service.ArticuloService;
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
public class ControladorArticulo {
    
    @Autowired
    ArticuloService articuloService;
    
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
    
}
