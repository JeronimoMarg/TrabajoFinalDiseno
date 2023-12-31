package com.trabajofinal.models;

import java.time.LocalDate;
import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuota")
public class Cuota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuota")
    private int id;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "fecha_vencimiento")
    private LocalDate fecha_vencimiento;

    @Column(name = "desde")
    private LocalDate desde;

    @Column(name = "hasta")
    private LocalDate hasta;

    @OneToOne(mappedBy = "cuota", cascade = CascadeType.ALL)
    private CuotaPago cuota_pago;

    public Cuota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public LocalDate getDesde() {
        return desde;
    }

    public void setDesde(LocalDate desde) {
        this.desde = desde;
    }

    public LocalDate getHasta() {
        return hasta;
    }

    public void setHasta(LocalDate hasta) {
        this.hasta = hasta;
    }

    public CuotaPago getCuota_pago() {
        return cuota_pago;
    }

    public void setCuota_pago(CuotaPago cuota_pago) {
        this.cuota_pago = cuota_pago;
    }


}
