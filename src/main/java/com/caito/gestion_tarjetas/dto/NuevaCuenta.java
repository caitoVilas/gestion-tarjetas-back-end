package com.caito.gestion_tarjetas.dto;

public class NuevaCuenta {

    private String usuario;
    private Long tarjeta_id;
    private Long entidad_id;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getTarjeta_id() {
        return tarjeta_id;
    }

    public void setTarjeta_id(Long tarjeta_id) {
        this.tarjeta_id = tarjeta_id;
    }

    public Long getEntidad_id() {
        return entidad_id;
    }

    public void setEntidad_id(Long entidad_id) {
        this.entidad_id = entidad_id;
    }
}
