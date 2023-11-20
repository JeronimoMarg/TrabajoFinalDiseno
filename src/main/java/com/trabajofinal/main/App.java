package com.trabajofinal.main;

import com.trabajofinal.gui.BusquedaCliente;


public class App {

   public static void main(String[] args) {
   
     
   
    BusquedaCliente busquedaCliente = new BusquedaCliente();
    busquedaCliente.setVisible(true);


     /*
	   
	  EntityManager entityManager = EntityManagerUtil.getEntityManager();

      ProvinciaManager pm = new ProvinciaManager(entityManager);
      ProvinciaDTO sf = null;
      ProvinciaDTO er = null;
      ProvinciaDTO bs = null;

      Pais argentina = new Pais(1, "Argentina");

      List<ProvinciaDTO> provincias = new ArrayList<ProvinciaDTO>();
      try {
         sf = ProvinciaForm.validarProvincia("Santa Fe", argentina);
         er = ProvinciaForm.validarProvincia("Entre Ríos", argentina);
         bs = ProvinciaForm.validarProvincia("Buenos Aires", argentina);
         provincias = List.of(sf, er, bs);
         provincias.forEach(s -> pm.addProvincia(s));
      } catch (Exception e) {
         System.out.println("Error al cargar Provincias: " + e.getMessage());
      }

      entityManager.close();
      
      */
   }

}
