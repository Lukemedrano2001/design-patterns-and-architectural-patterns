package gof.criacao.abstractFactory.checkbox;

public class WindowsCheckbox implements ICheckbox {
	@Override
	public void paint() {
		System.out.println("Você já criou um WindowsCheckbox.");
	}
}