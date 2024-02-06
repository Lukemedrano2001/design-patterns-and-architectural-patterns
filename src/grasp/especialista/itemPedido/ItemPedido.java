package grasp.especialista.itemPedido;

import grasp.especialista.produto.Produto;

public class ItemPedido {
	private final int id;
	private Produto produto;
	private int quantidade;
	
	public ItemPedido(int id, Produto produto, int quantidade) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public int getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double calcularSubTotal() {
		return produto.getPreco() * quantidade;
	}
	
	@Override
	public String toString() {
		String id = "Id: " + this.getId();
		String produto = "Produto: " + this.getProduto().getId();
		String quantidade = "Quantidade: " + this.getQuantidade();
		String subTotal = "SubTotal: " + this.calcularSubTotal();
		
		return String.format("%s | %s | %s | %s |", id, produto, quantidade, subTotal);
	}
}