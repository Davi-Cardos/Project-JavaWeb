package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dados.memoria.DadosUsuario;
import dominio.Usuario;

/**
 * Servlet implementation class EfetuarRegistro
 */
@WebServlet("/EfetuarRegistro")
public class EfetuarRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 @Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/registro.jsp");
	        dispatcher.forward(request, response);
		}
     
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String nome = request.getParameter("nome");
	        String email = request.getParameter("email");
	        String senha = request.getParameter("senha");
	        String confirmarSenha = request.getParameter("confirmarSenha");

	        try {
	            // Validações básicas
	            if (nome == null || nome.isEmpty() || email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
	                request.setAttribute("mensagemErro", "Todos os campos são obrigatórios.");
	                RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/registro.jsp");
	    	        dispatcher.forward(request, response);
	                return;
	            }

	            if (!senha.equals(confirmarSenha)) {
	                request.setAttribute("mensagemErro", "As senhas não coincidem.");
	                RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/registro.jsp");
	    	        dispatcher.forward(request, response);
	                return;
	            }

	            Usuario usuarioExistente = DadosUsuario.buscarUsuarioPorEmail(email);
	            if (usuarioExistente != null) {
	                request.setAttribute("mensagemErro", "Este e-mail já está cadastrado.");
	                RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/registro.jsp");
	    	        dispatcher.forward(request, response);
	                return;
	            }

	            Usuario novoUsuario = new Usuario(email, senha, nome);
	            DadosUsuario.adicionarUsuario(novoUsuario);

	            request.setAttribute("mensagemSucesso", "Registro realizado com sucesso! Faça login.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/login.jsp");
		        dispatcher.forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("mensagemErro", "Erro ao realizar o registro. Tente novamente.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/registro.jsp");
		        dispatcher.forward(request, response);
	        }
	    }
	}