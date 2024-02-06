package gof.comportamento.templateMethod.maquinasBebidas;

import gof.comportamento.templateMethod.bebidas.Cha;

public class MaquinaCha extends MaquinaBebida<Cha> {
	public MaquinaCha() {
		super();
	}

	public void adicionarComplementos() {
		 System.out.println("- Adicionando complementos ao chá");
	}
}