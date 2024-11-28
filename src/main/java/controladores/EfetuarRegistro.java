package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import Dados.memoria.Dados;
import Dados.memoria.Usuario;

@WebServlet("/EfetuarRegistro")
public class EfetuarRegistro extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtendo os parâmetros do formulário HTML
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Verifica se o usuário já está cadastrado
        Usuario usuarioExistente = Dados.buscarUsuario(email, senha);

        if (usuarioExistente != null) {
            // Redireciona para uma página indicando que o e-mail já está cadastrado
            request.setAttribute("mensagemErro", "E-mail já cadastrado.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/registro.jsp");
            dispatcher.forward(request, response);
        } else {
            // Cria e registra o novo usuário
            Usuario novoUsuario = new Usuario(email, senha, "Novo Usuário");
            Dados.adicionarUsuario(novoUsuario);

            // Redireciona para uma página de sucesso ou login
            request.setAttribute("mensagemSucesso", "Usuário registrado com sucesso!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}

