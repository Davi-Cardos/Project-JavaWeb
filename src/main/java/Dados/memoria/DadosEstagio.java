package Dados.memoria;

import Entidades.TabelaIntencaoEstagio;
import Entidades.ResultSet.copy.ResultSet;

public class DadosEstagio {
	private static ResultSet resultSet;

    public static ResultSet getResultSet() {
        if (resultSet == null) {
            inicializarResultSet();
        }
        return resultSet;
    }

    private static void inicializarResultSet() {
        resultSet = new ResultSet();

        TabelaIntencaoEstagio tabelaEstagio = new TabelaIntencaoEstagio();

        resultSet.addTabela("IntecaoEstagio", tabelaEstagio);
    }
}

