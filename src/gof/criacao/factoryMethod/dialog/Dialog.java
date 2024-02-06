package gof.criacao.factoryMethod.dialog;

import gof.criacao.factoryMethod.button.IButton;

public abstract class Dialog {
	public void renderWindow() {
        IButton okButton = createButton();
        okButton.renderizar();
    }
	
	public abstract IButton createButton();
}