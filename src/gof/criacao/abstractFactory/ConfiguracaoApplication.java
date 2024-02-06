package gof.criacao.abstractFactory;

import gof.criacao.abstractFactory.button.IButton;
import gof.criacao.abstractFactory.checkbox.ICheckbox;
import gof.criacao.abstractFactory.gui.IGUIFactory;

public class ConfiguracaoApplication {
	private IButton botao;
	private ICheckbox checkbox;
	
	public ConfiguracaoApplication(IGUIFactory factory) {
		botao = factory.criarBotao();
        checkbox = factory.criarCheckbox();
    }
	
	public void paint() {
        botao.paint();
        checkbox.paint();
    }
}