package gof.estruturais.adapter.buracos;

import gof.estruturais.adapter.pinos.PinoRedondo;

public class BuracoRedondo {
	private double raio;
	
	public BuracoRedondo(double raio) {
		this.raio = raio;
	}
	
	public double getRaio() {
		return raio;
	}
	
	public boolean encaixe(PinoRedondo pino) {
		if(this.getRaio() >= pino.getRaio()) {
			return true;
		} else {
			return false;	
		}		
	}
}