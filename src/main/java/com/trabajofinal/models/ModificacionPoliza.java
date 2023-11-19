package com.trabajofinal.models;

import java.time.LocalDate;
import java.util.HashSet;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
public class ModificacionPoliza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_modificacion_poliza")
    private int id;
	
	@Column(name = "fecha_inicio_vigencia")
    private LocalDate fecha_inicio_vigencia;
	
	@Column(name = "fecha_fin_vigencia")
    private LocalDate fecha_fin_vigencia;
	
	@Column(name = "cantidad_siniestros")
    private int cantidad_siniestros;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_poliza")	
    private Poliza poliza;
    
    @OneToMany
    @JoinColumn(name = "id_hijo")
    private HashSet<ModificacionHijo> modificaciones_hijo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cobertura")	
    private TipoCobertura cobertura;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getFecha_inicio_vigencia() {
        return fecha_inicio_vigencia;
    }
    public void setFecha_inicio_vigencia(LocalDate fecha_inicio_vigencia) {
        this.fecha_inicio_vigencia = fecha_inicio_vigencia;
    }
    public LocalDate getFecha_fin_vigencia() {
        return fecha_fin_vigencia;
    }
    public void setFecha_fin_vigencia(LocalDate fecha_fin_vigencia) {
        this.fecha_fin_vigencia = fecha_fin_vigencia;
    }
    public int getCantidad_siniestros() {
        return cantidad_siniestros;
    }
    public void setCantidad_siniestros(int cantidad_siniestros) {
        this.cantidad_siniestros = cantidad_siniestros;
    }
    public Poliza getPoliza() {
        return poliza;
    }
    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }
    public HashSet<ModificacionHijo> getModificaciones_hijo() {
        return modificaciones_hijo;
    }
    public void setModificaciones_hijo(HashSet<ModificacionHijo> modificaciones_hijo) {
        this.modificaciones_hijo = modificaciones_hijo;
    }
    public TipoCobertura getCovertura() {
        return cobertura;
    }
    public void setCovertura(TipoCobertura covertura) {
        this.cobertura = covertura;
    }

}
