package com.caito.gestion_tarjetas.service;

import com.caito.gestion_tarjetas.entity.Entidad;
import com.caito.gestion_tarjetas.repository.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EntidadService {

    @Autowired
    EntidadRepository entidadRepository;

    @Transactional(readOnly = true)
    public List<Entidad> view(){

        return entidadRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Entidad> getOne(Long id){

        return entidadRepository.findById(id);
    }

    @Transactional
    public Entidad save(Entidad entidad){

        return entidadRepository.save(entidad);
    }

    @Transactional
    public void delete(Long id){

        entidadRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public boolean existId(Long id){

        return entidadRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    public boolean existNombre(String nombre){

        return entidadRepository.existsByNombre(nombre);
    }
}
