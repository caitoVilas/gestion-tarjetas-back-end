package com.caito.gestion_tarjetas.repository;

import com.caito.gestion_tarjetas.entity.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long> {

    boolean existsById(Long id);
    boolean existsByNombre(String nombre);
}
