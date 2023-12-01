package com.trabajofinal.gestores;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.models.*;
import com.trabajofinal.utils.EntityManagerUtil;
import com.trabajofinal.dao.PolizaDao;
import com.trabajofinal.dao.ClienteDao;

public class GestorPoliza {

   private static GestorPoliza instance;
   private HashSet<Poliza> polizas;

   private GestorPoliza() {

   }

   public static GestorPoliza getInstance() {
      if (instance == null) {
         instance = new GestorPoliza();
      }
      return instance;
   }

   public void crearPoliza(PolizaDTO poliza, List<HijoDTO> hijos, ClienteDTO cliente, VehiculoDTO vehiculo) {

      if (validarLogica()) {

         Poliza polizaNueva = new Poliza();
         polizaNueva.setFecha_inicio_vigencia(poliza.getFechaInicioVigencia());
         polizaNueva.setForma_pago(poliza.getTipoPago());
         polizaNueva.setCobertura_poliza(obtenerFactoresTipoCobertura(poliza.getTipoCobertura()));
         polizaNueva.setFactores_generacion(obtenerFactoresCaracteristicas());
         polizaNueva.setDescuentos(sumarDescuentos(poliza));
         polizaNueva.setDerechosEmision(poliza.getDerechos_emision().doubleValue());
         polizaNueva.setPremio(poliza.getPremio().doubleValue());
         polizaNueva.setCantidad_siniestros(cliente.getCantidadSiniestros());
         polizaNueva.setEstado(TipoEstadoPoliza.GENERADA);
         polizaNueva.setCliente(obtenerCliente(cliente));
         setearHijos(hijos, polizaNueva);
         polizaNueva.setLocalidad(obtenerLocalidad(poliza));
         polizaNueva.setFactor_riesgo_localidad(obtenerFactorRiesgoLocalidad(poliza));
         polizaNueva.setFactores_vehiculo(obtenerFactoresVehiculo(vehiculo));
         polizaNueva.setFactores_modelo(obtenerFactoresModelo(vehiculo));
         polizaNueva.setVehiculo_asegurado(obtenerVehiculo(vehiculo));
         actualizarEstadoCliente(cliente, poliza, polizaNueva.getCliente());

         setearCuotas(poliza, polizaNueva);
         guardar(polizaNueva);

      }
   }

   private boolean validarLogica() {

      boolean bool = true;

      // metodo de validarLogica para la poliza que va a ser creada
      return bool;
   }

   private Double sumarDescuentos(PolizaDTO poliza) {
      return poliza.getDto_pago_semestral() + poliza.getDto_antiguedad() + poliza.getDto_mas_un_vehiculo();
   }

   public void calcularPremioDerechosDescuentos(PolizaDTO poliza) {

      poliza.setDerechos_emision(1000.0);
      poliza.setPremio(5000.0);
      // poliza.setDescuentos(500.0);
      poliza.setDto_pago_semestral(100.0);
      poliza.setDto_antiguedad(50.90);
      poliza.setDto_mas_un_vehiculo(150.99);
      Double monto_a_pagar = poliza.getPremio() + poliza.getDerechos_emision() - poliza.getDto_antiguedad()
            - poliza.getDto_mas_un_vehiculo() - poliza.getDto_pago_semestral();
      poliza.setMonto_a_pagar(monto_a_pagar);

   }

   private FactoresTipoCobertura obtenerFactoresTipoCobertura(TipoCobertura tipo) {

      GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
      FactoresTipoCobertura factorCobertura = gestor.obtenerFactoresTipoCobertura(tipo);
      return factorCobertura;

   }

   private FactoresCaracteristicas obtenerFactoresCaracteristicas() {

      GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
      FactoresCaracteristicas factoresCaracteristicas = gestor.obtenerFactoresCaracteristicas();
      return factoresCaracteristicas;

   }

   private void setearHijos(List<HijoDTO> hijos, Poliza polizaNueva) {

      for (int i = 0; i < hijos.size(); i++) {
         HijoDTO actual = hijos.get(i);
         Hijo nuevo = new Hijo(actual.getFecha_nacimiento(), actual.getSexo(), actual.getEstado_civil());
         polizaNueva.getHijos().add(nuevo);
      }

   }

   private void setearCuotas(PolizaDTO poliza, Poliza polizaNueva) {

      polizaNueva.setCuotas(poliza.getCuotas());

   }

   private Localidad obtenerLocalidad(PolizaDTO poliza) {

      GestorLocalidad gestor = GestorLocalidad.getInstance();
      Localidad localidad = gestor.obtenerLocalidad(poliza.getLocalidad());
      return localidad;

   }

