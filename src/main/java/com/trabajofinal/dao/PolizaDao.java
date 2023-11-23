package com.trabajofinal.dao;

import javax.swing.text.html.parser.Entity;

import com.trabajofinal.models.Poliza;

import jakarta.persistence.EntityManager;

public class PolizaDao extends AbstractDao<Poliza> {
   
   public PolizaDao() {
      //super(em);  
      setClazz(Poliza.class);
    }
   
   //Override al metodo poliza para que guarde tambien el vehiculo, hijos, cuotas, etc?
   
   
   
}
