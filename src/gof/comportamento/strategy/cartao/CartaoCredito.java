package gof.comportamento.strategy.cartao;

@SuppressWarnings("unused")
public class CartaoCredito {
	private int saldo;
	private String numero;
    private String data;
    private String cardVerificationValue;	// CVV

    public CartaoCredito(String numero, String data, String cardVerificationValue) {
        this.saldo = 100_000;
        this.numero = numero;
        this.data = data;
        this.cardVerificationValue = cardVerificationValue;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }
}