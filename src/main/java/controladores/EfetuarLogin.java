package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import Dados.memoria.Dados;
import Dados.memoria.DadosUsuario;
import dominio.Usuario;
/**
 * Servlet implementation class EfetuarLogin
 */
@WebServlet("/EfetuarLogin")
public class EfetuarLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try {
            List<Usuario> usuarios = DadosUsuario.getUsuarios(); 
            boolean autenticado = false;

            for (Usuario usuario : usuarios) {
                if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                    request.getSession().setAttribute("usuarioLogado", usuario);
                    autenticado = true;
                    break;
                }
            }

            if (autenticado) {
                response.sendRedirect("welcome.jsp");
            } else {
                request.setAttribute("mensagemErro", "E-mail ou senha inválidos.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro", "Erro ao realizar login. Tente novamente.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
