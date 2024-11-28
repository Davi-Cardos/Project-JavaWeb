package dominio;

public class Usuarios {
	String nomeUsuario, senha;
	
	public Usuarios(String nomeUsuario, String senha) {
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}
	
	@Override
	public boolean equals(Object other) {
		Usuarios outroUsuario = (Usuarios) other;
		
		return nomeUsuario.equals(outroUsuario.nomeUsuario) && senha.equals(outroUsuario.senha);
	
	}
		

}
