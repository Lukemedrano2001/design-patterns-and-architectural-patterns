package gof.comportamento.mediator.botoes;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import gof.comportamento.mediator.interfaces.IComponente;
import gof.comportamento.mediator.interfaces.IMediator;

@SuppressWarnings("serial")
public class BotaoSalvar extends JButton implements IComponente {
	private IMediator mediator;

    public BotaoSalvar() {
        super("Salvar");
    }

    @Override
    public void setMediator(IMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.salvarMudancas();
    }

    @Override
    public String getNome() {
        return "Botao de Salvar";
    }
}