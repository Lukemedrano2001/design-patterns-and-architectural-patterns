package gof.estruturais.composite.formas;

import java.awt.Color;
import java.awt.Graphics;

public class Ponto extends FormaBase{
	private final int TAMANHO_PONTO = 3;

    public Ponto(int x, int y, Color cor) {
        super(x, y, cor);
    }

    @Override
    public int getLargura() {
        return TAMANHO_PONTO;
    }

    @Override
    public int getAltura() {
        return TAMANHO_PONTO;
    }

    @Override
    public void paint(Graphics graficos) {
        super.paint(graficos);
        graficos.fillRect(x - 1, y - 1, getLargura(), getAltura());
    }
}