package Dados.memoria;

public class PedidoEstagio {
	private int numPedido;
    private String descricao;

    public PedidoEstagio(int numPedido, String descricao) {
        this.numPedido = numPedido;
        this.descricao = descricao;
    }

    public int getNumPedido() {
        return numPedido;
    }

    @Override
    public String toString() {
        return "PedidoEstagio{" +
                "numPedido=" + numPedido +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
