package com.caito.gestion_tarjetas.security.service;

import com.caito.gestion_tarjetas.security.entity.Rol;
import com.caito.gestion_tarjetas.security.enums.RolNombre;
import com.caito.gestion_tarjetas.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;

    @Transactional(readOnly = true)
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){

        return rolRepository.findByRolNombre(rolNombre);
    }

    @Transactional
    public void save(Rol rol){

        rolRepository.save(rol);
    }
}
