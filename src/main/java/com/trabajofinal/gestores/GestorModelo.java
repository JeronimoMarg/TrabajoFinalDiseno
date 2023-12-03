package com.trabajofinal.gestores;

import com.trabajofinal.dao.ModeloDao;
import com.trabajofinal.models.Modelo;
import java.util.List;

public class GestorModelo {

    private static GestorModelo instance;

    private GestorModelo() {

    }

    public static GestorModelo getInstance() {
        if (instance == null) {
            instance = new GestorModelo();
        }
        return instance;
    }

    public List<Modelo> obtenerModelosPorMarca(int id_marca) {
        ModeloDao modeloDao = new ModeloDao();
        return modeloDao.getModelosMarca(id_marca);
    }

}
