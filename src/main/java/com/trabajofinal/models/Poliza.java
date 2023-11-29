package com.trabajofinal.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "poliza")
public class Poliza {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poliza")
    private int id;
	
	@Column(name = "nro_poliza")
    private String numero_poliza;
	
	@Column(name = "premio")
    private Double premio;
	
	@Column(name = "fecha_inicio_vigencia")
    private Date fecha_inicio_vigencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pago")
    private TipoPago forma_pago;
	
	@Column(name = "descuentos")
    private Double descuentos;
	
	@Column(name = "total_a_pagar")
    private Double total_a_pagar;
	
	@Column(name = "derechos_emision")
	private Double derechos_emision;
	
	@Column(name = "cantidad_siniestros")
    private int cantidad_siniestros;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
    private TipoEstadoPoliza estado;
	
	@OneToOne
	@JoinColumn(name = "id_poliza_propuesta")
    private Poliza poliza_propuesta;
	
    @OneToOne
	@JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo_asegurado;
		
    @OneToMany
    @JoinColumn(name = "id_poliza")
    private HashSet<Hijo> hijos;
		
    @OneToMany
    @JoinColumn(name = "id_poliza")
    private List<ModificacionPoliza> modificaciones;
		
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factores_cobertura")	
    private FactoresTipoCobertura factores_cobertura_poliza;
		
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factor")
    private FactoresCaracteristicas factores_caracteristicas;
		
    @OneToMany
    @JoinColumn(name = "id_poliza")
    private List<Cuota> cuotas;
		
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factores_vehiculo")	
    private FactoresVehiculo factores_vehiculo;
		
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factores_modelo")
    private FactoresModelo factores_modelo;
		
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
		
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;
		
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_riesgo_loc")
    private FactorRiesgoLocalidad factor_riesgo_localidad;

    public Poliza() {
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Localidad getLocalidad() {
        return localidad;
    }
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    public FactorRiesgoLocalidad getFactor_riesgo_localidad() {
        return factor_riesgo_localidad;
    }
    public void setFactor_riesgo_localidad(FactorRiesgoLocalidad factor_riesgo_localidad) {
        this.factor_riesgo_localidad = factor_riesgo_localidad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public TipoPago getForma_pago() {
        return forma_pago;
    }
    public void setForma_pago(TipoPago forma_pago) {
        this.forma_pago = forma_pago;
    }
    public Double getDescuentos() {
        return descuentos;
    }
    public void setDescuentos(Double descuentos) {
        this.descuentos = descuentos;
    }
    public Double getTotal_a_pagar() {
        return total_a_pagar;
    }
    public void setTotal_a_pagar(Double total_a_pagar) {
        this.total_a_pagar = total_a_pagar;
    }
    public int getCantidad_siniestros() {
        return cantidad_siniestros;
    }
    public void setCantidad_siniestros(int cantidad_siniestros) {
        this.cantidad_siniestros = cantidad_siniestros;
    }
    public TipoEstadoPoliza getEstado() {
        return estado;
    }
    public void setEstado(TipoEstadoPoliza estado) {
        this.estado = estado;
    }
    public Poliza getPoliza_propuesta() {
        return poliza_propuesta;
    }
    public void setPoliza_propuesta(Poliza poliza_propuesta) {
        this.poliza_propuesta = poliza_propuesta;
    }
    public Vehiculo getVehiculo_asegurado() {
        return vehiculo_asegurado;
    }
    public void setVehiculo_asegurado(Vehiculo vehiculo_asegurado) {
        this.vehiculo_asegurado = vehiculo_asegurado;
    }
    public HashSet<Hijo> getHijos() {
        return hijos;
    }
    public void setHijos(HashSet<Hijo> hijos) {
        this.hijos = hijos;
    }
    public List<ModificacionPoliza> getModificaciones() {
        return modificaciones;
    }
    public void setModificaciones(List<ModificacionPoliza> modificaciones) {
        this.modificaciones = modificaciones;
    }
    public FactoresTipoCobertura getCobertura_poliza() {
        return factores_cobertura_poliza;
    }
    public void setCobertura_poliza(FactoresTipoCobertura cobertura_poliza) {
        this.factores_cobertura_poliza = cobertura_poliza;
    }
    public FactoresCaracteristicas getFactores_generacion() {
        return factores_caracteristicas;
    }
    public void setFactores_generacion(FactoresCaracteristicas factores_generacion) {
        this.factores_caracteristicas = factores_generacion;
    }
    public List<Cuota> getCuotas() {
        return cuotas;
    }
    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }
    public FactoresVehiculo getFactores_vehiculo() {
        return factores_vehiculo;
    }
    public void setFactores_vehiculo(FactoresVehiculo factores_vehiculo) {
        this.factores_vehiculo = factores_vehiculo;
    }
    public FactoresModelo getFactores_modelo() {
        return factores_modelo;
    }
    public void setFactores_modelo(FactoresModelo factores_modelo) {
        this.factores_modelo = factores_modelo;
    }
    public String getNumero_poliza() {
        return numero_poliza;
    }
    public void setNumero_poliza(String numero_poliza) {
        this.numero_poliza = numero_poliza;
    }
    public Double getPremio() {
        return premio;
    }
    public void setPremio(Double premio) {
        this.premio = premio;
    }
    public Date getFecha_inicio_vigencia() {
        return fecha_inicio_vigencia;
    }
    public void setFecha_inicio_vigencia(Date fecha_inicio_vigencia) {
        this.fecha_inicio_vigencia = fecha_inicio_vigencia;
    }

	public void setDerechosEmision(Double derechos_emision) {
		this.derechos_emision = derechos_emision;
	}

	public boolean hayCuotaImpaga() {
		
		boolean retorno = false;
		for(Cuota c: cuotas) {
			if( c.getPago() == null && c.getFecha_vencimiento().isAfter(LocalDate.now())) {
				retorno = true;
			}
		}
		return retorno;
	}
}
