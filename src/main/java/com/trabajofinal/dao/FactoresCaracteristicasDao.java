package com.trabajofinal.dao;

import com.trabajofinal.models.FactoresCaracteristicas;
import com.trabajofinal.models.Poliza;

public class FactoresCaracteristicasDao extends AbstractDao<FactoresCaracteristicas> {

	public FactoresCaracteristicasDao() {
	      //super(em);  
	      setClazz(FactoresCaracteristicas.class);
	    }
	
}
