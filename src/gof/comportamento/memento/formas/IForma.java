package gof.comportamento.memento.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public interface IForma extends Serializable {
    int getX();
    int getY();
    int getLargura();
    int getAltura();
    
    void arrastar();
    void soltar();
    void moverPara(int x, int y);
    void moverAte(int x, int y);
    boolean isDentroDosLimites(int x, int y);
    
    Color getCor();
    void setCor(Color color);
    
    void selecionar();
    void deselecionar();
    boolean isSelecionado();
    void paint(Graphics graphics);
}