package gof.estruturais.composite.formas;

import java.awt.Color;
import java.awt.Graphics;

public class Circulo extends FormaBase {
	public int raio;
	 
	public Circulo(int x, int y, int raio, Color cor) {
		super(x, y, cor);
		this.raio = raio;
	}
	
	@Override
	public int getLargura() {
		return raio * 2;
	}
	
	@Override
	public int getAltura() {
		return raio * 2;
	}
	
	public void paint(Graphics graficos) {
		super.paint(graficos);
		graficos.drawOval(x, y, getLargura() - 1, getAltura() - 1);
	}
}