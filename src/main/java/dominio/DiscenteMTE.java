package dominio;

import java.util.List;

public class DiscenteMTE {

	    private int ira;
	    private String nome;
	    private List<IntencaoEstagio> intencoes;
	    
	    public ResultSet validarElegibilidadeEstagio(ResultSet rs, int id) {
	    	boolean sit = IntencaoEstagioMTE.validarIra(rs);
	    	if(sit == true) {
	    		sit = IntencaoEstagioMTE.validarCargaHoraria(rs);
	    	}
	    	return rs;
	    }
	    
	}
