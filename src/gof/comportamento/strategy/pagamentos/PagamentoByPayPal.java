package gof.comportamento.strategy.pagamentos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PagamentoByPayPal implements IPagamentoStrategy {
	private static final Map<String, String> BANCO_DE_DADOS = new HashMap<String, String>();
    private final BufferedReader LEITOR = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String senha;
    private boolean loginEfetuado;
    
    static {
    	BANCO_DE_DADOS.put("guilherme8764", "guilherme@email.com");
    	BANCO_DE_DADOS.put("fulano1245", "fulano@email.com");
    }

	@Override
	public boolean pagar(int montantePagamento) {
		if (loginEfetuado) {
            System.out.println("Pagando " + montantePagamento + " usando PayPal.");
            return true;
        } else {
            return false;
        }
	}

	@Override
	public void recolherDetalhesPagamento() {
		try {
            while (!loginEfetuado) {
                // E-mail
            	System.out.print("Digite o seu e-mail de usuário: ");
                email = LEITOR.readLine();
                
                // Senha
                System.out.print("Digite a senha: ");
                senha = LEITOR.readLine();
                
                if (verificar()) {
                    System.out.println("A verificação de dados foi bem-sucedida.");
                } else {
                    System.out.println("E-mail ou senha incorretos.");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
	}
	
	private boolean verificar() {
        setLoginEfetuado(email.equals(BANCO_DE_DADOS.get(senha)));
        return loginEfetuado;
    } 
	
	private void setLoginEfetuado(boolean loginEfetuado) {
        this.loginEfetuado = loginEfetuado;
    }
}