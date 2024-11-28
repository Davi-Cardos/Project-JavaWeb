package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dados.memoria.Dados;

/**
 * Servlet implementation class FormPedidoEstagio
 */
@WebServlet("/FormPedidoEstagio")
public class FormPedidoEstagio extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeEmp = request.getParameter("nomeEmp");
        String enderecoEmp = request.getParameter("enderecoEmp");
        String modalidadeEst = request.getParameter("modalidadeEst");
        int maxCargaHoraria = Integer.parseInt(request.getParameter("maxCargaHoraria"));
        double valorBolsa = Double.parseDouble(request.getParameter("valorBolsa"));
        String resumo = request.getParameter("resumo");
        String conteudos = request.getParameter("conteudos");
        String motivoEst = request.getParameter("motivoEst");

        boolean cargaHorariaValidaMAX = Dados.validarCargaHoraria(maxCargaHoraria);

        if (cargaHorariaValidaMAX) {
        	Dados.criarPedidoIntencaoEstagio(
                    true, nomeEmp, enderecoEmp, modalidadeEst, maxCargaHoraria, 
                    valorBolsa, resumo, conteudos, motivoEst
                );
                request.setAttribute("mensagemSucesso", "Pedido de intencao de estagio criado com sucesso!");
            } else {
                request.setAttribute("mensagemErro", "Nao foi possivel criar o pedido. Verifique a carga horaria.");
            }

      
            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/resultado.jsp");
            dispatcher.forward(request, response);

	}

}
