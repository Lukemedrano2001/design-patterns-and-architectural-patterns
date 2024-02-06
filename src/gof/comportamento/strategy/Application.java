package gof.comportamento.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import gof.comportamento.strategy.ordem.Ordem;
import gof.comportamento.strategy.pagamentos.IPagamentoStrategy;
import gof.comportamento.strategy.pagamentos.PagamentoByCartaoCredito;
import gof.comportamento.strategy.pagamentos.PagamentoByPayPal;

public class Application {
	private static Map<Integer, Integer> precoNosProdutos = new HashMap<Integer, Integer>();
    private static BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
    private static Ordem ordem = new Ordem();
    private static IPagamentoStrategy strategy;

    static {
        precoNosProdutos.put(1, 2200); 
        precoNosProdutos.put(2, 1850);
        precoNosProdutos.put(3, 1100);
        precoNosProdutos.put(4, 890);
    }  

    public static void main(String[] args) throws IOException {
        while (ordem.isAberto()) {
            int custo;

            String escolhaContinua;
            while (true) {
                System.out.print("Por favor, selecione um produto:" + "\n" +
                        "1 - Placa mãe" + "\n" +
                        "2 - Processador (CPU)" + "\n" +
                        "3 - Hard Disk Drive (HDD)" + "\n" +
                        "4 - Memória RAM" + "\n");
                int escolha = Integer.parseInt(leitor.readLine());
                custo = precoNosProdutos.get(escolha);
                
                System.out.print("Quantidade: ");
                int quantidade = Integer.parseInt(leitor.readLine());
                
                ordem.setCustoTotal(custo * quantidade);
                System.out.print("Deseja continuar selecionando produtos? Y/N: ");
                escolhaContinua = leitor.readLine();
                
                if (!escolhaContinua.equalsIgnoreCase("Y")) {
                    break;
                }
            }

            if (strategy == null) {
                System.out.println("Por favor, selecione um método de pagamento:" + "\n" +
                        "1 - PayPal" + "\n" +
                        "2 - Cartão de Crédito");
                String metodoPagamento = leitor.readLine(); 

                if (metodoPagamento.equals("1")) {
                    strategy = new PagamentoByPayPal();
                } else {
                    strategy = new PagamentoByCartaoCredito();
                }
            }

            ordem.processarOrdemPagamento(strategy); 

            System.out.print("Pagar " + ordem.getCustoTotal() + " o pedido ou Continuar comprando? P/C: ");
            String processar = leitor.readLine();
            if (processar.equalsIgnoreCase("P")) {
                if (strategy.pagar(ordem.getCustoTotal())) {
                    System.out.println("Pagamento feito com sucesso.");
                } else {
                    System.out.println("FALHA! Por favor, cheque os seus dados.");
                }
                
                ordem.setFechado();
            }
        }
    }
}