package gof.comportamento.mediator.filtro;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import gof.comportamento.mediator.interfaces.IComponente;
import gof.comportamento.mediator.interfaces.IMediator;
import gof.comportamento.mediator.textos.Nota;

@SuppressWarnings({ "serial", "rawtypes" })
public class Filtro extends JTextField implements IComponente {
	private IMediator mediator;
	private ListModel lista;

    public Filtro() {}

    @Override
    public void setMediator(IMediator iMediator) {
        this.mediator = iMediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        String start = getText();
        buscarElementos(start);
    }

    public void setList(ListModel lista) {
        this.lista = lista; 
    }

    private void buscarElementos(String string) {
        if (lista == null) {
            return;
        }

        if (string.equals("")) {
            mediator.setListaElementos(lista);
            return;
        } 

        ArrayList<Nota> notas = new ArrayList<Nota>();
        for (int i = 0; i < lista.getSize(); i++) {
            notas.add((Nota) lista.getElementAt(i));
        }
        
        DefaultListModel<Nota> lista = new DefaultListModel<Nota>();
        for (Nota nota: notas) {
            if (nota.getNome().contains(string)) {
                lista.addElement(nota);
            }
        }
        
        mediator.setListaElementos(lista);
    }

    @Override
    public String getNome() {
        return "Filtro";
    }
}