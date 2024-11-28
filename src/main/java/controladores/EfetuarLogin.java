package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import Dados.memoria.Dados;
import Dados.memoria.Usuario;
import dominio.Usuarios;

/**
 * Servlet implementation class EfetuarLogin
 */
@WebServlet("/EfetuarLogin")
public class EfetuarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	private Usuarios usuarioPadrao = new Usuarios("user", "1234");
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuarios usuarioInformado = new Usuarios(request.getParameter("Login"), request.getParameter("senha"));
		
		HttpSession sessao = request.getSession();
		
		sessao.setAttribute("usuario", usuarioInformado);
		
Usuario rs = Dados.buscarUsuario(request.getParameter("Login"), request.getParameter("senha"));
	if (rs != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./VerificarLogin");
			dispatcher.forward(request, response);
	}
	else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		
		}
	}
}

