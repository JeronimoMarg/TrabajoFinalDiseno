package com.trabajofinal.main;

import com.trabajofinal.gui.BusquedaCliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.trabajofinal.dao.ClienteDao;
import com.trabajofinal.dao.FactoresCaracteristicasDao;
import com.trabajofinal.dao.FactoresVehiculoDao;
import com.trabajofinal.dao.LocalidadDao;
import com.trabajofinal.dao.MarcaDao;
import com.trabajofinal.dao.ModeloDao;
import com.trabajofinal.dao.PaisDao;
import com.trabajofinal.dao.ProvinciaDao;
import com.trabajofinal.dao.TipoCoberturaDao;
import com.trabajofinal.dao.TipoVehiculoDao;
import com.trabajofinal.dao.UsuarioDao;
import com.trabajofinal.gui.BusquedaCliente;
import com.trabajofinal.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import com.trabajofinal.models.*;

public class App {

   public static void main(String[] args) {

      // Ejecutar primero para armar la base de datos
      /*
       * cargarClientes();
       * cargarAutos();
       * cargarCoberturas();
       * cargarProvincias();
       * cargarUsuario();
       */

      BusquedaCliente busquedaCliente = new BusquedaCliente();
      busquedaCliente.setVisible(true);

   }

   private static void cargarProvincias() {
      Pais pais = new Pais("Argentina");
      Provincia p1 = new Provincia("Santa Fe", pais);
      Provincia p2 = new Provincia("Cordoba", pais);
      Localidad l1 = new Localidad("Rosario", null, p1);
      Localidad l2 = new Localidad("Santa Fe", null, p1);
      Localidad l3 = new Localidad("San Francisco", null, p2);
      Localidad l4 = new Localidad("Cosquin", null, p2);
      try {
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

      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }

   }

   private static void cargarAutos() {
      Marca marca1 = new Marca("Ford");
      Marca marca2 = new Marca("Fiat");
      Modelo m1 = new Modelo("Falcon", new FactoresModelo(), marca1);
      Modelo m2 = new Modelo("Palio", new FactoresModelo(), marca2);
      TipoVehiculo t1 = new TipoVehiculo(10.0, 20.0, 450.0, 2001, m1, new FactoresVehiculo());
      TipoVehiculo t2 = new TipoVehiculo(15.0, 20.0, 450.0, 2002, m1, new FactoresVehiculo());
      TipoVehiculo t3 = new TipoVehiculo(15.0, 20.0, 450.0, 2003, m2, new FactoresVehiculo());
      TipoVehiculo t4 = new TipoVehiculo(17.0, 20.0, 450.0, 2001, m2, new FactoresVehiculo());
      FactoresVehiculo f1 = new FactoresVehiculo(LocalDate.of(2023, 12, 01), LocalDate.of(2023, 12, 03), 300000.0, t1,
            new Usuario());
      FactoresVehiculo f2 = new FactoresVehiculo(LocalDate.of(2023, 12, 01), LocalDate.of(2023, 12, 03), 400000.0, t2,
            new Usuario());
      FactoresVehiculo f3 = new FactoresVehiculo(LocalDate.of(2023, 12, 01), LocalDate.of(2023, 12, 03), 500000.0, t3,
            new Usuario());
      FactoresVehiculo f4 = new FactoresVehiculo(LocalDate.of(2023, 12, 01), LocalDate.of(2023, 12, 03), 200000.0, t4,
            new Usuario());
      t1.setFactores_actuales(f1);
      t2.setFactores_actuales(f2);
      t3.setFactores_actuales(f3);
      t4.setFactores_actuales(f4);
      try {
         MarcaDao dao_marca = new MarcaDao();
         ModeloDao dao_modelo = new ModeloDao();
         TipoVehiculoDao dao_tipo = new TipoVehiculoDao();
         FactoresVehiculoDao dao_factores = new FactoresVehiculoDao();
         dao_factores.save(f1);
         dao_factores.save(f2);
         dao_factores.save(f3);
         dao_factores.save(f4);
         dao_marca.save(marca1);
         dao_marca.save(marca2);
         dao_modelo.save(m1);
         dao_modelo.save(m2);
         dao_tipo.save(t1);
         dao_tipo.save(t2);
         dao_tipo.save(t3);
         dao_tipo.save(t4);

      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }

   }

