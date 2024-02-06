package grasp.altaCoesaoAndBaixoAcoplamento.pedido;

import java.util.ArrayList;
import java.util.List;

import grasp.altaCoesaoAndBaixoAcoplamento.itemPedido.ItemPedido;

public class Pedido {
	private List<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();

    public Pedido() {}

    public void adicionarItem(ItemPedido item) {
        this.itemPedidos.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item: itemPedidos) {
        	double precoProduto = item.getItemMenu().getPreco();
        	int quantidadeProduto = item.getQuantidade();
            total += precoProduto * quantidadeProduto;
        }
        
        return total;
    }
}