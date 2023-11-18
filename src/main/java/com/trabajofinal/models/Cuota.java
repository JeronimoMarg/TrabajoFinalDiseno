package com.trabajofinal.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cuota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poliza")
    private int id;
    private Double monto;
    private LocalDate fecha_vencimiento;
    private LocalDate desde;
    private LocalDate hasta;
    private Pago pago;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_poliza")				//cuota NO conoce a la poliza
    private Poliza poliza;

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
    public Pago getPago() {
        return pago;
    }
    public void setPago(Pago pago) {
        this.pago = pago;
    }

}
