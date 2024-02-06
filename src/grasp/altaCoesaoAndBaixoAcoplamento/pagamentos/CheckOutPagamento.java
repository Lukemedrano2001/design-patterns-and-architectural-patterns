package grasp.altaCoesaoAndBaixoAcoplamento.pagamentos;

public class CheckOutPagamento {
	private IPagamento pagamento;
	
    public CheckOutPagamento(IPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void processarOrdemPagamento(double montante) {
    	pagamento.processarPagamento(montante);
    }
}