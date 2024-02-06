package gof.comportamento.chainOfResponsibilty.middleware;

public class LimitacaoTaxaMiddleware extends Middleware {
	private int requisicoesPorMinuto;
    private int requisicao;
    private long tempoAtual;

    public LimitacaoTaxaMiddleware(int requisicoesPorMinuto) {
        this.requisicoesPorMinuto = requisicoesPorMinuto;
        this.tempoAtual = System.currentTimeMillis();
    }
    
    @Override
    public boolean checar(String email, String senha) {
        if (System.currentTimeMillis() > tempoAtual + 60_000) {
        	this.requisicao = 0;
        	this.tempoAtual = System.currentTimeMillis();
        }

        requisicao++;
        
        if (requisicao > requisicoesPorMinuto) {
            System.out.println("Limite de Requisições excedidas!");
            System.exit(0);;
        }
        
        return checarProximo(email, senha);
    }
}