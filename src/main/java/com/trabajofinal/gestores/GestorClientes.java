package com.trabajofinal.gestores;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.trabajofinal.dao.ClienteDao;
import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.models.Cliente;
import com.trabajofinal.models.Poliza;
import com.trabajofinal.models.TipoCondicion;
import com.trabajofinal.dao.SiniestrosConductorDao;

public class GestorClientes {
	
	private static GestorClientes instance;

	private GestorClientes() {
		
	}
	
	public static GestorClientes getInstance() {
		if(instance == null) {
			instance = new GestorClientes();
		}
		return instance;
	}

	public Cliente obtenerCliente(int id) {
		ClienteDao dao = new ClienteDao();
		return dao.getById(id);
	}

	
	public void actualizarEstadoCliente(PolizaDTO poliza, Cliente cliente) {

		      ClienteDao daocliente = new ClienteDao();
		      GestorPoliza gestorP = GestorPoliza.getInstance();
		      List<Poliza> polizasAsociadas = gestorP.obtenerCantidadPolizas(cliente.getId());

		      if (polizasAsociadas.size() == 0) {
		         cliente.setCondicion(TipoCondicion.NORMAL);
		      } else if (polizasAsociadas.size() != 0 && gestorP.sonNoVigentes(polizasAsociadas)) {
		         cliente.setCondicion(TipoCondicion.NORMAL);
		      } else {
		         int cantidad_siniestros = GestorSistemaSiniestros.getInstance().obtenerSiniestros(cliente.getId());
		         Period period = Period.between(cliente.getFecha_activacion(), LocalDate.now());
		         if (cantidad_siniestros != 0 && gestorP.tieneCuotasImpagas(polizasAsociadas) && period.getYears() >= 2) {
		            cliente.setCondicion(TipoCondicion.NORMAL);
		         } else if (cantidad_siniestros != 0 && !gestorP.tieneCuotasImpagas(polizasAsociadas) && period.getYears() >= 2) {
		            cliente.setCondicion(TipoCondicion.PLATA);
		         }
		      }
		      
		      daocliente.update(cliente);		//lo guarda en la base de datos.

	}

}
