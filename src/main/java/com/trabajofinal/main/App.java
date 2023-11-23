package com.trabajofinal.main;

import com.trabajofinal.gui.BusquedaCliente;
import java.util.ArrayList;
import java.util.List;
import com.trabajofinal.dto.ProvinciaDTO;
import com.trabajofinal.forms.ProvinciaForm;
import com.trabajofinal.gui.BusquedaCliente;
import com.trabajofinal.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import com.trabajofinal.models.*;

public class App {

    public static void main(String[] args) {

           /*
        EntityManager em = EntityManagerUtil.getEntityManager();
        Poliza e = new Poliza();
        em.persist(e);
*/
        BusquedaCliente busquedaCliente = new BusquedaCliente();
        busquedaCliente.setVisible(true);

        //em.close();

    }

}
