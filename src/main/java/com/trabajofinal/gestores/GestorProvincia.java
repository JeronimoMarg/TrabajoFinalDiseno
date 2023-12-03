package com.trabajofinal.gestores;

import com.trabajofinal.dao.ProvinciaDao;
import com.trabajofinal.models.Provincia;
import java.util.List;

public class GestorProvincia {

    private static GestorProvincia instance;

    private GestorProvincia() {

    }

    public static GestorProvincia getInstance() {
        if (instance == null) {
            instance = new GestorProvincia();
        }
        return instance;
    }

    public List<Provincia> obtenerTodasLasProvincias() {
        ProvinciaDao provinciaDao = new ProvinciaDao();
        return provinciaDao.getAll(); // Suponiendo que tienes un método getAll en el ProvinciaDao para obtener todas las provincias.
    }

}
