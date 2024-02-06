package gof.criacao.abstractFactory.button;

public class WindowsButton implements IButton {
	@Override
	public void paint() {
		System.out.println("Você já criou um WindowsButton");
	}
}