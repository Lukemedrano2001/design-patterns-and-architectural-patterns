package gof.comportamento.mediator.botoes;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import gof.comportamento.mediator.interfaces.IComponente;
import gof.comportamento.mediator.interfaces.IMediator;

@SuppressWarnings("serial")
public class BotaoDeletar extends JButton implements IComponente {
	private IMediator mediator;

    public BotaoDeletar() {
        super("Deletar");
    }

    @Override
    public void setMediator(IMediator iMediator) {
        this.mediator = iMediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.deletarNota();
    }

    @Override
    public String getNome() {
        return "Botao de Deletar";
    }
}