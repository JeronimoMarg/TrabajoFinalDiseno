package com.trabajofinal.gestores;

import java.util.List;

import com.trabajofinal.dao.TipoCoberturaDao;
import com.trabajofinal.models.TipoCobertura;

public class GestorTipoCobertura {

	   private static GestorTipoCobertura instance;
	
	
	   public static GestorTipoCobertura getInstance() {
		   	if (instance == null) {
		        instance = new GestorTipoCobertura();
		     }
		     return instance;
	   }
	   
	   public List<TipoCobertura> getTipos(){
		   
		   TipoCoberturaDao dao = new TipoCoberturaDao();
		   return dao.getAll();
		   
	   }
	
}
