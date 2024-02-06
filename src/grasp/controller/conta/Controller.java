package grasp.controller.conta;

public class Controller {
	private Conta conta;
	private VisualizarConta visualizacaoConta;
	
	public Controller(Conta conta, VisualizarConta visualizacaoConta) {
		this.conta = conta;
		this.visualizacaoConta = visualizacaoConta;
	}
	
	public void realizarOperacao(double valor) {
		double saldo = conta.getSaldo();
		saldo += valor;
		conta.setSaldo(saldo);
		
		visualizacaoConta.exibirSaldo(conta.getNumero(), conta.getSaldo());
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public VisualizarConta getVisualizacaoConta() {
		return visualizacaoConta;
	}

	public void setVisualizacaoConta(VisualizarConta visualizacaoConta) {
		this.visualizacaoConta = visualizacaoConta;
	}
}