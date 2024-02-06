package gof.comportamento.observer;

import gof.comportamento.observer.namorada.Namorada;
import gof.comportamento.observer.porteiro.Porteiro;

public class Application {
	// Aniversário Surpresa
	
	public static void main(String[] args) {
		Namorada namorada = new Namorada();
		Porteiro porteiro = new Porteiro();
		
		porteiro.registrarObservador(namorada);
		
		porteiro.start();
	}
}