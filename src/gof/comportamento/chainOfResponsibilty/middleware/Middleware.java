package gof.comportamento.chainOfResponsibilty.middleware;

public abstract class Middleware {
	private Middleware proximo;
	
	public static Middleware linkar(Middleware primeiro, Middleware... corrente) {
		Middleware cabeca = primeiro;
		
		for(Middleware proximoNaCorrente: corrente) {
			cabeca.proximo = proximoNaCorrente;
			cabeca = proximoNaCorrente;
		}
		
		return primeiro;
	}
	
	public abstract boolean checar(String email, String senha);
	
	public boolean checarProximo(String email, String senha) {
		if(proximo == null) {
			return true;
		}
		
		return proximo.checar(email, senha);
	}
}