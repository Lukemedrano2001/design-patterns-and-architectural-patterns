package gof.comportamento.mediator.lista;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import gof.comportamento.mediator.interfaces.IComponente;
import gof.comportamento.mediator.interfaces.IMediator;
import gof.comportamento.mediator.textos.Nota;

@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
public class Lista extends JList implements IComponente {
	private IMediator mediator;
    private final DefaultListModel LISTA_MODELO;

	public Lista(DefaultListModel lista) {
        super(lista);
        this.LISTA_MODELO = lista;
        setModel(lista);
        this.setLayoutOrientation(JList.VERTICAL);
        Thread thread = new Thread(new Hide(this));
        thread.start();
    }

    @Override
    public void setMediator(IMediator mediator) {
        this.mediator = mediator;
    }

	public void adicionarElemento(Nota nota) {
		this.LISTA_MODELO.addElement(nota);
        int indice = LISTA_MODELO.size() - 1;
        setSelectedIndex(indice);
        ensureIndexIsVisible(indice);
        this.mediator.enviarParaFiltro(LISTA_MODELO);
    }

    public void deletarElemento() {
        int index = this.getSelectedIndex();
        try {
        	this.LISTA_MODELO.remove(index);
            mediator.enviarParaFiltro(LISTA_MODELO);
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public Nota getElementoAtual() {
        return (Nota)getSelectedValue();
    }

    @Override
    public String getNome() {
        return "Lista";
    }

    private class Hide implements Runnable {
        private Lista lista;

        Hide(Lista lista) {
            this.lista = lista;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException exception) {
                	exception.printStackTrace();
                }
                
                if (lista.isSelectionEmpty()) {
                    mediator.esconderElementos(true);
                } else {
                    mediator.esconderElementos(false);
                }
            }
        }
    }
}