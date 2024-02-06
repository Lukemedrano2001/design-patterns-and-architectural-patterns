package grasp.controller.conta;

public class Conta {
	private final int id;
	private int numero;
	private double saldo;
	
	public Conta(int id, int numero, double saldo) {
		this.id = id;
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public int getId() {
		return id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}