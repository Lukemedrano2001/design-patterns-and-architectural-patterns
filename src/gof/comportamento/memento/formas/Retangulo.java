package gof.comportamento.memento.formas;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Retangulo extends FormaBase {
    private int largura;
    private int altura;

    public Retangulo(int x, int y, int largura, int altura, Color cor) {
        super(x, y, cor);
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public int getLargura() {
        return largura; 
    }

    @Override
    public int getAltura() {
        return altura;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawRect(coordenadaAtualX, coordenadaAtualY, getLargura() - 1, getAltura() - 1);
    }
}