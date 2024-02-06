package gof.comportamento.chainOfResponsibilty;

import java.util.HashMap;
import java.util.Map;

import gof.comportamento.chainOfResponsibilty.middleware.Middleware;

public class Servidor {
	 private Map<String, String> usuarios = new HashMap<String, String>();
	    private Middleware middleware;

	    public void setMiddleware(Middleware middleware) {
	        this.middleware = middleware;
	    }

	    public boolean login(String email, String password) {
	        if (middleware.checar(email, password)) {
	            System.out.println("Autorização realizada com sucesso!");

	            return true;
	        }
	        
	        return false;
	    }

	    public void registrar(String email, String password) {
	        usuarios.put(email, password);
	    }

	    public boolean emailExistente(String email) {
	        return usuarios.containsKey(email);
	    }

	    public boolean isSenhaValida(String email, String password) {
	        return usuarios.get(email).equals(password);
	    }
}