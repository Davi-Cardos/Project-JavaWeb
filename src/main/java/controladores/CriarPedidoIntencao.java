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
 * Servlet implementation class CriarPedidoIntencao
 */
@WebServlet("/CriarPedidoIntencao")
public class CriarPedidoIntencao extends HttpServlet {
       
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtendo parâmetros do formulário
        float ira = Float.parseFloat(request.getParameter("ira"));
        int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
        String nomeEmp = request.getParameter("nomeEmp");
        String enderecoEmp = request.getParameter("enderecoEmp");
        String modalidadeEst = request.getParameter("modalidadeEst");
        int maxCargaHoraria = Integer.parseInt(request.getParameter("maxCargaHoraria"));
        double valorBolsa = Double.parseDouble(request.getParameter("valorBolsa"));
        String resumo = request.getParameter("resumo");
        String conteudos = request.getParameter("conteudos");
        String motivoEst = request.getParameter("motivoEst");

        // Validação de elegibilidade
        boolean iraValido = Dados.validarIRA(ira);
        boolean cargaHorariaValida = iraValido && Dados.validarCargaHoraria(cargaHoraria);

        if (iraValido && cargaHorariaValida) {
            Dados.criarPedidoIntencaoEstagio(
                true, nomeEmp, enderecoEmp, modalidadeEst, maxCargaHoraria, 
                valorBolsa, resumo, conteudos, motivoEst
            );
            request.setAttribute("mensagemSucesso", "Pedido de intenção de estágio criado com sucesso!");
        } else {
            request.setAttribute("mensagemErro", "Não foi possível criar o pedido. Verifique IRA ou carga horária.");
        }

        // Redireciona para a página de resultado
        RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/resultado.jsp");
        dispatcher.forward(request, response);
    }

}
