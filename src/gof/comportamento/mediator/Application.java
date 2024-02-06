package gof.comportamento.mediator;

import javax.swing.DefaultListModel;

import gof.comportamento.mediator.botoes.BotaoAdicionar;
import gof.comportamento.mediator.botoes.BotaoDeletar;
import gof.comportamento.mediator.botoes.BotaoSalvar;
import gof.comportamento.mediator.filtro.Filtro;
import gof.comportamento.mediator.interfaces.IMediator;
import gof.comportamento.mediator.lista.Lista;
import gof.comportamento.mediator.textos.CaixaDeTexto;
import gof.comportamento.mediator.textos.Titulo;

@SuppressWarnings("rawtypes")
public class Application {
	public static void main(String[] args) { 
		IMediator mediator = new Editor();

	    mediator.registrarComponente(new Titulo());
	    mediator.registrarComponente(new CaixaDeTexto());
	    mediator.registrarComponente(new BotaoAdicionar());
	    mediator.registrarComponente(new BotaoDeletar());
	    mediator.registrarComponente(new BotaoSalvar());
	    mediator.registrarComponente(new Lista(new DefaultListModel()));
	    mediator.registrarComponente(new Filtro());
	
	    mediator.createGUI();
	}
}