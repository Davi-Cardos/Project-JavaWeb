package Dados.memoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dominio.IntencaoEstagioMTE;

public class Dados {

	private static List<IntencaoEstagioMTE> lista;
	
	public static void inserir(boolean primeiroEstagio, String nomeEmpresa, String enderecoEmpresa, 
	                           String modalidadeEst, int maxCargaHoraria, double valorBolsa, 
	                           String resumo, String conteudos, String motivoEstagio) {
		
		IntencaoEstagioMTE pedido = new IntencaoEstagioMTE(primeiroEstagio, nomeEmpresa, enderecoEmpresa, modalidadeEst, maxCargaHoraria, 
	                          valorBolsa, resumo, conteudos, motivoEstagio);
		
		lista.add(pedido);
	}
	
	

}


