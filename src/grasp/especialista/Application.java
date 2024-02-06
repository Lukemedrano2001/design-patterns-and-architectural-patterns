package grasp.especialista;

import grasp.especialista.cliente.Cliente;
import grasp.especialista.itemPedido.ItemPedido;
import grasp.especialista.pedido.Pedido;
import grasp.especialista.produto.Produto;

public class Application {
	public static void main(String[] args) {
		// Clientes
        Cliente cliente1 = new Cliente(1, "Alice");
        Cliente cliente2 = new Cliente(2, "Bob");

        // Produtos
        Produto produto1 = new Produto(1, "Laptop", 10);
        Produto produto2 = new Produto(2, "Fones de Ouvido", 20);
        Produto produto3 = new Produto(3, "Celular", 30);
        Produto produto4 = new Produto(4, "Computador", 40);

        // Itens Pedidos
        ItemPedido itemPedido1 = new ItemPedido(1, produto1, 1);
        ItemPedido itemPedido2 = new ItemPedido(2, produto2, 2);
        ItemPedido itemPedido3 = new ItemPedido(3, produto3, 3);
        ItemPedido itemPedido4 = new ItemPedido(4, produto4, 4);

        // Pedidos
        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();
        pedido1.adicionarItem(itemPedido1);
        pedido1.adicionarItem(itemPedido2);
        pedido2.adicionarItem(itemPedido3);
        pedido2.adicionarItem(itemPedido4);

        
        // Clientes
        System.out.println("- Clientes");
        System.out.println(cliente1.toString());
        System.out.println(cliente2.toString());
       
        // Produtos
        System.out.println("\n- Produtos");
        System.out.println(produto1.toString());
        System.out.println(produto2.toString());
        System.out.println(produto3.toString());
        System.out.println(produto4.toString());
        
        // Itens Pedidos
        System.out.println("\n- Itens Pedidos");
        System.out.println(itemPedido1.toString());
        System.out.println(itemPedido2.toString());
        System.out.println(itemPedido3.toString());
        System.out.println(itemPedido4.toString());
        
        // Pedidos
        System.out.println("\n- Pedidos");
        System.out.println(pedido1.toString());
        System.out.println(pedido2.toString());
	}
}