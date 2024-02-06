package grasp.altaCoesao;

import grasp.altaCoesao.itemPedido.ItemPedido;
import grasp.altaCoesao.pedido.Pedido;
import grasp.altaCoesao.produto.Produto;

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

        // Total do pedido
        double total1 = pedido1.calcularTotal();
        double total2 = pedido2.calcularTotal();

        // Exibir o total
        System.out.println("Total do Pedido 1: R$ " + total1);
        System.out.println("Total do Pedido 2: R$ " + total2);
	}
}