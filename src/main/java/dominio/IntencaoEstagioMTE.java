package dominio;

import java.util.Iterator;

import Entidades.ResultSet.copy.Linha;
import Entidades.ResultSet.copy.ResultSet;

public class IntencaoEstagioMTE {
	 public static boolean validarIra(ResultSet rs, String nomeTabela, int idAluno) {
	        Linha linha = buscarLinhaPorId(rs, nomeTabela, idAluno);
	        if (linha != null) {
	            int ira = (int) linha.getValor("ira");
	            return ira >= 6;
	        }
	        return false;
	    }

	    public static boolean validarCargaHoraria(ResultSet rs, String nomeTabela, int idAluno) {
	        Linha linha = buscarLinhaPorId(rs, nomeTabela, idAluno);
	        if (linha != null) {
	            int cargaHoraria = (int) linha.getValor("cargaHoraria");
	            return cargaHoraria >= 80;
	        }
	        return false;
	    }

	    private static Linha buscarLinhaPorId(ResultSet rs, String nomeTabela, int idAluno) {
	        Iterator<Linha> iterator = rs.getLinha(nomeTabela);
	        while (iterator.hasNext()) {
	            Linha linha = iterator.next();
	            if ((int) linha.getValor("id") == idAluno) {
	                return linha;
	            }
	        }
	        return null;
	    }

	    public static void criarPedidoIntencaoEstagio(ResultSet rs, boolean primeiroEstagio, String nomeEmpresa, String enderecoEmpresa, 
	                                                  String modalidadeEst, int maxCargaHoraria, double valorBolsa, 
	                                                  String resumo, String conteudos, String motivoEstagio) {
	        if (maxCargaHoraria <= 30) {
	            Dados.inserir(primeiroEstagio, nomeEmpresa, enderecoEmpresa, modalidadeEst, maxCargaHoraria, 
	                          valorBolsa, resumo, conteudos, motivoEstagio);
	        }
	    }
	} 