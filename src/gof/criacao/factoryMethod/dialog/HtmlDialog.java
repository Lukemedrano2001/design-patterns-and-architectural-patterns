package gof.criacao.factoryMethod.dialog;

import gof.criacao.factoryMethod.button.HtmlButton;
import gof.criacao.factoryMethod.button.IButton;

public class HtmlDialog extends Dialog {
	@Override
	public IButton createButton() {
		return new HtmlButton();
	}
}