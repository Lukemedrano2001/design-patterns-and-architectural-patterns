package gof.comportamento.memento.formas;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Ponto extends FormaBase {
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
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.fillRect(coordenadaAtualX - 1, coordenadaAtualY - 1, getLargura(), getAltura());
    }
}