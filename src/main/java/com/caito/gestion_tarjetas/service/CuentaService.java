package com.caito.gestion_tarjetas.service;

import com.caito.gestion_tarjetas.entity.Cuenta;
import com.caito.gestion_tarjetas.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    CuentaRepository cuentaRepository;

    @Transactional(readOnly = true)
    public List<Cuenta> view(){

        return cuentaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Cuenta> getOne(Long id){

        return cuentaRepository.findById(id);
    }

    @Transactional
    public Cuenta save(Cuenta cuenta){

        return cuentaRepository.save(cuenta);
    }

    @Transactional(readOnly = true)
    public boolean existeCuenta(Long usuario_id, Long tarjeta_id, Long entidad_id){

        return cuentaRepository.existsByUsuario_idAndTarjeta_idAndEntidad_id(usuario_id,
                tarjeta_id, entidad_id);
    }

    @Transactional(readOnly = true)
    public List<Cuenta> findByUser(Long id){

        return cuentaRepository.findAllByUsuario_id(id);
    }
}
