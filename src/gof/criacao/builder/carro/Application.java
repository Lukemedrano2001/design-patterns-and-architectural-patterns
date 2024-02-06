package gof.criacao.builder.carro;

import gof.criacao.builder.carro.builders.BuilderCarroEletrico;
import gof.criacao.builder.carro.builders.BuilderCarroEsportivo;
import gof.criacao.builder.carro.builders.BuilderCarroPopular;
import gof.criacao.builder.carro.configs.CarroEletrico;
import gof.criacao.builder.carro.configs.CarroEsportivo;
import gof.criacao.builder.carro.configs.CarroPopular;
import gof.criacao.builder.carro.configs.Diretor;

public class Application {
	public static void main(String[] args) {
		Diretor diretor = new Diretor();
		
		// Builders
		BuilderCarroPopular builderCarroPopular = new BuilderCarroPopular();
		BuilderCarroEsportivo builderCarroEsportivo = new BuilderCarroEsportivo();
		BuilderCarroEletrico builderCarroEletrico = new BuilderCarroEletrico();
		
		// Construindo
		diretor.construirCarroPopular(builderCarroPopular);
		diretor.construirCarroEsportivo(builderCarroEsportivo);
		diretor.construirCarroEletrico(builderCarroEletrico);
		
		// Resultado da Construção
		CarroPopular carroPopular = builderCarroPopular.getResultado();
		CarroEsportivo carroEsportivo = builderCarroEsportivo.getResultado();
		CarroEletrico carroEletrico = builderCarroEletrico.getResultado();
		
		System.out.println(carroPopular.toString());
		System.out.println(carroEsportivo.toString());
		System.out.println(carroEletrico.toString());
	}
}