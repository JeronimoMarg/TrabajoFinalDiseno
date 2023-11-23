package com.trabajofinal.main;

import com.trabajofinal.gui.BusquedaCliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trabajofinal.dao.ClienteDao;
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
