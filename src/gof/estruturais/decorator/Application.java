package gof.estruturais.decorator;

import gof.estruturais.decorator.codigoFonte.CodigoFonteArquivo;
import gof.estruturais.decorator.codigoFonte.CodigoFonteDecorator;
import gof.estruturais.decorator.codigoFonte.ICodigoFonte;
import gof.estruturais.decorator.compressor.CompressorDecorator;
import gof.estruturais.decorator.criptografia.CriptografiaDecorator;

public class Application {
	public static void main(String[] args) {
		 String infoPessoais = 
				 "Nome: Steve Jobs, Salário: 912.000 U$ \nNome: John Smith, Salário: 100.000 U$";
		 
	        CodigoFonteDecorator encoded = new CompressorDecorator(
	                                         new CriptografiaDecorator(
	                                             new CodigoFonteArquivo("codigo.txt")));
	        encoded.escreverDado(infoPessoais);
	        ICodigoFonte plain = new CodigoFonteArquivo("codigo.txt");

	        // Input dos dados
	        System.out.println(infoPessoais);
	        
	        System.out.println();
	        
	        // Dados Criptografados
	        System.out.println(plain.lerDado());
	        
	        System.out.println();
	        
	        // Dados Descriptografados
	        System.out.println(encoded.lerDado());
	}
}