package main.servlets.admin;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class PaisesServlet
 */
@WebServlet("/PaisesServlet")
public class PaisesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaisesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String opcion = request.getParameter("opcion");

		System.out.println("Opcion: " + opcion);

		if (opcion.equals("verPaises")){
			try {
				verPaises(request, response);
			}catch(Exception e) {
				System.out.println("Error en metodo verPaises. Mensaje: "+e);
			}
		}else if(opcion.equals("crear")){

			try {
				inicioCrearPais(request, response, opcion);
			}catch(Exception e) {
				System.out.println("Error en metodo inicioCrearPais. Mensaje: "+e);
			}
		}else if(opcion.equals("insertar")) {

			try {
				insertarPais(request, response);
			}catch(Exception e) {
				System.out.println("Error en metodo insertarPais. Mensaje: "+e);
			}
		}
	}

	private void verPaises(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();

		IPaisesService paisesService = new PaisesService();

		try {

			listaPaises = paisesService.listarPaises();

			request.setAttribute("listaPaises", listaPaises);

		}catch(Exception e) {

			System.out.println("Error en verPaises de PaisesServlet. Mensaje: " + e);


		}finally {

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/admin/paises/listaPaises.jsp");
			rd.forward(request, response);

		}
	}

	private void inicioCrearPais(HttpServletRequest request, HttpServletResponse response, String opcion) throws Exception {
		// TODO Auto-generated method stub

		try {

			request.setAttribute("accion",opcion);

		}catch(Exception e) {

			System.out.println("Error en inicioCrearPais de PaisServlet. Mensaje: " + e);

		}finally {

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/admin/paises/inicioPais.jsp");
			rd.forward(request, response);

		}
	}

	private void insertarPais(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String nombre = request.getParameter("nombre");
		String status = "Disponible";
		String respuesta = "";

		PaisVO pais = new PaisVO();
		IPaisesService paisService = new PaisesService();

		pais.setNombre(nombre);
		pais.setStatus(status);

		try {

			respuesta = paisService.insertarPais(pais);
			request.setAttribute("respuesta", respuesta);

		} catch (Exception e) {
			System.out.println("Error en insertarPais de PaisServlet. Mesaje: " + e);
		}finally {
			verPaises(request, response);
		}

	}

}
