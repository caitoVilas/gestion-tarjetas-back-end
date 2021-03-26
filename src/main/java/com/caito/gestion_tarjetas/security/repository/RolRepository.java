package com.caito.gestion_tarjetas.security.repository;

import com.caito.gestion_tarjetas.security.entity.Rol;
import com.caito.gestion_tarjetas.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
