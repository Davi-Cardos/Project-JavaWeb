package Entidades.ResultSet.copy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ResultSet {
	
	private Map<String, Tabela> tabelas;
	
	public ResultSet() {
        tabelas = new HashMap<String, Tabela>();
    }

    public void addTabela(String nomeTabela,Tabela novaTabela) {
        tabelas.put(nomeTabela, novaTabela);
    }

    public Tabela getTabela(String nomeTabela) {
        return tabelas.get(nomeTabela);
    }
    
   // public void getLinha(String nomeTabela, ) 

    public Iterator<Linha> getLinha(String nomeTabela){
        Tabela tabela = getTabela(nomeTabela);
        return tabela.iterador();
    }; 
}
