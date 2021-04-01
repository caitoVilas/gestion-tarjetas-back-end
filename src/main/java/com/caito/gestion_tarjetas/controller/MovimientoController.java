package com.caito.gestion_tarjetas.controller;

import com.caito.gestion_tarjetas.dto.MovimientoDto;
import com.caito.gestion_tarjetas.entity.Cuenta;
import com.caito.gestion_tarjetas.entity.Movimiento;
import com.caito.gestion_tarjetas.service.CuentaService;
import com.caito.gestion_tarjetas.service.MovimientoService;
import com.caito.gestion_tarjetas.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/movimientos")
@CrossOrigin
public class MovimientoController {

    @Autowired
    MovimientoService movimientoService;
    @Autowired
    CuentaService cuentaService;


    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody MovimientoDto movimientoDto){

        Movimiento nuevo = new Movimiento(
                movimientoDto.getImporte(),
                movimientoDto.getCuotas(),
                movimientoDto.getNumero_cuota(),
                movimientoDto.getDetalle(),
                movimientoDto.getFecha_compra(),
                movimientoDto.getFecha_vencimiento()
        );

        Cuenta cuenta = cuentaService.getOne(movimientoDto.getCuenta()).get();

        nuevo.setCuenta(cuenta);

        movimientoService.save(nuevo);

        return new ResponseEntity(new Mensaje("Movimiento Guardado!"),
                HttpStatus.OK);

    }
}
