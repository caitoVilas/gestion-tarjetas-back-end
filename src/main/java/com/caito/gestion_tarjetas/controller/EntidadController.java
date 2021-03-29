package com.caito.gestion_tarjetas.controller;

import com.caito.gestion_tarjetas.entity.Entidad;
import com.caito.gestion_tarjetas.entity.Tarjeta;
import com.caito.gestion_tarjetas.service.CuentaService;
import com.caito.gestion_tarjetas.service.EntidadService;
import com.caito.gestion_tarjetas.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entidad")
@CrossOrigin
public class EntidadController {

    @Autowired
    EntidadService entidadService;
    @Autowired
    CuentaService cuentaService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<Entidad>> view(){

        List<Entidad> entidades = entidadService.view();

        return new ResponseEntity<List<Entidad>>(entidades, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Entidad entidad){

        if (entidadService.existNombre(entidad.getNombre())){
            return new ResponseEntity(new Mensaje("La Entidad existe!"),
                    HttpStatus.BAD_REQUEST);
        }

        entidadService.save(entidad);
        return new ResponseEntity(new Mensaje("Entidad Creada!"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{entidad_id}")
    public ResponseEntity<?> delete(@PathVariable("entidad_id") Long entidad_id){

        if (cuentaService.existsEntidad(entidad_id)){

            return new ResponseEntity(new Mensaje("La Entidad Tiene Cuentas Asignadas!"),
                    HttpStatus.BAD_REQUEST);
        }

        entidadService.delete(entidad_id);

        return new ResponseEntity(new Mensaje("Entidad Eliminada!"), HttpStatus.OK);
    }
}
