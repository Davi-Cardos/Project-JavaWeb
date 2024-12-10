package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dados.memoria.DadosEstagio;
import Entidades.ResultSet.copy.Linha;
import Entidades.ResultSet.copy.ResultSet;
import dominio.IntencaoEstagioMTE;

/**
 * Servlet implementation class BuscarAluno
 */
@WebServlet("/BuscarAluno")
public class BuscarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAluno = Integer.parseInt(request.getParameter("idAluno"));

        ResultSet rs = DadosEstagio.getResultSet(); // Supondo um método para obter o ResultSet

        try {
            Linha linha = IntencaoEstagioMTE.buscarLinhaPorId(rs, idAluno);
            if (linha != null) {
                request.setAttribute("dadosAluno", linha);
                request.getRequestDispatcher("detalhesAluno.jsp").forward(request, response);
            } else {
                request.setAttribute("mensagemErro", "Aluno não encontrado.");
                request.getRequestDispatcher("resultado.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro", "Erro ao buscar aluno. Tente novamente.");
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        }
    }
}

