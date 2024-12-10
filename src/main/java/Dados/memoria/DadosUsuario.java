package Dados.memoria;

import java.util.ArrayList;
import java.util.List;

import dominio.Usuario;

public class DadosUsuario {

    private static List<Usuario> usuarios = new ArrayList<>();

    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

   
    /*static {
        usuarios.add(new Usuario("admin@example.com", "123456", "Admin"));
        usuarios.add(new Usuario("user@example.com", "senha123", "Usuário"));
    }*/
}
