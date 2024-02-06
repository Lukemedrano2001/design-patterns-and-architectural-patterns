package gof.estruturais.composite.formas;

import java.awt.Graphics;

public interface IForma {
	int getX();
    int getY();
    
    int getLargura();
    int getAltura();
    
    void mover(int x, int y);
    boolean isDentroDosLimites(int x, int y);
    
    void selecionar();
    void deselecionar();
    boolean isSelecionado();
    
    void paint(Graphics graphics);
}