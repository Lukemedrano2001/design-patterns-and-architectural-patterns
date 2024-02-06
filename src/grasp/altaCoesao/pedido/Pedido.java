package grasp.altaCoesao.pedido;

import java.util.ArrayList;
import java.util.List;

import grasp.altaCoesao.itemPedido.ItemPedido;

public class Pedido {
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();

    public Pedido() {}

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item: itens) {
        	double precoProduto = item.getProduto().getPreco();
        	int quantidadeProduto = item.getQuantidade();
            total += precoProduto * quantidadeProduto;
        }
        
        return total;
    }
}