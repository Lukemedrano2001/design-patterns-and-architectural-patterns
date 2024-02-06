package gof.comportamento.templateMethod.maquinasBebidas;

import gof.comportamento.templateMethod.bebidas.Bebida;

public class MaquinaBebida<TIPO extends Bebida> {
	public MaquinaBebida() {}
	
	public void prepararBebida(TIPO bebida) {
		System.out.printf("- Nome da Bebida: %s \n", bebida.getNome());
		
		if (deveEsquentarAgua()) {
			 esquentarAgua();
		}
		
		bebida.prepararMistura();
		
		if(deveColocarAcucar()) {
			adicionarAcucar();			
		}
		
		colocarNoCopo();
		liberarBebida();
	}
	
	protected boolean deveEsquentarAgua() {
        return true;
    }
	
	protected boolean deveColocarAcucar() {
        return true;
    }
	
	public void esquentarAgua() {
		System.out.printf("- Esquentando a água \n");
	}
	
	public void colocarNoCopo() {
		System.out.printf("- Colocando a bebida no copo \n");
	}
	 
	public void adicionarAcucar() {
		System.out.printf("- Adicionando açúcar na bebida \n");
	}
	
	public void liberarBebida() {
		System.out.printf("- Liberando a bebida \n");
	}
}