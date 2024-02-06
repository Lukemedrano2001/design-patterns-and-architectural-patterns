package gof.comportamento.mediator.textos;

import java.awt.event.KeyEvent;

import javax.swing.JTextArea;

import gof.comportamento.mediator.interfaces.IComponente;
import gof.comportamento.mediator.interfaces.IMediator;

@SuppressWarnings("serial")
public class CaixaDeTexto extends JTextArea implements IComponente { 
	private IMediator mediator;

    @Override
    public void setMediator(IMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        mediator.marcarNota();
    }

    @Override
    public String getNome() {
        return "Caixa de Texto";
    }
}