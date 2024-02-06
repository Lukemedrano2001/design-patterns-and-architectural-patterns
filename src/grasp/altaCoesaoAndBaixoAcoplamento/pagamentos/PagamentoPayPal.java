package grasp.altaCoesaoAndBaixoAcoplamento.pagamentos;

public class PagamentoPayPal implements IPagamento {
	@Override
	public void processarPagamento(double montante) {
		System.out.printf("Pagamento com PayPal: %.2f R$ \n", montante);
	}
}