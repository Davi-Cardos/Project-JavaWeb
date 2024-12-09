package Entidades;

import Entidades.ResultSet.copy.Linha;

public class LinhaTabelaIntencaoEstagio extends Linha{
	public LinhaTabelaIntencaoEstagio(int id, int ira, int CargaHoraria) {
		valores.put("id", id);
		valores.put("ira", ira);
		valores.put("CargaHoraria", CargaHoraria);
	}
}
