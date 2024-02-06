package gof.comportamento.memento.formas;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Circulo extends FormaBase {
    private int raio;

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

    @Override
    public void paint(Graphics graficos) {
        super.paint(graficos);
        graficos.drawOval(coordenadaAtualX, coordenadaAtualY, getLargura() - 1, getAltura() - 1);
    }
}