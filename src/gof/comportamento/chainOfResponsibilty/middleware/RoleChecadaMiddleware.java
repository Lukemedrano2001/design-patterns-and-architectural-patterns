package gof.comportamento.chainOfResponsibilty.middleware;

public class RoleChecadaMiddleware extends Middleware {
	
	@Override
	public boolean checar(String email, String senha) {
        if (email.equals("admin@exemplo.com")) {
            System.out.println("Olá, Admin!");
            return true;
        }
        
        System.out.println("Olá, Usuário!");
        return checarProximo(email, senha);
    }
}