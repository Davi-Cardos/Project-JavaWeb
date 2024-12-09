package dominio;

import java.util.List;

import Entidades.ResultSet.copy.ResultSet;

public class DiscenteMTE {

	    
	    public ResultSet validarElegibilidadeEstagio(ResultSet rs, int id) {
	    	boolean sit = IntencaoEstagioMTE.validarIra(rs, id);
	    	if(sit == true) {
	    		sit = IntencaoEstagioMTE.validarCargaHoraria(rs, id);
	    	}
	    	return rs;
	    }
	    
	}
