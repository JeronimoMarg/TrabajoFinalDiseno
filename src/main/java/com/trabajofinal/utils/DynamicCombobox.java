package com.trabajofinal.utils;

public class DynamicCombobox {
     private int id;
    private String nombre;

  
    public DynamicCombobox(int id, String name) {
        this.id = id;
        this.nombre = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }
    
    @Override
    public String toString(){
        return this.getNombre();
    }
}
