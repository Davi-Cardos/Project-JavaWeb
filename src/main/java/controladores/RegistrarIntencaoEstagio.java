package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dados.memoria.DadosEstagio;
import Entidades.ResultSet.copy.ResultSet;
import dominio.DiscenteMTE;
import dominio.IntencaoEstagioMTE;

/**
 * Servlet implementation class RegistrarIntencaoEstagio
 */
@WebServlet("/RegistrarIntencaoEstagio")
public class RegistrarIntencaoEstagio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAluno = Integer.parseInt(request.getParameter("idAluno"));
        boolean primeiroEstagio = Boolean.parseBoolean(request.getParameter("primeiroEstagio"));
        String nomeEmpresa = request.getParameter("nomeEmpresa");
        String enderecoEmpresa = request.getParameter("enderecoEmpresa");
        String modalidadeEstagio = request.getParameter("modalidadeEstagio");
        int maxCargaHoraria = Integer.parseInt(request.getParameter("maxCargaHoraria"));
        double valorBolsa = Double.parseDouble(request.getParameter("valorBolsa"));
        String resumo = request.getParameter("resumo");
        String conteudos = request.getParameter("conteudos");
        String motivoEstagio = request.getParameter("motivoEstagio");

        ResultSet rs = DadosEstagio.getResultSet(); 

        try {
            DiscenteMTE discente = new DiscenteMTE();
            rs = discente.validarElegibilidadeEstagio(rs, idAluno);

            if (IntencaoEstagioMTE.validarIra(rs, idAluno) && IntencaoEstagioMTE.validarCargaHoraria(rs, idAluno)) {
                IntencaoEstagioMTE.criarPedidoIntencaoEstagio(
                        rs, primeiroEstagio, nomeEmpresa, enderecoEmpresa, modalidadeEstagio,
                        maxCargaHoraria, valorBolsa, resumo, conteudos, motivoEstagio
                );

                request.setAttribute("mensagemSucesso", "Pedido de estágio enviado com sucesso.");
            } else {
                request.setAttribute("mensagemErro", "Aluno não é elegível para estágio.");
            }

            request.getRequestDispatcher("pedidoEstagio.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro", "Erro ao registrar intenção de estágio. Tente novamente.");
            request.getRequestDispatcher("pedidoEstagio.jsp").forward(request, response);
        }
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/pedidoEstagio.jsp");
	    dispatcher.forward(request, response);
	}

}
