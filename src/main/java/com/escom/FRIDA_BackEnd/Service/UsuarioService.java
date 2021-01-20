package com.escom.FRIDA_BackEnd.Service;

import com.escom.FRIDA_BackEnd.Repository.UsuarioRepository;
import com.escom.FRIDA_BackEnd.Entity.Usuario;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nu){
        return usuarioRepository.findByNombreUsuario(nu);
    }

    public Optional<Usuario> getById(Long id) {
        return usuarioRepository.findById(id);
    }
    
    public Usuario getByIdUsuario(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }
    
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
        
    public boolean existePorNombre(String nu){
        return usuarioRepository.existsByNombre(nu);
    }

    public  boolean existePorEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void guardar(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
