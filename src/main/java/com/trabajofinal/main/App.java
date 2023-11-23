package com.trabajofinal.main;

import com.trabajofinal.gui.BusquedaCliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trabajofinal.dao.ClienteDao;
import com.trabajofinal.dao.FactoresCaracteristicasDao;
import com.trabajofinal.dto.ProvinciaDTO;
import com.trabajofinal.forms.ProvinciaForm;
import com.trabajofinal.gui.BusquedaCliente;
import com.trabajofinal.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import com.trabajofinal.models.*;

public class App {

   public static void main(String[] args) {

	  
	   
      //BusquedaCliente busquedaCliente = new BusquedaCliente();
      //busquedaCliente.setVisible(true);

     //guardarCliente(crearCliente());	//anda perfecto
	 //mostrarClientes();				//anda perfecto
	 //mostrarPorId(3);					//anda perfecto. gestionar que es lo que pasa cuando no encuentra cliente
	 
	 //guardarFactoresCaracteristicas(crearFactoresCaracteristicas());
	   
   }
   
   
   private static Cliente crearCliente() {
	   

	   Cliente ejemplo1 = new Cliente(
			   "222-444",
			   "43426530",
			   TipoDocumento.DNI,
			   "Jeronimo",
			   "Margitic",
			   TipoCondicion.NORMAL,
			   true,
			   2020,
			   "estudiante",
			   "11-43426530-33",
			   "jero.margitic@gmail.com",
			   TipoCondicionIVA.RESPONSABLE_INSCRIPTO,
			   LocalDate.of(2001, 6, 9),
			   EstadoCivil.SOLTERO,
			   'm',
			   new Domicilio()
			   );
	   
	   System.out.print(ejemplo1.toString());
	   return ejemplo1;
	   
   }
   
   private static void guardarCliente(Cliente cliente) {
	   
	   try {
	    	  ClienteDao dao = new ClienteDao();
	    	  dao.save(cliente);
	    	  
	      }catch(Exception e) {
	    	  System.out.println(e.getMessage());
	    	  e.printStackTrace();
	      }
	   
   }
   
   private static FactoresCaracteristicas crearFactoresCaracteristicas() {
	   
	   FactoresCaracteristicas ejemplo1 = new FactoresCaracteristicas(
			   0.02,
			   0.01,
			   0.01,
			   0.3,
			   0.1,
			   0.2,
			   0.3,
			   0.4,
			   0.05,
			   0.08,
			   10.00,
			   10000.00,
			   500.00,
			   LocalDate.of(2023, 12, 31),
			   null,
			   2,
			   new Usuario()
			   );
	   
	   System.out.print(ejemplo1.toString());
	   return ejemplo1;
	   
   }
   
   private static void guardarFactoresCaracteristicas(FactoresCaracteristicas factores) {
	   
	   try {
	    	  FactoresCaracteristicasDao dao = new FactoresCaracteristicasDao();
	    	  dao.save(factores);
	    	  
	      }catch(Exception e) {
	    	  System.out.println(e.getMessage());
	    	  e.printStackTrace();
	      }
	   
   }
   
   private static void mostrarClientes() {
	   
	   ClienteDao dao = new ClienteDao();
	   List<Cliente> clientes = dao.getAll();
	   System.out.println(clientes);
	   
   }
   
   private static void mostrarPorId(int id) {
	   
	   ClienteDao dao = new ClienteDao();
	   Cliente cliente = dao.getById(id);
	   System.out.println(cliente);
	   
   }

}
