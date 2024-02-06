package gof.comportamento.mediator.botoes;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import gof.comportamento.mediator.interfaces.IComponente;
import gof.comportamento.mediator.interfaces.IMediator;
import gof.comportamento.mediator.textos.Nota;

@SuppressWarnings("serial")
public class BotaoAdicionar extends JButton implements IComponente { 
	private IMediator mediator;

	public BotaoAdicionar() {
	    super("Adiciona");
	}
	
	@Override
	public void setMediator(IMediator iMediator) {
	    this.mediator = iMediator;
	}
	
	@Override
	protected void fireActionPerformed(ActionEvent actionEvent) {
	    mediator.adicionarNovaNota(new Nota());
	}
	
	@Override
	public String getNome() {
	    return "Botao de Adicionar";
	}
}