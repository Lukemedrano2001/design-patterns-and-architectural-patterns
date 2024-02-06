package gof.estruturais.adapter.pinos;

public class PinoQuadrado {
	private double lado;
	
	public PinoQuadrado(double lado) {
		this.lado = lado;
	}
	
	public double getLado() {
		return lado;
	}
	
	public double getQuadrado() {
		return Math.pow(lado, 2);
	}
}