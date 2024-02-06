package gof.comportamento.strategy.ordem;

import gof.comportamento.strategy.pagamentos.IPagamentoStrategy;

public class Ordem {
	private int custoTotal = 0;
    private boolean fechado = false;

    public void processarOrdemPagamento(IPagamentoStrategy strategy) {
        strategy.recolherDetalhesPagamento();
    }

    public void setCustoTotal(int custo) {
        this.custoTotal += custo;
    }

    public int getCustoTotal() {
        return custoTotal;
    }

    public boolean isFechado() {
        return fechado;
    }

    public void setFechado() {
        fechado = true;
    }
    
    public boolean isAberto() {
    	return !isFechado();
    }
}