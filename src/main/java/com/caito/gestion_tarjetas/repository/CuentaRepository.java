package com.caito.gestion_tarjetas.repository;

import com.caito.gestion_tarjetas.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    boolean existsByUsuario_idAndTarjeta_idAndEntidad_id(Long u_id, Long t_id, Long e_id);
}
