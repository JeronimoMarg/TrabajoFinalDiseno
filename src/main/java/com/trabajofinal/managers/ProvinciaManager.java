package com.trabajofinal.managers;

import java.util.List;

import com.trabajofinal.dao.ProvinciaDao;
import com.trabajofinal.dto.ProvinciaDTO;
import com.trabajofinal.mappers.ProvinciaMapper;
import com.trabajofinal.models.Provincia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

//En estas clases, "Manager" pondremos la lógica del negocio, mientras que en Controller quedará la lógica para operar
//con las vistas. 
public class ProvinciaManager {
   
   private ProvinciaDao provinciaDao;

   public ProvinciaManager(EntityManager em) {
      provinciaDao = new ProvinciaDao(em);
   }
   
   //Obtener todas las provincias existentes en la base de datos
   public List<ProvinciaDTO> getAllProvincias() {
      return ProvinciaMapper.toDto(provinciaDao.getAll());
   
   }

   public ProvinciaDTO getProvinciaById(int id) {
      Provincia provincia = provinciaDao.getById(id);
      return provincia != null ? ProvinciaMapper.toDto(provincia) : null;
   }
   
   public ProvinciaDTO getProvinciaByName(String nombre) {
      Provincia provincia = provinciaDao.getByName(nombre);
      return provincia != null ? ProvinciaMapper.toDto(provincia) : null;
   }

   public List<ProvinciaDTO> getProvinciasByName(String name) {
      return ProvinciaMapper.toDto(provinciaDao.getProvinciaByName(name));
   }
    
    public void addProvincia(ProvinciaDTO dto) {
        Provincia provincia = (ProvinciaMapper.toEntity(dto));
        if (provinciaDao.getAll().contains(provincia))
            throw new IllegalArgumentException("Ya existe una Provincia con el mismo nombre en el País.");
        provinciaDao.save(provincia);
    }

    
    public void updateProvincia(ProvinciaDTO dto) {
        Provincia provincia = (ProvinciaMapper.toEntity(dto));
        provinciaDao.update(provincia);
    }

    public void deleteProvincia(ProvinciaDTO dto) {
        Provincia provincia = (ProvinciaMapper.toEntity(dto));
        provinciaDao.delete(provincia);
    }



}
