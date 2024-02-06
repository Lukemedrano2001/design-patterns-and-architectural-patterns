package gof.comportamento.chainOfResponsibilty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gof.comportamento.chainOfResponsibilty.middleware.LimitacaoTaxaMiddleware;
import gof.comportamento.chainOfResponsibilty.middleware.Middleware;
import gof.comportamento.chainOfResponsibilty.middleware.RoleChecadaMiddleware;
import gof.comportamento.chainOfResponsibilty.middleware.UsuarioExisteMiddleware;

public class Application {
	private static BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
    private static Servidor servidor;

    private static void init() {
        servidor = new Servidor();
        servidor.registrar("admin@exemplo.com", "admin");
        servidor.registrar("usuario@exemplo.com", "usuario");

        // Chain of Responsibility
        Middleware middleware = Middleware.linkar(
            new LimitacaoTaxaMiddleware(2),
            new UsuarioExisteMiddleware(servidor),
            new RoleChecadaMiddleware()
        );

        servidor.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean successo = false;
        while (!successo){
            System.out.print("Digite o e-mail: ");
            String email = leitor.readLine();
            System.out.print("Digite a senha: ");
            String senha = leitor.readLine();
            successo = servidor.login(email, senha);
        }
    }
}