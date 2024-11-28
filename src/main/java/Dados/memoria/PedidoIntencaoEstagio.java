package Dados.memoria;

public class PedidoIntencaoEstagio {
	    private Boolean primeiroEst;
	    private String nomeEmpresa;
	    private String enderecoEmpresa;
	    private String modalidadeEstagio;
	    private int maxCargaHoraria;
	    private double valorBolsa;
	    private String resumo;
	    private String motivoEstagio;
	    private String conteudos;

	    public PedidoIntencaoEstagio(Boolean primeiroEst, String nomeEmpresa, String enderecoEmpresa,
	                                 String modalidadeEstagio, int maxCargaHoraria, double valorBolsa,
	                                 String resumo, String motivoEstagio, String conteudos) {
	        this.primeiroEst = primeiroEst;
	        this.nomeEmpresa = nomeEmpresa;
	        this.enderecoEmpresa = enderecoEmpresa;
	        this.modalidadeEstagio = modalidadeEstagio;
	        this.maxCargaHoraria = maxCargaHoraria;
	        this.valorBolsa = valorBolsa;
	        this.resumo = resumo;
	        this.motivoEstagio = motivoEstagio;
	        this.conteudos = conteudos;
	    }

	    @Override
	    public String toString() {
	        return "PedidoIntencaoEstagio{" +
	                "primeiroEst=" + primeiroEst +
	                ", nomeEmpresa='" + nomeEmpresa + '\'' +
	                ", enderecoEmpresa='" + enderecoEmpresa + '\'' +
	                ", modalidadeEstagio='" + modalidadeEstagio + '\'' +
	                ", maxCargaHoraria=" + maxCargaHoraria +
	                ", valorBolsa=" + valorBolsa +
	                ", resumo='" + resumo + '\'' +
	                ", motivoEstagio='" + motivoEstagio + '\'' +
	                ", conteudos='" + conteudos + '\'' +
	                '}';
	    }
	}