   private FactorRiesgoLocalidad obtenerFactorRiesgoLocalidad(PolizaDTO poliza) {

      GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
      FactorRiesgoLocalidad factoresLocalidad = gestor.obtenerFactoresLocalidad(poliza.getLocalidad());
      return factoresLocalidad;

   }

   private FactoresVehiculo obtenerFactoresVehiculo(VehiculoDTO vehiculo) {

      GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
      FactoresVehiculo factoresVehiculo = gestor.obtenerFactoresVehiculo(vehiculo.getModelo());
      return factoresVehiculo;

   }

   private FactoresModelo obtenerFactoresModelo(VehiculoDTO vehiculo) {

      GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
      FactoresModelo factoresModelo = gestor.obtenerFactoresModelo(vehiculo.getModelo());
      return factoresModelo;

   }

   private Vehiculo obtenerVehiculo(VehiculoDTO vehiculo) {

      GestorVehiculos gestor = GestorVehiculos.getInstance();
      Vehiculo v = gestor.crearVehiculo(vehiculo);
      return v;

   }

   private Cliente obtenerCliente(ClienteDTO cliente_dto) {

      GestorClientes gestor = GestorClientes.getInstance();
      Cliente cliente = gestor.obtenerCliente(cliente_dto.getId());
      return cliente;

   }

   private void actualizarEstadoCliente(ClienteDTO cliente_dto, PolizaDTO poliza, Cliente cliente) {

      ClienteDao daocliente = new ClienteDao();

      List<Poliza> polizasAsociadas = GestorPoliza.getInstance().obtenerCantidadPolizas(cliente_dto.getId());

      if (polizasAsociadas.size() == 0) {
         cliente.setCondicion(TipoCondicion.NORMAL);
      } else if (polizasAsociadas.size() != 0 && sonNoVigentes(polizasAsociadas)) {
         cliente.setCondicion(TipoCondicion.NORMAL);
      } else {
         int cantidad_siniestros = GestorClientes.getInstance().obtenerSiniestros(cliente_dto.getId());
         Period period = Period.between(cliente.getFecha_activacion(), LocalDate.now());
         if (cantidad_siniestros != 0 && tieneCuotasImpagas(polizasAsociadas) && period.getYears() >= 2) {
            cliente.setCondicion(TipoCondicion.NORMAL);
         } else if (cantidad_siniestros != 0 && !tieneCuotasImpagas(polizasAsociadas) && period.getYears() >= 2) {
            cliente.setCondicion(TipoCondicion.PLATA);
         }
      }

   }

   public List<Poliza> obtenerCantidadPolizas(int id_cliente) {

      PolizaDao dao = new PolizaDao();
      return dao.getAsociadasCliente(id_cliente);

   }

   public boolean sonNoVigentes(List<Poliza> polizas) {

      boolean retorno = true;
      for (Poliza p : polizas) {
         if (p.getEstado() != TipoEstadoPoliza.INACTIVA) {
            retorno = false;
         }
      }
      return retorno;

   }

   public boolean tieneCuotasImpagas(List<Poliza> polizas) {

      boolean retorno = false;
      for (Poliza p : polizas) {
         if (p.hayCuotaImpaga()) {
            retorno = true;
         }
      }
      return retorno;

   }

   private void guardar(Poliza poliza) {

      PolizaDao polizaDao = new PolizaDao();
      polizaDao.save(poliza);
      // System.out.println("Polizas: " + polizaDao.getAll());

   }

   public List<Cuota> crearCuotas(PolizaDTO poliza) {
      List<Cuota> cuotas = new ArrayList<Cuota>();
      Date vigencia = poliza.getFechaInicioVigencia();
      TipoPago tipoPago;
      LocalDate fechaVencimiento;

      fechaVencimiento = vigencia.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(1);

      if (poliza.getTipoPago() == TipoPago.MENSUAL) {
         for (int i = 0; i < 6; i++) {
            Cuota cuota = new Cuota();
            cuota.setMonto(poliza.getMonto_a_pagar() / 6.0);
            cuota.setFecha_vencimiento(fechaVencimiento);
            cuotas.add(cuota);
            fechaVencimiento = fechaVencimiento.plusMonths(1); // Siguiente mes para siguientes cuotas
         }
      } else {
         Cuota cuota = new Cuota();
         cuota.setMonto(poliza.getMonto_a_pagar());
         cuota.setFecha_vencimiento(fechaVencimiento);
         cuotas.add(cuota);
      }

      return cuotas;
   }

}
