package com.caito.gestion_tarjetas.service;

import com.caito.gestion_tarjetas.entity.Tarjeta;
import com.caito.gestion_tarjetas.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TarjetaService {

    @Autowired
    TarjetaRepository tarjetaRepository;

    @Transactional(readOnly = true)
    public List<Tarjeta> view(){

        return tarjetaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Tarjeta> getOne(Long id){

        return tarjetaRepository.findById(id);
    }

    @Transactional
    public Tarjeta save(Tarjeta tarjeta){

        return tarjetaRepository.save(tarjeta);
    }

    @Transactional
    public void delete(Long id){

        tarjetaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public boolean existId(Long id){

        return tarjetaRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    public boolean existNombre(String nombre){

        return tarjetaRepository.existsByNombre(nombre);
    }
}
