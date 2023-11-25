package com.trabajofinal.dao;

import com.trabajofinal.models.Usuario;

public class UsuarioDao extends AbstractDao<Usuario>{

	
	public UsuarioDao() {
		//super(entityManager);
		setClazz(Usuario.class);
	}

}
