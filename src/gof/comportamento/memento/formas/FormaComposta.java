package gof.comportamento.memento.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
public class FormaComposta extends FormaBase {
    private List<IForma> filhos = new ArrayList<IForma>();

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

    public void remove(IForma child) {
        filhos.remove(child);
    }

    public void remove(IForma... componentes) {
        filhos.removeAll(Arrays.asList(componentes));
    }

    public void limpar() {
        filhos.clear();
    }

    @Override
    public int getX() {
        if (filhos.size() == 0) {
            return 0;
        }
        
        int x = filhos.get(0).getX();
        for (IForma child: filhos) {
            if (child.getX() < x) {
                x = child.getX();
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
        for (IForma child: filhos) {
            if (child.getY() < y) {
                y = child.getY();
            }
        }
        
        return y;
    }

    @Override
    public int getLargura() {
        int maxWidth = 0;
        int x = getX();
        for (IForma child: filhos) {
            int childsRelativeX = child.getX() - x;
            int childWidth = childsRelativeX + child.getLargura();
            if (childWidth > maxWidth) {
                maxWidth = childWidth;
            }
        }
        
        return maxWidth;
    }

    @Override
    public int getAltura() {
        int maxHeight = 0;
        int y = getY();
        for (IForma child: filhos) {
            int childsRelativeY = child.getY() - y;
            int childHeight = childsRelativeY + child.getAltura();
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }
        
        return maxHeight;
    }

    @Override
    public void arrastar() {
        for (IForma child: filhos) {
            child.arrastar();
        }
    }

    @Override
    public void soltar() {
        for (IForma child: filhos) {
            child.soltar();
        }
    }

    @Override
    public void moverPara(int x, int y) {
        for (IForma child: filhos) {
            child.moverPara(x, y);
        }
    }

    @Override
    public void moverAte(int x, int y) {
        for (IForma child: filhos) {
            child.moverAte(x, y);
        }
    }

    @Override
    public boolean isDentroDosLimites(int x, int y) {
        for (IForma child: filhos) {
            if (child.isDentroDosLimites(x, y)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public void setCor(Color color) {
        super.setCor(color);
        for (IForma child: filhos) {
            child.setCor(color);
        }
    }

    @Override
    public void deselecionar() {
        super.deselecionar();
        for (IForma child: filhos) {
            child.deselecionar();
        }
    }

    public IForma getChildAt(int x, int y) {
        for (IForma child: filhos) {
            if (child.isDentroDosLimites(x, y)) {
                return child;
            }
        }
        
        return null;
    }

    public boolean selectFilhoNaPosicao(int x, int y) {
        IForma child = getChildAt(x,y);
        if (child != null) {
            child.selecionar();
            return true;
        }
        
        return false;
    }

    public List<IForma> getSelecionado() {
        List<IForma> selected = new ArrayList<>();
        for (IForma child: filhos) {
            if (child.isSelecionado()) {
                selected.add(child);
            }
        }
        
        return selected;
    }

    @Override
    public void paint(Graphics graphics) {
        if (isSelecionado()) {
        	habilitarSelecaoEstilo(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getLargura() + 1, getAltura() + 1);
            desabilitarSelecaoEstilo(graphics);
        }

        for (IForma child: filhos) {
            child.paint(graphics);
        }
    }
}