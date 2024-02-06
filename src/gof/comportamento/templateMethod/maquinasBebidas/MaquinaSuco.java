package gof.comportamento.templateMethod.maquinasBebidas;

import gof.comportamento.templateMethod.bebidas.Suco;

public class MaquinaSuco extends MaquinaBebida<Suco> {
	public MaquinaSuco() {
		super();
	}

	public void adicionarComplementos() {
		 System.out.println("- Adicionando complementos ao suco");
	}
	
	@Override
    protected boolean deveEsquentarAgua() {
        return false;
    }
}