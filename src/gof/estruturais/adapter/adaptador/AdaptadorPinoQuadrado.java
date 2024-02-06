package gof.estruturais.adapter.adaptador;

import gof.estruturais.adapter.pinos.PinoQuadrado;
import gof.estruturais.adapter.pinos.PinoRedondo;

public class AdaptadorPinoQuadrado extends PinoRedondo {
	private PinoQuadrado pino;
	
	public AdaptadorPinoQuadrado(PinoQuadrado pino) {
		this.pino = pino;
	}
	
	public double getRaio() {
		return (Math.sqrt(Math.pow((pino.getLado() / 2), 2) * 2));
	}
}