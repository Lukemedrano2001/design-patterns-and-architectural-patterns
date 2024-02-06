package grasp.altaCoesaoAndBaixoAcoplamento;

import grasp.altaCoesaoAndBaixoAcoplamento.cliente.Cliente;
import grasp.altaCoesaoAndBaixoAcoplamento.itemPedido.ItemPedido;
import grasp.altaCoesaoAndBaixoAcoplamento.pagamentos.CheckOutPagamento;
import grasp.altaCoesaoAndBaixoAcoplamento.pagamentos.IPagamento;
import grasp.altaCoesaoAndBaixoAcoplamento.pagamentos.PagamentoCartaoCredito;
import grasp.altaCoesaoAndBaixoAcoplamento.pagamentos.PagamentoPayPal;
import grasp.altaCoesaoAndBaixoAcoplamento.pedido.Pedido;
import grasp.altaCoesaoAndBaixoAcoplamento.produto.Produto;

public class Application {
	public static void main(String[] args) {
		// Produtos
		Produto produto1 = new Produto(1, "Produto 1", 10);
        Produto produto2 = new Produto(2, "Produto 2", 20);
        Produto produto3 = new Produto(3, "Produto 3", 30);
        Produto produto4 = new Produto(4, "Produto 4", 40);

        
        // Itens Pedidos
        ItemPedido item1 = new ItemPedido(produto1, 1);
        ItemPedido item2 = new ItemPedido(produto2, 2);
        ItemPedido item3 = new ItemPedido(produto3, 3);
        ItemPedido item4 = new ItemPedido(produto4, 4);

        
        // Pedidos
        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();
        
        pedido1.adicionarItem(item1);
        pedido1.adicionarItem(item2);
        pedido2.adicionarItem(item3);
        pedido2.adicionarItem(item4);

        
        // IPagamentos
        IPagamento pagamentoPayPal = new PagamentoPayPal();
        IPagamento pagamentoCartaoCredito = new PagamentoCartaoCredito();
        
        
        // CheckOuts
        CheckOutPagamento checkoutPayPal = new CheckOutPagamento(pagamentoPayPal);
        CheckOutPagamento checkoutCartaoCredito = new CheckOutPagamento(pagamentoCartaoCredito);

        
        // Clientes
        Cliente cliente1 = new Cliente(checkoutPayPal);
        Cliente cliente2 = new Cliente(checkoutCartaoCredito);

        
        // Simulação dos clientes fazendo os pedidos e pagando
        cliente1.fazerPedido(pedido1);
        cliente2.fazerPedido(pedido2);
	}
}