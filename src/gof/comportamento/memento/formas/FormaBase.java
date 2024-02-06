package gof.comportamento.memento.formas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public abstract class FormaBase implements IForma {
    int coordenadaAtualX;
    int coordenadaAtualY;  
    private int coordenadaOriginalX = 0;
    private int coordenadaOriginalY = 0;
    private Color cor;
    private boolean selecionado = false; 

    protected FormaBase(int x, int y, Color cor) {
        this.coordenadaAtualX = x;
        this.coordenadaAtualY = y;
        this.cor = cor;
    } 

    @Override
    public int getX() {
        return coordenadaAtualX;
    }

    @Override
    public int getY() {
        return coordenadaAtualY;
    }

    @Override
    public int getLargura() {
        return 0;
    }

    @Override
    public int getAltura() {
        return 0;
    }

    @Override
    public void arrastar() {
        coordenadaOriginalX = coordenadaAtualX;
        coordenadaOriginalY = coordenadaAtualY;
    }

    @Override
    public void moverPara(int x, int y) {
        this.coordenadaAtualX = coordenadaOriginalX + x;
        this.coordenadaAtualY = coordenadaOriginalY + y;
    }

    @Override
    public void moverAte(int x, int y) {
        this.coordenadaAtualX += x;
        this.coordenadaAtualY += y;
    }

    @Override
    public void soltar() {
        this.coordenadaAtualX = coordenadaOriginalX;
        this.coordenadaAtualY = coordenadaOriginalY;
    }

    @Override
    public boolean isDentroDosLimites(int x, int y) {
        return x > getX() && x < (getX() + getLargura()) &&
                y > getY() && y < (getY() + getAltura());
    }

    @Override
    public Color getCor() {
        return cor;
    }

    @Override
    public void setCor(Color color) {
        this.cor = color;
    }

    @Override
    public void selecionar() {
        this.selecionado = true;
    }

    @Override
    public void deselecionar() {
        this.selecionado = false;
    }

    @Override
    public boolean isSelecionado() {
        return selecionado;
    }

    protected void habilitarSelecaoEstilo(Graphics graficos) {
    	graficos.setColor(Color.LIGHT_GRAY);

        Graphics2D graficos2D = (Graphics2D) graficos; 
        float[] dash1 = {2.0f};
        graficos2D.setStroke(new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                2.0f, dash1, 0.0f));
    }

    protected void desabilitarSelecaoEstilo(Graphics graficos) {
    	graficos.setColor(cor);
        Graphics2D graficos2D = (Graphics2D) graficos;
        graficos2D.setStroke(new BasicStroke());
    }

    @Override
    public void paint(Graphics graficos) {
        if (isSelecionado()) {
        	habilitarSelecaoEstilo(graficos);
        } else {
        	desabilitarSelecaoEstilo(graficos);
        }
    }
}