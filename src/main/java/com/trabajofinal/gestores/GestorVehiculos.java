package com.trabajofinal.gestores;

import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.models.Poliza;
import com.trabajofinal.models.TipoEstadoPoliza;
import com.trabajofinal.models.TipoVehiculo;
import com.trabajofinal.models.Vehiculo;

import java.util.List;

import com.trabajofinal.dao.TipoVehiculoDao;
import com.trabajofinal.dao.VehiculoDao;

public class GestorVehiculos {

   private static GestorVehiculos instance;

   private GestorVehiculos() {

   }

   public static GestorVehiculos getInstance() {
      if (instance == null) {
         instance = new GestorVehiculos();
      }
      return instance;
   }

   public Vehiculo crearVehiculo(VehiculoDTO vehiculo) {

      Vehiculo v = new Vehiculo();
      v.setChasis(vehiculo.getChasis());
      v.setCon_alarma(vehiculo.getCon_alarma());
      v.setCon_rastreo(vehiculo.getCon_rastreo());
      v.setCon_tuerca_antirrobo(vehiculo.getCon_tuerca_antirrobo());
      v.setEn_garage(vehiculo.getEn_garage());
      v.setKilometros_anio(vehiculo.getKilometros_anio());
      v.setMotor(vehiculo.getMotor());
      v.setPatente(vehiculo.getPatente());
      v.setTipo_vehiculo(obtenerTipoVehiculo(vehiculo.getId_tipo_vehiculo()));

      return v;
   }

   private TipoVehiculo obtenerTipoVehiculo(int id_tipo_vehiculo) {

      TipoVehiculoDao dao = new TipoVehiculoDao();
      return dao.getById(id_tipo_vehiculo);
   }

   public boolean existeVehiculoAsegurado(String patente) {

      boolean retorno = false;

      VehiculoDao dao = new VehiculoDao();
      List<Poliza> polizas = dao.getByPatente(patente);

      if (polizas.stream().filter(p -> p.getEstado() == TipoEstadoPoliza.ACTIVA).findAny().orElse(null) != null) {
         retorno = true;
      }

      return retorno;
   }

   public TipoVehiculo obtenerTipoVehiculoPorId(int id_tipo_vehiculo) {
      TipoVehiculoDao tipoVehiculoDao = new TipoVehiculoDao();
      return tipoVehiculoDao.getById(id_tipo_vehiculo);
   }

   public List<TipoVehiculo> obtenerTiposVehiculoPorModelo(int id_modelo) {
      TipoVehiculoDao tipoVehiculoDao = new TipoVehiculoDao();
      return tipoVehiculoDao.getTipoVehiculoModelo(id_modelo);
   }

}
