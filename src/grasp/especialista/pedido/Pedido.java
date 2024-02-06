package grasp.especialista.pedido;

import java.util.ArrayList;
import java.util.List;

import grasp.especialista.itemPedido.ItemPedido;

public class Pedido {
	private List<ItemPedido> itensPedidos = new ArrayList<ItemPedido>();

	public void adicionarItem(ItemPedido item) {
	    itensPedidos.add(item);
	}
	
	public double calcularTotal() {
		double total = 0;
		for(ItemPedido itemPedido: itensPedidos) {
			total += itemPedido.calcularSubTotal();
		}
		
		return total;
	}
	
	@Override
	public String toString() { 
		StringBuilder builder = new StringBuilder();
	    String total = "- Total: " + this.calcularTotal();
		
	    for (ItemPedido itemPedido: itensPedidos) {
	        builder.append(itemPedido.toString()).append("\n");
	    }
	    
	    builder.append(total).append("\n");
	    
	    return builder.toString();
	}
} 