package gof.criacao.prototype;

import java.util.ArrayList;
import java.util.List;

import gof.criacao.prototype.formas.Circulo;
import gof.criacao.prototype.formas.Forma;
import gof.criacao.prototype.formas.Retangulo;

public class Application {
	public static void main(String[] args) {
		List<Forma> formas = new ArrayList<Forma>();
        List<Forma> formasCopias = new ArrayList<Forma>();

        Circulo circulo = new Circulo(10, 20, "Vermelho", 20);
        formas.add(circulo);

        Circulo outroCirculo = (Circulo) circulo.clone();
        formas.add(outroCirculo);

        Retangulo retangulo = new Retangulo(20, 40, "Amarelo", 30);
        formas.add(retangulo);
        
        Retangulo outroRetangulo = (Retangulo) retangulo.clone();
        formas.add(outroRetangulo);
        
        comparar(formas, formasCopias);
        exibir(formas, formasCopias);
	}

	public static void comparar(List<Forma> formas, List<Forma> formasCopias) {
		clonar(formas, formasCopias);
		
		for (int i = 0; i < formas.size(); i++) {
            if (formas.get(i) != formasCopias.get(i)) {
                System.out.println(i + ": As formas são objetos diferentes.");
                if (formas.get(i).equals(formasCopias.get(i))) {
                    System.out.println(i + ": Eles são idênticos.");
                } else {
                    System.out.println(i + ": Mas eles não são idênticos.");
                }
            } else {
                System.out.println(i + ": A forma dos objetos é a mesma.");
            }
        }
	}
	
	public static void clonar(List<Forma> formas, List<Forma> formasCopias) {
		for(Forma forma: formas) {
			formasCopias.add(forma.clone());
		}
	}
	
	public static void exibir(List<Forma> formas, List<Forma> formasCopias) {
		System.out.println("\nArray Original:");

		for(Forma forma: formas) {
			System.out.println(forma.toString());
		}
		
		System.out.println("\nArray com as cópias:");
		
		for(Forma forma: formasCopias) {
			System.out.println(forma.toString());
		}
	}
}