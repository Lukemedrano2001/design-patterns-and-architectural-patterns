package grasp.indirection;

import grasp.indirection.carrinhoDeCompras.CarrinhoDeCompras;
import grasp.indirection.gerenciadorPedido.GerenciadorPedido;
import grasp.indirection.itemPedido.ItemPedido;
import grasp.indirection.produto.Produto;

public class Application {
    public static void main(String[] args) {
        // Produtos
        Produto produto1 = new Produto(1, "Laptop", 10);
        Produto produto2 = new Produto(2, "Computador", 20);
        Produto produto3 = new Produto(3, "Televisão", 30);
        Produto produto4 = new Produto(4, "Geladeira", 40);

        // Itens Pedidos
        ItemPedido itemPedido1 = new ItemPedido(1, produto1, 1, 10);
        ItemPedido itemPedido2 = new ItemPedido(2, produto2, 2, 10);
        ItemPedido itemPedido3 = new ItemPedido(3, produto3, 3, 10);
        ItemPedido itemPedido4 = new ItemPedido(4, produto4, 4, 10);
        
        // Carrinho de compras
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        
        // Gerenciador de Pedidos
        GerenciadorPedido gerenciadorPedidos = new GerenciadorPedido(carrinho);

        
        // Gerenciador de Pedidos adiciona os itens no carrinho, usando Indirection
        gerenciadorPedidos.adicionarItemPedido(itemPedido1);
        gerenciadorPedidos.adicionarItemPedido(itemPedido2);
        gerenciadorPedidos.adicionarItemPedido(itemPedido3);
        gerenciadorPedidos.adicionarItemPedido(itemPedido4);
        
        
        // Produtos
        System.out.println("- Produtos");
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
        
        // Gerenciador de Pedidos
        System.out.println("\n- Gerenciador de Pedidos");
        System.out.println(gerenciadorPedidos.toString());
    }
}
