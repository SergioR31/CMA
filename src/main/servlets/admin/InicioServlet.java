package main.servlets.admin;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InicioServlet.
 */
@WebServlet("/InicioServlet")
public class InicioServlet extends HttpServlet {

    /**
    *
    */
    private static final Logger LOGGER = Logger.getLogger("main.servlets.InicioServlet");

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        LOGGER.log(Level.INFO, "Usuario es admin?:" + request.isUserInRole("ADMINISTRADOR"));
        LOGGER.log(Level.INFO, "Usuario es comercial?:" + request.isUserInRole("COMERCIAL"));

        if (request.isUserInRole("ADMINISTRADOR")) {

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/admin/home.jsp");
            rd.forward(request, response);

        }

        if (request.isUserInRole("COMERCIAL")) {

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/comercial/home.jsp");
            rd.forward(request, response);

        }

    }

}
