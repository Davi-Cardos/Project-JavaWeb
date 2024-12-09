package Entidades.ResultSet.copy;

import java.util.HashMap;
import java.util.Map;

public class Linha {
    protected Map<String, Object> valores;

    public Linha() {
        valores = new HashMap<>();
    }

    public void setValor(String coluna, Object valor) {
        valores.put(coluna, valor);
    }

    public Object getValor(String coluna) {
        return valores.get(coluna);
    }
}
	

