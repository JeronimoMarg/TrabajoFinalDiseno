package com.trabajofinal.main;

import com.trabajofinal.gui.BusquedaCliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.trabajofinal.dao.*;
import com.trabajofinal.gui.BusquedaCliente;
import com.trabajofinal.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import com.trabajofinal.models.*;

public class App {

   public static void main(String[] args) {

      // inicializarDatos();

      BusquedaCliente busquedaCliente = new BusquedaCliente();
      busquedaCliente.setVisible(true);

   }

   private static void cargarEntidades() {

      Usuario usuario1 = new Usuario(TipoRol.GERENTE, "Santiago", "root");

      Pais pais = new Pais("Argentina");

      Provincia p1 = new Provincia("Santa Fe", pais);
      Provincia p2 = new Provincia("Cordoba", pais);

      Localidad l1 = new Localidad("Rosario", null, p1);
      Localidad l2 = new Localidad("Santa Fe", null, p1);
      Localidad l3 = new Localidad("San Francisco", null, p2);
      Localidad l4 = new Localidad("Cosquin", null, p2);

      Cliente cliente1 = new Cliente(
            "00-43426530",
            "43426530",
            TipoDocumento.DNI,
            "Jeronimo",
            "Margitic",
            null,
            true,
            2020,
            "estudiante",
            "11-43426530-3",
            "jero.margitic@gmail.com",
            TipoCondicionIVA.RESPONSABLE_INSCRIPTO,
            LocalDate.of(2023, 12, 31),
            EstadoCivil.SOLTERO,
            'm',
            new Domicilio("3000", 300, "Dorrego", false, 0, "", l1),
            LocalDate.of(2020, 6, 1));
      Cliente cliente2 = new Cliente(
            "00-43685258",
            "43685258",
            TipoDocumento.DNI,
            "Mateo",
            "Weber",
            null,
            true,
            2020,
            "ingeniero",
            "11-43685258-3",
            "mateo.weber@gmail.com",
            TipoCondicionIVA.MONOTRIBUTISTA,
            LocalDate.of(2023, 12, 31),
            EstadoCivil.CASADO,
            'm',
            new Domicilio("4000", 200, "San martin", true, 4, "c", l1),
            LocalDate.of(2021, 8, 1));
      Cliente cliente3 = new Cliente(
            "00-24876678",
            "24876678",
            TipoDocumento.DNI,
            "Diego",
            "Danelone",
            null,
            true,
            2020,
            "abogado",
            "20-24876678-7",
            "diego.danelone@gmail.com",
            TipoCondicionIVA.EXENTO,
            LocalDate.of(2023, 12, 31),
            EstadoCivil.DIVORCIADO,
            'm',
            new Domicilio("3000", 2134, "Luciano Torrent", false, 0, "", l1),
            LocalDate.of(2019, 12, 30));
      Cliente cliente4 = new Cliente(
            "00-41654296",
            "41654296",
            TipoDocumento.DNI,
            "Franco",
            "Cosolito",
            null,
            true,
            2020,
            "presidente",
            "17-41654296-6",
            "franco.cosolito@gmail.com",
            TipoCondicionIVA.CONSUMIDOR_FINAL,
            LocalDate.of(2023, 12, 31),
            EstadoCivil.SOLTERO,
            'm',
            new Domicilio("3000", 1423, "San Luis", false, 0, "", l1),
            LocalDate.of(2022, 4, 12));

      SiniestrosConductor s1 = new SiniestrosConductor(cliente1, 0);
      SiniestrosConductor s2 = new SiniestrosConductor(cliente2, 1);
      SiniestrosConductor s3 = new SiniestrosConductor(cliente3, 2);
      SiniestrosConductor s4 = new SiniestrosConductor(cliente4, 5);

      Marca marca1 = new Marca("Ford");
      Marca marca2 = new Marca("Fiat");

      FactoresModelo fm1 = new FactoresModelo(LocalDate.of(2019, 12, 30), null, 0.4, null, usuario1);
      FactoresModelo fm2 = new FactoresModelo(LocalDate.of(2023, 5, 3), null, 0.6, null, usuario1);

      Modelo m1 = new Modelo("Falcon", fm1, marca1);
      Modelo m2 = new Modelo("Palio", fm2, marca2);

      TipoVehiculo t1 = new TipoVehiculo(10.0, 20.0, 450.0, 2001, m1, null);
      TipoVehiculo t2 = new TipoVehiculo(15.0, 20.0, 450.0, 2002, m1, null);
      TipoVehiculo t3 = new TipoVehiculo(15.0, 20.0, 450.0, 2015, m2, null);
      TipoVehiculo t4 = new TipoVehiculo(17.0, 20.0, 450.0, 2001, m2, null);

      FactoresVehiculo f1 = new FactoresVehiculo(LocalDate.of(2023, 12, 01), null, 300000.0, t1,
            usuario1);
      FactoresVehiculo f2 = new FactoresVehiculo(LocalDate.of(2023, 12, 01), null, 400000.0, t2,
            usuario1);
      FactoresVehiculo f3 = new FactoresVehiculo(LocalDate.of(2023, 12, 01), null, 500000.0, t3,
            usuario1);
      FactoresVehiculo f4 = new FactoresVehiculo(LocalDate.of(2023, 12, 01), null, 200000.0, t4,
            usuario1);

      TipoCobertura resp_civil = new TipoCobertura("Responsabilidad Civil");
      TipoCobertura resp_civil_robo = new TipoCobertura("Responsabilidad Civil mas robo total mas incendio total");
      TipoCobertura todo_total = new TipoCobertura("Todo Total");
      TipoCobertura terceros_comp = new TipoCobertura("Terceros Completos");
      TipoCobertura todo_riesgo_fran = new TipoCobertura("Todo Riesgo Franquicia");

      FactoresTipoCobertura fact_resp_civil = new FactoresTipoCobertura(LocalDate.of(2023, 11, 01), null, 0.2,
            resp_civil, usuario1);
      FactoresTipoCobertura fact_resp_civil_robo = new FactoresTipoCobertura(LocalDate.of(2023, 12, 02), null, 0.2,
            resp_civil_robo, usuario1);
      FactoresTipoCobertura fact_todo_total = new FactoresTipoCobertura(LocalDate.of(2023, 11, 01), null, 0.2,
            todo_total, usuario1);
      FactoresTipoCobertura fact_terceros_comp = new FactoresTipoCobertura(LocalDate.of(2023, 12, 02), null, 0.2,
            terceros_comp, usuario1);
      FactoresTipoCobertura fact_todo_riesgo_fran = new FactoresTipoCobertura(LocalDate.of(2023, 11, 01), null, 0.2,
            todo_riesgo_fran, usuario1);

      FactoresCaracteristicas factores1 = new FactoresCaracteristicas(
            0.02,
            0.01,
            0.01,
            0.3,
            0.1,
            0.2,
            0.3,
            0.4,
            0.05,
            0.08,
            10.00,
            10000.00,
            500.00,
            LocalDate.of(2023, 12, 31),
            null,
            3,
            usuario1);

      FactorRiesgoLocalidad factor_riesgo1 = new FactorRiesgoLocalidad(
            LocalDate.of(2023, 12, 31),
            null,
            0.5,
            usuario1,
            l1);
      FactorRiesgoLocalidad factor_riesgo2 = new FactorRiesgoLocalidad(
            LocalDate.of(2023, 12, 31),
            null,
            0.34,
            usuario1,
            l2);
      FactorRiesgoLocalidad factor_riesgo3 = new FactorRiesgoLocalidad(
            LocalDate.of(2023, 12, 31),
            null,
            0.78,
            usuario1,
            l3);
      FactorRiesgoLocalidad factor_riesgo4 = new FactorRiesgoLocalidad(
            LocalDate.of(2023, 12, 31),
            null,
            0.4,
            usuario1,
            l4);

      LimiteDeBusqueda limiteDeBusqueda = new LimiteDeBusqueda(5);

      try {

         UsuarioDao dao_usuario = new UsuarioDao();
         dao_usuario.save(usuario1);

         PaisDao dao_pais = new PaisDao();
         ProvinciaDao dao_provincia = new ProvinciaDao();
         LocalidadDao dao_localidad = new LocalidadDao();
         dao_pais.save(pais);
         dao_provincia.save(p1);
         dao_provincia.save(p2);
         dao_localidad.save(l1);
         dao_localidad.save(l2);
         dao_localidad.save(l3);
         dao_localidad.save(l4);

         ClienteDao dao_cliente = new ClienteDao();
         dao_cliente.save(cliente1);
         dao_cliente.save(cliente2);
         dao_cliente.save(cliente3);
         dao_cliente.save(cliente4);

         SiniestrosConductorDao dao_siniestros = new SiniestrosConductorDao();
         dao_siniestros.save(s1);
         dao_siniestros.save(s2);
         dao_siniestros.save(s3);
         dao_siniestros.save(s4);

         MarcaDao dao_marca = new MarcaDao();
         ModeloDao dao_modelo = new ModeloDao();
         TipoVehiculoDao dao_tipo = new TipoVehiculoDao();
         FactoresVehiculoDao dao_factores = new FactoresVehiculoDao();
         FactoresModeloDao dao_factores_m = new FactoresModeloDao();
         dao_factores_m.save(fm1);
         dao_factores_m.save(fm2);
         dao_marca.save(marca1);
         dao_marca.save(marca2);
         dao_modelo.save(m1);
         dao_modelo.save(m2);
         dao_tipo.save(t1);
         dao_tipo.save(t2);
         dao_tipo.save(t3);
         dao_tipo.save(t4);
         dao_factores.save(f1);
         dao_factores.save(f2);
         dao_factores.save(f3);
         dao_factores.save(f4);
         // actualizar el tipo con el factor recien guardado para que quede consistente
         t1.setFactores_actuales(f1);
         t2.setFactores_actuales(f2);
         t3.setFactores_actuales(f3);
         t4.setFactores_actuales(f4);
         dao_tipo.update(t1);
         dao_tipo.update(t2);
         dao_tipo.update(t3);
         dao_tipo.update(t4);
         fm1.setModelo(m1);
         fm2.setModelo(m2);
         dao_factores_m.update(fm1);
         dao_factores_m.update(fm2);

         TipoCoberturaDao dao_cobertura = new TipoCoberturaDao();
         dao_cobertura.save(resp_civil);
         dao_cobertura.save(resp_civil_robo);
         dao_cobertura.save(todo_total);
         dao_cobertura.save(terceros_comp);
         dao_cobertura.save(todo_riesgo_fran);

         FactoresTipoCoberturaDao dao_factores_t_c = new FactoresTipoCoberturaDao();
         dao_factores_t_c.save(fact_resp_civil);
         dao_factores_t_c.save(fact_resp_civil_robo);
         dao_factores_t_c.save(fact_todo_total);
         dao_factores_t_c.save(fact_terceros_comp);
         dao_factores_t_c.save(fact_todo_riesgo_fran);

         FactoresCaracteristicasDao dao_factores_c = new FactoresCaracteristicasDao();
         dao_factores_c.save(factores1);

         FactorRiesgoLocalidadDao dao_factores_l = new FactorRiesgoLocalidadDao();
         dao_factores_l.save(factor_riesgo1);
         dao_factores_l.save(factor_riesgo2);
         dao_factores_l.save(factor_riesgo3);
         dao_factores_l.save(factor_riesgo4);
         // actualizar el factor de localidad con el factor recien creado para que quede
         // consistente
         l1.setRiesgo_localidad(factor_riesgo1);
         l2.setRiesgo_localidad(factor_riesgo2);
         l3.setRiesgo_localidad(factor_riesgo3);
         l4.setRiesgo_localidad(factor_riesgo4);
         dao_localidad.update(l1);
         dao_localidad.update(l2);
         dao_localidad.update(l3);
         dao_localidad.update(l4);

         LimiteDao dao_LimiteDao = new LimiteDao();
         dao_LimiteDao.save(limiteDeBusqueda);

      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }

   }

   private static void inicializarDatos() {

      // este codigo lo que hace es verificar si hay entidades cargadas en la BD.
      // si la cuenta de entidades (de cliente por ahora) es cero, carga todos los
      // datos.

      EntityManager entityManager = EntityManagerUtil.getEntityManager();
      long entityCount = (long) entityManager.createQuery("SELECT COUNT(c) FROM Cliente c").getSingleResult();

      if (entityCount == 0) {
         cargarEntidades();
      }
   }
}
