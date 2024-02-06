package grasp.polimorfismo.calculadoraDesconto;

public class CalculadoraDescontoSazonal implements ICalculadoraDescontos {
	private double desconto;

	public CalculadoraDescontoSazonal(double desconto) {
		this.desconto = desconto;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	@Override
	public double calcularDesconto(double preco) {
		double precoComDesconto = preco * (desconto / 100);
		
		return precoComDesconto;
	}
}