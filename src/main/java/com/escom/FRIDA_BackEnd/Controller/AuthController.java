package com.escom.FRIDA_BackEnd.Controller;

import com.escom.FRIDA_BackEnd.DTO.JwtDTO;
import com.escom.FRIDA_BackEnd.DTO.LoginUsuario;
import com.escom.FRIDA_BackEnd.DTO.Mensaje;
import com.escom.FRIDA_BackEnd.DTO.NuevoUsuario;
import com.escom.FRIDA_BackEnd.Entity.Brigadista;
import com.escom.FRIDA_BackEnd.Entity.Ciudadano;
import com.escom.FRIDA_BackEnd.Entity.CiudadanoUsuario;
import com.escom.FRIDA_BackEnd.Entity.Rol;
import com.escom.FRIDA_BackEnd.Entity.Usuario;
import com.escom.FRIDA_BackEnd.Entity.UsuarioRol;
import com.escom.FRIDA_BackEnd.Security.JWT.JwtProvider;
import com.escom.FRIDA_BackEnd.Service.BrigadistaService;
import com.escom.FRIDA_BackEnd.Service.CiudadanoService;
import com.escom.FRIDA_BackEnd.Service.RolService;
import com.escom.FRIDA_BackEnd.Service.UsuarioRolService;
import com.escom.FRIDA_BackEnd.Service.UsuarioService;
import com.escom.FRIDA_BackEnd.enums.RolNombre;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    BrigadistaService brigadistaService;
    
    @Autowired
    UsuarioRolService usuarioRolService;
    
    @Autowired
    CiudadanoService ciudadanoService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        boolean isBrigadista = false;
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos vacíos o email inválido"), HttpStatus.ACCEPTED.BAD_REQUEST);
        if(usuarioService.existePorNombre(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existePorEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getApellido_paterno(), nuevoUsuario.getApellido_materno(),
                        nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<String> rolesStr = nuevoUsuario.getRoles();
        Set<Rol> roles = new HashSet<>();
        for (String rol : rolesStr) {
            switch (rol) {
                case "admin":
                    Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
                    roles.add(rolAdmin);
                    break;
                case "brigadista":
                    Rol rolBrigadista = rolService.getByRolNombre(RolNombre.ROLE_BRIGADISTA).get();
                    roles.add(rolBrigadista);
                    isBrigadista = true;
                    break;
                default:
                    Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_CIUDADANO).get();
                    roles.add(rolUser);
            }
        }
        usuario.setRoles(roles);
        usuarioService.guardar(usuario);
        
        // Insertando ahora en tabla brigadistas        
        if (isBrigadista) {
            Usuario user = usuarioService.getByNombreUsuario(usuario.getNombreUsuario()).get();
            Brigadista brig = new Brigadista(user.getId());
            brig.setEstado("Disponible");
            brigadistaService.crearBrigadista(brig);
        }
            
        return new ResponseEntity(new Mensaje("El usuario ha sido guardado"), HttpStatus.CREATED);
    }
    
    @PostMapping("/nuevo/ciudadano") 
    public ResponseEntity<?> nuevoCiudadano(@Valid @RequestBody CiudadanoUsuario ciud, BindingResult bindingResult) {
        
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos vacíos o email inválido"), HttpStatus.ACCEPTED.BAD_REQUEST);
        if(usuarioService.existePorNombre(ciud.getEmail()))
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existePorEmail(ciud.getEmail()))
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(ciud.getNombre(), ciud.getApellido_paterno(), ciud.getApellido_materno(),
                        ciud.getEmail(), ciud.getEmail(),
                        passwordEncoder.encode(ciud.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_CIUDADANO).get();
        roles.add(rolUser);
        
        usuario.setRoles(roles);
        usuarioService.guardar(usuario);
        
        // Obteniendo usuario creado para ese ciudadano
        Usuario user = usuarioService.getByNombreUsuario(usuario.getNombreUsuario()).get();        
        Ciudadano c = new Ciudadano(user.getId());
        
        c.setFecha_nacimiento(ciud.getFecha_nacimiento());
        c.setCalle_numero(ciud.getCalle_numero());
        c.setColonia(ciud.getColonia());
        c.setCp(ciud.getCp());
        c.setAlcaldia_municipio(ciud.getAlcaldia_municipio());
        c.setEstado(ciud.getEstado());
        c.setIdRecomendacion(ciud.getId_recomendacion());
        
        ciudadanoService.crearCiudadano(c);
        
        return new ResponseEntity(new Mensaje("El ciudadano ha sido guardado"), HttpStatus.CREATED);        
    }
    
    @GetMapping(path = "/usuarios/nombreUsuario/{nombreUsuario}")
    public ResponseEntity<CiudadanoUsuario> listarNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
        Optional<Usuario> u =  usuarioService.getByNombreUsuario(nombreUsuario);
        Ciudadano c = ciudadanoService.getByIdUsuario(u.get().getId());
        CiudadanoUsuario cu = new CiudadanoUsuario();
        
        cu.setNombre(u.get().getNombre());
        cu.setApellido_paterno(u.get().getApellido_paterno());
        cu.setApellido_materno(u.get().getApellido_materno());
        cu.setEmail(u.get().getEmail());
        cu.setIdCiudadano(c.getId_ciudadano());
        cu.setFecha_nacimiento(c.getFecha_nacimiento());
        cu.setCalle_numero(c.getCalle_numero());
        cu.setColonia(c.getColonia());
        cu.setCp(c.getCp());
        cu.setAlcaldia_municipio(c.getAlcaldia_municipio());
        cu.setEstado(c.getEstado());
        cu.setIdUsuario(c.getIdUsuario());
        
        return new ResponseEntity<CiudadanoUsuario>(cu,HttpStatus.OK);
    }
    

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<JwtDTO>(jwtDTO, HttpStatus.OK);
    }
    
    @GetMapping(path = "/usuarios/{id}")
    public Usuario listarId(@PathVariable("id") Long id) {
        return usuarioService.getByIdUsuario(id);
    }
        
    @GetMapping(path = "/usuarios")
    public List<Usuario> listar() {
        return usuarioService.listar();
    }
    
    @GetMapping(path = "/listar/brigadistas")
    public List<Usuario> listarBrigadistas() {
        List<Usuario> brigadistas = new ArrayList<Usuario>();
        List<UsuarioRol> usuariosBrigadistas;
        
        usuariosBrigadistas = usuarioRolService.getIdUsuariosBrigadistas(new Long(3));
        
        for (UsuarioRol u: usuariosBrigadistas) {
            //System.out.println("Usuario: " + u.getUsuarioId());
            brigadistas.add(usuarioService.getById(u.getUsuarioId()).get());
        }
        
        return brigadistas;
    }
    
    @PutMapping(path = "/actualizar/usuario/{id}")
    public ResponseEntity<?> actualizarUsuarioBrigadista(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
        Set<Rol> roles = new HashSet<>();
        usuario.setId(id);
        Rol rolBrigadista = rolService.getByRolNombre(RolNombre.ROLE_BRIGADISTA).get();
        roles.add(rolBrigadista);
        usuario.setRoles(roles);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioService.guardar(usuario);
        return new ResponseEntity(new Mensaje("El usuario ha sido actualizado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping(path = "/actualizar/uciudadano/{id}")
    public ResponseEntity<?> actualizarUsuarioCiudadano(@RequestBody CiudadanoUsuario ciudadano, @PathVariable("id") Long id) {
        Ciudadano c = ciudadanoService.getByIdUsuario(id);
        
        c.setFecha_nacimiento(ciudadano.getFecha_nacimiento());
        c.setCalle_numero(ciudadano.getCalle_numero());
        c.setColonia(ciudadano.getColonia());
        c.setCp(ciudadano.getCp());
        c.setAlcaldia_municipio(ciudadano.getAlcaldia_municipio());
        c.setEstado(ciudadano.getEstado());
        ciudadanoService.actualizarCiudadano(c);
        
        Usuario usuario = new Usuario();
        
        Set<Rol> roles = new HashSet<>();
        usuario.setId(c.getIdUsuario());
        usuario.setNombre(ciudadano.getNombre());
        usuario.setApellido_paterno(ciudadano.getApellido_paterno());
        usuario.setApellido_materno(ciudadano.getApellido_materno());
        usuario.setEmail(ciudadano.getEmail());
        usuario.setNombreUsuario(ciudadano.getEmail());
        usuario.setPassword(passwordEncoder.encode(ciudadano.getPassword()));
        Rol rolCiudadano = rolService.getByRolNombre(RolNombre.ROLE_CIUDADANO).get();
        roles.add(rolCiudadano);
        usuario.setRoles(roles);
        
        usuarioService.guardar(usuario);
        
        return new ResponseEntity(new Mensaje("El ciudadano ha sido actualizado correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping(path = "/usuarios/{id}")
    public ResponseEntity<?> eliminarUsuarioBrigadista(@PathVariable("id") Long id) {        
        usuarioService.eliminar(id);
        Brigadista brig = new Brigadista(id);
        brigadistaService.eliminarBrigadista(brig.getIdBrigadista());
        return new ResponseEntity(new Mensaje("El usuario ha sido eliminado correctamente"), HttpStatus.OK);
    }
}