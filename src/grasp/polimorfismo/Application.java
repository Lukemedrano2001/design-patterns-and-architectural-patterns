package grasp.polimorfismo;

import grasp.polimorfismo.calculadoraDesconto.CalculadoraDescontoVIP;
import grasp.polimorfismo.calculadoraDesconto.CalculadoraDescontoPadrao;
import grasp.polimorfismo.calculadoraDesconto.CalculadoraDescontoSazonal;
import grasp.polimorfismo.calculadoraDesconto.ICalculadoraDescontos;
import grasp.polimorfismo.produto.Produto;

public class Application {
	public static void main(String[] args) {
		// Desconto Padrão
		ICalculadoraDescontos calculadoraPadrao = new CalculadoraDescontoPadrao();
		Produto produtoPadrao = new Produto(1, "Produto Padrão", 100, calculadoraPadrao);
		System.out.println(produtoPadrao.toString());
		
		// Desconto Sazonal (Natal, Ano Novo, Páscoa)
        ICalculadoraDescontos calculadoraSazonal = new CalculadoraDescontoSazonal(20);
        Produto produtoSazonal = new Produto(2, "Produto Sazonal", 100, calculadoraSazonal);
        System.out.println(produtoSazonal.toString());

        // Desconto VIP
        ICalculadoraDescontos calculadoraVIP = new CalculadoraDescontoVIP(30);
        Produto produtoVIP = new Produto(3, "Produto VIP", 100, calculadoraVIP);
        System.out.println(produtoVIP.toString());
	}
}