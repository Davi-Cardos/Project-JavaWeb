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
        Optional<Usuario> usuario = usuarios.stream()
                .filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha))
                .findFirst();

        if (usuario.isPresent()) {
            System.out.println("Usuário encontrado: " + usuario.get());
            return usuario.get();
        } else {
            System.out.println("Usuário não encontrado.");
            return null;
        }
    }
    
    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Novo usuário adicionado: " + usuario);
    }

    public static void criarPedidoIntencaoEstagio(Boolean primeiroEst, String nomeEmpresa, String enderecoEmpresa,
                                                  String modalidadeEstagio, int maxCargaHoraria, double valorBolsa,
                                                  String resumo, String motivoEstagio, String conteudos) {
        // Cria e adiciona um novo pedido de intenção de estágio
        PedidoIntencaoEstagio novoPedido = new PedidoIntencaoEstagio(primeiroEst, nomeEmpresa, enderecoEmpresa,
                modalidadeEstagio, maxCargaHoraria, valorBolsa, resumo, motivoEstagio, conteudos);

        pedidosIntencaoEstagio.add(novoPedido);
        System.out.println("Pedido de intenção de estágio criado: " + novoPedido);
    }

    public static void main(String[] args) {
        // Testes
        buscarPedidoEstagio(1);
        buscarUsuario("user@example.com", "12345");
        criarPedidoIntencaoEstagio(true, "Empresa XYZ", "Rua ABC, 123", "Remoto", 30, 1500.00,
                "Resumo breve", "Motivo convincente", "Conteúdos abordados");
    }
}



