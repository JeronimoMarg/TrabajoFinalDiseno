package com.trabajofinal.dto;

import java.time.LocalDate;

public class CuotaDTO {
    private Double monto;
    private LocalDate fecha_vencimiento;

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

}
