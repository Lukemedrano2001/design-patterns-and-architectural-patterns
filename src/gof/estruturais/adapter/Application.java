package gof.estruturais.adapter;

import gof.estruturais.adapter.adaptador.AdaptadorPinoQuadrado;
import gof.estruturais.adapter.buracos.BuracoRedondo;
import gof.estruturais.adapter.pinos.PinoQuadrado;
import gof.estruturais.adapter.pinos.PinoRedondo;

public class Application {
	public static void main(String[] args) {
		BuracoRedondo buraco = new BuracoRedondo(5);
		PinoRedondo pinoRedondo = new PinoRedondo(5);
		PinoQuadrado pinoQuadrado = new PinoQuadrado(5);
		AdaptadorPinoQuadrado adaptadorPinoQuadrado = new AdaptadorPinoQuadrado(pinoQuadrado);
		
		if(buraco.encaixe(pinoRedondo)) {
			System.out.println("Pino Redondo encaixou.");
		}
		
		if(buraco.encaixe(adaptadorPinoQuadrado)) {
			System.out.println("Pino Quadrado encaixou usando o Adaptador.");
		}
	}
}