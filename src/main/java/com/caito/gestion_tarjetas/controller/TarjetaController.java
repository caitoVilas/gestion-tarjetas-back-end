package com.caito.gestion_tarjetas.controller;

import com.caito.gestion_tarjetas.entity.Tarjeta;
import com.caito.gestion_tarjetas.service.CuentaService;
import com.caito.gestion_tarjetas.service.TarjetaService;
import com.caito.gestion_tarjetas.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarjeta")
@CrossOrigin
public class TarjetaController {

    @Autowired
    TarjetaService tarjetaService;
    @Autowired
    CuentaService cuentaService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<Tarjeta>> view(){

        List<Tarjeta> tarjetas = tarjetaService.view();

        return new ResponseEntity<List<Tarjeta>>(tarjetas, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Tarjeta tarjeta){

        if (tarjetaService.existNombre(tarjeta.getNombre())){
            return new ResponseEntity(new Mensaje("La Tarjeta existe!"),
                    HttpStatus.BAD_REQUEST);
        }

        tarjetaService.save(tarjeta);
        return new ResponseEntity(new Mensaje("Tarjeta Creada!"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{tarjeta_id}")
    public ResponseEntity<?> delete(@PathVariable("tarjeta_id") Long tarjeta_id){

        if (cuentaService.existsTarjeta(tarjeta_id)){

            return new ResponseEntity(new Mensaje("La Tarjeta Tiene Cuentas Asignadas!"),
                    HttpStatus.BAD_REQUEST);
        }

        tarjetaService.delete(tarjeta_id);

        return new ResponseEntity(new Mensaje("Tarjeta Eliminada!"), HttpStatus.OK);
    }


}
