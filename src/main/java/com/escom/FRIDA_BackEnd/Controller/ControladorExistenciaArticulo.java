package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.Entity.Existencia_Articulo;
import com.escom.FRIDA_BackEnd.Repository.Existencia_ArticuloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
public class ControladorExistenciaArticulo {
    
    @Autowired
    Existencia_ArticuloRepository EartRepository;
    
    @PostMapping(path = "/insertar/existencia-articulo")
    public Existencia_Articulo insertarExistenciaArticulo(@RequestBody Existencia_Articulo Eart) {
        return EartRepository.save(Eart);
    }
    
    @PutMapping(path = "/actualizar/existencia-articulo/{idCentro}")
    public Existencia_Articulo actualizarExistenciaArticuloByCentro(@RequestBody Existencia_Articulo Eart,
            @PathVariable("idCentro") Integer idCentro) {
        // Obtención de idExistenciaArticuloCentro de ese registro para actualizar 
        Existencia_Articulo Earticulo = EartRepository.findByIdCentroAndIdArticulo(idCentro, Eart.getIdArticulo());
        Eart.setIdExistenciaArticuloCentro(Earticulo.getIdExistenciaArticuloCentro());
        return EartRepository.save(Eart);
    }
    
    @GetMapping(path = "/listar/existencia-articulos/{idCentro}")
    public List<Existencia_Articulo> obtenerExistenciaArticulosByCentro(@PathVariable("idCentro") Integer idCentro) {
        return EartRepository.findAllByIdCentro(idCentro);
    }
    
    @GetMapping(path = "/listar/existencia-articulo/{idArticulo}")
    public Existencia_Articulo obtenerExistenciaArticuloByCentro(@PathVariable("idArticulo") Integer idArticulo) {
        return EartRepository.findByIdArticulo(idArticulo);
    }
    
    @DeleteMapping(path = "/eliminar/existencia-articulos/{idCentro}")
    @Transactional
    public void eliminarExistenciaArticulosByCentro(@PathVariable("idCentro") Integer idCentro) {
        EartRepository.deleteByIdCentro(idCentro);
    }
    
}
