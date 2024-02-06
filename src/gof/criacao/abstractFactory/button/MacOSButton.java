package gof.criacao.abstractFactory.button;

public class MacOSButton implements IButton {
	@Override
	public void paint() {
		System.out.println("Você já criou um MacOSButton");
	}
}