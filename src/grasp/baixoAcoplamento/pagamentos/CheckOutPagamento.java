package grasp.baixoAcoplamento.pagamentos;

public class CheckOutPagamento {
	private IPagamento pagamento;
	
    public CheckOutPagamento(IPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void processarOrdemPagamento(double montanteTotal) {
    	pagamento.processarPagamento(montanteTotal);
    }
}