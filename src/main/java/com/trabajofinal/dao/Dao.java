package com.trabajofinal.dao;

import java.util.List;
import java.util.Optional;

public interface Dao <T>{

	List<T> getAll();

   T getById(int id);
	
   void save(T t);
	
	void update(T t);
	
	void delete(T t);

}
