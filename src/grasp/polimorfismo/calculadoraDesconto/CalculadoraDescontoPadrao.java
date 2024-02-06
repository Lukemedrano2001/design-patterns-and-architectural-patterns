package grasp.polimorfismo.calculadoraDesconto;

public class CalculadoraDescontoPadrao implements ICalculadoraDescontos {
	// Em porcentagem seria 0.1 ou 10%
	private final static double descontoPadrao = 10;

	public static double getDescontopadrao() {
		return descontoPadrao;
	}

	@Override
	public double calcularDesconto(double preco) {
		double precoComDesconto = preco * (descontoPadrao / 100);
		
		return precoComDesconto;
	}	
}