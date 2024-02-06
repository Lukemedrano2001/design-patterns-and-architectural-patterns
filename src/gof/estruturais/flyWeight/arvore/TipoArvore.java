package gof.estruturais.flyWeight.arvore;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("unused")
public class TipoArvore {
	private String nome;
    private Color cor;
    private String outrosDadosArvore;

    public TipoArvore(String nome, Color cor, String outrosDadosArvore) {
        this.nome = nome;
        this.cor = cor;
        this.outrosDadosArvore = outrosDadosArvore;
    }

    public void desenhar(Graphics graficos, int x, int y) {
    	graficos.setColor(Color.BLACK);
    	graficos.fillRect(x - 1, y, 3, 5);
    	graficos.setColor(cor);
    	graficos.fillOval(x - 5, y - 10, 10, 10);
    }
}