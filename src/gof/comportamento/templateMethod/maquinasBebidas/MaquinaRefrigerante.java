package gof.comportamento.templateMethod.maquinasBebidas;

import gof.comportamento.templateMethod.bebidas.Refrigerante;

public class MaquinaRefrigerante extends MaquinaBebida<Refrigerante> {
	public MaquinaRefrigerante() {
		super();
	}
	
	@Override
    protected boolean deveEsquentarAgua() {
        return false;
    }
	
	@Override
    protected boolean deveColocarAcucar() {
        return false;
    }
}