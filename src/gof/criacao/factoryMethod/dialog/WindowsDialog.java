package gof.criacao.factoryMethod.dialog;

import gof.criacao.factoryMethod.button.IButton;
import gof.criacao.factoryMethod.button.WindowsButton;

public class WindowsDialog extends Dialog {
	@Override
	public IButton createButton() {
		return new WindowsButton();
	}
}