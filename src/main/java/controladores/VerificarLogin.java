package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dominio.Usuarios;

/**
 * Servlet implementation class verificarLogin
 */
@WebServlet("/VerificarLogin")
public class VerificarLogin extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		Usuarios usuarioInformado = (Usuarios) request.getSession().getAttribute("usuario");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/welcome.jsp");
		dispatcher.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
	}
  }
}


