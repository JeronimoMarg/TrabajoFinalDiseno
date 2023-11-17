package com.trabajofinal.models;

public class ModificacionHijo {

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
