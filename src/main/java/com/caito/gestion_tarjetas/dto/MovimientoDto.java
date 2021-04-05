package com.caito.gestion_tarjetas.dto;

import java.util.Date;

public class MovimientoDto {

    private String fecha_compra;
    private String fecha_vencimiento;
    private Double importe;
    private String detalle;
    private int cuotas;
    private int numero_cuota;
    private Long cuenta;

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuota(int cuotas) {
        this.cuotas = cuotas;
    }

    public int getNumero_cuota() {
        return numero_cuota;
    }

    public void setNumero_cuota(int numero_cuota) {
        this.numero_cuota = numero_cuota;
    }

    public Long getCuenta() {
        return cuenta;
    }

    public void setCuenta(Long cuenta) {
        this.cuenta = cuenta;
    }
}
