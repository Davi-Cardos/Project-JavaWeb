package Dados.memoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dados {
    // Simulação de tabelas em memória
    private static List<PedidoEstagio> pedidosEstagio = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<PedidoIntencaoEstagio> pedidosIntencaoEstagio = new ArrayList<>();

    // Inicializando dados simulados
    static {
        // Adicionando alguns dados de exemplo
        pedidosEstagio.add(new PedidoEstagio(1, "Pedido 1"));
        pedidosEstagio.add(new PedidoEstagio(2, "Pedido 2"));
        usuarios.add(new Usuario("user@example.com", "12345", "Usuário Teste"));
    }

    public static PedidoEstagio buscarPedidoEstagio(int numPedidoEstagio) {
        // Busca um pedido pelo número
        Optional<PedidoEstagio> pedido = pedidosEstagio.stream()
                .filter(p -> p.getNumPedido() == numPedidoEstagio)
                .findFirst();

        if (pedido.isPresent()) {
            System.out.println("Pedido encontrado: " + pedido.get());
            return pedido.get();
        } else {
            System.out.println("Pedido não encontrado para o número: " + numPedidoEstagio);
            return null;
        }
    }

    public static Usuario buscarUsuario(String email, String senha) {
    	 // Busca usuário por email e senha
    	  return usuarios.stream()
    	            .filter(u -> u != null && email.equals(u.getEmail()) && senha.equals(u.getSenha()))
    	            .findFirst()
    	            .orElse(null);
    	}
    
    public static void adicionarUsuario(Usuario usuario) {
        if (usuario != null && usuario.getEmail() != null && usuario.getSenha() != null) {
            usuarios.add(usuario);
            System.out.println("Novo usuário adicionado: " + usuario);
        } else {
            System.out.println("Erro: Tentativa de adicionar um usuário inválido.");
        }
    }


    public static void criarPedidoIntencaoEstagio(
    	    boolean primeiroEst, String nomeEmp, String enderecoEmp, String modalidadeEst, 
    	    int maxCargaHoraria, double valorBolsa, String resumo, String conteudos, String motivoEst) {
    	    
    	    PedidoIntencaoEstagio novoPedido = new PedidoIntencaoEstagio(
    	        primeiroEst, nomeEmp, enderecoEmp, modalidadeEst, maxCargaHoraria, 
    	        valorBolsa, resumo, conteudos, motivoEst
    	    );
    	    
    	    pedidosIntencaoEstagio.add(novoPedido); 
    	    System.out.println("Pedido de intenção criado com sucesso: " + novoPedido);
    	}

    
    public static boolean validarIRA(float ira) {
        return ira >= 6.0; 
    }

    public static boolean validarCargaHoraria(int cargaHoraria) {
        return cargaHoraria <= 30; 
    }
    
    public static boolean validarCargaHorariaMin(int cargaHoraria) {
        return cargaHoraria >= 80; 
    }
    


    public static void main(String[] args) {
        // Testes
        buscarPedidoEstagio(1);
        buscarUsuario("user@example.com", "12345");
        criarPedidoIntencaoEstagio(true, "Empresa XYZ", "Rua ABC, 123", "Remoto", 30, 1500.00,
                "Resumo breve", "Motivo convincente", "Conteúdos abordados");
    }
}



