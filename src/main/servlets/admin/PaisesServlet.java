package main.servlets.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.services.implementation.PaisesService;
import main.services.interfaces.IPaisesService;
import main.vo.PaisVO;

/**
 * Servlet implementation class PaisesServlet.
 */
@WebServlet("/PaisesServlet")
public class PaisesServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger("main.servlets.PaisesServlet");

    private static final String ERROR = "{0}";

    private static final String ID_PAIS = "id_pais";

    private static final String RESPUESTA = "respuesta";

    private static final String NOMBRE = "nombre";

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaisesServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        try {
            doPost(request, response);
        } catch (ServletException e) {
            LOGGER.log(Level.SEVERE, ERROR, e);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("opcion");

        LOGGER.log(Level.INFO, "Opcion: {0}", opcion);

        if (opcion.equals("verPaises")) {

            try {
                verPaises(request, response);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, ERROR, e);
            }
        } else if (opcion.equals("crear")) {

            try {
                inicioCrearPais(request, response, opcion);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, ERROR, e);
            }
        } else if (opcion.equals("insertar")) {

            try {
                insertarPais(request, response);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, ERROR, e);
            }
        } else if (opcion.equals("modificar")) {

            try {
                inicioModificarPais(request, response, opcion);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, ERROR, e);
            }
        } else if (opcion.equals("actualizar")) {

            try {
                acualizarPais(request, response);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, ERROR, e);
            }
        } else if (opcion.equals("eliminar")) {

            try {
                eliminarPais(request, response);

            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, ERROR, e);
            }
        }
    }

    /**
     *
     * @param request
     *            Proporciona informacion request para servlets HTTP
     * @param response
     *            Provee funcionalidad especifica de HTTP
     * @throws IOException
     *             si hay operaciones I/O fallidas
     * @throws ServletException
     *             cuando el servlet encuentra dificultades
     */
    private void verPaises(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<PaisVO> listaPaises = new ArrayList<>();

        IPaisesService paisesService = new PaisesService();

        try {

            listaPaises = paisesService.listarPaises();

            request.setAttribute("listaPaises", listaPaises);

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, ERROR, e);

        } finally {

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/admin/paises/listaPaises.jsp");
            rd.forward(request, response);

        }
    }

    /**
     *
     * @param request
     *            Proporciona informacion request para servlets HTTP
     * @param response
     *            Provee funcionalidad especifica de HTTP
     * @param opcion
     *            Indica que accion se realizará
     * @throws IOException
     *             si hay operaciones I/O fallidas
     * @throws ServletException
     *             cuando el servlet encuentra dificultades
     */
    private void inicioCrearPais(final HttpServletRequest request, final HttpServletResponse response,
            final String opcion) throws ServletException, IOException {

        try {

            request.setAttribute("accion", opcion);

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, ERROR, e);

        } finally {

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/admin/paises/inicioPais.jsp");
            rd.forward(request, response);

        }
    }

    /**
     *
     * @param request
     *            Proporciona informacion request para servlets HTTP
     * @param response
     *            Provee funcionalidad especifica de HTTP
     * @throws IOException
     *             si hay operaciones I/O fallidas
     * @throws ServletException
     *             cuando el servlet encuentra dificultades
     */
    private void insertarPais(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter(NOMBRE);
        String status = "Disponible";
        String respuesta = "";

        PaisVO pais = new PaisVO();
        IPaisesService paisService = new PaisesService();

        pais.setNombre(nombre);
        pais.setStatus(status);

        try {

            respuesta = paisService.insertarPais(pais);
            request.setAttribute(RESPUESTA, respuesta);

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, ERROR, e);

        } finally {

            verPaises(request, response);

        }

    }

    /**
     *
     * @param request
     *            Proporciona informacion request para servlets HTTP
     * @param response
     *            Provee funcionalidad especifica de HTTP
     * @param opcion
     *            Indica que accion se realizará
     * @throws IOException
     *             si hay operaciones I/O fallidas
     * @throws ServletException
     *             cuando el servlet encuentra dificultades
     */
    private void inicioModificarPais(final HttpServletRequest request, final HttpServletResponse response,
            final String opcion) throws ServletException, IOException {

        try {

            request.setAttribute("accion", opcion);

            int id = Integer.parseInt(request.getParameter(ID_PAIS));

            PaisVO pais = new PaisVO();
            IPaisesService paisService = new PaisesService();

            pais = paisService.consultarPais(id);

            request.setAttribute(ID_PAIS, id);
            request.setAttribute(NOMBRE, pais.getNombre());

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, ERROR, e);

        } finally {

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/admin/paises/inicioPais.jsp");
            rd.forward(request, response);

        }

    }

    /**
     *
     * @param request
     *            Proporciona informacion request para servlets HTTP
     * @param response
     *            Provee funcionalidad especifica de HTTP
     * @throws IOException
     *             si hay operaciones I/O fallidas
     * @throws ServletException
     *             cuando el servlet encuentra dificultades
     */
    private void acualizarPais(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter(ID_PAIS));
        String nombre = request.getParameter(NOMBRE);
        String status = "Disponible";

        String respuesta = "";

        PaisVO pais = new PaisVO();
        IPaisesService paisService = new PaisesService();

        pais.setId(id);
        pais.setNombre(nombre);
        pais.setStatus(status);

        try {

            respuesta = paisService.actualizarPais(pais);

            request.setAttribute(RESPUESTA, respuesta);

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, ERROR, e);

        } finally {

            verPaises(request, response);

        }
    }

    /**
     *
     * @param request
     *            Proporciona informacion request para servlets HTTP
     * @param response
     *            Provee funcionalidad especifica de HTTP
     * @throws IOException
     *             si hay operaciones I/O fallidas
     * @throws ServletException
     *             cuando el servlet encuentra dificultades
     */
    private void eliminarPais(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter(ID_PAIS));

        String status = "Eliminado";

        String respuesta = "";

        PaisVO pais = new PaisVO();
        IPaisesService paisService = new PaisesService();

        pais.setId(id);
        pais.setStatus(status);

        try {

            respuesta = paisService.eliminarPais(pais);

            request.setAttribute(RESPUESTA, respuesta);

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, ERROR, e);

        } finally {

            verPaises(request, response);

        }
    }

}
