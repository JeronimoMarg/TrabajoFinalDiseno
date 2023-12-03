package com.trabajofinal.gestores;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.models.*;
import com.trabajofinal.utils.EntityManagerUtil;
import com.trabajofinal.dao.PolizaDao;
import com.trabajofinal.dao.ClienteDao;
import com.trabajofinal.dao.VehiculoDao;

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

      if (validarLogica(vehiculo.getPatente())) {

         Poliza polizaNueva = new Poliza();
         polizaNueva.setFecha_inicio_vigencia(poliza.getFechaInicioVigencia());
         polizaNueva.setForma_pago(poliza.getTipoPago());
         polizaNueva.setCobertura_poliza(obtenerFactoresTipoCobertura(poliza.getTipoCobertura()));
         polizaNueva.setFactores_generacion(obtenerFactoresCaracteristicas());
         polizaNueva.setDescuentos(sumarDescuentos(poliza));
         polizaNueva.setDerechosEmision(poliza.getDerechos_emision().doubleValue());
         polizaNueva.setPremio(poliza.getPremio().doubleValue());
         polizaNueva.setTotal_a_pagar(poliza.getMonto_a_pagar());
         polizaNueva.setCantidad_siniestros(cliente.getCantidadSiniestros());
         polizaNueva.setEstado(TipoEstadoPoliza.GENERADA);
         polizaNueva.setCliente(obtenerCliente(cliente));
         setearHijos(hijos, polizaNueva);
         polizaNueva.setLocalidad(obtenerLocalidad(poliza.getId_localidad()));
         polizaNueva.setFactor_riesgo_localidad(obtenerFactorRiesgoLocalidad(poliza.getId_localidad()));         
         polizaNueva.setFactores_vehiculo(obtenerFactoresVehiculo(vehiculo.getId_tipo_vehiculo()));
         polizaNueva.setFactores_modelo(obtenerFactoresModelo(vehiculo.getId_modelo()));
         polizaNueva.setVehiculo_asegurado(obtenerVehiculo(vehiculo));
         setearCuotas(poliza, polizaNueva);
         generarNumeroPoliza(polizaNueva);
         guardar(polizaNueva);
         GestorClientes.getInstance().actualizarEstadoCliente(poliza, polizaNueva.getCliente());

      }
   }

   private boolean validarLogica(String patente) {

      //verificar que no exista una poliza vigente ya asociada a un vehiculo determinado.
      return !GestorVehiculos.getInstance().existeVehiculoAsegurado(patente);

   }

   private Double sumarDescuentos(PolizaDTO poliza) {
      return poliza.getDto_pago_semestral() + poliza.getDto_antiguedad() + poliza.getDto_mas_un_vehiculo();
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
	   
	   if (hijos.size() == 0) {
		   List<Hijo> listanula = new ArrayList<>();
	   }else {
		      for (int i = 0; i < hijos.size(); i++) {
		          HijoDTO actual = hijos.get(i);
		          Hijo nuevo = new Hijo(actual.getFecha_nacimiento(), actual.getSexo(), actual.getEstado_civil());
		          polizaNueva.getHijos().add(nuevo);
		       }
	   }

   }

   private void setearCuotas(PolizaDTO poliza, Poliza polizaNueva) {

      polizaNueva.setCuotas(poliza.getCuotas());

   }

   private Localidad obtenerLocalidad(int id_localidad) {

      GestorLocalidad gestor = GestorLocalidad.getInstance();
      Localidad localidad = gestor.obtenerLocalidad(id_localidad);
      return localidad;

   }

   private FactorRiesgoLocalidad obtenerFactorRiesgoLocalidad(int id_localidad) {

      GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
      FactorRiesgoLocalidad factoresLocalidad = gestor.obtenerFactoresLocalidad(id_localidad);
      return factoresLocalidad;

   }

   private FactoresVehiculo obtenerFactoresVehiculo(int id_tipo_vehiculo) {

      GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
      FactoresVehiculo factoresVehiculo = gestor.obtenerFactoresVehiculo(id_tipo_vehiculo);
      return factoresVehiculo;

   }

   private FactoresModelo obtenerFactoresModelo(int id_modelo) {

      GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
      FactoresModelo factoresModelo = gestor.obtenerFactoresModelo(id_modelo);
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
      System.out.println("Polizas: " + polizaDao.getAll());

   }

   public List<Cuota> crearCuotas(PolizaDTO poliza) {
      List<Cuota> cuotas = new ArrayList<Cuota>();
      Date vigencia = poliza.getFechaInicioVigencia();
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
   
   public List<Poliza> obtenerCantidadPolizas(int id_cliente) {

	      PolizaDao dao = new PolizaDao();
	      return dao.getAsociadasCliente(id_cliente);

   }
   
   public void generarNumeroPoliza(Poliza polizaNueva) {
	   
	   String numeroPoliza = getNumeroSucursal() + "-"
			   + getNumeroAsociacion(polizaNueva.getCliente().getId()) + "-"
			   + getNumeroRenovacion();
	   
	   polizaNueva.setNumero_poliza(numeroPoliza);
	   
   }
   
   public String getNumeroAsociacion(int id_cliente) {
	   
	   int retorno = 1000 * id_cliente + getLastIdVehiculo() + 1;
	   String aux = String.format("%07d", retorno);
	   
	   return aux;
	   
   }
   
   public String getNumeroSucursal() {
	   return "0000";
   }
   
   public String getNumeroRenovacion() {
	   return "00";
   }

   public int getLastIdVehiculo() {
	   
	   VehiculoDao dao = new VehiculoDao();
	   return dao.getUltimoId();
	   
   }
  
   
}
