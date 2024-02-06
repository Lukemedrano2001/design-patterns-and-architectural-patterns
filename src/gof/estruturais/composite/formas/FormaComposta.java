package gof.estruturais.composite.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormaComposta extends FormaBase {
    protected List<IForma> filhos = new ArrayList<IForma>();

    public FormaComposta(IForma... componentes) {
        super(0, 0, Color.BLACK);
        adicionar(componentes);
    }

    public void adicionar(IForma componente) {
        filhos.add(componente);
    }

    public void adicionar(IForma... componentes) {
        filhos.addAll(Arrays.asList(componentes));
    }

    public void remove(IForma filho) {
        filhos.remove(filho);
    }

    public void remove(IForma... componentes) {
        filhos.removeAll(Arrays.asList(componentes));
    }

    public void clear() {
        filhos.clear();
    }

    @Override
    public int getX() {
        if (filhos.size() == 0) {
            return 0;
        }
        
        int x = filhos.get(0).getX();
        for (IForma filho: filhos) {
            if (filho.getX() < x) {
                x = filho.getX();
            }
        }
        
        return x;
    }

    @Override
    public int getY() {
        if (filhos.size() == 0) {
            return 0;
        }
        
        int y = filhos.get(0).getY();
        for (IForma filho: filhos) {
            if (filho.getY() < y) {
                y = filho.getY();
            }
        }
        
        return y;
    }

    @Override
    public int getLargura() {
        int larguraMaxima = 0;
        int x = getX();
        
        for (IForma filho: filhos) {
            int filhosRelativosX = filho.getX() - x;
            int larguraFilho = filhosRelativosX + filho.getLargura();
            
            if (larguraFilho > larguraMaxima) {
                larguraMaxima = larguraFilho;
            }
        }
        
        return larguraMaxima;
    }

    @Override
    public int getAltura() {
        int alturaMaxima = 0;
        int y = getY();
        
        for (IForma filho: filhos) {
            int filhosRelativosY = filho.getY() - y;
            int alturaFilho = filhosRelativosY + filho.getAltura();
            
            if (alturaFilho > alturaMaxima) {
                alturaMaxima = alturaFilho;
            }
        }
        
        return alturaMaxima;
    }

    @Override
    public void mover(int x, int y) {
        for (IForma filho: filhos) {
        	filho.mover(x, y);
        }
    }

    @Override
    public boolean isDentroDosLimites(int x, int y) {
        for (IForma filho: filhos) {
            if (filho.isDentroDosLimites(x, y)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public void deselecionar() {
        super.deselecionar();
        for (IForma filho: filhos) {
        	filho.deselecionar();
        }
    }

    public boolean selecionarFilhoNaPosicao(int x, int y) {
        for (IForma filho: filhos) {
            if (filho.isDentroDosLimites(x, y)) {
                filho.selecionar();
                return true;
            }
        }
        
        return false;
    }

    @Override
    public void paint(Graphics graficos) {
        if (isSelecionado()) {
            habilitarSelecaoEstilo(graficos);
            graficos.drawRect(getX() - 1, getY() - 1, getLargura() + 1, getAltura() + 1);
            desabilitarSelecaoEstilo(graficos);
        }

        for (IForma filho: filhos) {
        	filho.paint(graficos);
        }
    }
}