package com.caito.gestion_tarjetas.repository;

import com.caito.gestion_tarjetas.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    boolean existsByUsuario_idAndTarjeta_idAndEntidad_id(Long u_id, Long t_id, Long e_id);
    List<Cuenta> findAllByUsuario_id (Long id);
    boolean existsByTarjeta_id(Long id_tarjeta);
    boolean existsByEntidad_id(Long id_entidad);
}
