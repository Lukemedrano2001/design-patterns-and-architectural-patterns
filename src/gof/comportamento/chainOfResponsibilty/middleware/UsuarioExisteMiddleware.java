package gof.comportamento.chainOfResponsibilty.middleware;

import gof.comportamento.chainOfResponsibilty.Servidor;

public class UsuarioExisteMiddleware extends Middleware {
	private Servidor servidor;
	
	public UsuarioExisteMiddleware(Servidor servidor) {
		this.servidor = servidor;
	}
	
	@Override
	public boolean checar(String email, String senha) {
        if (!servidor.emailExistente(email)) {
            System.out.println("Este e-mail não está cadastrado!");
            return false;
        }
        
        if (!servidor.isSenhaValida(email, senha)) {
            System.out.println("Senha errada!");
            return false;
        }
        
        return checarProximo(email, senha);
    }
}