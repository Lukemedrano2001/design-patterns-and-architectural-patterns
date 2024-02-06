package grasp.polimorfismo.calculadoraDesconto;

public class CalculadoraDescontoVIP implements ICalculadoraDescontos {
	private double descontoVIP;

	public CalculadoraDescontoVIP(double descontoClienteVIP) {
		this.descontoVIP = descontoClienteVIP;
	}

	public double getDescontoVIP() {
		return descontoVIP;
	}
 
	public void setDescontoVIP(double descontoClienteVIP) {
		this.descontoVIP = descontoClienteVIP;
	}

	@Override
	public double calcularDesconto(double preco) {
		double precoComDesconto = preco * (descontoVIP / 100);
		
		return precoComDesconto;
	}
}