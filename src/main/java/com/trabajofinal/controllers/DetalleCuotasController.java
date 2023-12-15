package com.trabajofinal.controllers;

import com.trabajofinal.dto.CuotaDTO;
import com.trabajofinal.gui.DetalleCuotas;
import com.trabajofinal.models.Cuota;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class DetalleCuotasController implements ActionListener {

    private DetalleCuotas detalleCuotas;
    private List<CuotaDTO> cuotas;

    public DetalleCuotasController(DetalleCuotas detalleCuotas, List<CuotaDTO> cuotas) {
        this.detalleCuotas = detalleCuotas;
        this.cuotas = cuotas;
        cargar();

        // Pongo a la escucha el botón
        this.detalleCuotas.btn_detalle_cuotas.addActionListener(this);

        this.detalleCuotas.setDefaultCloseOperation(DetalleCuotas.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == detalleCuotas.btn_detalle_cuotas) {
            this.detalleCuotas.dispose();
        }
    }

    private void cargar() {
        String montoFormateado;
        String fechaFormateada;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato deseado

        montoFormateado = String.format("%.2f", cuotas.get(0).getMonto());
        this.detalleCuotas.txt_det_cuota_1.setText(montoFormateado);
        fechaFormateada = sdf
                .format(Date
                        .from(cuotas.get(0).getFecha_vencimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        this.detalleCuotas.txt_det_cuota_ult_pago1.setText(fechaFormateada);

        montoFormateado = String.format("%.2f", cuotas.get(1).getMonto());
        this.detalleCuotas.txt_det_cuota_2.setText(montoFormateado);
        fechaFormateada = sdf
                .format(Date
                        .from(cuotas.get(1).getFecha_vencimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        this.detalleCuotas.txt_det_cuota_ult_pago2.setText(fechaFormateada);

        montoFormateado = String.format("%.2f", cuotas.get(2).getMonto());
        this.detalleCuotas.txt_det_cuota_3.setText(montoFormateado);
        fechaFormateada = sdf
                .format(Date
                        .from(cuotas.get(2).getFecha_vencimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        this.detalleCuotas.txt_det_cuota_ult_pago3.setText(fechaFormateada);

        montoFormateado = String.format("%.2f", cuotas.get(3).getMonto());
        this.detalleCuotas.txt_det_cuota_4.setText(montoFormateado);
        fechaFormateada = sdf
                .format(Date
                        .from(cuotas.get(3).getFecha_vencimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        this.detalleCuotas.txt_det_cuota_ult_pago4.setText(fechaFormateada);

        montoFormateado = String.format("%.2f", cuotas.get(4).getMonto());
        this.detalleCuotas.txt_det_cuota_5.setText(montoFormateado);
        fechaFormateada = sdf
                .format(Date
                        .from(cuotas.get(4).getFecha_vencimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        this.detalleCuotas.txt_det_cuota_ult_pago5.setText(fechaFormateada);

        montoFormateado = String.format("%.2f", cuotas.get(5).getMonto());
        this.detalleCuotas.txt_det_cuota_6.setText(montoFormateado);
        fechaFormateada = sdf
                .format(Date
                        .from(cuotas.get(5).getFecha_vencimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        this.detalleCuotas.txt_det_cuota_ult_pago6.setText(fechaFormateada);

    }

}
