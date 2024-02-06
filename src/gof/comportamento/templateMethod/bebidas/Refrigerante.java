package gof.comportamento.templateMethod.bebidas;

public class Refrigerante extends Bebida {
	public Refrigerante(String nome) {
		super(nome);
	}
	
	@Override
	protected boolean devePrepararMistura() {
		return false;
	}
}