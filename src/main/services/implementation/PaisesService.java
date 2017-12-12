package main.services.implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.dao.implementation.PaisesDAO;
import main.dao.interfaces.IPaisesDAO;
import main.services.interfaces.IPaisesService;
import main.vo.PaisVO;

/**
 *
 * @author Sergio Ramos
 *
 */
public class PaisesService implements IPaisesService {

    /**
    *
    */
    private static final Logger LOGGER = Logger.getLogger("main.dao.implementation.PaisesService");

    @Override
    public final ArrayList<PaisVO> listarPaises() {

        ArrayList<PaisVO> listaPaises = new ArrayList<>();

        IPaisesDAO paisesDAO = new PaisesDAO();

        Collection<PaisVO> paisesNoMostrar = new ArrayList<>();

        try {

            listaPaises = paisesDAO.consultarPaises();

            for (int i = 0; i < listaPaises.size(); i++) {
                if (listaPaises.get(i).getStatus().equals("Eliminado")
                        || listaPaises.get(i).getStatus().equals("Inactivo")) {
                    paisesNoMostrar.add(listaPaises.get(i));
                }
            }

            listaPaises.removeAll(paisesNoMostrar);

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error listarPaises PaisService: " + e);

        }

        return listaPaises;
    }

    @Override
    public final ArrayList<PaisVO> consultarPaises() {

        ArrayList<PaisVO> listaPaises = new ArrayList<>();

        IPaisesDAO paisesDAO = new PaisesDAO();

        try {

            listaPaises = paisesDAO.consultarPaises();

            for (int i = 0; i < listaPaises.size(); i++) {
                if (listaPaises.get(i).getStatus().equals("Eliminado")) {
                    listaPaises.remove(i);
                }
            }

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error consultarPaises PaisService:" + e);

        }

        return listaPaises;

    }

    @Override
    public final String insertarPais(final PaisVO pais) {

        ArrayList<PaisVO> listaPaises = new ArrayList<>();

        IPaisesDAO paisesDAO = new PaisesDAO();

        boolean realizarInsert = true;

        String respuesta = "";

        int idEncontrado = 0;

        try {

            listaPaises = paisesDAO.consultarPaises();

            for (int i = 0; i < listaPaises.size(); i++) {
                if (listaPaises.get(i).getNombre().equalsIgnoreCase(pais.getNombre())) {

                    realizarInsert = false;

                    idEncontrado = listaPaises.get(i).getId();
                }
            }

            if (realizarInsert) {

                respuesta = paisesDAO.insertarPais(pais);

            } else {

                String status = "Disponible";
                pais.setStatus(status);
                pais.setId(idEncontrado);
                respuesta = actualizarPais(pais);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error insertarPais PaisesService: " + e);
        }
        return respuesta;
    }

    @Override
    public final PaisVO consultarPais(final int id) throws SQLException {

        PaisVO pais = new PaisVO();

        IPaisesDAO paisDAO = new PaisesDAO();

        pais = paisDAO.consultarPais(id);

        return pais;
    }

    @Override
    public final String actualizarPais(final PaisVO pais) {

        ArrayList<PaisVO> listaPaises = new ArrayList<>();

        String respuesta = "";

        IPaisesDAO paisDAO = new PaisesDAO();

        boolean realizarUpdate = true;

        int idEncontrado = 0;

        try {

            listaPaises = paisDAO.consultarPaises();

            for (int i = 0; i < listaPaises.size(); i++) {
                if (listaPaises.get(i).getNombre().equalsIgnoreCase(pais.getNombre())) {

                    idEncontrado = listaPaises.get(i).getId();

                    realizarUpdate = false;

                    respuesta = "Pais ya existe.";

                    if (pais.getId() == (idEncontrado)) {
                        if (listaPaises.get(i).getStatus().equals("Eliminado")) {

                            realizarUpdate = true;

                            respuesta = "Pais existe. Actualizando estado... ";
                        }
                    }
                }
            }

            if (realizarUpdate) {

                respuesta += paisDAO.actualizarPais(pais);

            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error actualizarPais PaisesService: " + e);
        }

        return respuesta;
    }

    @Override
    public final String eliminarPais(final PaisVO pais) {

        String respuesta = "";

        IPaisesDAO paisDAO = new PaisesDAO();

        try {

            respuesta = paisDAO.eliminarPais(pais);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error eliminarPais PaisesService: " + e);
        }

        return respuesta;
    }

}
