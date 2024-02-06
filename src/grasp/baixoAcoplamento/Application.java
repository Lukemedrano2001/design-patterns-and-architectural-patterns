package grasp.baixoAcoplamento;

import grasp.baixoAcoplamento.pagamentos.CheckOutPagamento;
import grasp.baixoAcoplamento.pagamentos.IPagamento;
import grasp.baixoAcoplamento.pagamentos.PagamentoCartaoCredito;
import grasp.baixoAcoplamento.pagamentos.PagamentoPayPal;

public class Application {
	public static void main(String[] args) {
		// Pagamentos
        IPagamento cartaoCreditoPagamento = new PagamentoCartaoCredito();
        IPagamento payPalPagamento = new PagamentoPayPal();

        // CheckOut
        CheckOutPagamento checkOutCartaoCredito = new CheckOutPagamento(cartaoCreditoPagamento);
        CheckOutPagamento checkOutPayPal = new CheckOutPagamento(payPalPagamento);

        // Simulando um pedido e processando o pagamento
        double ordemTotal = 100.0; 

        // Cartão de crédito
        checkOutCartaoCredito.processarOrdemPagamento(ordemTotal);
 
        // PayPal
        checkOutPayPal.processarOrdemPagamento(ordemTotal);
	}
}