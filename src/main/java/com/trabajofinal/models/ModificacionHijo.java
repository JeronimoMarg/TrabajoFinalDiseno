package com.trabajofinal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ModificacionHijo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehiculo")
    private int id;
    private Hijo hijo;
    private Boolean eliminar_hijo;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Hijo getHijo() {
        return hijo;
    }
    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }
    public Boolean getEliminar_hijo() {
        return eliminar_hijo;
    }
    public void setEliminar_hijo(Boolean eliminar_hijo) {
        this.eliminar_hijo = eliminar_hijo;
    }

}
