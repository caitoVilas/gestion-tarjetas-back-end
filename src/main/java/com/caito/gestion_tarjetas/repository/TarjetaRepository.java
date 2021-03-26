package com.caito.gestion_tarjetas.repository;

import com.caito.gestion_tarjetas.entity.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {

    boolean existsById(Long id);
    boolean existsByNombre(String nombre);
}
