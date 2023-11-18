package com.trabajofinal.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.trabajofinal.dto.ProvinciaDTO;
import com.trabajofinal.models.Provincia;

public class ProvinciaMapper {
 
   public static Provincia toEntity(ProvinciaDTO dto) {
      Provincia entity = new Provincia();
      entity.setId(dto.getId());
      entity.setNombre(dto.getNombre());
      entity.setPais(dto.getPais());
      return entity;
   }

   public static List<Provincia> toEntity(List<ProvinciaDTO> dtoList) {
     return dtoList.stream()
                .map(ProvinciaMapper::toEntity)
                .collect(Collectors.toList());
   }

   public static ProvinciaDTO toDto(Provincia provincia) {
      ProvinciaDTO dto = new ProvinciaDTO();
      dto.setId(provincia.getId());
      dto.setNombre(provincia.getNombre());
      dto.setPais(provincia.getPais());
      return dto;
   }

   public static List<ProvinciaDTO> toDto(List<Provincia> provincia) {
        return provincia.stream()
                .map(ProvinciaMapper::toDto)
                .collect(Collectors.toList());
    }
}	
