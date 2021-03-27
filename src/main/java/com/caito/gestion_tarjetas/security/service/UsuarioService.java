package com.caito.gestion_tarjetas.security.service;

import com.caito.gestion_tarjetas.security.entity.Usuario;
import com.caito.gestion_tarjetas.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Optional<Usuario> getByNombreusuario(String nombreUsuario) {

        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    @Transactional(readOnly = true)
    public boolean existsByNombreUsuario(String nombreUsuario) {

        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {

        return usuarioRepository.existsByEmail(email);
    }

    @Transactional
    public void save(Usuario usuario){

        usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> findOne(Long id){

        return usuarioRepository.findById(id);
    }

}
