package com.caito.gestion_tarjetas.controller;

import com.caito.gestion_tarjetas.dto.NuevaCuenta;
import com.caito.gestion_tarjetas.entity.Cuenta;
import com.caito.gestion_tarjetas.entity.Entidad;
import com.caito.gestion_tarjetas.entity.Tarjeta;
import com.caito.gestion_tarjetas.security.entity.Usuario;
import com.caito.gestion_tarjetas.security.service.UsuarioService;
import com.caito.gestion_tarjetas.service.CuentaService;
import com.caito.gestion_tarjetas.service.EntidadService;
import com.caito.gestion_tarjetas.service.TarjetaService;
import com.caito.gestion_tarjetas.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
@CrossOrigin
public class CuentaController {

    @Autowired
    CuentaService cuentaService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    TarjetaService tarjetaService;
    @Autowired
    EntidadService entidadService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<Cuenta>> view(){

        List<Cuenta> cuentas = cuentaService.view();

        return new ResponseEntity<List<Cuenta>>(cuentas, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getOne(@PathVariable(name = "id") Long id){

        Cuenta cuenta = cuentaService.getOne(id).orElse(null);

        return new ResponseEntity<Cuenta>(cuenta, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody NuevaCuenta nuevaCuenta){

        Usuario usuario;

        if (usuarioService.existsByNombreUsuario(nuevaCuenta.getUsuario())){
            usuario = usuarioService.getByNombreusuario(nuevaCuenta.getUsuario()).get();
        }else {
            return new ResponseEntity(new Mensaje("La Cuenta necesita un Titular"),
                    HttpStatus.BAD_REQUEST);
        }

        if (cuentaService.existeCuenta((long) usuario.getId(), nuevaCuenta.getTarjeta_id(),
                nuevaCuenta.getEntidad_id())){
            return new ResponseEntity(new Mensaje("La Cuenta ya Existe!"),
                     HttpStatus.BAD_REQUEST);
        }

        Tarjeta tarjeta = tarjetaService.getOne(nuevaCuenta.getTarjeta_id()).get();
        Entidad entidad = entidadService.getOne(nuevaCuenta.getEntidad_id()).get();

        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario(usuario);
        cuenta.setTarjeta(tarjeta);
        cuenta.setEntidad(entidad);

        cuentaService.save(cuenta);

        return new ResponseEntity(new Mensaje("Cuenta Creada"), HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/cuenta/{nombreUsuario}")
    public ResponseEntity<List<Cuenta>> listByUser(@PathVariable("nombreUsuario")
                                                   String nombreUsuario){

        Usuario usuario = null;

        if (usuarioService.existsByNombreUsuario(nombreUsuario)){
            usuario = usuarioService.getByNombreusuario(nombreUsuario).get();
        }else {
            return new ResponseEntity(new Mensaje("El Titular No Existe!"),
                     HttpStatus.BAD_REQUEST);
        }

        List<Cuenta> cuentas = cuentaService.findByUser(usuario.getId());

        return new ResponseEntity<List<Cuenta>>(cuentas, HttpStatus.OK);
    }

}
