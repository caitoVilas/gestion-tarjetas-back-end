package com.caito.gestion_tarjetas.controller;

import com.caito.gestion_tarjetas.dto.MovimientoDto;
import com.caito.gestion_tarjetas.entity.Cuenta;
import com.caito.gestion_tarjetas.entity.Movimiento;
import com.caito.gestion_tarjetas.security.jwt.JwtEntryPoint;
import com.caito.gestion_tarjetas.service.CuentaService;
import com.caito.gestion_tarjetas.service.MovimientoService;
import com.caito.gestion_tarjetas.util.Mensaje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/movimientos")
@CrossOrigin
public class MovimientoController {

    @Autowired
    MovimientoService movimientoService;
    @Autowired
    CuentaService cuentaService;

    private final static Logger logger = LoggerFactory.getLogger(MovimientoController.class);


    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody MovimientoDto movimientoDto){

       LocalDate compra = LocalDate.parse(movimientoDto.getFecha_compra());
       LocalDate vencimiento = LocalDate.parse(movimientoDto.getFecha_vencimiento());

        Movimiento nuevo = new Movimiento(
                movimientoDto.getImporte(),
                movimientoDto.getCuotas(),
                movimientoDto.getNumero_cuota(),
                movimientoDto.getDetalle(),
                compra,
               vencimiento
        );

        Cuenta cuenta = cuentaService.getOne(movimientoDto.getCuenta()).get();

        nuevo.setCuenta(cuenta);

        movimientoService.save(nuevo);

        return new ResponseEntity(new Mensaje("Movimiento Guardado!"),
                HttpStatus.OK);

    }
}
