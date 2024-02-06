package gof.criacao.factoryMethod.button;

public class HtmlButton implements IButton {
	// Produto Concreto
	
	@Override
	public void renderizar() {
		System.out.println("<button>Botão Teste</button>");
	}

	@Override
	public void onClick() {
		System.out.println("Click! Hello World");
	}
}