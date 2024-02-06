package gof.estruturais.flyWeight.arvore;

import java.awt.Graphics;

public class Arvore {
	private int x;
    private int y;
    private TipoArvore tipo;

    public Arvore(int x, int y, TipoArvore tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }

    public void desenhar(Graphics graficos) {
        tipo.desenhar(graficos, x, y);
    }
}