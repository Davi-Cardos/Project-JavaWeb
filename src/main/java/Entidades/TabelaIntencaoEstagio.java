package Entidades;

import Entidades.ResultSet.copy.Tabela;

public class TabelaIntencaoEstagio extends Tabela{
	public TabelaIntencaoEstagio(){
		super("IntecaoEstagio");
		this.addColuna("id");
		this.addColuna("ira");
		this.addColuna("CargaHoraria");
	}
}
