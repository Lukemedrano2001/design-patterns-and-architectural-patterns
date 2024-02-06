package gof.criacao.abstractFactory.gui;

import gof.criacao.abstractFactory.button.IButton;
import gof.criacao.abstractFactory.button.MacOSButton;
import gof.criacao.abstractFactory.checkbox.ICheckbox;
import gof.criacao.abstractFactory.checkbox.MacOSCheckbox;

public class MacOSFactory implements IGUIFactory {
	@Override
	public IButton criarBotao() {
		return new MacOSButton();
	}

	@Override
	public ICheckbox criarCheckbox() {
		return new MacOSCheckbox();
	}
}