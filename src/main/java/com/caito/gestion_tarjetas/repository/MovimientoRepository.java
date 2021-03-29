package com.caito.gestion_tarjetas.repository;

import com.caito.gestion_tarjetas.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    List<Movimiento> findAllByCuenta_id(Long cuenta_id);
}
