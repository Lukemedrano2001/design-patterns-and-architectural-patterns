package gof.criacao.singleton;

public final class Singleton {
	private static Singleton instancia;
	private String valor;
	
	private Singleton(String valor) {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException exception) {
			exception.printStackTrace();
		}
		
		this.valor = valor;
	}
	
	public static Singleton getInstancia(String valor) {
        if (instancia == null) {
        	instancia = new Singleton(valor);
        }
        
        return instancia;
    }
	
	public String getValor() {
		return valor;
	}
}