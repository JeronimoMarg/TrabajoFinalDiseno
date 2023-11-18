package com.trabajofinal.forms;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import com.trabajofinal.dto.ProvinciaDTO;
import com.trabajofinal.models.Pais;

public class ProvinciaForm {

   public static ProvinciaDTO validarProvincia(String nombre, Pais pais) {
      validarNombre(nombre);
      // validarPais(pais);

      ProvinciaDTO result = new ProvinciaDTO();
      result.setId(0);
      result.setNombre(nombre);
      result.setPais(pais);
      return result;
   }

   private static void validarNombre(String nombre) {
      if (nombre == null || nombre.trim().isEmpty() || nombre.length() > 255) {
         throw new IllegalArgumentException("El nombre es invalido.");
      }

      if (!nombre.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚüÜñÑ][a-zA-Z0-9áéíóúÁÉÍÓÚüÜñÑ\\s]*[a-zA-Z0-9áéíóúÁÉÍÓÚüÜñÑ]$")) {
         System.out.println("El nombre contiene caracteres no permitidos: " + nombre);
         throw new IllegalArgumentException("El nombre contiene caracteres no permitidos.");
      }

   }
}
