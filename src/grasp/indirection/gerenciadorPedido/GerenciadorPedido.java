package grasp.indirection.gerenciadorPedido;

import grasp.indirection.carrinhoDeCompras.CarrinhoDeCompras;
import grasp.indirection.itemPedido.ItemPedido;

public class GerenciadorPedido {
    private final CarrinhoDeCompras carrinho;

    public GerenciadorPedido(CarrinhoDeCompras carrinho) {
        this.carrinho = carrinho;
    }
    
    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }
    
    public void adicionarItemPedido(ItemPedido itemPedido) {
    	carrinho.adicionarItemPedido(itemPedido);
    }
    
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	
    	builder.append(carrinho.toString()).append("\n");
    	
        return builder.toString();
    }
}