   private static void cargarCoberturas() {
      TipoCobertura resp_civil = new TipoCobertura("Responsabilidad Civil");
      TipoCobertura resp_civil_robo = new TipoCobertura("Responsabilidad Civil mas robo total mas incendio total");
      TipoCobertura todo_total = new TipoCobertura("Todo Total");
      TipoCobertura terceros_comp = new TipoCobertura("Terceros Completos");
      TipoCobertura todo_riesgo_fran = new TipoCobertura("Todo Riesgo Franquicia");
      try {
         TipoCoberturaDao dao = new TipoCoberturaDao();
         dao.save(resp_civil);
         dao.save(resp_civil_robo);
         dao.save(todo_total);
         dao.save(terceros_comp);
         dao.save(todo_riesgo_fran);

      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }
   }

   private static void cargarUsuario() {

      Usuario ejemplo1 = new Usuario(TipoRol.COBRADOR, "Santiago", "root");
      try {
         UsuarioDao dao = new UsuarioDao();
         dao.save(ejemplo1);

      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }

   }

   private static void cargarClientes() {

      Cliente ejemplo1 = new Cliente(
            "00-43426530",
            "43426530",
            TipoDocumento.DNI,
            "Jeronimo",
            "Margitic",
            TipoCondicion.NORMAL,
            true,
            2020,
            "estudiante",
            "11-43426530-3",
            "jero.margitic@gmail.com",
            TipoCondicionIVA.RESPONSABLE_INSCRIPTO,
            LocalDate.of(2023, 12, 31),
            EstadoCivil.SOLTERO,
            'm',
            new Domicilio("3000", 300, "Dorrego", false, 0, "", new Localidad()));
      Cliente ejemplo2 = new Cliente(
            "00-43685258",
            "43685258",
            TipoDocumento.DNI,
            "Mateo",
            "Weber",
            TipoCondicion.NORMAL,
            true,
            2020,
            "ingeniero",
            "11-43685258-3",
            "mateo.weber@gmail.com",
            TipoCondicionIVA.MONOTRIBUTISTA,
            LocalDate.of(2023, 12, 31),
            EstadoCivil.CASADO,
            'm',
            new Domicilio("4000", 200, "San martin", true, 4, "c", new Localidad()));
      Cliente ejemplo3 = new Cliente(
            "00-24876678",
            "24876678",
            TipoDocumento.DNI,
            "Diego",
            "Danelone",
            TipoCondicion.NORMAL,
            true,
            2020,
            "abogado",
            "20-24876678-7",
            "diego.danelone@gmail.com",
            TipoCondicionIVA.EXENTO,
            LocalDate.of(2023, 12, 31),
            EstadoCivil.DIVORCIADO,
            'm',
            new Domicilio("3000", 2134, "Luciano Torrent", false, 0, "", new Localidad()));
      Cliente ejemplo4 = new Cliente(
            "00-41654296",
            "41654296",
            TipoDocumento.DNI,
            "Franco",
            "Cosolito",
            TipoCondicion.PLATA,
            true,
            2020,
            "presidente",
            "17-41654296-6",
            "franco.cosolito@gmail.com",
            TipoCondicionIVA.CONSUMIDOR_FINAL,
            LocalDate.of(2023, 12, 31),
            EstadoCivil.SOLTERO,
            'm',
            new Domicilio("3000", 1423, "San Luis", false, 0, "", new Localidad()));
      try {
         ClienteDao dao = new ClienteDao();
         dao.save(ejemplo1);
         dao.save(ejemplo2);
         dao.save(ejemplo3);
         dao.save(ejemplo4);

      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }

   }

   private static FactoresCaracteristicas crearFactoresCaracteristicas() {

      FactoresCaracteristicas ejemplo1 = new FactoresCaracteristicas(
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
            2,
            new Usuario());

      System.out.print(ejemplo1.toString());
      return ejemplo1;

   }

   private static FactorRiesgoLocalidad crearFactorRiesgoLocalidad() {
      FactorRiesgoLocalidad factor_riesgo = new FactorRiesgoLocalidad(
            LocalDate.of(2023, 12, 31),
            LocalDate.of(2024, 01, 31),
            0.5,
            new Usuario(),
            new Localidad());
      return factor_riesgo;
   }

   private static void guardarFactoresCaracteristicas(FactoresCaracteristicas factores) {

      try {
         FactoresCaracteristicasDao dao = new FactoresCaracteristicasDao();
         dao.save(factores);

      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }

   }

   private static void mostrarClientes() {

      ClienteDao dao = new ClienteDao();
      List<Cliente> clientes = dao.getAll();
      System.out.println(clientes);

   }

   private static void mostrarPorId(int id) {

      ClienteDao dao = new ClienteDao();
      Cliente cliente = dao.getById(id);
      System.out.println(cliente);

   }

}
