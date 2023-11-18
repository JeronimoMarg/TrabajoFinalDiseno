package com.trabajofinal.dao;

import javax.swing.text.html.parser.Entity;

import com.trabajofinal.models.Poliza;

import jakarta.persistence.EntityManager;

public class PolizaDao extends AbstractDao<Poliza> {
    
   public PolizaDao(EntityManager em) {
      super(em);  
      setClazz(Poliza.class);
    }
}
