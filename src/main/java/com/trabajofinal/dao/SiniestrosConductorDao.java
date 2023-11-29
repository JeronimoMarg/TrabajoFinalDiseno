package com.trabajofinal.dao;

import com.trabajofinal.models.SiniestrosConductor;

public class SiniestrosConductorDao extends AbstractDao<SiniestrosConductor> {
	   
	   public SiniestrosConductorDao() {
	      //super(em);  
	      setClazz(SiniestrosConductor.class);
	    }

}
