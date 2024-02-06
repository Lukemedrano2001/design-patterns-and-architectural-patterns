package gof.criacao.abstractFactory.gui;

import gof.criacao.abstractFactory.button.IButton;
import gof.criacao.abstractFactory.checkbox.ICheckbox;

public interface IGUIFactory {
	IButton criarBotao();
	ICheckbox criarCheckbox();
}