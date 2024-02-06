package grasp.indirection.carrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

import grasp.indirection.itemPedido.ItemPedido;

public class CarrinhoDeCompras {
    private List<ItemPedido> itensPedidos = new ArrayList<ItemPedido>();

    public CarrinhoDeCompras() {}

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void adicionarItemPedido(ItemPedido itemPedido) {
        itensPedidos.add(itemPedido);
    }
    
    public double totalSemDesconto() {
    	double total = 0;
    	for(ItemPedido itemPedido: this.getItensPedidos()) {
    		total += itemPedido.subTotalSemDesconto();
    	}
    	
    	return total;
    }
    
    public double totalComDesconto() {
    	double total = 0;
    	for(ItemPedido itemPedido: this.getItensPedidos()) {
    		total += itemPedido.subTotalComDesconto();
    	}
    	
    	return total;
    }

    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
        String semDesconto = String.format("Total sem Desconto: %.2f R$", this.totalSemDesconto());
        String comDesconto = String.format("Total sem Desconto: %.2f R$", this.totalComDesconto());
        
        builder.append(semDesconto).append("\n");
        builder.append(comDesconto).append("\n");

        return builder.toString();
    }
}