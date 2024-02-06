package gof.comportamento.strategy.pagamentos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gof.comportamento.strategy.cartao.CartaoCredito;

public class PagamentoByCartaoCredito implements IPagamentoStrategy {
	private final BufferedReader LEITOR = new BufferedReader(new InputStreamReader(System.in));
    private CartaoCredito cartao;

	@Override
	public boolean pagar(int montantePagamento) {
		if (isCartaoPresente()) {
            System.out.println("Pagando " + montantePagamento + " usando Cartão de Crédito.");
            cartao.setSaldo(cartao.getSaldo() - montantePagamento);
            return true;
        } else {
            return false;
        }
	}

	@Override 
	public void recolherDetalhesPagamento() {
		try {
			// Número do cartão
            System.out.print("Digite o número do cartão: ");
            String numero = LEITOR.readLine();
            
            // Data
            System.out.print("Digite a data de expiração do cartão (mm/yy): ");
            String data = LEITOR.readLine();
            
            // CVV
            System.out.print("Digite o código do CVV: ");
            String cardVerificationValue = LEITOR.readLine();
            
            cartao = new CartaoCredito(numero, data, cardVerificationValue);
        } catch (IOException exception) {
        	exception.printStackTrace();
        } 
	} 
	
	private boolean isCartaoPresente() {
        return cartao != null;
    }
}