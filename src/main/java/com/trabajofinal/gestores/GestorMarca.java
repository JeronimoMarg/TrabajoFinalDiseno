package com.trabajofinal.gestores;

import com.trabajofinal.dao.MarcaDao;
import com.trabajofinal.models.Marca;
import java.util.List;

public class GestorMarca {

    private static GestorMarca instance;

    private GestorMarca() {

    }

    public static GestorMarca getInstance() {
        if (instance == null) {
            instance = new GestorMarca();
        }
        return instance;
    }

    public List<Marca> obtenerTodasLasMarcas() {
        MarcaDao marcaDao = new MarcaDao();
        return marcaDao.getAll(); // Suponiendo que tienes un método getAll en el MarcaDao para obtener todas las marcas.
    }

}
