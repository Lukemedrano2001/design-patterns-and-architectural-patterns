package gof.comportamento.memento;

import java.awt.Color;

import gof.comportamento.memento.editor.Editor;
import gof.comportamento.memento.formas.Circulo;
import gof.comportamento.memento.formas.FormaComposta;
import gof.comportamento.memento.formas.Ponto;
import gof.comportamento.memento.formas.Retangulo;

public class Application {
	public static void main(String[] args) {
	    Editor editor = new Editor();
	    editor.carregarFormas(
	    		new Circulo(10, 10, 10, Color.BLUE),
	    		
	    		new FormaComposta(
	    				new Circulo(110, 110, 50, Color.RED),
	    				new Ponto(160, 160, Color.RED)
	    		),
	    		
	    		new FormaComposta(
	    				new Retangulo(250, 250, 100, 100, Color.GREEN),
	    				new Ponto(240, 240, Color.GREEN),
	    				new Ponto(240, 360, Color.GREEN),
	    				new Ponto(360, 360, Color.GREEN),
	    				new Ponto(360, 240, Color.GREEN)
	    		)
	    );
	}
}