package gof.comportamento.strategy.pagamentos;

public interface IPagamentoStrategy {
	public boolean pagar(int montantePagamento);
	public void recolherDetalhesPagamento();
}