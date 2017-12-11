package main.servlets.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("/InicioServlet")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InicioServlet() {
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

		System.out.println("Usuario es admin?:"+request.isUserInRole("ADMINISTRADOR"));
		System.out.println("Usuario es comercial?:"+request.isUserInRole("COMERCIAL"));

		if(request.isUserInRole("ADMINISTRADOR")) {

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/admin/home.jsp");
			rd.forward(request, response);

		}

		if(request.isUserInRole("COMERCIAL")) {

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/comercial/home.jsp");
			rd.forward(request, response);

		}

	}

}
