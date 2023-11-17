package com.trabajofinal.models;

public class Usuario {

    private int id;
    private TipoRol rol;
    private String nombre;
    private String contrasena;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public TipoRol getRol() {
        return rol;
    }
    public void setRol(TipoRol rol) {
        this.rol = rol;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
