package com.caito.gestion_tarjetas.service;

import com.caito.gestion_tarjetas.entity.Movimiento;
import com.caito.gestion_tarjetas.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    MovimientoRepository movimientoRepository;

    @Transactional(readOnly = true)
    public List<Movimiento> viewAll(Long cuenta_id){

        return movimientoRepository.findAllByCuenta_id(cuenta_id);
    }

    @Transactional
    public Movimiento save(Movimiento movimiento){

        return movimientoRepository.save(movimiento);
    }
}
