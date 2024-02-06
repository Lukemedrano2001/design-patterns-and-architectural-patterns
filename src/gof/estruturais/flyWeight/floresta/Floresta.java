package gof.estruturais.flyWeight.floresta;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import gof.estruturais.flyWeight.arvore.Arvore;
import gof.estruturais.flyWeight.arvore.ArvoreFactory;
import gof.estruturais.flyWeight.arvore.TipoArvore;

@SuppressWarnings("serial")
public class Floresta extends JFrame {
	private List<Arvore> arvores = new ArrayList<Arvore>();

    public void plantarArvore(int x, int y, String nome, Color cor, String outrosDadosArvore) {
        TipoArvore tipo = ArvoreFactory.getTipoArvore(nome, cor, outrosDadosArvore);
        Arvore arvore = new Arvore(x, y, tipo);
        arvores.add(arvore);
    }

    @Override
    public void paint(Graphics graficos) {
        for (Arvore arvore: arvores) {
            arvore.desenhar(graficos);
        }
    }
}