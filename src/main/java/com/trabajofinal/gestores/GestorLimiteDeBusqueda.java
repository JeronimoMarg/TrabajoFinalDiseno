package com.trabajofinal.gestores;

import com.mysql.cj.Session;
import com.trabajofinal.dao.LimiteDao;
import com.trabajofinal.models.LimiteDeBusqueda;

public class GestorLimiteDeBusqueda {
    private static GestorLimiteDeBusqueda instance;

    private GestorLimiteDeBusqueda() {}
	
	public static GestorLimiteDeBusqueda getInstance() {
		if(instance == null) {
			instance = new GestorLimiteDeBusqueda();
		}
		return instance;
	}
    
    public void modificarLimite (int limite){
        LimiteDeBusqueda limite_actualizado = new LimiteDeBusqueda();
        limite_actualizado.setId(1);
        limite_actualizado.setLimite(limite); 
        LimiteDao limiteDao = new LimiteDao();
        limiteDao.update(limite_actualizado);
    }

    public int getLimite(){
        LimiteDao limiteDao = new LimiteDao();
        return limiteDao.getLimiteDeBusqueda();
    }
}
