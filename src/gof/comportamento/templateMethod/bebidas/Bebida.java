package gof.comportamento.templateMethod.bebidas;

public abstract class Bebida {
	private String nome;
	
	public Bebida(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	protected boolean devePrepararMistura() {
		return true;
	}
	
	public void prepararMistura() {
		if(devePrepararMistura()) {
			System.out.println("- Preparando a mistura");
		}
	}
}