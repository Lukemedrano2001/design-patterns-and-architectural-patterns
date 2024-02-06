package gof.criacao.abstractFactory.gui;

import gof.criacao.abstractFactory.button.IButton;
import gof.criacao.abstractFactory.button.WindowsButton;
import gof.criacao.abstractFactory.checkbox.ICheckbox;
import gof.criacao.abstractFactory.checkbox.WindowsCheckbox;

public class WindowsFactory implements IGUIFactory {
	@Override
	public IButton criarBotao() {
		return new WindowsButton();
	}

	@Override
	public ICheckbox criarCheckbox() {
		return new WindowsCheckbox();
	}
}