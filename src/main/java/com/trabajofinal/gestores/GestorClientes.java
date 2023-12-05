package com.trabajofinal.gestores;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.trabajofinal.dao.ClienteDao;
import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.models.Cliente;
import com.trabajofinal.models.Poliza;
import com.trabajofinal.models.TipoCondicion;
import com.trabajofinal.models.TipoDocumento;
import com.trabajofinal.dao.SiniestrosConductorDao;
import java.util.ArrayList;

public class GestorClientes {

   private static GestorClientes instance;

   private GestorClientes() {

   }

   public static GestorClientes getInstance() {
      if (instance == null) {
         instance = new GestorClientes();
      }
      return instance;
   }

   public Cliente obtenerCliente(int id) {
      ClienteDao dao = new ClienteDao();
      return dao.getById(id);
   }

   public void actualizarEstadoCliente(PolizaDTO poliza, Cliente cliente) {

      ClienteDao daocliente = new ClienteDao();
      GestorPoliza gestorP = GestorPoliza.getInstance();
      List<Poliza> polizasAsociadas = gestorP.obtenerCantidadPolizas(cliente.getId());

      if (polizasAsociadas.size() == 0) {
         cliente.setCondicion(TipoCondicion.NORMAL);
      } else if (polizasAsociadas.size() != 0 && gestorP.sonNoVigentes(polizasAsociadas)) {
         cliente.setCondicion(TipoCondicion.NORMAL);
      } else {
         int cantidad_siniestros = GestorSistemaSiniestros.getInstance().obtenerSiniestros(cliente.getId());
         Period period = Period.between(cliente.getFecha_activacion(), LocalDate.now());
         if (cantidad_siniestros != 0 && gestorP.tieneCuotasImpagas(polizasAsociadas) && period.getYears() >= 2) {
            cliente.setCondicion(TipoCondicion.NORMAL);
         } else if (cantidad_siniestros != 0 && !gestorP.tieneCuotasImpagas(polizasAsociadas)
               && period.getYears() >= 2) {
            cliente.setCondicion(TipoCondicion.PLATA);
         }
      }

      daocliente.update(cliente); // lo guarda en la base de datos.

   }

   public List<ClienteDTO> buscarClientesDTO(String nombre, String apellido, String numeroDoc, TipoDocumento tipoDoc,
      String numeroCliente) {
      ClienteDao clienteDao = new ClienteDao();

      if (nombre != null && !nombre.isEmpty()) {
         clienteDao.getClientesPorNombre(nombre);
      }

      if (apellido != null && !apellido.isEmpty()) {
         clienteDao.getClientesPorApellido(apellido);
      }

      if (numeroDoc != null && !numeroDoc.isEmpty() && tipoDoc != null) {
         clienteDao.getClientesPorDocumento(numeroDoc, tipoDoc);
      }

      if (numeroCliente != null && !numeroCliente.isEmpty()) {
         clienteDao.getClientesPorNumero(numeroCliente);
      }    
      List<Cliente> clientes = new ArrayList<>();
      clientes = clienteDao.ejecutarQuery();
      List<ClienteDTO> clientesDTO = new ArrayList<>();
      for (Cliente c: clientes) {
          clientesDTO.add(aDTO(c));
      }
      return  clientesDTO;
   }
   
    private ClienteDTO aDTO(Cliente cliente) {

        ClienteDTO dto = new ClienteDTO();

        dto.setId(cliente.getId());
        dto.setNumero_cliente(cliente.getNumero_cliente());
        dto.setNumero_documento(cliente.getNumero_documento());
        dto.setTipo_documento(cliente.getTipo_documento());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setCondicion(cliente.getCondicion());
        dto.setActivo(cliente.getActivo());
        dto.setAnio_registro(cliente.getAnio_registro());
        dto.setProfesion(cliente.getProfesion());
        dto.setNumero_cuil(cliente.getNumero_cuil());
        dto.setEmail(cliente.getEmail());
        dto.setCondicion_iva(cliente.getCondicion_iva());
        dto.setFecha_nacimiento(cliente.getFecha_nacimiento());
        dto.setEstado_civil(cliente.getEstado_civil());
        dto.setSexo(cliente.getSexo());
        dto.setCalle(cliente.getDomicilio().getNombre_calle());
        dto.setCod_postal(cliente.getDomicilio().getCodigo_postal());
        dto.setNro(cliente.getDomicilio().getNumero_calle());
        dto.setPiso(cliente.getDomicilio().getPiso());
        dto.setDepartamento(cliente.getDomicilio().getDepartamento());
        dto.setLocalidad(cliente.getDomicilio().getLocalidad().getNombre());

        String prov = cliente.getDomicilio().getLocalidad().getProvincia().getNombre();
        String pais = cliente.getDomicilio().getLocalidad().getProvincia().getPais().getNombre();
        dto.setProvincia(prov);
        dto.setPais(pais);

        return dto;

    }
}
