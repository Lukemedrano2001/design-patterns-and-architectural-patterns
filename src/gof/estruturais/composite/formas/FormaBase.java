package gof.estruturais.composite.formas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class FormaBase implements IForma {
	public int x;
    public int y;
    public Color cor;
    private boolean selecionado = false;

    FormaBase(int x, int y, Color cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
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
    public void mover(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean isDentroDosLimites(int x, int y) {
        return x > getX() && x < (getX() + getLargura()) &&
                y > getY() && y < (getY() + getAltura());
    }

    @Override
    public void selecionar() {
        selecionado = true;
    }

    @Override
    public void deselecionar() {
        selecionado = false;
    }

    @Override
    public boolean isSelecionado() {
        return selecionado;
    } 

    void habilitarSelecaoEstilo(Graphics graficos) {
        graficos.setColor(Color.LIGHT_GRAY);

        Graphics2D g2 = (Graphics2D) graficos;
        float[] dash1 = { 2.0f };
        g2.setStroke(new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                2.0f, dash1, 0.0f));
    }

    void desabilitarSelecaoEstilo(Graphics graficos) {
        graficos.setColor(cor);
        Graphics2D g2 = (Graphics2D) graficos;
        g2.setStroke(new BasicStroke());
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