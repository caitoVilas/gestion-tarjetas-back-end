package com.caito.gestion_tarjetas.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double importe;
    private int cuota;
    private int numero_cuota;
    @Temporal(TemporalType.DATE)
    private Date fecha_compra;
    @Temporal(TemporalType.DATE)
    private Date fecha_vencimiento;
    @ManyToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "id")
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(Double importe, int cuota, int numero_cuota, Date fecha_compra,
                      Date fecha_vencimiento) {
        this.importe = importe;
        this.cuota = cuota;
        this.numero_cuota = numero_cuota;
        this.fecha_compra = fecha_compra;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public int getNumero_cuota() {
        return numero_cuota;
    }

    public void setNumero_cuota(int numero_cuota) {
        this.numero_cuota = numero_cuota;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
