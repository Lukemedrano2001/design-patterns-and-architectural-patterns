package gof.comportamento.templateMethod.maquinasBebidas;

import gof.comportamento.templateMethod.bebidas.Cafe;

public class MaquinaCafe extends MaquinaBebida<Cafe> {
	public MaquinaCafe() {
		super();
	}

	public void adicionarComplementos() {
		 System.out.println("- Adicionando complementos ao café");
	}
}