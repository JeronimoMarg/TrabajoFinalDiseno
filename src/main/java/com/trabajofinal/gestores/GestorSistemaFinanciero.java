package com.trabajofinal.gestores;

import com.trabajofinal.dto.PolizaDTO;

public class GestorSistemaFinanciero {
	
	private static GestorSistemaFinanciero instance;

	private GestorSistemaFinanciero() {
		
	}
	
	public static GestorSistemaFinanciero getInstance() {
		if(instance == null) {
			instance = new GestorSistemaFinanciero();
		}
		return instance;
	}
	
	public void calcularPremioDerechosDescuentos(PolizaDTO poliza) {

	      poliza.setDerechos_emision(1000.0);
	      poliza.setPremio(5000.0);
	      // poliza.setDescuentos(500.0);
	      poliza.setDto_pago_semestral(100.0);
	      poliza.setDto_antiguedad(50.90);
	      poliza.setDto_mas_un_vehiculo(150.99);
	      Double monto_a_pagar = poliza.getPremio() + poliza.getDerechos_emision() - poliza.getDto_antiguedad()
	            - poliza.getDto_mas_un_vehiculo() - poliza.getDto_pago_semestral();
	      poliza.setMonto_a_pagar(monto_a_pagar);

}

}
