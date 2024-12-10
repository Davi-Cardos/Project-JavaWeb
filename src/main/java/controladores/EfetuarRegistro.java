package controladores;

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
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String nome = request.getParameter("nome");
	        String email = request.getParameter("email");
	        String senha = request.getParameter("senha");
	        String confirmarSenha = request.getParameter("confirmarSenha");

	        try {
	            // Validações básicas
	            if (nome == null || nome.isEmpty() || email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
	                request.setAttribute("mensagemErro", "Todos os campos são obrigatórios.");
	                request.getRequestDispatcher("registro.jsp").forward(request, response);
	                return;
	            }

	            if (!senha.equals(confirmarSenha)) {
	                request.setAttribute("mensagemErro", "As senhas não coincidem.");
	                request.getRequestDispatcher("registro.jsp").forward(request, response);
	                return;
	            }

	            Usuario usuarioExistente = DadosUsuario.buscarUsuarioPorEmail(email);
	            if (usuarioExistente != null) {
	                request.setAttribute("mensagemErro", "Este e-mail já está cadastrado.");
	                request.getRequestDispatcher("registro.jsp").forward(request, response);
	                return;
	            }

	            Usuario novoUsuario = new Usuario(email, senha, nome);
	            DadosUsuario.adicionarUsuario(novoUsuario);

	            request.setAttribute("mensagemSucesso", "Registro realizado com sucesso! Faça login.");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("mensagemErro", "Erro ao realizar o registro. Tente novamente.");
	            request.getRequestDispatcher("registro.jsp").forward(request, response);
	        }
	    }
	}