package grasp.baixoAcoplamento.pagamentos;

public class PagamentoCartaoCredito implements IPagamento {
	@Override
	public void processarPagamento(double montante) {
		System.out.printf("Pagamento com Cartão de Crédito: %.2f R$ \n", montante);
	}
}