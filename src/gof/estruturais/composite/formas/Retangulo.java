package gof.estruturais.composite.formas;

import java.awt.Color;
import java.awt.Graphics;

public class Retangulo extends FormaBase {
    public int largura;
    public int altura;

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
    public void paint(Graphics graficos) {
        super.paint(graficos);
        graficos.drawRect(x, y, getLargura() - 1, getAltura() - 1);
    }
}